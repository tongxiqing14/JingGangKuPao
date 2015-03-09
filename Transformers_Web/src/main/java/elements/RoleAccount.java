package elements;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-8-29
 * Time: ÏÂÎç2:15
 * To change this template use File | Settings | File Templates.
 */
public class RoleAccount {

    private int role_account_id = 0;
    private List<Hero> heroList;

    public int getRole_account_id() {
        return role_account_id;
    }

    public void setRole_account_id(int role_account_id) {
        this.role_account_id = role_account_id;
    }

    public List<Hero> getHeroList() {
        return heroList;
    }

    public void setHeroList(List<Hero> heroList) {
        this.heroList = heroList;
    }

    @Override
    public String toString() {
        return "RoleAccount{" +
                "role_account_id=" + role_account_id +
                ", heroList=" + heroList +
                '}';
    }
}
