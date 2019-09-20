public class GCD {
    /**
     * 辗转相除法
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(gcd(6 ,1));
    }

    public static int gcd(int a,int b){
        if(a<b){
            int temp=a;
            a=b;
            b=temp;
        }
        while(a%b!=0){
            int temp=a;
            a=b;
            b=temp%b;
        }

        return b;
    }
}
