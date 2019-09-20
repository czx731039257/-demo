import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sqrt {


    public static void main(String[] args) {
        double n=2.0;
        double sqrt = sqrt(2);
        //System.out.println(sqrt);


    }

    public static double sqrt(double n){
        double s=0.0000000001;
        double left=1.4,right=1.5;
        double mid=(left+right)/2;

        while(right-left>s){
            if(mid*mid>n){
                right=mid;
            }else{
                left=mid;
            }
            mid=(left+right)/2;
            System.out.println(mid);
        }

        return mid;
    }
}
