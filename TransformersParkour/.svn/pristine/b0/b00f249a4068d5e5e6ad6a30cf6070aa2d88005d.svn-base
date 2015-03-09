/*
 * COPYRIGHT - MOTIONWELDER
 */
package motion;

import java.io.IOException;

import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

import motion.studio.MSprite;
import motion.studio.MSpriteImageLoader;

import common.Globe;



/**
 * Resource Loader: Class to load Images
 * @author Nitin Pokar (pokar.nitin@gmail.com)
 *
 */
public class ResourceLoader implements MSpriteImageLoader{

	/** Making Class Singleton */
	static private ResourceLoader resourceLoader;
	private ResourceLoader(){}

	static public ResourceLoader getInstance(){
		if(resourceLoader==null){
			resourceLoader = new ResourceLoader();
		}
		return resourceLoader;
	}

	/**
	 *  Function : LoadImage will be called while loading .anu.
	 *  This version of Load Image will be called when .anu is loaded without chopping images
     *  In this example we have not loaded any .anu where we have passed false to MSpriteLoader, hence this function will never be called
	 */
	public Image loadImage(String spriteName,int imageId){
		// determine whether i need flipped version in my game
		Image baseImage=null;
		if(spriteName.equals("/boss6/guoyuantianzun_z.anu")){
			if(imageId==0){
				baseImage = downloadImage("gaming/guoyuantianzun_z1.png");
			}else if(imageId==1){
				baseImage = downloadImage("gaming/guoyuantianzun_z2.png");
			}
		}else if(spriteName.equals("/game/hero0/hero0.anu")){
			if(imageId==0){
				baseImage = Globe.getImage("game/hero0/chong.png");
			}else if(imageId==1){
				baseImage = Globe.getImage("game/hero0/run.png");
			}
		}else if(spriteName.equals("/game/hero1/hero1.anu")){
			if(imageId==0){
				baseImage = Globe.getImage("game/hero1/chong.png");
			}else if(imageId==1){
				baseImage = Globe.getImage("game/hero1/run.png");
			}
		}else if(spriteName.equals("/game/hero2/hero2.anu")){
			if(imageId==0){
				baseImage = Globe.getImage("game/hero2/chong.png");
			}else if(imageId==1){
				baseImage = Globe.getImage("game/hero2/run.png");
			}
		}else if(spriteName.equals("/game/hero3/hero3.anu")){
			if(imageId==0){
				baseImage = Globe.getImage("game/hero3/run.png");
			}else if(imageId==1){
				baseImage = Globe.getImage("game/hero3/chong.png");
			}
		}else if(spriteName.equals("/effect/chongfeng.anu")){
//			if (imageId == 0) {
				baseImage = Globe.getImage("effect/chongfeng"+(imageId+1)+".png");
//			} else if (imageId == 1) {
//				baseImage = Globe.getImage("effect/feng.png");
//			}
		}else if(spriteName.equals("/effect/xijin.anu")){
			baseImage = Globe.getImage("effect/xijin.png");
		}else if(spriteName.equals("/game/star.anu")){
			baseImage = Globe.getImage("game/star.png");
		}else if(spriteName.equals("/game/star14.anu")){
			if (imageId == 0) {
				baseImage = Globe.getImage("game/star1.png");
			} else if (imageId == 1) {
				baseImage = Globe.getImage("game/star2.png");
			}
		}else if(spriteName.equals("/game/siwang/siwangyan.anu")){
			switch (imageId) {
			case 0:
				baseImage = Globe.getImage("game/siwang/siwangyan1.png");
				break;
			case 1:
				baseImage = Globe.getImage("game/siwang/siwangyan2.png");
				break;
			case 2:
				baseImage = Globe.getImage("game/siwang/siwangyan3.png");
				break;
			case 3:
				baseImage = Globe.getImage("game/siwang/siwangyan4.png");
				break;
			case 4:
				baseImage = Globe.getImage("game/siwang/siwangyan5.png");
				break;

			}
		} else
//        if (spriteName.equals("/gaming/bianfu/bianfu.anu")) {
//			baseImage = downloadImage("gaming/bianfu/bianfu.png");
//		} else
        if (spriteName.equals("/gaming/dachou/dachou.anu")) {
			baseImage = downloadImage("gaming/dachou/dachou.png");
		} else if (spriteName.equals("/gaming/dragon/dragon.anu")) {
			baseImage = downloadImage("gaming/dragon/dalong.png");
		} else if (spriteName.equals("/gaming/qie/qie.anu")) {
			baseImage = downloadImage("gaming/qie/daqie.png");
		} else if (spriteName.equals("/gaming/samllsnowbow/samllsnowbow.anu")) {
			baseImage = downloadImage("gaming/samllsnowbow/samllsnowbow.png");
		} else if (spriteName.equals("/gaming/shilaimu/shilaimu.anu")) {
			baseImage = downloadImage("gaming/shilaimu/shilaimu.png");
		} else if (spriteName.equals("/gaming/smalldragon/smalldragon.anu")) {
			baseImage = downloadImage("gaming/smalldragon/smalldragon.png");
		} else if (spriteName.equals("/gaming/snowbow/snowbow.anu")) {
			baseImage = downloadImage("gaming/snowbow/snowbow.png");
		} else if (spriteName.equals("/gaming/xianrenzhang/xianrenzhang.anu")) {
			baseImage = downloadImage("gaming/xianrenzhang/xianrenzhang.png");
		} else if (spriteName.equals("/gaming/xiaochou/xiaochou.anu")) {
			baseImage = downloadImage("gaming/xiaochou/xiaochou.png");
		} else if (spriteName.equals("/gaming/xiaoqie/xiaoqie.anu")) {
			baseImage = downloadImage("gaming/xiaoqie/xiaoqie.png");
		} else if (spriteName.equals("/gaming/xiaoshilaimu/xiaoshilaimu.anu")) {
			baseImage = downloadImage("gaming/xiaoshilaimu/xiaoshilaimu.png");
		} else if (spriteName.equals("/gaming/xiaoxianren/xiaoxianren.anu")) {
			baseImage = downloadImage("gaming/xiaoxianren/xiaoxianren.png");
		}else if(spriteName.equals("/collision/98.anu")){
			switch (imageId) {
			case 0:
				baseImage = Globe.getImage("collision/daniao.png");
				break;
			}
		}else if(spriteName.equals("/collision/Mongo_Sprite.anu")){
			if(imageId==0){
				baseImage = Globe.getImage("collision/daniao.png");
			}else if(imageId==1){
				baseImage = Globe.getImage("collision/daniao.png");
			}else if(imageId==2){
				baseImage = Globe.getImage("collision/daniao.png");
			}
        }else if(spriteName.equals("/game/pets/xiaoniao.anu")){
            if(imageId==0){
				baseImage = Globe.getImage("game/pets/xiaoniao01.png");
			}else if(imageId==1){
				baseImage = Globe.getImage("game/pets/xiaoniao02.png");
			}
        }else if(spriteName.equals("/game/pets/feiniao.anu")){
            if(imageId==0){
				baseImage = Globe.getImage("game/pets/feiniao1.png");
			}else if(imageId==1){
				baseImage = Globe.getImage("game/pets/feiniao2.png");
			}
        }else if(spriteName.equals("/game/pets/wuzhizhi.anu")){
        	if(imageId==0){
				baseImage = Globe.getImage("game/pets/wuzhizhi01.png");
			}else if(imageId==1){
				baseImage = Globe.getImage("game/pets/wuzhizhi02.png");
			}
        }else if(spriteName.equals("/game/pets/xuefeifei.anu")){
            if(imageId==0){
				baseImage = Globe.getImage("game/pets/xuefeifei01.png");
			}else if(imageId==1){
				baseImage = Globe.getImage("game/pets/xuefeifei02.png");
			}
        }else if(spriteName.equals("/game/pets/daniao.anu")){
            if(imageId==0){
				baseImage = Globe.getImage("game/pets/daniao1.png");
			}else if(imageId==1){
				baseImage = Globe.getImage("game/pets/daniao2.png");
			}
        }else if(spriteName.equals("/game/pets/hudie.anu")){
            baseImage = Globe.getImage("game/pets/hudie.png");
        }else if(spriteName.equals("/game/pets/mianmian.anu")){
            if(imageId==0){
				baseImage = Globe.getImage("game/pets/mianmian01.png");
			}else if(imageId==1){
				baseImage = Globe.getImage("game/pets/mianmian02.png");
			}
        }else if(spriteName.equals("/game/pets/qiu.anu")){
            if(imageId==0){
				baseImage = Globe.getImage("game/pets/qiu01.png");
			}else if(imageId==1){
				baseImage = Globe.getImage("game/pets/qiu02.png");
			}
        }else if(spriteName.equals("/game/pets/tuzi.anu")){
            if(imageId==0){
				baseImage = Globe.getImage("game/pets/tuzi01.png");
			}else if(imageId==1){
				baseImage = Globe.getImage("game/pets/tuzi02.png");
			}
        }else if(spriteName.equals("/game/pets/yang.anu")){
            if(imageId==0){
				baseImage = Globe.getImage("game/pets/yang01.png");
			}else if(imageId==1){
				baseImage = Globe.getImage("game/pets/yang02.png");
			}
        }else if(spriteName.equals("/game/pets/yangtuo.anu")){
            if(imageId==0){
				baseImage = Globe.getImage("game/pets/yangtuo01.png");
			}else if(imageId==1){
				baseImage = Globe.getImage("game/pets/yangtuo02.png");
			}
        }else if(spriteName.equals("/game/pets/zhu.anu")){
            if(imageId==0){
				baseImage = Globe.getImage("game/pets/zhu01.png");
			}else if(imageId==1){
				baseImage = Globe.getImage("game/pets/zhu02.png");
			}
		}else if(spriteName.equals("/game/pets/ciwei.anu")){
            if(imageId==0){
				baseImage = Globe.getImage("game/pets/c1.png");
			}else if(imageId==1){
				baseImage = Globe.getImage("game/pets/c2.png");
			}
		}else if(spriteName.equals("/game/daniao.anu")){
            baseImage = Globe.getImage("game/daniao.png");
        }
        else if(spriteName.equals("/game/nima.anu")){
            if(imageId==0){
                baseImage = Globe.getImage("game/nima.png");
            }
        }else if(spriteName.equals("/effect/texiao.anu")){
            if(imageId==0){
                baseImage = Globe.getImage("effect/texiao0.png");
            }else if(imageId==1){
				baseImage = Globe.getImage("effect/texiao1.png");
			}
		} else if (spriteName.equals("/effect/alarm.anu")) {
			baseImage = Globe.getImage("effect/alarm.png");
		} else if(spriteName.equals("/game/car1/car1.anu")){
            baseImage = Globe.getImage("game/car1/car1.png");
        }else if(spriteName.equals("/game/car2/car2.anu")){
            baseImage = Globe.getImage("game/car2/car2.png");
        }else if(spriteName.equals("/game/car3/car3.anu")){
            baseImage = Globe.getImage("game/car3/car3.png");
        }else if(spriteName.equals("/game/car4/car4.anu")){
            baseImage = Globe.getImage("game/car4/car4.png");
        }else if(spriteName.equals("/game/car5/car5.anu")){
            baseImage = Globe.getImage("game/car5/car5.png");
        }else if(spriteName.equals("/bee/bee.anu")){
            if(imageId<4){
                baseImage = Globe.getImage("bee/bee"+(imageId+1)+".png");
            }else {
                switch (imageId){
                    case 4:
                        baseImage = Globe.getImage("bee/state1/6.png");
                        break;
                    case 5:
                        baseImage = Globe.getImage("bee/state1/a.png");
                        break;
                    case 6:
                        baseImage = Globe.getImage("bee/state1/b.png");
                        break;
                }
            }
        }else if(spriteName.equals("/cache/cache.anu")){
            if(imageId<4){
                baseImage = Globe.getImage("cache/ka"+(imageId+1)+".png");
            }else {
                switch (imageId){
                    case 4:
                        baseImage = Globe.getImage("cache/state1/1.png");
                        break;
                    case 5:
                        baseImage = Globe.getImage("cache/state1/a.png");
                        break;
                    case 6:
                        baseImage = Globe.getImage("cache/state1/b.png");
                        break;
                }
            }
        }else if(spriteName.equals("/paoche/paoche.anu")){
            if(imageId<4){
                baseImage = Globe.getImage("paoche/pao"+(imageId+1)+".png");
            }else {
                switch (imageId){
                    case 4:
                        baseImage = Globe.getImage("paoche/state1/6.png");
                        break;
                    case 5:
                        baseImage = Globe.getImage("paoche/state1/a.png");
                        break;
                    case 6:
                        baseImage = Globe.getImage("paoche/state1/b.png");
                        break;
                }
            }
        }else if(spriteName.equals("/qin/qin.anu")){
            if(imageId<4){
                baseImage = Globe.getImage("qin/qin"+(imageId+1)+".png");
            }else {
                switch (imageId){
                    case 4:
                        baseImage = Globe.getImage("qin/state1/6.png");
                        break;
                    case 5:
                        baseImage = Globe.getImage("qin/state1/a.png");
                        break;
                    case 6:
                        baseImage = Globe.getImage("qin/state1/b.png");
                        break;
                }
            }
        }else if(spriteName.equals("/selectHero/rect1.anu")){
            baseImage = Globe.getImage("selectHero/rect-"+(imageId+1)+".png");
        }else if(spriteName.equals("/castle/arrow02.anu")){
            baseImage = Globe.getImage("castle/arrow02.png");
        }else if(spriteName.equals("/gaming/bianfu/bianfu.anu")){
            baseImage = Globe.getImage("gaming/bianfu/bianfu.png");
        }else if(spriteName.equals("/gaming/fire/fire.anu")){
            baseImage = Globe.getImage("gaming/fire/00"+(imageId+1)+".png");
        }else if(spriteName.equals("/game/pets/a1.anu")){
            if(imageId == 0){
                baseImage = Globe.getImage("game/pets/a1.png");
            }else if(imageId == 1){
                baseImage = Globe.getImage("game/pets/AA.png");
            }
        }else if(spriteName.equals("/game/pets/a2.anu")){
            if(imageId == 0){
                baseImage = Globe.getImage("game/pets/a2.png");
            }else if(imageId == 1){
                baseImage = Globe.getImage("game/pets/AA.png");
            }
        }else if(spriteName.equals("/game/pets/a3.anu")){
            if(imageId == 0){
                baseImage = Globe.getImage("game/pets/a3.png");
            }else if(imageId == 1){
                baseImage = Globe.getImage("game/pets/AA.png");
            }
        }else if(spriteName.equals("/game/pets/a4.anu")){
            if(imageId == 0){
                baseImage = Globe.getImage("game/pets/a4.png");
            }else if(imageId == 1){
                baseImage = Globe.getImage("game/pets/AA.png");
            }
        }else if(spriteName.equals("/game/pets/b1.anu")){
            if(imageId == 0){
                baseImage = Globe.getImage("game/pets/b1.png");
            }else if(imageId == 1){
                baseImage = Globe.getImage("game/pets/B.png");
            }
        }else if(spriteName.equals("/game/pets/b2.anu")){
            if(imageId == 0){
                baseImage = Globe.getImage("game/pets/b2.png");
            }else if(imageId == 1){
                baseImage = Globe.getImage("game/pets/B.png");
            }
        }else if(spriteName.equals("/game/pets/c1.anu")){
            if(imageId == 0){
                baseImage = Globe.getImage("game/pets/c1.png");
            }else if(imageId == 1){
                baseImage = Globe.getImage("game/pets/c.png");
            }
        }else if(spriteName.equals("/game/pets/c2.anu")){
            if(imageId == 0){
                baseImage = Globe.getImage("game/pets/c2.png");
            }else if(imageId == 1){
                baseImage = Globe.getImage("game/pets/c.png");
            }
        } else if(spriteName.equals("/game/pets/land/a1.anu")){
            if(imageId == 0){
                baseImage = Globe.getImage("game/pets/land/a1.png");
            }else if(imageId == 1){
                baseImage = Globe.getImage("game/pets/land/a2.png");
            }
        }  else if(spriteName.equals("/game/pets/land/b1.anu")){
            if(imageId == 0){
                baseImage = Globe.getImage("game/pets/land/b1.png");
            }else if(imageId == 1){
                baseImage = Globe.getImage("game/pets/land/b2.png");
            }
        } else if(spriteName.equals("/game/pets/land/c1.anu")){
            if(imageId == 0){
                baseImage = Globe.getImage("game/pets/land/c1.png");
            }else if(imageId == 1){
                baseImage = Globe.getImage("game/pets/land/c2.png");
            }
        }  else if(spriteName.equals("/game/pets/land/d1.anu")){
            if(imageId == 0){
                baseImage = Globe.getImage("game/pets/land/d1.png");
            }else if(imageId == 1){
                baseImage = Globe.getImage("game/pets/land/d2.png");
            }
        }  else if(spriteName.equals("/game/pets/land/e1.anu")){
            if(imageId == 0){
                baseImage = Globe.getImage("game/pets/land/e1.png");
            }else if(imageId == 1){
                baseImage = Globe.getImage("game/pets/land/e2.png");
            }
        } else if(spriteName.equals("/game/pets/land/f.anu")){
            if(imageId == 0){
                baseImage = Globe.getImage("game/pets/land/f.png");
            }else if(imageId == 1){
                baseImage = Globe.getImage("game/pets/land/1.png");
            }else if(imageId == 2){
                baseImage = Globe.getImage("game/pets/land/2.png");
            }
        } else if(spriteName.equals("/game/pets/land/g.anu")){
            if(imageId == 0){
                baseImage = Globe.getImage("game/pets/land/g.png");
            }else if(imageId == 1){
                baseImage = Globe.getImage("game/pets/land/1.png");
            }else if(imageId == 2){
                baseImage = Globe.getImage("game/pets/land/2.png");
            }
        } else if(spriteName.equals("/game/pets/land/h.anu")){
            if(imageId == 0){
                baseImage = Globe.getImage("game/pets/land/h.png");
            }else if(imageId == 1){
                baseImage = Globe.getImage("game/pets/land/1.png");
            }else if(imageId == 2){
                baseImage = Globe.getImage("game/pets/land/2.png");
            }
        } else if(spriteName.equals("/castle/skill.anu")){
            baseImage = Globe.getImage("castle/skill.png");
        } else if(spriteName.equals("/stageSelect/stage.anu")){
            baseImage = Globe.getImage("stageSelect/"+(imageId+1)+".png");
        } else if(spriteName.equals("/gaming/ground/ground1.anu")){
            baseImage = Globe.getImage("gaming/ground/ground1--"+(imageId+1)+".png");
        } else if(spriteName.equals("/gaming/ground/ground2.anu")){
            baseImage = Globe.getImage("gaming/ground/ground2--"+(imageId+1)+".png");
        } else if(spriteName.equals("/gaming/ground/ground3.anu")){
            baseImage = Globe.getImage("gaming/ground/ground3--"+(imageId+1)+".png");
        } else if(spriteName.equals("/gaming/ground/ground4.anu")){
            baseImage = Globe.getImage("gaming/ground/ground4--"+(imageId+1)+".png");
        } else if(spriteName.equals("/gaming/ground/ground5.anu")){
            baseImage = Globe.getImage("gaming/ground/ground5--"+(imageId+1)+".png");
        } else if(spriteName.equals("/gaming/sky/sky1.anu")){
            baseImage = Globe.getImage("gaming/sky/sky1"+(imageId+1)+".png");
        } else if(spriteName.equals("/gaming/sky/sky2.anu")){
            baseImage = Globe.getImage("gaming/sky/sky2"+(imageId+1)+".png");
        } else if(spriteName.equals("/gaming/sky/sky3.anu")){
            baseImage = Globe.getImage("gaming/sky/sky3.png");
        } else if(spriteName.equals("/gaming/sky/sky4.anu")){
            baseImage = Globe.getImage("gaming/sky/sky4.png");
        } else if(spriteName.equals("/game/icon8a.anu")){
            if(imageId == 0){
                baseImage = Globe.getImage("game/icon8a08.png");
            }else if(imageId == 1){
                baseImage = Globe.getImage("game/icon8a09.png");
            }
        }

		return baseImage;
	}

	/**
	 *  If you are using Nokia DirectGraphics, please don't load flipped image, Instead modify MPlayer to flip it at runtime
	 *
	 *  Function : LoadImageClip will be called while loading .anu.
	 *  This version of Load Image will be called when .anu is loaded with chopped images
     *  In this example we have loaded .anu with passing true in MSpriteLoader, hence this function will be called
	 */
//	public Vector tempVector=new Vector();
	public Image loadImageClip(String spriteName,Image img,int x,int y,int w,int h,int orientationUsedInStudio){
		Image image = Image.createImage(img,x,y,w,h,Sprite.TRANS_NONE);
		return image;
	}

	public static Image loadImage(String str){
		try{
			return Image.createImage(str);
		}catch (Exception e) {
			//System.out.println("Error loading Image " + str);
		}
		return null;
	}

	public static Image downloadImage(String str){
		Image img = null;
		img = Globe.download.creatImage(str);
		return img;
	}
}
