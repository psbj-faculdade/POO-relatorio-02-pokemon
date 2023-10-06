public class Pergunta {
    private String textoPergunta;
    private Pergunta respostaSim;
    private Pergunta respostaNao;
    private boolean eFinal;

    public Pergunta(String textoPergunta) {
        this.textoPergunta = textoPergunta;
        this.respostaSim = null;
        this.respostaNao = null;
        this.eFinal = false;
    }

    public void definirRespostaSim(Pergunta resposta) {
        this.respostaSim = resposta;
    }

    public void definirRespostaNao(Pergunta resposta) {
        this.respostaNao = resposta;
    }

    public boolean eFinal() {
        return this.eFinal;
    }

    public void tornarFinal() {
        this.eFinal = true;
    }

    public String getTextoPergunta() {
        return textoPergunta;
    }
}
