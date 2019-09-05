/**
 * 普通的结算策略
 */
public class PayWithOrdinary implements PayStrategy {
	public double payBill( Bill bill,double receipt) {

		return receipt-bill.getSum();
	}
}
