package screens;

import Entry.LWGameCanvas;
import common.GameVariables;
import common.Globe;
import common.Screen;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/**
 * Created with IntelliJ IDEA.
 * User: tongxiqing
 * Date: 15-1-26
 * Time: ÏÂÎç8:49
 * To change this template use File | Settings | File Templates.
 */
public class GiftTipScreen extends Screen {

    private Image[] imageTips = new Image[5];
    private Image[] imageTitles = new Image[4];
    private Image indexImage;

    private int confirmIndex = 0;
    private int indexFrame;

    public static Screen returnScreen;

    public GiftTipScreen(int screenId) {
        super(screenId);
    }

    //    @java.lang.Override
    public void init() {
        //
        imageTips[4] = Globe.getImage("confirm/buybg1.png");
        for (int i = 0; i < imageTips.length - 1; i++) {
            imageTips[i] = Globe.getImage("confirm/btn" + i + ".png");
        }

        for (int i = 0; i < imageTitles.length - 1; i++) {
            imageTitles[i] = Globe.getImage("game/effect" + (i+1) + ".png");
        }
        indexImage = Globe.getImage("success/index.jpg");
    }

//    @java.lang.Override
    public void update() {
        //
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
//                GamingScreen.hero.chongBuffTime = System.currentTimeMillis();
                LWGameCanvas.setActive(returnScreen, true);
            } else {
//                LWGameCanvas.deleteScreen(this);
//                LoadingScreen.loadIndex = 3;
//                LWGameCanvas.switchToScreen(new LoadingScreen(GameVariables.LOADING_SCREEN_ID));
            }
        }
        LWGameCanvas.keyReset();
    }

//    @java.lang.Override
    public void draw(Graphics g) {
        //
        g.drawImage(imageTips[4], Globe.SW >> 1, Globe.SH >> 1, Graphics.HCENTER | Graphics.VCENTER);
        g.drawImage(imageTips[0 == confirmIndex ? 1 : 0], 170, 450, 20);
        g.drawImage(imageTips[1 == confirmIndex ? 3 : 2], 370, 450, 20);

        g.drawImage(imageTitles[0], 170, 200, 20);
        g.drawImage(imageTitles[1], 270, 200, 20);
        g.drawImage(imageTitles[2], 170, 250, 20);
        g.drawImage(imageTitles[3], 270, 250, 20);

        g.drawImage(indexImage, 152 + confirmIndex * 200 + indexFrame, 312, Graphics.HCENTER | Graphics.VCENTER);

    }

//    @java.lang.Override
    public void clear() {
        //
        imageTips = null;
        indexImage = null;
        imageTitles = null;
//        System.gc();
        Runtime.getRuntime().gc();
    }

}
