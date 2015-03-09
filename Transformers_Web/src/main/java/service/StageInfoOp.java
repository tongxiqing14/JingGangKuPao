package service;

import com.fancyy.json.util.JSON;
import screen.stage.StageBtnItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-11-18
 * Time: ÉÏÎç10:00
 * To change this template use File | Settings | File Templates.
 */
public class StageInfoOp {

    public static List<StageBtnItem>  getStageDataList(){

        List<StageBtnItem> stageBtnItemList = new ArrayList<StageBtnItem>();

        StageBtnItem stageBtnItem = new StageBtnItem(1,1,1,100,295,"stage/map1/images/tab01.png",true);  //        item_id, stage_num, sub_stage_num, left_x, left_y, got_or_not
        stageBtnItemList.add(stageBtnItem);
        StageBtnItem stageBtnItem0 = new StageBtnItem(2,1,2,100,157,"stage/map1/images/tab02.png",true);
        stageBtnItemList.add(stageBtnItem0);
        StageBtnItem stageBtnItem00  = new StageBtnItem(3,1,3,202,230,"stage/map1/images/tab03.png",true);
        stageBtnItemList.add(stageBtnItem00);
        StageBtnItem stageBtnItem1  = new StageBtnItem(4,1,4,308,175,"stage/map1/images/tab06.png",true);
        stageBtnItemList.add(stageBtnItem1);
        StageBtnItem stageBtnItem2  = new StageBtnItem(5,1,5,402,285,"stage/map1/images/tab04.png",true);
        stageBtnItemList.add(stageBtnItem2);
        StageBtnItem stageBtnItem3  = new StageBtnItem(6,1,6,452,182,"stage/map1/images/tab05.png",true);
        stageBtnItemList.add(stageBtnItem3);
        StageBtnItem stageBtnItem4  = new StageBtnItem(7,2,1,144,161,"stage/map2/images/tab-2_03.png",true);
        stageBtnItemList.add(stageBtnItem4);
        StageBtnItem stageBtnItem5  = new StageBtnItem(8,2,2,145,285,"stage/map2/images/tab-2_22.png",true);
        stageBtnItemList.add(stageBtnItem5);
        StageBtnItem stageBtnItem6  = new StageBtnItem(9,2,3,274,200,"stage/map2/images/tab-2_09.png",true);
        stageBtnItemList.add(stageBtnItem6);
        StageBtnItem stageBtnItem7  = new StageBtnItem(10,2,4,397,133,"stage/map2/images/tab-2_06.png",true);
        stageBtnItemList.add(stageBtnItem7);
        StageBtnItem stageBtnItem8  = new StageBtnItem(11,2,5,365,280,"stage/map2/images/tab-2_19.png",true);
        stageBtnItemList.add(stageBtnItem8);
        StageBtnItem stageBtnItem9  = new StageBtnItem(12,2,6,474,230,"stage/map2/images/tab-2_25.png",true);
        stageBtnItemList.add(stageBtnItem9);
        StageBtnItem stageBtnItem10  = new StageBtnItem(13,3,1,100,263,"stage/map3/images/tab-3_24.png",true);
        stageBtnItemList.add(stageBtnItem10);
        StageBtnItem stageBtnItem11  = new StageBtnItem(14,3,2,210,285,"stage/map3/images/tab-3_18.png",true);
        stageBtnItemList.add(stageBtnItem11);
        StageBtnItem stageBtnItem12  = new StageBtnItem(15,3,3,127,123,"stage/map3/images/tab-3_03.png",true);
        stageBtnItemList.add(stageBtnItem12);
        StageBtnItem stageBtnItem13  = new StageBtnItem(16,3,4,285,135,"stage/map3/images/tab-3_09.png",true);
        stageBtnItemList.add(stageBtnItem13);
        StageBtnItem stageBtnItem14  = new StageBtnItem(17,3,5,350,235,"stage/map3/images/tab-3_21.png",true);
        stageBtnItemList.add(stageBtnItem14);
        StageBtnItem stageBtnItem15  = new StageBtnItem(18,3,6,435,295,"stage/map3/images/tab-3_15.png",true);
        stageBtnItemList.add(stageBtnItem15);

        StageBtnItem stageBtnItem16  = new StageBtnItem(19,3,6,472,127,"stage/map3/images/tab-3_06.png",true);
        stageBtnItemList.add(stageBtnItem16);

        StageBtnItem stageBtnItem17  = new StageBtnItem(20,4,1,82,128,"stage/map4/images/tab-4png_09.png",true);
        stageBtnItemList.add(stageBtnItem17);

        StageBtnItem stageBtnItem18  = new StageBtnItem(21,4,2,87,242,"stage/map4/images/tab-4png_12.png",true);
        stageBtnItemList.add(stageBtnItem18);

        StageBtnItem stageBtnItem19  = new StageBtnItem(22,4,3,179,287,"stage/map4/images/tab-4png_19.png",true);
        stageBtnItemList.add(stageBtnItem19);

        StageBtnItem stageBtnItem20  = new StageBtnItem(23,4,4,290,242,"stage/map4/images/tab-4png_28.png",true);
        stageBtnItemList.add(stageBtnItem20);

        StageBtnItem stageBtnItem21  = new StageBtnItem(24,4,5,258,103,"stage/map4/images/tab-4png_03.png",true);
        stageBtnItemList.add(stageBtnItem21);

        StageBtnItem stageBtnItem22  = new StageBtnItem(25,4,6,405,125,"stage/map4/images/tab-4png_22.png",true);
        stageBtnItemList.add(stageBtnItem22);

        StageBtnItem stageBtnItem23  = new StageBtnItem(26,4,7,492,205,"stage/map4/images/tab-4png_06.png",true);
        stageBtnItemList.add(stageBtnItem23);

        StageBtnItem stageBtnItem24  = new StageBtnItem(27,4,8,414,302,"stage/map4/images/tab-4png_25.png",true);
        stageBtnItemList.add(stageBtnItem24);

        StageBtnItem stageBtnItem25  = new StageBtnItem(28,5,1,87,222,"stage/map5/images/tab-5png_06.png",true);
        stageBtnItemList.add(stageBtnItem25);

        StageBtnItem stageBtnItem26  = new StageBtnItem(29,5,2,172,107,"stage/map5/images/tab-5png_03.png",true);
        stageBtnItemList.add(stageBtnItem26);

        StageBtnItem stageBtnItem27  = new StageBtnItem(30,5,3,330,126,"stage/map5/images/tab-5png_09.png",true);
        stageBtnItemList.add(stageBtnItem27);

        StageBtnItem stageBtnItem28  = new StageBtnItem(31,5,4,427,171,"stage/map5/images/tab-5png_22.png",true);
        stageBtnItemList.add(stageBtnItem28);

        StageBtnItem stageBtnItem29  = new StageBtnItem(32,5,5,230,242,"stage/map5/images/tab-5png_28.png",true);
        stageBtnItemList.add(stageBtnItem29);

        StageBtnItem stageBtnItem30  = new StageBtnItem(33,5,6,325,275,"stage/map5/images/tab-5png_19.png",true);
        stageBtnItemList.add(stageBtnItem30);

        StageBtnItem stageBtnItem31  = new StageBtnItem(34,5,7,470,265,"stage/map5/images/tab-5png_25.png",true);
        stageBtnItemList.add(stageBtnItem31);

        StageBtnItem stageBtnItem32  = new StageBtnItem(35,6,1,165,115,"stage/map6/images/tab-6_25.png",true);
        stageBtnItemList.add(stageBtnItem32);

        StageBtnItem stageBtnItem33  = new StageBtnItem(36,6,2,80,210,"stage/map6/images/tab-6_03.png",true);
        stageBtnItemList.add(stageBtnItem33);

        StageBtnItem stageBtnItem34  = new StageBtnItem(37,6,3,168,305,"stage/map6/images/tab-6_28.png",true);
        stageBtnItemList.add(stageBtnItem34);

        StageBtnItem stageBtnItem35  = new StageBtnItem(38,6,4,272,195,"stage/map6/images/tab-6_22.png",true);
        stageBtnItemList.add(stageBtnItem35);

        StageBtnItem stageBtnItem36  = new StageBtnItem(39,6,5,402,141,"stage/map6/images/tab-6_19.png",true);
        stageBtnItemList.add(stageBtnItem36);

        StageBtnItem stageBtnItem37  = new StageBtnItem(40,6,6,430,280,"stage/map6/images/tab-6_06.png",true);
        stageBtnItemList.add(stageBtnItem37);

        StageBtnItem stageBtnItem38  = new StageBtnItem(41,6,7,495,195,"stage/map6/images/tab-6_09.png",true);
        stageBtnItemList.add(stageBtnItem38);

//        String json = JSON.toJson(stageBtnItemList);
        return stageBtnItemList;
    }
}
