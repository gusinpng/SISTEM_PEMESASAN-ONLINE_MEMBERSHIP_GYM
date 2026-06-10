// Dibuat oleh Matthew - Custom Exception pembayaran
public class InvalidPaymentException extends Exception {

    public InvalidPaymentException(String message) {
        super(message);
    }
}