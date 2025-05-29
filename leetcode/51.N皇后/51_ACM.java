import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static List<List<String>> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] col = new int[n];
        boolean[] isChosen = new boolean[n];
        boolean[] r_diagonal = new boolean[2 * n - 1];
        boolean[] l_diagonal = new boolean[2 * n - 1];
        dfs(0, n, col, isChosen, r_diagonal, l_diagonal);
        for(List<String> list : res){
            for(String s: list){
                System.out.print(s + ", ");
            }
            System.out.println();
        }
    }
    private static void dfs(int i, int n, int[] col, boolean[] isChosen, boolean[] r_diagonal, boolean[] l_diagonal){
        if(i == n){
            List<String> path = new ArrayList<>();
            char[] ch = new char[n];
            for(int j = 0; j < n; j++){
                Arrays.fill(ch, '.');
                ch[col[j]] = 'Q';
                path.add(Arrays.toString(ch));
            }
            res.add(path);
            return;
        }
        for(int k = 0; k < n; k++){
            if(!isChosen[k] && !r_diagonal[i + k] && !l_diagonal[i - k + n - 1]){
                col[i] = k;
                isChosen[k] = r_diagonal[i + k] = l_diagonal[i - k + n - 1] = true;
                dfs(i + 1, n, col, isChosen, r_diagonal, l_diagonal);
                isChosen[k] = r_diagonal[i + k] = l_diagonal[i - k + n - 1] = false;

            }
        }
    }

}
