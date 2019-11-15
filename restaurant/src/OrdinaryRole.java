
/**
 * 普通客户
 */
public class OrdinaryRole extends Role {

    /**
     * 改变客户角色为vip
     *
     * @param client
     */
    public void changeRole(Client client) {
        client.setRole(new VipRole());
    }
}
