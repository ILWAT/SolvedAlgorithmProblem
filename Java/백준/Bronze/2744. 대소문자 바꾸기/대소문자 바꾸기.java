import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputString = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inputString.length(); i++) {
            String currentChar = String.valueOf(inputString.charAt(i));
            String currentCharUpper = currentChar.toUpperCase();
            if (currentChar.equals(currentCharUpper)) {
                sb.append(currentChar.toLowerCase());
            } else {
                sb.append(currentCharUpper);
            }
        }
        System.out.println(sb.toString());
    }
}