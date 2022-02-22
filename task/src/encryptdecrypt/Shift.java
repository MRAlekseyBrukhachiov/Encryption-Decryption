package encryptdecrypt;

public class Shift implements Algorithm {

    @Override
    public String encryption(String message, int key) {
        char[] symbols = message.toCharArray();

        for (int i = 0; i < symbols.length; i++) {
            int dif = Character.isLetter(symbols[i]) ? key : 0;

            if (Character.isLowerCase(symbols[i]) && symbols[i] + key > 122 ||
                    Character.isUpperCase(symbols[i]) && symbols[i] + key > 90) {
                dif -= 26;
            }

            symbols[i] = (char) (symbols[i] + dif);
        }

        return new String(symbols);
    }

    @Override
    public String decryption(String message, int key) {
        char[] symbols = message.toCharArray();

        for (int i = 0; i < symbols.length; i++) {
            int dif = Character.isLetter(symbols[i]) ? key : 0;

            if (Character.isLowerCase(symbols[i]) && symbols[i] - key < 97 ||
                    Character.isUpperCase(symbols[i]) && symbols[i] - key < 65) {
                dif -= 26;
            }

            symbols[i] = (char) (symbols[i] - dif);
        }

        return new String(symbols);
    }
}