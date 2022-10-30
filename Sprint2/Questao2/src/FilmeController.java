import java.sql.Connection;
import java.util.List;

public class FilmeController {

    private FilmeDAO filmeDAO;

    public FilmeController() {
        Connection connection = new ConnectionFactory().efetuarConexao();
        this.filmeDAO = new FilmeDAO(connection);
    }

    public List<Filme> listarComFiltro(int pagina, int quantidadeFilmes) {
        quantidadeFilmes += (pagina - 1) * 10;
        if (pagina == 2) {
            pagina = 11;
        }
        return this.filmeDAO.listarComFiltro(pagina, quantidadeFilmes);
    }
}
