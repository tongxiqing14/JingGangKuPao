package elements;

import elements.armorbase.EquipItem;
import elements.armorbase.Technique;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-7-30
 * Time: 下午9:25
 * To change this template use File | Settings | File Templates.
 */
public class Hero {

        private int hero_id = 0;    // ==>hero_id
        private String hero_name = "";  // ==>hero_name
        private String skill_levels = "";      // ==>skill_levels
        private int star_nums = 0;      // ==>star_nums
        private int type = 0;
        private boolean got_flag = false;  // ==>got_flag
        private boolean select_flag = false; //已经选中
        private String title_img_path ="";
        private String img_name = "";  //js img name fetch
        private List<EquipItem> equipItemList;
        private List<Technique> techniqueList;
        private int hp_num;
        private int fight_num;

        public Hero() {
        }

        public Hero(int hero_id, int star_nums, int type, boolean got_flag, int hp_num, int fight_num) {
            this.hero_id = hero_id;
            this.star_nums = star_nums;
            this.type = type;
            this.got_flag = got_flag;
            this.hp_num = hp_num;
            this.fight_num = fight_num;
        }

        public Hero(int hero_id, String skill_levels, int star_nums, int type, boolean got_flag, int hp_num, int fight_num) {
            this.hero_id = hero_id;
            this.skill_levels = skill_levels;
            this.star_nums = star_nums;
            this.type = type;
            this.got_flag = got_flag;
            this.hp_num = hp_num;
            this.fight_num = fight_num;
        }

        public Hero(int hero_id, String hero_name, String skill_levels, int star_nums, int type, boolean got_flag, String title_img_path, String img_name, int hp_num, int fight_num) {
            this.hero_id = hero_id;
            this.hero_name = hero_name;
            this.skill_levels = skill_levels;
            this.star_nums = star_nums;
            this.type = type;
            this.got_flag = got_flag;
            this.title_img_path = title_img_path;
            this.img_name = img_name;
            this.hp_num = hp_num;
            this.fight_num = fight_num;
        }

        public String getSkill_levels() {
            return skill_levels;
        }

        public void setSkill_levels(String skill_levels) {
            this.skill_levels = skill_levels;
        }

        public int getStar_nums() {
            return star_nums;
        }

        public void setStar_nums(int star_nums) {
            this.star_nums = star_nums;
        }

        public int getHero_id() {
            return hero_id;
        }

        public void setHero_id(int hero_id) {
            this.hero_id = hero_id;
        }

        public String getHero_name() {
            return hero_name;
        }

        public void setHero_name(String hero_name) {
            this.hero_name = hero_name;
        }

        public boolean isGot_flag() {
            return got_flag;
        }

        public void setGot_flag(boolean got_flag) {
            this.got_flag = got_flag;
        }

        public String getImg_name() {
            return img_name;
        }

        public void setImg_name(String img_name) {
            this.img_name = img_name;
        }

        public List<EquipItem> getEquipItemList() {
            return equipItemList;
        }

        public List<Technique> getTechniqueList() {
            return techniqueList;
        }

        public void setTechniqueList(List<Technique> techniqueList) {
            this.techniqueList = techniqueList;
        }

        public void setEquipItemList(List<EquipItem> equipItemList) {
            this.equipItemList = equipItemList;
        }

        public String getTitle_img_path() {
            return title_img_path;
        }

        public void setTitle_img_path(String title_img_path) {
            this.title_img_path = title_img_path;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
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
            return "Hero{" +
                    "hero_id=" + hero_id +
                    ", hero_name='" + hero_name + '\'' +
                    ", skill_levels=" + skill_levels +
                    ", star_nums=" + star_nums +
                    ", type=" + type +
                    ", got_flag=" + got_flag +
                    ", title_img_path='" + title_img_path + '\'' +
                    ", img_name='" + img_name + '\'' +
                    ", equipItemList=" + equipItemList +
                    ", techniqueList=" + techniqueList +
                    ", hp_num=" + hp_num +
                    ", fight_num=" + fight_num +
                    '}';
        }
}
