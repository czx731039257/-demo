import java.util.Iterator;
import java.util.List;

/**
 * 服务员类
 */
public class Waiter {
    public String name;//姓名
    public Cashier cashier;
    public Command cookFishCommand;
    public Command cookVegetableCommand;


    public Waiter() {
        cashier = Cashier.getInstance();
        System.out.println("服务员来了");
    }

    public void setCookFishCommand(Command cookFishCommand) {
        this.cookFishCommand = cookFishCommand;
    }

    public void setCookVegetableCommand(Command cookVegetableCommand) {
        this.cookVegetableCommand = cookVegetableCommand;
    }

    /**
     * 给厨房传送做鱼的命令
     *
     * @return
     */
    public Dish getFish() {
        System.out.println("服务员端上做好的鱼");
        return cookFishCommand.cooking();
    }

    /**
     * 给厨房传送做青菜的命令
     *
     * @return
     */
    public Dish getVegetable() {
        System.out.println("服务员端上做好的青菜");
        return cookVegetableCommand.cooking();
    }

    /**
     * 获取菜单
     *
     * @return
     */
    public Menu getMenu() {
        System.out.println("服务员拿来菜单");
        Menu menu = Menu.getInstance();
        System.out.println("菜单如下：");
        Iterator<Article> it = menu.getDishList().iterator();
        while (it.hasNext()) {
            Dish next = (Dish) it.next();
            System.out.println("菜品:" + next.getName() + "  单价:" + next.getPrice());
        }
        return Menu.getInstance();
    }

    /**
     * 帮客户买单
     *
     * @param client
     * @param receipt
     * @return
     */
    public double payBill(Client client, double receipt) {
        return cashier.payBill(client, receipt);
    }

    /**
     * 给客户到前台那账单
     *
     * @param client
     * @return
     */
    public Bill getBill(Client client) {
        Bill bill = cashier.getBillWithNoPay(client);
        System.out.println("服务员拿过账单给你，账单内容如下");
        Iterator<Dish> it = bill.getOrderDishList().iterator();
        System.out.println("菜品：");
        while (it.hasNext()) {
            System.out.println(it.next().getName());
        }
        System.out.println("总消费：" + bill.getSum());
        return bill;
    }

    /**
     * 给客户创建账单
     *
     * @param dishs  客户点的菜
     * @param client 客户
     */
    public void newBill(List<Dish> dishs, Client client) {
        System.out.println("服务员在前台开账单");
        cashier.addBill(dishs, client);//创建账单到前台系统
    }

    /**
     * 帮客户往账单上加菜
     *
     * @param client
     * @param dishs
     * @return
     */
    public void addDishIntoBill(Client client, List<Dish> dishs) {
        System.out.println("服务员帮你加了菜：");
        Iterator<Dish> it = dishs.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().getName());
        }
        cashier.addDishIntoBill(client, dishs);
    }

}
