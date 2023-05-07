// Caio Luiz
// Gustavo Ramos
// Douglas Cardoso

public class Usuario {
    // atributos
    private String nome, login, email, senha;
    private boolean logado;

    // construtor
    public Usuario() {
        
    }

    public Usuario(String nome, String login, String email, String senha) {
        this.nome = nome;
        this.login = login;
        this.email = email;
        this.senha = senha;
        this.logado = false;
    }

    // metodos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isLogado() {
        return logado = true;
    }

    @Override
    public String toString() {
        return "Usuario [nome=" + nome + ", login=" + login + ", email=" + email + ", senha=" + senha + "]";
    }

    public void add(Tweet tweet) {
    }
}
