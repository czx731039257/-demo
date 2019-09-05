
public class HasPay implements BillState {
	/**
	 * 改变账单状态为未支付
	 * @param bill
	 */
	@Override
	public void changeState(Bill bill) {
		bill.setState(new NoPay());
	}
}
