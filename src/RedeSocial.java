import Exceções.CampoVazioException;
import Exceções.SenhaInvalidaException;
import Exceções.UsuarioEmUsoException;
import Exceções.UsuarioNEncontradoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RedeSocial {
    private List<Perfil> perfis = new ArrayList<>();
    void cadastrarPerfil(){

        Scanner entrada = new Scanner(System.in);
        try {
            System.out.print("Digite seu nome: ");
            String nome = entrada.nextLine().toUpperCase();

            System.out.print("Escola um login: ");
            String login = entrada.nextLine();

            System.out.print("Escolha uma senha: ");
            String senha = entrada.nextLine();

            if (nome.isEmpty() || nome.isBlank() || login.isEmpty() || login.isBlank() || senha.isEmpty() || senha.isBlank()) {
                throw new CampoVazioException();
            }
            for (Perfil p : perfis) {
                if (p.getLogin().equals(login)) {
                    throw new UsuarioNEncontradoException();
                }
            }

        Perfil perfil = new Perfil();
        perfil.setNome(nome);
        perfil.setLogin(login);
        perfil.setSenha(senha);
        this.perfis.add(perfil);
        System.out.println("Cadastro realizado com sucesso!");

        } catch (CampoVazioException e) {
            System.out.println(e.getMessage());
        } catch (UsuarioEmUsoException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Cadastro não realizado.");
        }
    }

    void entrar() {
        if (perfis.size() == 0) {
            System.out.println("\nNenhum perfil cadastrado.\n");
        } else {
            try {
                Scanner entrada = new Scanner(System.in);

                System.out.println("\nENTRAR\n");

                System.out.print("Login: ");
                String login = entrada.nextLine();
                //Perfil perfil = (Perfil) this.perfis.stream().filter(p -> p.getLogin().equals(login));
                Perfil perfil = null;
                for(Perfil p: this.perfis){
                    if(p.getLogin().equals(login)){
                        perfil = p;
                    }
                }

                System.out.print("Senha: ");
                String senha = entrada.nextLine();

                if (perfil == null) {
                    throw new UsuarioNEncontradoException();
                } else if (perfil.getSenha().equals(senha)){
                    opcoesDoPerfil(perfil);
                }
            } catch (UsuarioNEncontradoException e) {
                System.out.println(e.getMessage());
            } catch (SenhaInvalidaException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Usuário não encontrado.");
            }
        }
    }
    void menuInicialPerfil() {
        System.out.println("\n Selecione um das opções:");
        System.out.println("\t P - Postar");
        System.out.println("\t T - Timeline");
        System.out.println("\t S - Sair");
    }
    String opcaoPerfil() {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Opção: ");
        return entrada.nextLine().toUpperCase();
    }
    void opcoesDoPerfil(Perfil perfil) {
        String opcao;
        do {
            System.out.println("\nBem-vindo, " + perfil.getNome());
            menuInicialPerfil();
            opcao = opcaoPerfil();
            switch (opcao) {
                case "P" -> perfil.postar();
                case "T" -> perfil.timeline();
                case "S" -> System.out.println("Logout...");
                default -> System.out.println("Opção inválida!");
            }
        } while (!opcao.equals("S"));
    }
}
