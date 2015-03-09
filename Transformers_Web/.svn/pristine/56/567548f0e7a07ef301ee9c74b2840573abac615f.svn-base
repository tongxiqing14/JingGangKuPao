package tools;

//import iptvNet.IptvNetException;
import org.json.me.JSONArray;
import org.json.me.JSONException;
import org.json.me.JSONObject;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-11-6
 * Time: ÏÂÎç1:26
 * To change this template use File | Settings | File Templates.
 */
public class TestArray {
    public static void main(String[] args){
        Boolean[] args1 = new Boolean[]{false,false,false,false,false};
        saveStageInfo(args1);
    }

    public static void saveStageInfo(Boolean[] o)
    {
        try {

            JSONObject jsonStage = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            for (int i = 0; i < o.length; i++) {
                jsonArray.put(o[i]);
            }

            jsonStage.put("stageLockOrUnlock", jsonArray);
            System.out.println(jsonStage.toString());
//            NetInfo.netHander.saveGameData(jsonStage.toString(), 33);
        } catch (JSONException e) {
            e.printStackTrace();
        }
//        catch (IptvNetException e) {
//            e.printStackTrace();
//        }

    }
}
