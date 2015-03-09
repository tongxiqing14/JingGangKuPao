package tools;

import com.fancyy.json.pojo.User;
import com.fancyy.json.util.JSON;
import elements.Hero;
import org.json.me.JSONObject;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		User user = new User();
//		user.setId(1);
//		user.setName("Fancyy");
//		user.setPwd("123456");
//
//		String json = JSON.toJson(user);
//
//		System.out.println(JSON.format(json));

        Hero hero = new Hero();
//        hero.setExps(1000);

        String json = JSON.toJson(hero);
        System.out.println(JSON.format(json));

        Hero userCopy = (Hero) JSON.toObject(json, Hero.class);
        System.out.println(userCopy);
	}

}
