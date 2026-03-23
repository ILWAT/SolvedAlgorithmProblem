import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 1; i<=n; i++) {
            al.add(i);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int index = 0;
        while (!al.isEmpty()) {
            index = (index+k-1) % al.size();

            sb.append(al.remove(index));

            if (!al.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append(">");
        System.out.println(sb.toString());
    }
}