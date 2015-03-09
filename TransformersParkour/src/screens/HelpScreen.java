package screens;

import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import Entry.LWGameCanvas;
import common.Globe;
import common.Screen;

public class HelpScreen extends Screen {
    //返回窗口
    public Screen returnScreen;

    private Image helpImages;

//    private Image commonImage1;

    public HelpScreen(int screenId) {
        super(screenId);
        // TODO Auto-generated constructor stub
    }

    public void init() {
//        helpImages = new Image[6];
//        for(int i=0; i<helpImages.length; i++){
        helpImages = Globe.getImage("help/helpbg.png");
//        }
//        commonImage1 = Globe.getImage("common/commonBG1.png");
    }

    public void update() {
        if(LWGameCanvas.iskeyPressed(Globe.M_KEY_0)||LWGameCanvas.iskeyPressed(Globe.M_KEY_OK)){
            LWGameCanvas.switchToScreen(new MenuScreen(0));
        }
    }

    //定义字体
    private Font mediumFont=Font.getFont(Font.FACE_SYSTEM,Font.STYLE_BOLD,Font.SIZE_MEDIUM);
    public void draw(Graphics g) {
//        g.drawImage(helpImage,0,0,20);

        g.drawImage(helpImages, 0, 0, 20);
//        g.drawImage(helpImages[1], 213, 0, 20);
//        g.drawImage(helpImages[2], 427, 0, 20);
//        g.drawImage(helpImages[3], 0, 265, 20);
//        g.drawImage(helpImages[4], 213, 265, 20);
//        g.drawImage(helpImages[5], 427, 265, 20);

        g.setFont(mediumFont);
//        g.drawImage(commonImage1, 320, 515, Graphics.HCENTER|Graphics.VCENTER);

    }

    public void clear() {
        // TODO Auto-generated method stub
        returnScreen = null;
//        for(int i=0; i<helpImages.length; i++){
//            helpImages[i] = null;
//        }
        helpImages = null;/**/
//        commonImage1 = null;
        Runtime.getRuntime().gc();

    }

}
