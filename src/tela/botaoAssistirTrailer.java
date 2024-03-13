package tela;

import javax.swing.*;
import java.awt.event.*;

public class botaoAssistirTrailer extends JButton {

    private String urlSelecionada;
    // Construtor que aceita uma instância de tela como parâmetro
    public botaoAssistirTrailer(tela telaInstance) {
        super("Assistir Trailer");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (urlSelecionada != null) {
                    telaInstance.abrirLink(urlSelecionada); // Chamando o método abrirLink da instância de tela
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecione um jogo antes de assistir o trailer.");
                }
            }
        });
    }

    public void setUrlSelecionada(String url) {
        this.urlSelecionada = url;
    }
}
