/**
 * 做青菜的命令类
 */
public class CookVegetable implements Command {
	private Kitchen kitchen;

	public CookVegetable() {
		kitchen = new Kitchen();
	}

	public Dish cooking() {
		return kitchen.newVevetable();
	}
}
