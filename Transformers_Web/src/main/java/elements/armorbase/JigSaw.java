package elements.armorbase;

/**
 * Created by Administrator on 2014/9/19.
 */
public class JigSaw {

    private String jisaw_img_path;

    public JigSaw() {
    }

    public JigSaw(String jisaw_img_path) {
        this.jisaw_img_path = jisaw_img_path;
    }

    public String getJisaw_img_path() {
        return jisaw_img_path;
    }

    public void setJisaw_img_path(String jisaw_img_path) {
        this.jisaw_img_path = jisaw_img_path;
    }

    @Override
    public String toString() {
        return "JigSaw{" +
                "jisaw_img_path='" + jisaw_img_path + '\'' +
                '}';
    }
}
