// Caio Luiz
// Gustavo Ramos
// Douglas Cardoso

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class Twitter {
    static ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
    static ArrayList<Tweet> listaTweet = new ArrayList<Tweet>();
    static Scanner leitor = new Scanner(System.in);

    // recebe true no metodo logarUsuario
    static boolean logado = false;

    public static void main(String[] args) {
        int n = 0;

        do {
            System.out.println("Menu");
            System.out.println("1 - Cadastrar Usuário");
            System.out.println("2 - Listar Usuário");
            System.out.println("3 - Logar Usuário");
            System.out.println("4 - Deslogar Usuário");
            System.out.println("5 - Twittar");
            System.out.println("6 - Mostrar últimos N tweets do feed");
            System.out.println("7 - Remover tweet de um Usuário");
            System.out.println("8 - Alterar senha de um Usuário");
            System.out.println("9 - Remover um Usuário");
            System.out.println("10 - Imprimir estastísticas");
            System.out.println("0 - Finalizar programa");

            n = leitor.nextInt();
            leitor.nextLine();

            switch (n) {
                case 0:
                    System.out.println("\nPrograma finalizado!");
                    break;
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    listarUsuario();
                    break;
                case 3:
                    logarUsuario();
                    break;
                case 4:
                    deslogarUsuario();
                    break;
                case 5:
                    twittar();
                    break;
                case 6:
                    mostrarUltimosTweets();
                    break;
                case 7:
                    removerTweet();
                    break;
                case 8:
                    alterarSenha();
                    break;
                case 9:
                    removerUsuario();
                    break;
                case 10:
                    imprimirEstastiticas();
                    break;
                // default:
                // System.out.println("Opção inválida!");
            }
        } while (n != 0);
    }

    public static void cadastrarUsuario() {
        System.out.println("\nDigite o nome");
        String nome = leitor.nextLine();
        System.out.println("\nDigite o seu login");
        String login = leitor.nextLine();
        System.out.println("\nDigite seu e-mail");
        String email = leitor.nextLine();
        System.out.println("\nDigite uma senha");
        String senha = leitor.nextLine();

        if (nome.length() >= 2 && nome.length() <= 30) {
            if (login.length() >= 2 && login.length() <= 20) {
                if (email.length() >= 6 && email.length() <= 30) {
                    if (senha.length() >= 6 && senha.length() <= 15) {
                        Usuario usuario = new Usuario(nome, login, email, senha);

                        listaUsuario.add(usuario);
                        System.out.println("\nCadastro realizado com sucesso!\n");

                        return;
                    }
                }
            }
        }
        System.out.println("\nInformações inválidas! Favor inserir corretamente");

        return;
    }

    public static void listarUsuario() {
        Iterator<Usuario> iter = listaUsuario.iterator();

        while (iter.hasNext()) {
            Usuario itemLista = iter.next();
            System.out.println(itemLista.getLogin());
        }
    }

    public static void logarUsuario() {
        System.out.println("Informe o nome do login:");
        String login = leitor.nextLine();
        System.out.println("Informe a senha:");
        String senha = leitor.nextLine();

        Iterator<Usuario> iter = listaUsuario.iterator();

        while (iter.hasNext()) {
            Usuario itemLista = iter.next();

            if (login.equals(itemLista.getLogin()) && senha.equals(itemLista.getSenha())) {
                System.out.println("Login realizado com sucesso!");
                logado = true;
                return;
            } else {
                System.out.println("Dados incorretos!");
                logado = false;

            }
        }
        return;

    }

    public static void deslogarUsuario() {
        System.out.println("Informe o login que deseja deslogar: ");
        String login = leitor.nextLine();

        Iterator<Usuario> iter = listaUsuario.iterator();

        while (iter.hasNext()) {
            Usuario itemLista = iter.next();

            if (login.equals(itemLista.getLogin())) {
                logado = false;
                System.out.println("Usúario deslogado!");
                return;
            } else {
                System.out.println("Login incorreto");
                return;
            }
        }
    }

    public static void twittar() {
        if (logado == true) {
            System.out.println("Informe o login do usuario que deseja twittar:");
            String login = leitor.nextLine();

            Usuario usuario = null;
            for (Usuario itemLista : listaUsuario) {
                if (login.equals(itemLista.getLogin())) {
                    usuario = itemLista;
                    break;
                }
            }

            if (usuario != null) {
                System.out.println("Novo tweet (1 a 140 caracteres): ");
                String publicar = leitor.nextLine();
                if (publicar.length() >= 1 && publicar.length() <= 140) {
                    Tweet tweet = new Tweet(usuario.getNome(), usuario.getLogin(), publicar);
                    listaTweet.add(tweet);
                } else {
                    System.out.println("O Tweet deve conter entre 1 e 140 caracteres!");
                }
            } else {
                System.out.println("Usuário não encontrado na lista de usuários!");
            }
        } else {
            System.out.println("Você precisa estar logado para poder twittar!");
        }
    }

    public static void mostrarUltimosTweets() {
        if (logado == true) {
            System.out.println("Informe a quantidade de tweets que deseja ver:");
            int n = leitor.nextInt();

            // Mostrar n ultimos tweets
            int i = listaTweet.size() - n;
            i = i < 0 ? 0 : i; // verificar se o indice é negativo
            for (; i < listaTweet.size(); i++) {
                Tweet tweet = listaTweet.get(i);
                System.out.println(tweet.getNome() + ": " + tweet.getTweet());
            }
        } else {
            System.out.println("Você precisa estar logado para poder tweetar!");
            return;
        }
    }

    public static void removerTweet() {
        if (logado == true) {
            System.out.println("Informe o login do usuario que deseja remover um tweet:");
            String login = leitor.nextLine();

            // Cria uma arraylist para armazenar os tweets de cada usuario no momento em
            // que se chama o metodo
            ArrayList<Tweet> tweetUsuario = new ArrayList<Tweet>();

            for (Tweet tweet : listaTweet) {
                if (tweet.getLogin().equals(login)) {
                    tweetUsuario.add(tweet);
                }
            }

            // Apresenta os tweets do usuario
            int num = 1;
            for (Tweet tweet : tweetUsuario) {
                System.out.println(num + ": " + tweet.getTweet());
                num++;
            }

            // Remover o tweet pelo numero identificador (var num)
            System.out.println("Informe o numero do tweet que deseja remover: ");
            int remov = leitor.nextInt();
            System.out.println(remov);

            // remover o tweet das duas arraylist e apresenta o tweet removido
            if (tweetUsuario.size() > remov) {
                Tweet tweetRemover = tweetUsuario.get(remov - 1);
                listaTweet.remove(tweetRemover);
                tweetUsuario.remove(tweetRemover);
                System.out.println("Tweet: " + tweetRemover + "\nremovido com sucesso!");

            } else {
                System.out.println("Numero invalido!");
                return;
            }
        } else {
            System.out.println("Você precisa estar logado para poder tweetar!");
            return;
        }

    }

    public static void alterarSenha() {
        if (logado) {
            System.out.println("Digite o usúario do qual deseja alterar a senha: ");
            String login = leitor.nextLine();
            System.out.println("Digite a senha atual do usuario: ");
            String senha = leitor.nextLine();

            Iterator<Usuario> iter = listaUsuario.iterator();

            while (iter.hasNext()) {
                Usuario itemLista = iter.next();

                if (login.equals(itemLista.getLogin()) && senha.equals(itemLista.getSenha())) {
                    System.out.println("Informe a nova senha do usuario: ");
                    String novaSenha = leitor.nextLine();
                    itemLista.setSenha(novaSenha);
                    System.out.println("Senha alterada com sucesso!");
                    return;
                } else {
                    System.out.println("Senha incorreta!");
                    return;
                }
            }
            return;

        } else {
            System.out.println("Voce precisa estar logado para fazer alterações nos usúarios!");
            return;
        }
    }

    public static void removerUsuario() {
        System.out.println("Informe o login:");
        String login = leitor.nextLine();
        System.out.println("Informe a senha:");
        String senha = leitor.nextLine();

        Iterator<Usuario> iter = listaUsuario.iterator();

        boolean usuarioEncontrado = false;
        while (iter.hasNext()) {
            Usuario itemLista = iter.next();

            if (login.equals(itemLista.getLogin()) && senha.equals(itemLista.getSenha())) {
                iter.remove();
                System.out.println("Usúario removido com sucesso!");
                usuarioEncontrado = true;
            }
        }
        if (!usuarioEncontrado) {
            System.out.println("Dados incorretos!");
        }

    }

    /**
     * 
     */
    public static void imprimirEstastiticas() {
        // imprimir o número total de usúarios cadastrados
        int totalUsuarios = listaUsuario.size();
        System.out.println("Número total de usúarios cadastrados: " + totalUsuarios);

        // Numero de usuarios logados no momento
        int usuariosLogados = 0;
        for (Usuario usuario : listaUsuario) {
            if (usuario.isLogado()) {
                usuariosLogados++;
            }
        }
        System.out.println("Numero de usuarios logados neste momento: " + usuariosLogados);

        // Numero total de Tweets
        int totalTweets = listaTweet.size();
        System.out.println("Numero total de tweets no momento: " + totalTweets);

        // Numero de tweets por Usúario
        System.out.println("Número de tweets por usúario: ");
        for (Usuario usuario : listaUsuario) {
            String login = usuario.getLogin();
            int quantidadeTweets = 0;
            for (Tweet tweet : listaTweet) {
                if (tweet.getLogin().equals(login)) {
                    quantidadeTweets++;
                }
            }
            System.out.println(login + ": " + quantidadeTweets);
        }

        // Login do usuario que mais tweetou e a qauntidade
        int maisTweets = 0;
        String usuarioMaisAtivo = "";
        for (Usuario usuario : listaUsuario) {
            String login = usuario.getLogin();
            int quantidadeTweets = 0;
            for (Tweet tweet : listaTweet) {
                if (tweet.getLogin().equals(login)) {
                    quantidadeTweets++;
                }
                if (quantidadeTweets > maisTweets) {
                    maisTweets = quantidadeTweets;
                    usuarioMaisAtivo = login;

                    System.out.println(
                            "Login do usúario que mais tweetou: " + usuarioMaisAtivo + "\nQuantidade de tweets: "
                                    + maisTweets);
                }
            }

            // Login do usuario que tweetou por ultimo e o proprio tweet,
            Tweet ultimoTweet = listaTweet.get(listaTweet.size() - 1);

            String loginUltimoTweet = ultimoTweet.getLogin();
            String mensagemUltimoTweet = ultimoTweet.getTweet();

            if (usuario.getLogin().equals(loginUltimoTweet)) {
                System.out.println("Login do usúario que tweetou por ultimo: " + loginUltimoTweet);
                System.out.println("Mensagem Ultimo Tweet: " + mensagemUltimoTweet);
                return;
            }

        }

    }
}
