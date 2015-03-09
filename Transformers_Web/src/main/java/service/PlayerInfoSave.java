package service;

import com.fancyy.json.util.JSON;
import elements.PlayUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-9-10
 * Time: ÏÂÎç4:22
 * To change this template use File | Settings | File Templates.
 */
public class PlayerInfoSave {

    public static String initialPlayersData(String UserID){
        List<PlayUser> playUserList = new ArrayList<PlayUser>();

        PlayUser playUser = new PlayUser(playUserList.size(),UserID,"","");

        playUserList.add(playUser);

        String json = JSON.toJson(playUserList);
        return json;
    }

    public static String updatePlayersData(String playUserString, String UserID){

        List<PlayUser> playUserList = (List<PlayUser>) JSON.toObject(playUserString, PlayUser.class);

        PlayUser playUser = new PlayUser(playUserList.size(),UserID,"","");

        playUserList.add(playUser);

        String json = JSON.toJson(playUserList);
        return json;
    }

}
