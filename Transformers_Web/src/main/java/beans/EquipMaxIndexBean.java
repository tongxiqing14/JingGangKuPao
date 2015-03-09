package beans;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-10-14
 * Time: ÏÂÎç8:45
 * To change this template use File | Settings | File Templates.
 */
public class EquipMaxIndexBean {

    private int hero1;
    private int hero2;
    private int hero3;
    private int hero4;
    private int hero5;
    private int hero6;
    private int hero7;

    public EquipMaxIndexBean() {
    }

    public EquipMaxIndexBean(int hero1, int hero2, int hero3, int hero4, int hero5, int hero6, int hero7) {
        this.hero1 = hero1;
        this.hero2 = hero2;
        this.hero3 = hero3;
        this.hero4 = hero4;
        this.hero5 = hero5;
        this.hero6 = hero6;
        this.hero7 = hero7;
    }

    public int getHero1() {
        return hero1;
    }

    public void setHero1(int hero1) {
        this.hero1 = hero1;
    }

    public int getHero2() {
        return hero2;
    }

    public void setHero2(int hero2) {
        this.hero2 = hero2;
    }

    public int getHero3() {
        return hero3;
    }

    public void setHero3(int hero3) {
        this.hero3 = hero3;
    }

    public int getHero4() {
        return hero4;
    }

    public void setHero4(int hero4) {
        this.hero4 = hero4;
    }

    public int getHero5() {
        return hero5;
    }

    public void setHero5(int hero5) {
        this.hero5 = hero5;
    }

    public int getHero6() {
        return hero6;
    }

    public void setHero6(int hero6) {
        this.hero6 = hero6;
    }

    public int getHero7() {
        return hero7;
    }

    public void setHero7(int hero7) {
        this.hero7 = hero7;
    }

    public int setEquipMaxIndex_zero(int fighter_id){
        int rt = 0;
        if(fighter_id == 1){
            setHero1(0);
        }else if(fighter_id == 2){
            setHero2(0);
        }else if(fighter_id == 3){
            setHero3(0);
        }else if(fighter_id == 4){
            setHero4(0);
        }else if(fighter_id == 5){
            setHero5(0);
        }else if(fighter_id == 6){
            setHero6(0);
        }else if(fighter_id == 7){
            setHero7(0);
        }
        return  rt;
    }

    public int getEquipMaxIndex(int fighter_id){
        int rt = 0;
            if(fighter_id == 1){
                rt =  getHero1();
            }else if(fighter_id == 2){
                rt =  getHero2();
            }else if(fighter_id == 3){
                rt =  getHero3();
            }else if(fighter_id == 4){
                rt =  getHero4();
            }else if(fighter_id == 5){
                rt =  getHero5();
            }else if(fighter_id == 6){
                rt =  getHero6();
            }else if(fighter_id == 7){
                rt =  getHero7();
            }
        return  rt;
    }

    public int getEquipMaxIndex_plus(int fighter_id){
        int rt = 0;
        if(fighter_id == 1){
            setHero1(getHero1()+1);
            rt =  getHero1();
        }else if(fighter_id == 2){
            setHero2(getHero2()+1);
            rt =  getHero2();
        }else if(fighter_id == 3){
            setHero3(getHero3()+1);
            rt =  getHero3();
        }else if(fighter_id == 4){
            setHero4(getHero4()+1);
            rt =  getHero4();
        }else if(fighter_id == 5){
            setHero5(getHero5()+1);
            rt =  getHero5();
        }else if(fighter_id == 6){
            setHero6(getHero6() + 1);
            rt =  getHero6();
        }else if(fighter_id == 7){
            setHero7(getHero7() + 1);
            rt =  getHero7();
        }
        return  rt;
    }

    @Override
    public String toString() {
        return "EquipMaxIndexBean{" +
                "hero1=" + hero1 +
                ", hero2=" + hero2 +
                ", hero3=" + hero3 +
                ", hero4=" + hero4 +
                ", hero5=" + hero5 +
                ", hero6=" + hero6 +
                ", hero7=" + hero7 +
                '}';
    }
}
