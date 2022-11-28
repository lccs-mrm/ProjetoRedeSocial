import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner menu = new Scanner(System.in);
        RedeSocial redeSocial = new RedeSocial();

        while (true) {

            System.out.print("##------Bem-vindo ao Jardim de Epicuro-------##\n\n");
            System.out.print("|--------------------------------------------|\n");
            System.out.print("| Opção C - Cadastrar-se                     |\n");
            System.out.print("| Opção E - Entrar                           |\n");
            System.out.print("| Opção F - Fechar                           |\n");
            System.out.print("|--------------------------------------------|\n");
            System.out.print("Digite uma opção: ");

            String opcao = menu.next();

            if (opcao.equals("F")) {
                System.out.print("\nAté logo!");
                menu.close();
                break;
            }

            switch (opcao) {
                case "C" -> {
                    System.out.println("\nOpção Cadastro \n");
                    redeSocial.cadastrarPerfil();
                }
                case "E" -> {
                    System.out.println("\nOpção Entrar\n");
                    redeSocial.entrar();
                }
                default -> System.out.println("\nOpção Inválida!");
            }
        }
    }
}