import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {
    
    private Connection connection;

    public FilmeDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Filme> listarComFiltro(int id1, int id2) {
        try {
            List<Filme> filmes = new ArrayList<>();
            String comandoSQL = "select nome, ano, descricao from filmes where id >= ? and id <= ?";
            
            try (PreparedStatement ps = connection.prepareStatement(comandoSQL)) {

                ps.setInt(1, id1);
                ps.setInt(2, id2);

                ps.execute();
                transformarResultSetEmFilmes(filmes, ps);
            }
            return filmes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void transformarResultSetEmFilmes(List<Filme> filmes, PreparedStatement ps) {
        try {
			try (ResultSet rs = ps.getResultSet()) {
				while (rs.next()) {
					Filme filme = new Filme(rs.getString(1), rs.getInt(2), rs.getString(3));

					filmes.add(filme);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
    }
}
