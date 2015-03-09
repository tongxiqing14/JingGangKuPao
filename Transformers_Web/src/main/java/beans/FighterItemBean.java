package beans;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-10-14
 * Time: 下午4:38
 * To change this template use File | Settings | File Templates.
 */
public class FighterItemBean {

    private int id = 0;
    private int fighter_id = 0;
    private int star_nums = 0;      /**星数*/
    private int hp_num = 0;       /**血量*/
    private int fight_num = 0;    /**战力*/

    public FighterItemBean() {
    }

    public FighterItemBean(int id, int fighter_id, int star_nums, int hp_num, int fight_num) {
        this.id = id;
        this.fighter_id = fighter_id;
        this.star_nums = star_nums;
        this.hp_num = hp_num;
        this.fight_num = fight_num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFighter_id() {
        return fighter_id;
    }

    public void setFighter_id(int fighter_id) {
        this.fighter_id = fighter_id;
    }

    public int getStar_nums() {
        return star_nums;
    }

    public void setStar_nums(int star_nums) {
        this.star_nums = star_nums;
    }

    public int getHp_num() {
        return hp_num;
    }

    public void setHp_num(int hp_num) {
        this.hp_num = hp_num;
    }

    public int getFight_num() {
        return fight_num;
    }

    public void setFight_num(int fight_num) {
        this.fight_num = fight_num;
    }

    @Override
    public String toString() {
        return "FighterItemBean{" +
                "id=" + id +
                ", fighter_id=" + fighter_id +
                ", star_nums=" + star_nums +
                ", hp_num=" + hp_num +
                ", fight_num=" + fight_num +
                '}';
    }
}
