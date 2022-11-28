package Exceções;

public class UsuarioEmUsoException extends RuntimeException {
    public String getMessage(){
        return "Este nome de usuário está em uso, por favor, selecione outro";
    }
}
