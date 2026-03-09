import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < M; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if(cmd.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                set.add(x);
            }

            else if(cmd.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                set.remove(x);
            }

            else if(cmd.equals("check")) {
                int x = Integer.parseInt(st.nextToken());

                if(set.contains(x)) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            }

            else if(cmd.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());

                if(set.contains(x)) {
                    set.remove(x);
                } else {
                    set.add(x);
                }
            }

            else if(cmd.equals("all")) {
                set.clear();
                for(int j = 1; j <= 20; j++) {
                    set.add(j);
                }
            }

            else if(cmd.equals("empty")) {
                set.clear();
            }
        }

        System.out.print(sb);
    }
}