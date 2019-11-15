/**
 * 客户类
 */
public class Client {
    private String name;
    private int integrals;//积分
    private Role role;//用户的角色：  普通用户/VIP


    public Client(String name) {
        this.name = name;
        this.role = new OrdinaryRole();//初始化客户的角色为普通客户
        integrals = 0;//初始化客户的积分为0
    }


    /**
     * 添加积分 如果
     *
     * @param i
     */
    public void addIntegrals(int i) {
        int before = integrals;//还没添加前的积分
        integrals += i;//添加后的积分

        /**
         * 倘若积分从小于1000  变成大于1000就把用户变成Vip角色
         *
         */
        if (before < 1000 && integrals >= 1000) {
            role.changeRole(this);
        }
    }

    /**
     * 设置角色
     *
     * @param role
     */
    public void setRole(Role role) {

    }

    /**
     * 获取角色
     *
     * @return
     */
    public Role getRole() {
        return role;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIntegrals() {
        return integrals;
    }

    public void setIntegrals(int integrals) {
        this.integrals = integrals;
    }

    @Override
    public boolean equals(Object obj) {
        //return super.equals(obj);
        if (((Client) obj).getName() == this.name) {
            return true;
        }
        return false;

    }
}
