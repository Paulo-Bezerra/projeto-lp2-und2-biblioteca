package modelo;

public class Credencias {
    private String login;
    private String senha;

    public Credencias(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Credencias(Credencias credencias) {
        this.login = credencias.getLogin();
        this.senha = credencias.getSenha();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
