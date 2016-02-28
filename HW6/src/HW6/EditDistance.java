package HW6;

import java.io.File;
import java.util.Scanner;

public class EditDistance {
    @SuppressWarnings("null")
	public static void main(String[] args) {
        //System.out.println(System.getProperty("user.dir"));
        File file = new File("DNASTRINGS.txt");
        String y = "";
        String z = "";
        try {
            @SuppressWarnings("resource")
			Scanner in = new Scanner(file);
            y = in.nextLine();
            z = in.nextLine();
            
        } catch (Exception e) {
        System.out.println(e);
        }
        
        System.out.println(y + " " + z);
        
        int c,i,m,j,n;
        c=i=m=j=n =0;
        int[][] d = null;
        int[] a,b;
        a = b = null;
        for(i = 0; i <= m; i ++) d[i][0] = i;
        for(j = 0; j <= n; j ++) d[0][j] = j; 
        //fill the DP table
        for(i = 1; i <= m; i ++)  {
                for(j = 1; j <= n; j ++) {
                        if(a[i] == b[j]) c = 0;
                        else c = 1; 
                        d[i][j] = min(d[i-1][j] + 1, d[i][j-1] + 1, d[i-1][j-1]+c);
                }
        }
        //trace-back
    }
//?
	private static int min(int i, int j, int k) {
		Math.min(Math.min(i, j), k);
		return 0;
	}
}