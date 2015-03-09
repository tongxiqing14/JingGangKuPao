package elements.screen;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-9-3
 * Time: обнГ2:59
 * To change this template use File | Settings | File Templates.
 */
public class TeamScreenItemObj {

    private List<TitleItem> titleItemList;

    public List<TitleItem> getTitleItemList() {
        return titleItemList;
    }

    public void setTitleItemList(List<TitleItem> titleItemList) {
        this.titleItemList = titleItemList;
    }

    @Override
    public String toString() {
        return "TeamScreenItemObj{" +
                "titleItemList=" + titleItemList +
                '}';
    }
}
