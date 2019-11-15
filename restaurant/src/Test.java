import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Waiter waiter = null;
        Scanner sc = new Scanner(System.in);
        String dishName;
        /**
         * type时操作指令
         */
        while (true) {
            String type = sc.next();
            switch (type) {
                case "callWaiter":
                    waiter = new Waiter();
                    break;
                case "getMenu":
                    waiter.getMenu();
                    break;
                case "order":
                    System.out.println("请输入你要点的菜名");
                    dishName = sc.next();
                    while (!dishName.equals("pause")) {

                        dishName = sc.next();
                    }
                    break;
                case ""
            }
        }
    }
}
