package encryptdecrypt;

public class SelectionAlgorithm {

    private Algorithm algorithm;

    public SelectionAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public String encrypt(String message, int key) {
        return algorithm.encryption(message, key);
    }

    public String decrypt(String message, int key) {
        return algorithm.decryption(message, key);
    }
}
