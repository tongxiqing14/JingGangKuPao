package screens;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import Entry.LWGameCanvas;

import common.GameVariables;
import common.Globe;
//import common.NetInfo;
import common.NetInfo;
import common.Screen;
import iptvNet.IptvNetException;
import org.json.me.JSONException;

public class RankingScreen extends Screen{
	
	public Image commonBGImage;
//	public Image rankingBgImage;
	public static String[][] rankInfo;
	public int getRankNum=10;
	public static int myRank=0;
	public static int myScore=0;
//    private Image commonImage1;

	public RankingScreen(int screenId) {
		super(screenId);
		// TODO Auto-generated constructor stub
	}

	public void clear() {
		// TODO Auto-generated method stub
		commonBGImage = null;
//		rankingBgImage = null;
//        for(int i=0; i<rankInfo.length; i++){
//            for (int j=0; j<rankInfo[i].length; j++){
//                rankInfo[i][j]=null;
//            }
//        }
//        rankInfo = null;
//        System.gc();
//        commonImage1 = null;
        Runtime.getRuntime().gc();
	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(commonBGImage, 0, 0, 20);
//		g.drawImage(rankingBgImage, 28, 0, 20);
		int color = g.getColor();
		g.setColor(0xffffff);
		for(int i=0;i<rankInfo.length;i++){
            if(GameVariables.nickName.equals(rankInfo[i][0]) && String.valueOf(myScore).equals(rankInfo[i][1])) {
                myRank = i + 1;
            }
            g.drawString(""+(i+1), 105, 99+i*31, Globe.ANCHOR_T_H);
			g.drawString(rankInfo[i][0], 310, 99+i*31, Globe.ANCHOR_T_H);
			g.drawString(rankInfo[i][1], 500, 99+i*31, Globe.ANCHOR_T_H);
		}
		
		g.drawString(""+myRank, 105, 453, Globe.ANCHOR_T_H);
		g.drawString(GameVariables.nickName, 310, 453, Globe.ANCHOR_T_H);
		g.drawString(""+myScore, 500, 453, Globe.ANCHOR_T_H);
		g.setColor(color);
//        g.drawImage(commonImage1, 320, 515, Graphics.HCENTER|Graphics.VCENTER);
	}

	public void init() {
		// TODO Auto-generated method stub
		commonBGImage = Globe.getImage("ranking/rankingBg2.png");
//		rankingBgImage = Globe.getImage("ranking/rankingBg2.png");
//        commonImage1 = Globe.getImage("common/commonBG1.png");
//        NetInfo.getGameScore();
        try {
            RankingScreen.myScore=NetInfo.netHander.getMyScore(0);
            RankingScreen.myRank=NetInfo.netHander.getMyRank(0);
            RankingScreen.rankInfo=NetInfo.netHander.getScoreList(0, 10);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IptvNetException e) {
            e.printStackTrace();
        }

	}

	public void update() {
		// TODO Auto-generated method stub
        if(LWGameCanvas.iskeyPressed(Globe.M_KEY_0)){
            LWGameCanvas.switchToScreen(new MenuScreen(0));
        }
	}

}
