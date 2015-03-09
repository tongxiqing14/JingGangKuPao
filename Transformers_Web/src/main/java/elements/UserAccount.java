package elements;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-8-29
 * Time: ÏÂÎç2:14
 * To change this template use File | Settings | File Templates.
 */
public class UserAccount {

    private int user_account_id = 0;
    private List<RoleAccount> roleAccountList;

    public int getUser_account_id() {
        return user_account_id;
    }

    public void setUser_account_id(int user_account_id) {
        this.user_account_id = user_account_id;
    }

    public List<RoleAccount> getRoleAccountList() {
        return roleAccountList;
    }

    public void setRoleAccountList(List<RoleAccount> roleAccountList) {
        this.roleAccountList = roleAccountList;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "user_account_id=" + user_account_id +
                ", roleAccountList=" + roleAccountList +
                '}';
    }
}
