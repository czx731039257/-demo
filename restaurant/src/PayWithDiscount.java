/**
 * vip客户打8折
 */

public class PayWithDiscount implements PayStrategy {
	public double payBill( Bill bill,double receipt) {
		return receipt-(0.8*bill.getSum());
	}
}
