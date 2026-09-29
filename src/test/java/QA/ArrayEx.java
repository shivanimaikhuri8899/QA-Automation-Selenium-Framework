package QA;

public class ArrayEx {
    public static void main(String[] args) {
// TODO Auto-generated method stub

        int abc[][] = {{2, 4, 5}, {3, 0, 7}, {1, 2, 9}};
        int min = abc[0][0];
        int mincoloumn = 0;
        int minrow=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (abc[i][j] < min)//2
                {
                    min = abc[i][j];
                    mincoloumn = j;
                    minrow=i;
                }
            }
        }
        System.out.println(min);
        System.out.println("mincolumn is "+mincoloumn+" and minrow is "+minrow);
        int k=0;
        int col=0;
        while(k<=mincoloumn){
            if(abc[minrow][k]>col) {
                col = abc[minrow][k];
            }
           k++;
       }
        System.out.println("Max number in identified column is "+col);

    }
}
