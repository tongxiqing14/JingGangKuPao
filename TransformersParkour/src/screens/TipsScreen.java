package screens;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import Entry.LWGameCanvas;

import common.GameVariables;
import common.Globe;
import common.Screen;
import elements.Hero;

public class TipsScreen extends Screen {

	private Image[] imageTips = new Image[5];
	private Image indexImage;
	public static Screen returnScreen;

	public TipsScreen(int sceneId) {
		super(sceneId);
	}

	public void clear() {
		imageTips = null;
		indexImage = null;
//        System.gc();
        Runtime.getRuntime().gc();
	}

	public void draw(Graphics g) {
//		g.setColor(0, 0, 0);
//		g.fillRect(0, 0, Globe.SW, Globe.SH);
//		g.setColor(255, 255, 255);

		g.drawImage(imageTips[4], Globe.SW >> 1, Globe.SH >> 1, Graphics.HCENTER | Graphics.VCENTER);
		g.drawImage(imageTips[0 == confirmIndex ? 1 : 0], 170, 300, 20);
		g.drawImage(imageTips[1 == confirmIndex ? 3 : 2], 370, 300, 20);
        g.setColor(0xffffff);
        g.setFont(Globe.BigBoldFont);
		g.drawString("游戏中退出积分将不保存，确定退出", 150, 180 + Globe.currentFont.getHeight(), Graphics.TOP | Graphics.LEFT);
        g.setColor(0x000000);

		g.drawImage(indexImage, 152 + confirmIndex * 200 + indexFrame, 312, Graphics.HCENTER | Graphics.VCENTER);
	}

	public void init() {
		imageTips[4] = Globe.getImage("confirm/buybg1.png");
		for (int i = 0; i < imageTips.length - 1; i++) {
			imageTips[i] = Globe.getImage("confirm/btn" + i + ".png");
		}
		indexImage = Globe.getImage("success/index.jpg");
	}

	int confirmIndex = 0;
	public int indexFrame;

	/**
	 * tipStyle: 0:复活; 1:退出; 2:难度选择;
	 */

	public void update() {
		indexFrame++;
		indexFrame = (indexFrame + 10) % 10;
		if (LWGameCanvas.iskeyPressed(Globe.M_KEY_RIGHT)) {
			confirmIndex++;
		} else if (LWGameCanvas.iskeyPressed(Globe.M_KEY_LEFT)) {
			confirmIndex--;
		}
		confirmIndex = (confirmIndex + 2) % 2;
		if (LWGameCanvas.iskeyPressed(Globe.M_KEY_OK)) {
			if (confirmIndex == 0) {
				LWGameCanvas.deleteScreen(this);
                GamingScreen.hero.chongBuffTime = System.currentTimeMillis();
				LWGameCanvas.setActive(returnScreen, true);
			} else {
				LWGameCanvas.deleteScreen(this);
				LoadingScreen.loadIndex = 3;
				LWGameCanvas.switchToScreen(new LoadingScreen(GameVariables.LOADING_SCREEN_ID));
			}
		}
		LWGameCanvas.keyReset();
	}
}
