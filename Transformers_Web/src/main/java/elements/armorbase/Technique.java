package elements.armorbase;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-9-17
 * Time: ÏÂÎç4:30
 * To change this template use File | Settings | File Templates.
 */
public class Technique {
    private int technique_id;
    private String technique_name;
    private int technique_fight_num;

    public Technique() {
    }

    public Technique(int technique_id, int technique_fight_num) {
        this.technique_id = technique_id;
        this.technique_fight_num = technique_fight_num;
    }

    public Technique(int technique_id, String technique_name, int technique_fight_num) {
        this.technique_id = technique_id;
        this.technique_name = technique_name;
        this.technique_fight_num = technique_fight_num;
    }

    public int getTechnique_id() {
        return technique_id;
    }

    public void setTechnique_id(int technique_id) {
        this.technique_id = technique_id;
    }

    public String getTechnique_name() {
        return technique_name;
    }

    public void setTechnique_name(String technique_name) {
        this.technique_name = technique_name;
    }

    public int getTechnique_fight_num() {
        return technique_fight_num;
    }

    public void setTechnique_fight_num(int technique_fight_num) {
        this.technique_fight_num = technique_fight_num;
    }

    @Override
    public String toString() {
        return "Technique{" +
                "technique_id=" + technique_id +
                ", technique_name='" + technique_name + '\'' +
                ", technique_fight_num=" + technique_fight_num +
                '}';
    }
}
