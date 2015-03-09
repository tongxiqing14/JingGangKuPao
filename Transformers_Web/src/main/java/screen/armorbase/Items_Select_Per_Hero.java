package screen.armorbase;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-9-17
 * Time: ÏÂÎç1:18
 * To change this template use File | Settings | File Templates.
 */
public class Items_Select_Per_Hero {
    private int item_id;
    private String src_img_path;
    private int left_x;
    private int top_y;

    public Items_Select_Per_Hero() {
    }

    public Items_Select_Per_Hero(int item_id, String src_img_path, int left_x, int top_y) {
        this.item_id = item_id;
        this.src_img_path = src_img_path;
        this.left_x = left_x;
        this.top_y = top_y;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getSrc_img_path() {
        return src_img_path;
    }

    public void setSrc_img_path(String src_img_path) {
        this.src_img_path = src_img_path;
    }

    public int getLeft_x() {
        return left_x;
    }

    public void setLeft_x(int left_x) {
        this.left_x = left_x;
    }

    public int getTop_y() {
        return top_y;
    }

    public void setTop_y(int top_y) {
        this.top_y = top_y;
    }

    @Override
    public String toString() {
        return "Items_Select_Per_Hero{" +
                "item_id=" + item_id +
                ", src_img_path='" + src_img_path + '\'' +
                ", left_x=" + left_x +
                ", top_y=" + top_y +
                '}';
    }
}
