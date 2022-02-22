package encryptdecrypt;

public class Unicode implements Algorithm {

    private String changeMessage(String message, int key) {
        char[] symbols = message.toCharArray();

        for (int i = 0; i < symbols.length; i++) {
            symbols[i] = (char) (symbols[i] + key);
        }

        return new String(symbols);
    }

    @Override
    public String encryption(String message, int key) {
        return changeMessage(message, key);
    }

    @Override
    public String decryption(String message, int key) {
        return changeMessage(message, -key);
    }
}
