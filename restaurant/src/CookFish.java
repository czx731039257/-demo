/**
 * 做鱼的命令类
 */
public class CookFish implements Command {

    private Kitchen kitchen;

    public CookFish() {
        kitchen = new Kitchen();
    }

    public Dish cooking() {
        return kitchen.newFish();
    }

}
