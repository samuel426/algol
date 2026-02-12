import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        ArrayDeque<Integer> list = new ArrayDeque<>();
        ArrayDeque<Integer> list2 = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            list.addLast(temp);
        }

        int s1 = sc.nextInt()-1;
        int e1 = sc.nextInt()-1;
        int s2 = sc.nextInt()-1;
        int e2 = sc.nextInt()-1;

        for(int i = 0; i < s1; i++) {
            int temp = list.removeFirst();
            list2.addLast(temp);
        }

        for(int i = s1; i <= e1; i++) {
            list.removeFirst();
        }

        for(int i = 0; i < s1; i++) {
            list.addFirst(list2.removeLast());
        }
        list2.clear();

        for(int i = 0; i < s2; i++) {
            int temp = list.removeFirst();
            list2.addLast(temp);
        }

        for(int i = s2; i <= e2; i++) {
            list.removeFirst();
        }

        for(int i = 0 ; i < s2; i++) {
            list.addFirst(list2.removeLast());
        }
        list2.clear();


        if(list.isEmpty()) {
            System.out.print(0);
            return;
        }
        System.out.println(list.size());
        while(!list.isEmpty()) {
            System.out.println(list.removeFirst());
        }
    }
}