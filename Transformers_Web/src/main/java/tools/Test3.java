package tools;

import java.util.ArrayList;
import java.util.List;

import com.fancyy.json.pojo.News;
import com.fancyy.json.pojo.User;
import com.fancyy.json.util.JSON;

public class Test3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		News news = new News();
		news.setId(1);
		news.setTitle("新年放假通知");
		news.setContent("从今天开始放假啦。");
		news.setAuthor(createAuthor());
		news.setReader(createReaders());
		
		String json = JSON.toJson(news);
		
		System.out.println(JSON.format(json));
	}

	private static List<User> createReaders() {
		List<User> readers = new ArrayList<User>();
		User readerA = new User();
		readerA.setId(2);
		readerA.setName("Jack");
		readers.add(readerA);
		
		User readerB = new User();
		readerB.setId(1);
		readerB.setName("Lucy");
		readers.add(readerB);
		
		return readers;
	}

	private static User createAuthor() {
		User author = new User();
		author.setId(1);
		author.setName("Fancyy");
		author.setPwd("123456");
		return author;
	}

}
