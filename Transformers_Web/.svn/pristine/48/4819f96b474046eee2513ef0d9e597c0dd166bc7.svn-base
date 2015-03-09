package tools;

import com.fancyy.json.pojo.User;
import com.fancyy.json.util.JSON;

public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User user = new User();
		user.setId(1);
		user.setName("Fancyy");
		user.setPwd("123456");
		
		String json = JSON.toJson(user);
        System.out.println(json);
		
		User userCopy = (User) JSON.toObject(json, User.class);
		System.out.println(userCopy);
	}

}
