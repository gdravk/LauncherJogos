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
    public String urlSelecionada;
    private JButton botaoSelecionado; // Novo atributo para armazenar o botão selecionado
    private botaoJogar botaoJogar; // Novo botão Jogar
    private botaoAssistirTrailer botaoAssistirTrailer; // Novo botão Assistir Trailer

    public tela() {
        super("Java Games Launcher");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1080);

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

        // Definindo o tamanho do botão iniciar launcher
botaoIniciarLauncher.setPreferredSize(new Dimension(200, 60));

        primeiraTela.add(botaoIniciarLauncher, BorderLayout.SOUTH);

        cardPanel.add(primeiraTela, "primeiraTela");

        JPanel segundaTela = new JPanel();
        segundaTela.setLayout(new BorderLayout());

        JPanel botoesPanel = new JPanel(new GridLayout(2, 1));

        botaoJogar = new botaoJogar(); // Instanciando o novo botão Jogar
        botoesPanel.add(botaoJogar);

        botaoAssistirTrailer = new botaoAssistirTrailer(this); // Passando a instância de tela para o botão
        botoesPanel.add(botaoAssistirTrailer); // Adicionando o botão Assistir Trailer

        segundaTela.add(botoesPanel, BorderLayout.NORTH);

        infoJogos info = new infoJogos();
        JPanel panelJogos = new JPanel(new GridLayout(2, 3));
        for (int i = 0; i < info.getJogos().size(); i++) {
            Jogo jogo = info.getJogos().get(i);

            
            JButton botaoJogo = new JButton();
            botaoJogo.setIcon(new ImageIcon(jogo.getCaminhoIcone()));
            botaoJogo.setToolTipText(jogo.getNome() + "\n" + jogo.getDescricao());
            String url = info.getUrl(i);

            // Criando o botão de informação e adicionando ao botão de jogo
            botaoInfoJogos botaoInfo = new botaoInfoJogos(jogo.getDescricao());
            botaoJogo.setLayout(new BorderLayout());
            botaoJogo.add(botaoInfo, BorderLayout.NORTH); // Adicionando o botão de informação ao norte do botão de jogo

            botaoJogo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    urlSelecionada = url;
                    botaoAssistirTrailer.setUrlSelecionada(urlSelecionada); // Configurando a URL selecionada no botão Assistir Trailer
                    botaoJogar.setNomeJogo(jogo.getNome()); // Definindo o nome do jogo no botão Jogar
                    if (botaoSelecionado != null) {
                        botaoSelecionado.setBackground(null); // Remove o destaque do botão anteriormente selecionado
                    }
                    botaoSelecionado = (JButton) e.getSource(); // Armazena o botão atualmente selecionado
                    botaoSelecionado.setBackground(new Color(161, 159, 183)); // Definindo cor personalizada azul cinza
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

        // Definindo o tamanho do botão voltar
        botaoVoltar.setPreferredSize(new Dimension(200, 60));

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

    public void abrirLink(String url) {
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
            } else {
                JOptionPane.showMessageDialog(null, "Navegador não suportado.");
            }
        } catch (IOException | URISyntaxException ex) {
            ex.printStackTrace();
        }
    }
}