package tela.jogos;

import java.util.ArrayList;
import java.util.List;

public class infoJogos {
    private List<Jogo> jogos;

    public infoJogos() {
        jogos = new ArrayList<>();

        // Adiciona os jogos
        jogos.add(new Jogo(" League of Legends", "MOBA", "caminho/do/icone1.png"));
        jogos.add(new Jogo(" Fortnite", "Battle Royale FPS", "caminho/do/icone2.png"));
        jogos.add(new Jogo(" Stardew Valley", "Farming simulation", "caminho/do/icone3.png"));
        jogos.add(new Jogo(" Palworld", "RPG", "caminho/do/icone4.png"));
        jogos.add(new Jogo(" Elden Ring", "Soulslike", "caminho/do/icone5.png"));
        jogos.add(new Jogo(" Minecraft", "Simulation", "caminho/do/icone6.png"));
    }

    public List<Jogo> getJogos() {
        return jogos;
    }
}
