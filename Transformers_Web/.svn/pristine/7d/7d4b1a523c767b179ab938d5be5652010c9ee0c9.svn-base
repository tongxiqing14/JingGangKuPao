package iptvNet;

import org.json.me.JSONArray;
import org.json.me.JSONException;
import org.json.me.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 14-6-30
 * Time: 下午2:07
 * To change this template use File | Settings | File Templates.
 */
public class NetHander {

    private String serverURL = "";
    private String account = "";
    private String gameId = "";
    private String adAccount = "";
    private String userToken = "";
    private String answer = "";
    private String question = "";

    public NetHander() {
    }

    public NetHander(String serverURL, String account, String gameId, String adAccount, String userToken) {
        this.serverURL = serverURL;
        this.account = account;
        this.gameId = gameId;
        this.adAccount = adAccount;
        this.userToken = userToken;
    }

    public String getServerURL() {
        return serverURL;
    }

    public void setServerURL(String serverURL) {
        this.serverURL = serverURL;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getAdAccount() {
        return adAccount;
    }

    public void setAdAccount(String adAccount) {
        this.adAccount = adAccount;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * 获取游戏数据
     *
     * @return
     * @throws org.json.me.JSONException
     * @throws iptvNet.IptvNetException
     */
    public String getGameData(int type) throws JSONException, IptvNetException {
        String ret="";
        String str;
        String url = LoadGameData_url(type);
        str = doSend_(url);
        JSONObject jo;

        jo = new JSONObject(str);
        if (jo.getInt("Result") == 0) {
            ret = jo.getString("Description");
        } else {
//            throw new IptvNetException("the 9 http Exception");
        }
        return ret;
    }

    public String str;

    /**
     * 保存游戏数据
     *
     * @return
     * @throws org.json.me.JSONException
     * @throws iptvNet.IptvNetException
     */
    public boolean saveGameData(String data, int type) throws JSONException,
            IptvNetException {
        boolean isSucess = false;
//        String str;
        String url = SaveGameData_url(data, type);
        str = doSend_(url);
        JSONObject jo;

        if(str!=null&&!str.equals("")){
            jo = new JSONObject(str);
            if (jo.getInt("Result") == 0) {
                isSucess = jo.getString("Description").equals("sucess");
            } else {
//            throw new IptvNetException("the 9 http Exception");
            }
        }

        return isSucess;
    }

    /**
     * 保存分数
     *
     * @return
     * @throws org.json.me.JSONException
     * @throws iptvNet.IptvNetException
     */
    public boolean saveScore(int score, int type) throws JSONException,
            IptvNetException {
        boolean isSucess = false;
        String str = "";
        String url = SaveScore_url(score, type);
        str = doSend_(url);

        JSONObject jo;
        jo = new JSONObject(str);
        if (jo.getInt("Result") == 0) {
            isSucess = jo.getString("Description").endsWith("sucess");
        } else {
//            isSucess = false;
//            throw new IptvNetException("the 9 http Exception");
        }
        return isSucess;
    }

    /**
     * 获取分数
     *
     * @return
     * @throws org.json.me.JSONException
     * @throws iptvNet.IptvNetException
     */
    public int getMyScore(int type) throws JSONException, IptvNetException {
        int score = 0;
        String str = "";
        String url = GetMyScore_url(type);  System.out.println("url="+url);
        str = doSend_(url);
        JSONObject jo;
//        System.out.println("getMyScore="+str);
        // try {
        jo = new JSONObject(str);
        if (jo.getInt("Result") == 0) {
            score = Integer.parseInt(jo.getString("Description"));
        } else {
            score = 0;
            throw new IptvNetException("the 9 http Exception");
        }
        // } catch (JSONException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        return score;
    }

    /**
     * 获取排行榜
     *
     * @param type
     * @param getNum
     * @return
     * @throws org.json.me.JSONException
     * @throws iptvNet.IptvNetException
     */
    public String[][] getScoreList(int type, int getNum) throws JSONException,
            IptvNetException {
        String ret[][] = null;
        String str = "";
        String url = GetScoreList_url(type,getNum);
        str = doSend_(url);
        JSONObject jo;
        // try {
        jo = new JSONObject(str);
        if (jo.getInt("Result") == 0) {
            String jo1 = jo.getString("Description");
            JSONArray ja = new JSONArray(jo1);
            if (ja.length() <= 0) {
                return ret;
            }
            ret = new String[ja.length()][2];
            for (int i = 0; i < ja.length(); i++) {
                String temp = ja.getString(i);
                JSONObject jo2 = new JSONObject(temp);
                ret[i][1] = jo2.getString("Socre");
                ret[i][0] = jo2.getString("NickName");
            }
        } else {
            throw new IptvNetException("the 9 http Exception");
        }
        // } catch (JSONException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        return ret;
    }

    /**
     * 获取名次
     *
     * @return
     * @throws org.json.me.JSONException
     * @throws iptvNet.IptvNetException
     */
    public int getMyRank(int type) throws JSONException, IptvNetException {
        int rank = 0;
        String str = "";
        String url = GetMyRank_url(type);
        str = doSend_(url);
        JSONObject jo;
        // try {
        jo = new JSONObject(str);
        if (jo.getInt("Result") == 0) {
            rank = Integer.parseInt(jo.getString("Description"));
        } else {
            rank = 0;
            throw new IptvNetException("the 9 http Exception");
        }
        // } catch (JSONException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        return rank;
    }

    /**
     *
     * @param money
     *            消费代币数目
     * @param wareName
     *            消费说明
     * @return
     * @throws org.json.me.JSONException
     * @throws iptvNet.IptvNetException
     */
    public boolean topupAndConsumeMoney(int money, String wareName)
            throws JSONException, IptvNetException {
        boolean isSucess = false;
        String str = "";
        String url = TopupAndConsumeMoney_url(money, wareName);
//        System.out.println(url);
        str = doSend_(url);
//        System.out.println(str);
        JSONObject jo;
        jo = new JSONObject(str);
        if (jo.getInt("Result") == 0) {
            isSucess = jo.getString("Description").endsWith("sucess");
        } else {
//            isSucess = false;
//            throw new IptvNetException("the 9 http Exception");
        }
        return isSucess;
    }

    /**
     *
     * @param money
     * @param wareName
     * @param password
     * @return 返回0、1、2分别表示 成功、童锁密码不正确、失败
     * @throws org.json.me.JSONException
     * @throws iptvNet.IptvNetException
     */
    public int judgeIsTopupPassword_topupAndConsumeMoney(int money, String wareName, String password)
            throws JSONException, IptvNetException {
        int ret = 2;
        boolean isSucess = false;
        String str = "";
        String url = JudgeIsTopupPassword_url(money,wareName,password);
        str = doSend_(url);

        JSONObject jo;
        jo = new JSONObject(str);
        if (jo.getInt("Result") == 0) {
            ret = 0;
        } else if (jo.getInt("Result") == 1023) {
            ret = 1;
        } else {
            ret = 2;
//			throw new IptvNetException("the 9 http Exception");
        }
        return ret;
    }

    /**
     * 获取代币余额
     *
     * @return
     * @throws iptvNet.IptvNetException
     * @throws org.json.me.JSONException
     * @throws
     * @throws Exception
     */
    public int getBalance() throws JSONException, IptvNetException {
        int ret = 0;
        String str = "";
        String url = GetBalance_url();
        str = doSend_(url);
        JSONObject jo;
        jo = new JSONObject(str);
        if (jo.getInt("Result") == 0) {
            ret = Integer.parseInt(jo.getString("Description"));
        } else {
            throw new IptvNetException("the 9 http Exception");
        }
        return ret;
    }

    /**
     * 获取昵称
     *
     * @return
     * @throws iptvNet.IptvNetException
     * @throws org.json.me.JSONException
     */
    public String getNickName() throws IptvNetException, JSONException {
        String nickName = "";
        String str = "";
        String url = GetNickName_url();
        str = doSend_(url);
        JSONObject jo;
        jo = new JSONObject(str);
        if (jo.getInt("Result") == 0) {
            nickName = jo.getString("Description");
        } else {
            nickName = "";
            throw new IptvNetException("the 9 http Exception");
        }
        return nickName;
    }

    public boolean hasVerificationCode() throws JSONException, IptvNetException {
        boolean has = false;
        String ret = "";
        String str = "";
        String url = JudgeIsYanZhengMa_url();
        str = doSend_(url);
        JSONObject jo;
        jo = new JSONObject(str);
        if (jo.getInt("Result") == 0) {
        } else if (jo.getInt("Result") == 1028) {
            has = true;
            ret = jo.getString("Description");
            JSONObject jo1 = new JSONObject(ret);
        } else {
            throw new IptvNetException("the 9 http Exception");
        }
        return has;
    }

    private String GetNickName_url(){
        String url1 = serverURL + "GetNickName.ashx";
        url1 += "?Account="+account;
        return url1;
    }

    private String GetMyRank_url(int type){
        String url1 = serverURL + "GetMyRank.ashx";
        url1 += "?Account="+account;
        url1 += "&GameID="+gameId;
        url1 += "&Type="+type;
        return url1;
    }

    private String GetBalance_url(){
        String url1 = serverURL + "GetBalance.ashx";
        url1 += "?ADAccount="+adAccount;
        System.out.println("url1="+url1);
        return url1;
    }

    private String SaveScore_url(int score, int type){
        String url1 = serverURL + "SaveScore.ashx";
        url1 += "?Account="+account;
        url1 += "&score="+score;
        url1 += "&GameID="+gameId;
        url1 += "&Type="+type;
        return url1;
    }

    private String GetMyScore_url(int type){
        String url1 = serverURL + "GetAccountMyScore.ashx";
        url1 += "?Account="+account;
        url1 += "&GameID="+gameId;
        url1 += "&type="+type;
        return url1;
    }

    private String GetScoreList_url(int type, int getNum){
        String url1 = serverURL + "GetScoreList.ashx";
        url1 += "?Number="+getNum;
        url1 += "&GameID="+gameId;
        url1 += "&type="+type;
        return url1;
    }

    private String SaveGameData_url(String data,int type){
        String url1 = serverURL + "SaveGameData.ashx";
        url1 += "?Account="+account;
        url1 += "&GameData="+data;
        url1 += "&GameID="+gameId;
        url1 += "&type="+type;
        return url1;
    }

    private String LoadGameData_url(int type){
        String url = serverURL + "LoadGameData.ashx";
        url += "?Account="+account;
        url += "&GameID="+gameId;
        url += "&type="+type;
        return url;
    }

    private String TopupAndConsumeMoney_url(int money, String wareName){
        String url = serverURL + "TopupAndConsumeMoney.ashx";
        url += "?ADAccount="+adAccount;
        url += "&UserToken="+userToken;
        url += "&Money="+money;
        url += "&Account="+account;
        url += "&GameID="+gameId;
        url += "&WareName="+wareName;

//        System.out.println("url="+url);
        return url;
    }

    private String JudgeIsTopupPassword_url(int money, String wareName, String password){
        String url = serverURL + "JudgeIsTopupPassword.ashx";
        url += "?ADAccount="+adAccount;
        url += "&UserToken="+userToken;
        url += "&Money="+money;
        url += "&Account="+account;
        url += "&GameID="+gameId;
        url += "&WareName="+wareName;
        url += "&Password="+password;
        return url;
    }

    private String JudgeIsYanZhengMa_url(){
        String url = serverURL + "JudgeIsYanZhengMa.ashx";
        url += "?GameID="+gameId;
        return url;
    }

    private String doSend_(String url) {
        HttpURLConnection httpConnection = null;
        String str1 = "";
        try {
            httpConnection = (HttpURLConnection)
                    new URL(url)
                            .openConnection();
            httpConnection.setRequestMethod("GET");

            InputStream in = httpConnection.getInputStream();

            int length = in.available();
            byte[] buffer = new byte[length];
            in.read(buffer);

            str1 = new String(buffer);
            str1 = str1.substring(str1.indexOf("{"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str1;
    }

}
