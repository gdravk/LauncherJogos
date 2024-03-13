package tela;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import tela.jogos.*;

public class tela extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private String urlSelecionada;
    private JButton botaoSelecionado; // Novo atributo para armazenar o botão selecionado

    public tela() {
        super("Java Games Launcher");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 550);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        add(cardPanel);

        JPanel primeiraTela = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon gifIcon = new ImageIcon("src/tela/imagens/backgroundTela/background_primeira_tela.gif");
                g.drawImage(gifIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        primeiraTela.setLayout(new BorderLayout());

        JLabel tituloLabel = new JLabel("Launcher de jogos!");
        tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tituloLabel.setVerticalAlignment(SwingConstants.CENTER);
        tituloLabel.setForeground(Color.WHITE);
        tituloLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
        primeiraTela.add(tituloLabel, BorderLayout.CENTER);

        JButton botaoIniciarLauncher = new JButton("Iniciar Launcher");
        botaoIniciarLauncher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(cardPanel);
            }
        });
        primeiraTela.add(botaoIniciarLauncher, BorderLayout.SOUTH);

        cardPanel.add(primeiraTela, "primeiraTela");

        JPanel segundaTela = new JPanel();
        segundaTela.setLayout(new BorderLayout());

        JButton botaoJogar = new JButton("Assistir Trailer");
        botaoJogar.setFont(new Font("Arial", Font.BOLD, 14));
        Color verdeFolha = new Color(51, 153, 51);
        botaoJogar.setBackground(verdeFolha);
        botaoJogar.setForeground(Color.WHITE);
        botaoJogar.setFocusPainted(false);
        botaoJogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (urlSelecionada != null) {
                    try {
                        abrirLink(urlSelecionada);
                    } catch (IOException | URISyntaxException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecione um jogo antes de jogar.");
                }
            }
        });
        segundaTela.add(botaoJogar, BorderLayout.NORTH);

        infoJogos info = new infoJogos();
        JPanel panelJogos = new JPanel(new GridLayout(2, 3));
        for (int i = 0; i < info.getJogos().size(); i++) {
            Jogo jogo = info.getJogos().get(i);
            JButton botaoJogo = new JButton();
            botaoJogo.setIcon(new ImageIcon(jogo.getCaminhoIcone()));
            botaoJogo.setToolTipText(jogo.getNome() + "\n" + jogo.getDescricao());
            String url = info.getUrl(i);
            botaoJogo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    urlSelecionada = url;
                    if (botaoSelecionado != null) {
                        botaoSelecionado.setBackground(null); // Remova o destaque do botão anteriormente selecionado
                    }
                    botaoSelecionado = (JButton) e.getSource(); // Armazene o botão atualmente selecionado
                    botaoSelecionado.setBackground(new Color(161, 159, 183));//quando clica no botao de selecionar o jogo fica com essa cor rgb cinza azulado no fundo
                }
            });
            panelJogos.add(botaoJogo);
        }
        segundaTela.add(panelJogos, BorderLayout.CENTER);

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.previous(cardPanel);
            }
        });
        segundaTela.add(botaoVoltar, BorderLayout.SOUTH);

        cardPanel.add(segundaTela, "segundaTela");

        cardLayout.show(cardPanel, "primeiraTela");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                tela telaPrincipal = new tela();
                telaPrincipal.setVisible(true);
            }
        });
    }

    private void abrirLink(String url) throws IOException, URISyntaxException {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop.getDesktop().browse(new URI(url));
        } else {
            JOptionPane.showMessageDialog(null, "Navegador não suportado.");
        }
    }
}
