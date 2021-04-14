package com.compasso.productms.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(){
        super("Não foi possível encontrar o produto com o id inserido");
    }

}
