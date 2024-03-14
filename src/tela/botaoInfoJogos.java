package tela;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

public class botaoInfoJogos extends JButton {
    private String descricaoJogo;

    public botaoInfoJogos(String descricaoJogo) {
        this.descricaoJogo = descricaoJogo;
        setIcon(new ImageIcon("src/tela/imagens/backgroundTela/info_icon.png")); 
        setToolTipText("Clique para ver a descrição do jogo");
        
        setBackground(new Color(192, 192, 192));

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirDescricao();
            }
        });
    }

    private void exibirDescricao() {
        JOptionPane.showMessageDialog(null, descricaoJogo, "Descrição do Jogo", JOptionPane.INFORMATION_MESSAGE);
    }
}
