package elements;

import elements.armorbase.EquipItem;
import elements.armorbase.Technique;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-7-30
 * Time: ÏÂÎç9:25
 * To change this template use File | Settings | File Templates.
 */
public class HeroItem {

//    private int id = 0;
    private int hero_id = 0;    // ==>hero_id
//    private int star_nums = 0;      // ==>star_nums
    private int type = 0;
    private boolean got_flag = false;  // ==>got_flag
    private boolean select_flag = false;  // ==>got_flag
//    private int hp_num;
//    private int fight_num;
//    private List<EquipItem> equipItemList;
//    private List<Technique> techniqueList;

    public HeroItem() {
    }

    public HeroItem(int hero_id, int type, boolean got_flag, boolean select_flag) {
        this.hero_id = hero_id;
//        this.star_nums = star_nums;
        this.type = type;
        this.got_flag = got_flag;
        this.select_flag = select_flag;
//        this.hp_num = hp_num;
//        this.fight_num = fight_num;
    }

    public boolean isSelect_flag() {
        return select_flag;
    }

    public void setSelect_flag(boolean select_flag) {
        this.select_flag = select_flag;
    }

//    public int getStar_nums() {
//        return star_nums;
//    }
//
//    public void setStar_nums(int star_nums) {
//        this.star_nums = star_nums;
//    }

    public int getHero_id() {
        return hero_id;
    }

    public void setHero_id(int hero_id) {
        this.hero_id = hero_id;
    }

    public boolean isGot_flag() {
        return got_flag;
    }

    public void setGot_flag(boolean got_flag) {
        this.got_flag = got_flag;
    }

//    public List<EquipItem> getEquipItemList() {
//        return equipItemList;
//    }
//
//    public List<Technique> getTechniqueList() {
//        return techniqueList;
//    }
//
//    public void setTechniqueList(List<Technique> techniqueList) {
//        this.techniqueList = techniqueList;
//    }
//
//    public void setEquipItemList(List<EquipItem> equipItemList) {
//        this.equipItemList = equipItemList;
//    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

//    public int getHp_num() {
//        return hp_num;
//    }
//
//    public void setHp_num(int hp_num) {
//        this.hp_num = hp_num;
//    }
//
//    public int getFight_num() {
//        return fight_num;
//    }
//
//    public void setFight_num(int fight_num) {
//        this.fight_num = fight_num;
//    }

    @Override
    public String toString() {
        return "HeroItem{" +
                "hero_id=" + hero_id +
//                ", star_nums=" + star_nums +
                ", type=" + type +
                ", got_flag=" + got_flag +
                ", select_flag=" + select_flag +
//                ", hp_num=" + hp_num +
//                ", fight_num=" + fight_num +
//                ", equipItemList=" + equipItemList +
//                ", techniqueList=" + techniqueList +
                '}';
    }
}
