package elements;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-9-3
 * Time: ÏÂÎç12:57
 * To change this template use File | Settings | File Templates.
 */
public class HeroTeam {

    private String heroName = "";
    private String follow1Name = "";
    private String follow2Name = "";
    private String pet1Name = "";
    private String pet2Name = "";

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getFollow1Name() {
        return follow1Name;
    }

    public void setFollow1Name(String follow1Name) {
        this.follow1Name = follow1Name;
    }

    public String getFollow2Name() {
        return follow2Name;
    }

    public void setFollow2Name(String follow2Name) {
        this.follow2Name = follow2Name;
    }

    public String getPet1Name() {
        return pet1Name;
    }

    public void setPet1Name(String pet1Name) {
        this.pet1Name = pet1Name;
    }

    public String getPet2Name() {
        return pet2Name;
    }

    public void setPet2Name(String pet2Name) {
        this.pet2Name = pet2Name;
    }

    @Override
    public String toString() {
        return "EnemyTeam{" +
                "heroName='" + heroName + '\'' +
                ", follow1Name='" + follow1Name + '\'' +
                ", follow2Name='" + follow2Name + '\'' +
                ", pet1Name='" + pet1Name + '\'' +
                ", pet2Name='" + pet2Name + '\'' +
                '}';
    }
}
