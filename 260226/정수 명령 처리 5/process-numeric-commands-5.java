import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");

            if(line[0].equals("size")) {
                System.out.println(arr.size());
                continue;
            }
            if(line[0].equals("pop_back")) {
                arr.remove(arr.size() - 1);
                continue;
            }
            if(line[0].equals("get")) {
                System.out.println(arr.get(Integer.parseInt(line[1]) - 1));
                continue;
            }
            if(line[0].equals("push_back")) {
                arr.add(Integer.parseInt(line[1]));
                continue;
            }

        }
    }
}