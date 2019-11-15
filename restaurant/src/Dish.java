/**
 * 菜品类
 */
public class Dish implements Article {
    private String name;//菜名
    private int price;//价格

    public Dish(String name) {
        this.name = name;
    }

    public Dish(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void show() {
        System.out.println("这道菜叫:" + name);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

}

