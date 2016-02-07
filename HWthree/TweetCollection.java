import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.ArrayList;


public class TweetCollection {
	ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	
	public void run(){
		URL url = null;
		try {
			url = new URL("http://homes.soic.indiana.edu/classes/spring2016/csci/c343-yye/tweet-data-Jan16.txt");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		Scanner in = null;
		try { 
			in = new Scanner(url.openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (in.hasNext()) {
			String str = in.nextLine();
			//System.out.println(str);
			int i = 0;
			while(!(" ".equals(str.substring(i, i+1))) || i>=str.length() ){
				i++;
			}
			String author = str.substring(0,i);
			String data = str.substring(i+1);
			Tweet tweet = new Tweet(data, author);
			this.tweets.add(tweet);
		}
	}

	public Tweet getTweet(int pos){
		if (pos> this.tweets.size()){
			System.out.println("Your index is out of bounds");
			return new Tweet(null, null);
		}
		else{
		return this.tweets.get(pos);
		}
	}
	
	public String getAll(){
		String display = "";
		for (int i =0; i<this.tweets.size(); i++){
			display += tweets.get(i).getBoth() + " ";
		}
		return display;
	}
	public String getAllAuthors(){
		String authors = "";
		for (int i = 0; i <this.tweets.size(); i++){
			authors += tweets.get(i).getName() + " ";
		}
		return authors;
	}
	
	public String getAllData(){
		String data = "";
		for (int i = 0; i<this.tweets.size(); i++){
			data += tweets.get(i).getContent() + " ";
		}
		return data;
	}
	
	public static void main(String[] args){
		TweetCollection test = new TweetCollection();
		test.run();
		System.out.println(test.getAll());
		System.out.println(test.getAllAuthors());
		System.out.println(test.getAllData());
		System.out.println(test.getTweet(4).getBoth());
		System.out.println(test.getTweet(100).getBoth());
	}
}
