package elements.screen;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-9-4
 * Time: ÉÏÎç10:18
 * To change this template use File | Settings | File Templates.
 */
public class TitleItem {

    private String titleBgImg;
    private String titleImg;
    private int type =0; // hero:0  human:1  pet2
    private boolean selected_flag = false;
    private String img_name;  //js img name fetch
    private int hp_num = 0;    //core number
    private int fight_num = 0;   //core number
    private int hero_id = 0; //reference to hero_id of hero class

    public TitleItem() {
    }

    public TitleItem(int type, boolean selected_flag, int hp_num, int fight_num, int hero_id) {
        this.type = type;
        this.selected_flag = selected_flag;
        this.hp_num = hp_num;
        this.fight_num = fight_num;
        this.hero_id = hero_id;
    }

    public TitleItem(String titleBgImg, String titleImg, int type, boolean selected_flag, String img_name, int hp_num, int fight_num, int hero_id) {
        this.titleBgImg = titleBgImg;
        this.titleImg = titleImg;
        this.type = type;
        this.selected_flag = selected_flag;
        this.img_name = img_name;
        this.hp_num = hp_num;
        this.fight_num = fight_num;
        this.hero_id = hero_id;
    }

    public boolean isSelected_flag() {
        return selected_flag;
    }

    public void setSelected_flag(boolean selected_flag) {
        this.selected_flag = selected_flag;
    }

    public String getTitleBgImg() {
        return titleBgImg;
    }

    public void setTitleBgImg(String titleBgImg) {
        this.titleBgImg = titleBgImg;
    }

    public String getTitleImg() {
        return titleImg;
    }

    public void setTitleImg(String titleImg) {
        this.titleImg = titleImg;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getImg_name() {
        return img_name;
    }

    public void setImg_name(String img_name) {
        this.img_name = img_name;
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

    public int getHero_id() {
        return hero_id;
    }

    public void setHero_id(int hero_id) {
        this.hero_id = hero_id;
    }

    @Override
    public String toString() {
        return "TitleItem{" +
                "titleBgImg='" + titleBgImg + '\'' +
                ", titleImg='" + titleImg + '\'' +
                ", type=" + type +
                ", selected_flag=" + selected_flag +
                ", img_name='" + img_name + '\'' +
                ", hp_num=" + hp_num +
                ", fight_num=" + fight_num +
                ", hero_id=" + hero_id +
                '}';
    }
}
