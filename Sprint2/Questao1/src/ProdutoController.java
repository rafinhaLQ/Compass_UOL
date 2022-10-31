import java.sql.Connection;

public class ProdutoController {

    private ProdutoDAO produtoDAO;

    public ProdutoController() {
        Connection connection = new ConnectionFactory().efetuarConexao();
        this.produtoDAO = new ProdutoDAO(connection);
    }

    public void cadastrar(Produto produto) {
        this.produtoDAO.salvar(produto);
        System.out.println("Produto " + produto.getNome() + " cadastrado!");
    }

    public void atualizar(int id, String nome, String descricao, int quantidade, double preco) {
        this.produtoDAO.alterar(id, nome, descricao, quantidade, preco);
        System.out.println("Produto " + nome + " alterado!");
    }

    public void excluir(int id) {
        this.produtoDAO.excluir(id);
        System.out.println("Produto excluido do sistema!");
    }
}
