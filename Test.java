import java.util.Scanner;

class Test{
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        System.out.print("Quantas palavras:");
        int k = stdin.nextInt();
        for(int i=0;i<k;i++){
            String alfa = stdin.next();
            System.out.print("[");
            for(int j=0;j<alfa.length();j++){
                System.out.print("'" + alfa.charAt(j) + "'");
                if(j+1<alfa.length()) System.out.print(",");
            }
            System.out.println("],");
        }
    }
}
