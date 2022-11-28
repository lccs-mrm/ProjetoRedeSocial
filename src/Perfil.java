import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Perfil {
    private String nome;
    private String login;
    private String senha;
    List<Post> posts = new ArrayList<>();

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    void postar() {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o conteúdo: ");
        String texto = entrada.nextLine();

        Post post = new Post();

        post.setData(LocalDate.now());
        post.setHora(LocalTime.now());
        post.setTexto(texto);
        this.posts.add(post);

        System.out.println("\nPost realizado!");
    }

    void timeline() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        if (this.posts.size() > 0) {
            System.out.println("\nTimeline de \n" + this.nome);
            for (Post p : this.posts) {
                System.out.println("\n\t" + p.getData().format(dateFormatter) + " às " + p.getHora().format(timeFormatter) + " - " + p.getTexto());
            }
        } else {
            System.out.println("\n\tNão há posts em seu perfil " + this.nome);
        }
    }
}