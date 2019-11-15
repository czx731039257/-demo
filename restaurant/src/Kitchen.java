/**
 * 厨房类
 */
public class Kitchen {
    private static Kitchen instance = null;
    /**
     * 做一盘鱼
     * @return
     */

    /**
     * 单例
     *
     * @return
     */
    public Kitchen getInstance() {
        if (instance == null) {
            instance = new Kitchen();
        }
        return instance;
    }

    public Dish newFish() {
        System.out.println("厨房做了鱼");
        return new Dish("鱼");
    }

    /**
     * 做一盘青菜
     *
     * @return
     */
    public Dish newVevetable() {
        System.out.println("厨房做了青菜");
        return new Dish("青菜");
    }

}
