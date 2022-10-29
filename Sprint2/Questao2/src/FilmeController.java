import java.sql.Connection;
import java.util.List;

public class FilmeController {
    
    private FilmeDAO filmeDAO;

    public FilmeController() {
        Connection connection = new ConnectionFactory().efetuarConexao();
        this.filmeDAO = new FilmeDAO(connection);
    }

    public List<Filme> listarComFiltro(int id1, int id2) {
        return this.filmeDAO.listarComFiltro(id1, id2);
    }
}
