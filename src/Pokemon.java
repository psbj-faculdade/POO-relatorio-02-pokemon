public class Pokemon {
    private String nome;
    private String genero;
    private String regiao;
    private String elemento;
    private String cor;
    private String evolucao;

    public Pokemon(String nome, String genero, String regiao, String elemento, String cor, String evolucao) {
        this.nome = nome;
        this.genero = genero;
        this.regiao = regiao;
        this.elemento = elemento;
        this.cor = cor;
        this.evolucao = evolucao;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public String getRegiao() {
        return regiao;
    }

    public String getElemento() {
        return elemento;
    }

    public String getCor() {
        return cor;
    }

    public String getEvolucao() {
        return evolucao;
    }
}
