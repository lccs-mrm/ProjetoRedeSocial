package Exceções;

public class SenhaInvalidaException extends RuntimeException{
    public String getMessage(){
        return "Senha inválida";
    }
}

