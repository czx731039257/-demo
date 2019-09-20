import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Demo{
    String name;

    public static void main(String[] args) {
        Demo a=new Demo();
        a.name="czx";
        try {
            Demo b=(Demo)a.clone();
            System.out.println(b.name);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Demo asd=new Demo();
        asd.name=this.name;
        return asd;
    }
}
