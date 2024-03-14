package tela;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.File;

public class botaoJogar extends JButton {

    private String nomeJogo;

    public botaoJogar() {
        super("Jogar");
        setBackground(new Color(0, 168, 45)); // Definindo a cor de fundo como verde escuro
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jogar();
            }
        });
    }

    public void setNomeJogo(String nomeJogo) {
        this.nomeJogo = nomeJogo;
    }

    private void jogar() {
        if (nomeJogo != null) {
            File desktop = new File(System.getProperty("user.home"), "Desktop");
            File[] files = desktop.listFiles();
            boolean encontrado = false;
            if (files != null) {
                for (File file : files) {
                    if (file.getName().toLowerCase().contains(nomeJogo.toLowerCase())) {
                        encontrado = true;
                        abrirAtalho(file);
                        break;
                    }
                }
            }
            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "Não encontrei o atalho desse jogo no seu desktop.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um jogo antes de jogar.");
        }
    }

    private void abrirAtalho(File atalho) {
        try {
            Desktop.getDesktop().open(atalho);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível abrir o atalho do jogo.");
            ex.printStackTrace();
        }
    }
}
