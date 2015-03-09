package tools;

import org.json.me.JSONArray;
import org.json.me.JSONException;
import org.json.me.JSONObject;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 15-1-21
 * Time: ÉÏÎç10:23
 * To change this template use File | Settings | File Templates.
 */
public class TestStageArray {
    public static void main(String[] args){
        int[][] kengInfo = new int[][] {  {900}, { 8, 100 }, { 14, 230 }, { 20, 230 }, { 28, 100 }, { 36, 230 }, { 40, 90 }, { 45, 230 }, { 51, 90 },
                { 58, 220 }, { 62, 100 }, { 68, 230 }, { 72, 100 }, { 78, 220 }, { 84, 120 }, { 88, 230 }, { 94, 100 }, { 99, 220 },
                { 105, 120 }, { 113, 200 }, { 120, 120 }, { 126, 100 }, { 130, 200 }, { 138, 130 }, { 146, 100 }, { 154, 220 },
                { 162, 90 }, { 170, 230 }, { 178, 90 }, { 186, 120 }, { 192, 230 }, { 200, 120 }, { 208, 100 }, { 216, 230 },
                { 224, 120 }, { 232, 230 }, { 240, 150 }, { 248, 90 }, { 256, 230 }, { 264, 100 }, { 272, 120 }, { 280, 100 },
                { 288, 230 }, { 296, 120 }, { 304, 150 }, { 312, 90 }, { 320, 230 }, { 325, 100 }, { 332, 230 }, { 342, 120 },
                { 349, 150 }, { 356, 90 }, { 373, 230 }, { 377, 100 } };
        saveStageInfo(kengInfo);
    }

    public static void saveStageInfo(int[][] kengInfo)
    {
        try {

            JSONArray jsonArray0 = new JSONArray();

            JSONObject jsonStage0 = new JSONObject();
            JSONArray jsonArray00 = new JSONArray();
            jsonArray00.put(kengInfo[0][0]);
            jsonStage0.put("distance", jsonArray00);
            jsonArray0.put(jsonStage0);

            for(int h = 1; h < kengInfo.length; h++){
                JSONObject jsonStage = new JSONObject();
                JSONArray jsonArray = new JSONArray();
                for (int i = 0; i < kengInfo[h].length; i++) {
                    jsonArray.put(kengInfo[h][i]);
                }

                jsonStage.put("ken"+h, jsonArray);

                jsonArray0.put(jsonStage);
            }

            System.out.println(jsonArray0.toString());

            System.out.println("------------------------");

            int[][] kengInfo_ = new int[jsonArray0.length()][];

            for(int k = 0; k< jsonArray0.length(); k++){
                kengInfo_[k] = new int[jsonArray0.getJSONObject(k).getJSONArray("ken"+k).length()];
                for(int kk = 0; kk < jsonArray0.getJSONObject(k).getJSONArray("ken"+k).length(); kk++){
                    kengInfo_[k][kk] = ((Integer)jsonArray0.getJSONObject(k).getJSONArray("ken"+k).get(kk)).intValue();
                }
//                System.out.println(jsonArray0.getJSONObject(k).getJSONArray("ken"+k).get(0));
            }

            System.out.println("+++++++++++++++++++++++++++");

            for (int i = 0; i < kengInfo_.length ; i++){
                for(int j = 0; j < kengInfo_[i].length ; j++){
                    System.out.println(kengInfo_[i][j]);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
