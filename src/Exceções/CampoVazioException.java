package Exceções;

public class CampoVazioException extends RuntimeException{
    public String getMessage(){
        return "Apenas caracteres alfanuméricos";
    }
}

