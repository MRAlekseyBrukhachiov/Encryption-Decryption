package encryptdecrypt;

public interface Algorithm {

    String encryption(String message, int key);
    String decryption(String message, int key);
}
