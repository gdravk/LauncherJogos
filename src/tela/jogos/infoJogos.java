package tela.jogos;

import java.util.ArrayList;
import java.util.List;

public class infoJogos {
    private List<Jogo> jogos;
    private List<String> urls; // Adicione uma lista para armazenar as URLs dos jogos

    public infoJogos() {
        jogos = new ArrayList<>();
        urls = new ArrayList<>();

        // Adiciona os jogos
        jogos.add(new Jogo("League of Legends", "MOBA", "src/tela/imagens/logoJogos/league_of_legends_logo.png"));
        urls.add("https://youtu.be/aR-KAldshAE?si=6IjPbBbcMTxMNeVe");

        jogos.add(new Jogo("Fortnite", "Battle Royale FPS", "src/tela/imagens/logoJogos/fortnite_logo.jpeg"));
        urls.add("https://youtu.be/eHBN4oBAwiA?si=CpfK58ZEdvQynYEu");

        jogos.add(new Jogo("Stardew Valley", "Farming simulation",
                "src/tela/imagens/logoJogos/stardew_valley_logo.jpg"));
        urls.add("https://youtu.be/ot7uXNQskhs?si=BnyQelVVkZTAUOcm");

        jogos.add(new Jogo("Palworld", "RPG", "src/tela/imagens/logoJogos/palworld_logo.jpg"));
        urls.add("https://youtu.be/D9w97KSEAOo?si=3ONTsXTm6Y6dUCLV");

        jogos.add(new Jogo("Elden Ring", "Soulslike", "src/tela/imagens/logoJogos/elden_ring_logo.jpg"));
        urls.add("https://youtu.be/E3Huy2cdih0?si=laIKCzBWt55fsv95");

        jogos.add(new Jogo("Minecraft", "Sandbox Simulation", "src/tela/imagens/logoJogos/minecraft_logo.jpg"));
        urls.add("https://youtu.be/Rla3FUlxJdE?si=_PlD3U1BFC5i93nU");

    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    // Método para obter a URL correspondente ao jogo no índice especificado
    public String getUrl(int index) {
        return urls.get(index);
    }
    
}
