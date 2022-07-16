package Exceptions;

public class BuyProductException extends Exception {
    public BuyProductException(String error){
        super(error);
    }
}
