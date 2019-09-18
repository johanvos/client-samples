package hello;

public class GLException extends Exception {

    GLException(int errorCode, String message) {
        super("0x" + Integer.toHexString(errorCode) + ": " + message);
    }

}
