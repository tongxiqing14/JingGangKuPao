package tools;

import java.util.ArrayList;
import java.util.List;

import com.fancyy.json.pojo.User;
import com.fancyy.json.util.JSON;
import elements.EnemyTeam;

public class Test6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<User> users = new ArrayList<User>();
		for (int i = 0; i < 3; i++) {
			User user = new User();
			user.setId(i);
			user.setName("Fancyy_" + i);
			user.setPwd("FancyyPwd_" + i);
			users.add(user);
		}
		String json = JSON.toJson(users);
		List<EnemyTeam> usersCopy = (List<EnemyTeam>) JSON.toObject("[{\"enemyName\":\"hero_right_blueImg\",\"type\":\"0\",\"hpNumber\":\"1000\"},{\"enemyName\":\"renwu_Img\",\"type\":\"1\",\"hpNumber\":\"1000\"},{\"enemyName\":\"white_wolf_Img\",\"type\":\"1\",\"hpNumber\":\"1000\"},{\"enemyName\":\"pet_horseImg\",\"type\":\"2\",\"hpNumber\":\"1000\"},{\"enemyName\":\"pet_batImg\",\"type\":\"2\",\"hpNumber\":\"1000\"}]\n", EnemyTeam.class);
		System.out.println(usersCopy);
	}

}
