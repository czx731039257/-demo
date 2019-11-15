import java.util.Iterator;
import java.util.List;

/**
 * 前台类
 */
public class Cashier {
    private static Cashier instance = null;
    private List<Bill> billsForNoPay;//还没支付的账单
    private List<Client> clients;//说有的客户信息
    private PayStrategy payStrategy;//结账时的策略  策略模式
    private double money;

    /**
     * 单例
     *
     * @return
     */
    public static Cashier getInstance() {
        if (instance == null) {
            instance = new Cashier();
            instance.setMoney(0);
        }
        return instance;
    }


    /**
     * 新增账单
     *
     * @param dishs  //新增账单中的菜
     * @param client //客户
     * @return
     */
    public void addBill(List<Dish> dishs, Client client) {
        billsForNoPay.add(new Bill(dishs, client));
    }

    /**
     * 根据用户获取他还没付款的账单
     *
     * @param client
     * @return
     */
    public Bill getBillWithNoPay(Client client) {
        Iterator<Bill> it = billsForNoPay.iterator();
        while (it.hasNext()) {
            Bill bill = it.next();
            if (bill.getClient().equals(client)) {
                return bill;
            }
        }
        return null;
    }

    /**
     * 修改结账策略
     *
     * @param payStrategy
     */
    public void setPayStrategy(PayStrategy payStrategy) {
        this.payStrategy = payStrategy;
    }


    /**
     * 结账功能
     *
     * @param client  客户
     * @param receipt 收的钱
     * @return 找回给客户的钱
     */
    public double payBill(Client client, double receipt) {
        Bill billWithNoPay = getBillWithNoPay(client);
        double repay = payStrategy.payBill(billWithNoPay, receipt);
        return repay;
    }


    /**
     * 给客户账单上添加菜
     *
     * @param client
     * @param dishs
     */
    public void addDishIntoBill(Client client, List<Dish> dishs) {
        Iterator<Bill> it = billsForNoPay.iterator();
        while (it.hasNext()) {
            Bill bill = it.next();
            if (bill.getClient().getName().equals(client)) {
                List<Dish> dishList = bill.getOrderDishList();
                for (int i = 0; i < dishs.size(); i++) {
                    dishList.add(dishs.get(i));
                }
                return;
            }
        }
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
