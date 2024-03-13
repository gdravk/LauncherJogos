package tela;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tela extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public tela() {
        super("Java Games Launcher");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // Criação do CardLayout para conter os cartões da segunda tela de jogos
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        add(cardPanel); // Adiciona o painel ao JFrame

        // Primeira tela com o GIF como plano de fundo
        JPanel primeiraTela = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon gifIcon = new ImageIcon("src/tela/backgroundTela/background_primeira_tela.gif");
                g.drawImage(gifIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        primeiraTela.setLayout(new BorderLayout());

        JLabel tituloLabel = new JLabel("Launcher de jogos!");
        tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tituloLabel.setVerticalAlignment(SwingConstants.CENTER);
        tituloLabel.setForeground(Color.WHITE); // Cor vermelha para destacar
        tituloLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 48)); // Fonte em negrito e tamanho aumentado
        primeiraTela.add(tituloLabel, BorderLayout.CENTER);

        JButton botaoIniciarLauncher = new JButton("Iniciar Launcher");
        botaoIniciarLauncher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(cardPanel); // Quando clica em iniciar launcher, abre o próximo cartão de tela que mostra os jogos
            }
        });
        primeiraTela.add(botaoIniciarLauncher, BorderLayout.SOUTH);

        cardPanel.add(primeiraTela, "primeiraTela");

        // Implementação da segunda tela (tela dos jogos)
        JPanel segundaTela = new JPanel();
        segundaTela.setLayout(new BorderLayout());

        JLabel labelJogos = new JLabel("Lista de Jogos");
        labelJogos.setHorizontalAlignment(SwingConstants.CENTER);
        labelJogos.setVerticalAlignment(SwingConstants.CENTER);
        segundaTela.add(labelJogos, BorderLayout.CENTER);

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.previous(cardPanel); // Quando clicado, volta para a tela inicial
            }
        });
        segundaTela.add(botaoVoltar, BorderLayout.SOUTH);

        cardPanel.add(segundaTela, "segundaTela");

        cardLayout.show(cardPanel, "primeiraTela"); // Define qual cartão será exibido inicialmente
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
}
