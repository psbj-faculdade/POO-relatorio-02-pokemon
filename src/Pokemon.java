public class Pokemon {
    private String nome;
    private String genero;
    private String regiao;
    private String elemento;
    private String cor;
    private String evolucao;
    private String evolucao1;
    private String evolucao2;

    public Pokemon(String nome, String genero, String regiao, String elemento, String cor, String evolucao, String evolucao1, String evolucao2) {
        this.nome = nome;
        this.genero = genero;
        this.regiao = regiao;
        this.elemento = elemento;
        this.cor = cor;
        this.evolucao = evolucao;
        this.evolucao1 = evolucao1;
        this.evolucao2 = evolucao2;
    }

    public String getNome() {
        return nome;
    }

    public boolean temCaracteristica(int indiceCaracteristica) {
        switch (indiceCaracteristica) {
            case 0:
                return "Água".equalsIgnoreCase(elemento);
            case 1:
                return "Voador".equalsIgnoreCase(elemento);
            case 2:
                return "Kanto".equalsIgnoreCase(regiao);
            case 3:
                return "Terra".equalsIgnoreCase(elemento);
            case 4:
                return "Fogo".equalsIgnoreCase(elemento);
            case 5:
                return "Johto".equalsIgnoreCase(regiao);
            case 6:
                return "Dragão".equalsIgnoreCase(elemento);
            case 7:
                return "Elétrico".equalsIgnoreCase(elemento);
            case 8:
                return "laranja".equalsIgnoreCase(cor);
            case 9:
                return "Planta".equalsIgnoreCase(elemento);
            case 10:
                return "Lutador".equalsIgnoreCase(elemento);
            case 11:
                return "Venenoso".equalsIgnoreCase(elemento);
            case 12:
                return "Pedra".equalsIgnoreCase(elemento);
            case 13:
                return "Genderless".equalsIgnoreCase(genero);
            case 14:
                return "Masculino".equalsIgnoreCase(genero);
            case 15:
                return evolucao != null;
            case 16:
                return "rosa".equalsIgnoreCase(cor);
            case 17:
                return "azul".equalsIgnoreCase(cor);
            case 18:
                return "Branco".equalsIgnoreCase(cor);
            default:
                return false;
        }
    }
}
