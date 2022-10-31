import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProdutoDAO {

    private Connection connection;

    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }

    public void salvar(Produto produto) {
        try {
            String comandoSQL = "insert into produtos (nome, descricao, quantidade, preco) values (?, ?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(comandoSQL, Statement.RETURN_GENERATED_KEYS)) {

                ps.setString(1, produto.getNome());
                ps.setString(2, produto.getDescricao());
                ps.setInt(3, produto.getQuantidade());
                ps.setDouble(4, produto.getPreco());

                ps.execute();

                try (ResultSet rs = ps.getGeneratedKeys()) {
                    while (rs.next()) {
                        produto.setId(rs.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void alterar(int id, String nome, String descricao, int quantidade, double preco) {
        try {
            String comandoSQL = "update produtos set nome = ?, descricao = ?, quantidade = ?, preco = ? where id = ?";

            try (PreparedStatement ps = connection.prepareStatement(comandoSQL)) {

                ps.setString(1, nome);
                ps.setString(2, descricao);
                ps.setInt(3, quantidade);
                ps.setDouble(4, preco);
                ps.setInt(5, id);

                ps.execute();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(int id) {
        try {
            String comandoSQL = "delete from produtos where id = ?";

            try (PreparedStatement ps = connection.prepareStatement(comandoSQL)) {
                ps.setInt(1, id);

                ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
