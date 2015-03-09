package elements;

import javax.microedition.lcdui.Graphics;

import screens.GamingScreen;

import motion.Motion;

import common.GameVariables;
import common.Globe;

public class Pet {
	public int x;
	public int y;
	public int distance;
	public int speed;
	public int vx;
	public int vy;
	public int type;
	public Motion motion ;
	public Pet(int type, int HeroX,int HeroY){
		this.x = HeroX;
		this.y = HeroY;
		this.type = type;
		switch (type) {

            case 0:
                motion=new Motion("/game/pets/land/a1.anu", x, y);
                break;
            case 1:
                motion=new Motion("/game/pets/land/b1.anu", x, y);
                break;
            case 2:
                motion=new Motion("/game/pets/land/c1.anu", x, y);
                break;
            case 3:
                motion=new Motion("/game/pets/land/d1.anu", x, y);
                break;
            case 4:
                motion=new Motion("/game/pets/land/e1.anu", x, y);
                break;
            case 5:
                motion=new Motion("/game/pets/land/f.anu", x, y);
                break;
            case 6:
                motion=new Motion("/game/pets/land/g.anu", x, y);
                break;
            case 7:
                motion=new Motion("/game/pets/land/h.anu", x, y);
                break;
            case 8:
                motion=new Motion("/game/pets/a1.anu", x, y);
                break;
            case 9:
                motion=new Motion("/game/pets/a2.anu", x, y);
                break;
            case 10:
                motion=new Motion("/game/pets/b1.anu", x, y);
                break;
            case 11:
                motion=new Motion("/game/pets/b2.anu", x, y);
                break;
            case 12:
                motion=new Motion("/game/pets/c1.anu", x, y);
                break;
            case 13:
                motion=new Motion("/game/pets/c2.anu", x, y);
                break;
            case 14:
                motion=new Motion("/game/pets/a3.anu", x, y);
                break;
            case 15:
                motion=new Motion("/game/pets/a4.anu", x, y);
                break;
		}
		
	}
	
	public void update(){

//        if(distance < 200 && distance > 80){
//            motion.keepId(1);
//            motion.update(x, y);
//        }else {
            motion.keepId(0);
            motion.update(x, y);
//        }

		//int hx = GamingScreen.hero.getPosX();
		if (type < 6) {
			int hy =  GamingScreen.hero.getPosY() + GamingScreen.hero.bodyHeight / 2;
			distance = (hy - y) * (hy - y);
			if(distance < 1600){
				return;
			}else if(distance < 2500){
				speed = GamingScreen.hero.moveFrame * 3 / 4;
			}else if(distance > 2500){
				speed = GamingScreen.hero.moveFrame * 5 / 4;
			}
			
			int vxy[] = Globe.getAng(0, hy, 0, y, 30);
			vy = vxy[1];
			y += vy;
			if (y > Globe.SH * 2 / 3 + 2) {
				y = Globe.SH * 2 / 3 + 2;
			}
		}
	}
	
	public void draw(Graphics g){

		motion.draw(g);
	}
}
