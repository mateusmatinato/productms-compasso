package com.compasso.productms.exception;

public class GenericException extends RuntimeException {
    private String error;

    public GenericException(Exception e){
        super("Ocorreu um erro ao tentar executar essa operação. Tente novamente.");
        this.setError(e.getMessage());
    }

    public String getError(){
        return this.error;
    }

    private void setError(String error){
        this.error = error;
    }
}
