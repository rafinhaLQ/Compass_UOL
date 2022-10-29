public class Filme {

    private String nome;
    private String descricao;
    private int ano;

    public Filme(String nome, int ano, String descricao) {
        this.nome = nome;
        this.ano = ano;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return String.format("%s (%d)\n%s", this.nome, this.ano, this.descricao);
    }
}
