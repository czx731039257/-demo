/**
 * 策略模式用的接口
 */
public interface PayStrategy {
	public double payBill(Bill bill,double receipt);
}
