package Exceções;

public class UsuarioNEncontradoException extends RuntimeException{
    public String getMessage(){
        return "Usuário inválido!";
    }
}
