package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static encryptdecrypt.Arguments.*;

public class Data {

    private int key = 0;
    private String alg = "shift";
    private String mode = "eng";
    private String message = "";
    private List<String> commands;

    public Data(String[] args) {
        commands = Arrays.asList(args);

        if (commands.contains(MODE.getCode())) {
            mode = commands.get(commands.indexOf(MODE.getCode()) + 1);
        }
        if (commands.contains(KEY.getCode())) {
            key = Integer.parseInt(commands.get(commands.indexOf(KEY.getCode()) + 1));
        }
        if (commands.contains(ALG.getCode())) {
            alg = commands.get(commands.indexOf(ALG.getCode()) + 1);
        }
    }

    public void input() {
        if (commands.contains(IN.getCode()) && commands.contains(DATA.getCode())) {
            message = commands.get(commands.indexOf(DATA.getCode()) + 1);
        } else if (commands.contains(IN.getCode())) {
            String inputFile = commands.get(commands.indexOf(IN.getCode()) + 1);
            File file = new File(inputFile);

            try (Scanner in = new Scanner(file)) {
                message = in.nextLine();
            } catch (FileNotFoundException e) {
                System.out.println("Error");
            }
        }
    }

    public void output() {
        if (commands.contains(OUT.getCode())) {
            String outputFile = commands.get(commands.indexOf(OUT.getCode()) + 1);
            File file = new File(outputFile);

            try (FileWriter writer = new FileWriter(file)) {
                writer.write(message);
            } catch (IOException e) {
                System.out.println("Error");
            }
        } else {
            System.out.println(message);
        }
    }

    public void convert(SelectionAlgorithm algorithm) {
        if (mode.equals("enc")) {
            message = algorithm.encrypt(message, key);
        } else {
            message = algorithm.decrypt(message, key);
        }
    }

    public String getAlg() {
        return alg;
    }
}
