package screens;

import Entry.LWGameCanvas;
import common.GameVariables;
import common.Globe;
import common.Screen;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class MenuTipsScreen extends Screen {

	private Image[] imageTips = new Image[5];
	private Image indexImage;
	public static Screen returnScreen;

	public MenuTipsScreen(int sceneId) {
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
        g.setFont(Globe.BigBoldFont);
        g.setColor(0xffffff);
//        g.setColor(0xffffff);
		g.drawString("亲！", 200, 180 + Globe.currentFont.getHeight(), Graphics.TOP | Graphics.LEFT);
        g.drawString("真的，真的打算退出游戏吗？", 200, 210 + Globe.currentFont.getHeight(), Graphics.TOP | Graphics.LEFT);
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
				LWGameCanvas.setActive(returnScreen, true);
			} else {
//				LWGameCanvas.deleteScreen(this);
//				LoadingScreen.loadIndex = 3;
//				LWGameCanvas.switchToScreen(new LoadingScreen(GameVariables.LOADING_SCREEN_ID));
                LWGameCanvas.isExit = true;
			}
		}
		LWGameCanvas.keyReset();
	}
}
