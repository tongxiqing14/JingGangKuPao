package tools;

import java.util.ArrayList;
import java.util.List;

import com.fancyy.json.pojo.User;
import com.fancyy.json.util.JSON;

public class Test5 {

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
		System.out.println(JSON.format(json));
	}

}
