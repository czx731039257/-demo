import java.util.List;


/**
 * 菜单类
 */
public class Menu {
    private List<Article> dishList;//使用菜品
    private static Menu instance = null;//菜单对象

    /**
     * 单例模式
     *
     * @return
     */
    public static Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
            instance.add(new Dish("鱼", 50));
            instance.add(new Dish("青菜", 20));
        }
        return instance;
    }


    /**
     * 给菜单添加新菜
     *
     * @param article
     */
    public void add(Article article) {
        dishList.add(article);
    }

    /**
     * 从菜单上删除菜品
     *
     * @param article
     */
    public void remove(Article article) {
        dishList.remove(article);
    }

    /**
     * 获取菜单上所有菜品
     *
     * @param
     * @return
     */
    public List<Article> getChild() {
        return dishList;
    }

    public List<Article> getDishList() {
        return dishList;
    }
}
