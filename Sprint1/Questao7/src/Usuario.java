
public class Usuario {
    private String usuario;
    private String senha;
    
    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void cadastra(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    

}
