package tela.jogos;

public class Jogo {
    private String nome;
    private String descricao;
    private String caminhoIcone;

    public Jogo(String nome, String descricao, String caminhoIcone) {
        this.nome = nome;
        this.descricao = descricao;
        this.caminhoIcone = caminhoIcone;
    }

    // Métodos getters para acessar os atributos privados
    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCaminhoIcone() {
        return caminhoIcone;
    }
}
