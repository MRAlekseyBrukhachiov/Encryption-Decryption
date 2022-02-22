package encryptdecrypt;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Data data = new Data(args);

        SelectionAlgorithm algorithm;

        if (data.getAlg().equals("unicode")) {
            algorithm = new SelectionAlgorithm(new Unicode());
        } else {
            algorithm = new SelectionAlgorithm(new Shift());
        }

        data.input();
        data.convert(algorithm);
        data.output();
    }
}
