//Classe usuário
public class Usuario {
    private String usuario;
    private String senha;

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    // Método que cadastra o usuário, substituindo o set.
    public void cadastra(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

}