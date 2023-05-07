// Caio Luiz
// Gustavo Ramos
// Douglas Cardoso

import java.util.Date;

public class Tweet {

    String nome, login, tweet;
    Date dataPostagem;

    public Tweet(String nome, String login, String tweet) {
        this.nome = nome;
        this.login = login;
        this.tweet = tweet;
        this.dataPostagem = new Date();
    }

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

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public Date getDataPostagem() {
        return dataPostagem;
    }

    public void setDataPostagem(Date dataPostagem) {
        this.dataPostagem = dataPostagem;
    }

    @Override
    public String toString() {
        return "Tweet: " + tweet + " Nome:" + nome + "\n";
    }

}
