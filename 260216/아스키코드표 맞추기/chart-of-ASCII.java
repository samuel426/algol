import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        for(int i = 0; i < line.length; i++) {
            char c = (char) Integer.parseInt(line[i]);
            System.out.print(c + " ");
        }

    }
}