package exceptions;

public class EmptyNameException extends RuntimeException {

    public EmptyNameException() {
        super("Empty Name input.");
    }

}
