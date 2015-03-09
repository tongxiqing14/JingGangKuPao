package service;

import common.PropertiesOp;
import org.json.me.JSONArray;
import org.json.me.JSONException;
import org.json.me.JSONObject;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-11-6
 * Time: 下午2:05
 * To change this template use File | Settings | File Templates.
 */
public class JigSawInfoOp {

    private static final String propname1 = "/jigsaw/jigsawinfo.properties";

    public static String initialJigSawInfo(){
        PropertiesOp propertiesOp = new PropertiesOp();
        Properties properties = propertiesOp.load(propname1);
        return properties.getProperty("jigsawinfo");
    }

    /**
     * 拼图购买信息转为数组
     * */
    public static int[][] getJigSawInfo(String jigsawinfo)
    {
        int[][] pic_info_array=null;

        try {
            JSONArray arr1 = new JSONArray(jigsawinfo);
            pic_info_array = new int[arr1.length()][];
            for (int i=0; i<arr1.length(); i++){
                JSONObject json1 = new JSONObject(arr1.getString(i));
                    JSONArray arr11 = json1.getJSONArray("pic"+(i+1));
                pic_info_array[i] = new int[arr11.length()];
                    for (int j=0; j<arr11.length(); j++){
                        pic_info_array[i][j] = arr11.getInt(j);
                    }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return pic_info_array;
    }

    /**
     * 拼图购买信息数组转为字符串
     * */
    public static String updateJigSawInfo(int[][] pic_info_array)
    {
        JSONArray jsonArray_ = new JSONArray();
        try {
            for (int i=0; i<pic_info_array.length; i++){
                    JSONObject jsonStage = new JSONObject();
                        JSONArray jsonArray = new JSONArray();
                        for (int j=0; j<pic_info_array[i].length; j++){
                            jsonArray.put(pic_info_array[i][j]);
                        }
                    jsonStage.put("pic"+(i+1), jsonArray);
                jsonArray_.put(jsonStage);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonArray_.toString();
    }

}
