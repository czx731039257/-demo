
/**
 * VIP客户
 */
public class VipRole extends Role {

    /**
     * 改变客户角色为普通客户
     *
     * @param client
     */
    public void changeRole(Client client) {
        client.setRole(new OrdinaryRole());
    }
}
