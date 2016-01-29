import java.util.ArrayList;
public class Tweet {
	private String content;
	private String name;
	
	Tweet(String content,String name){
		this.content = content;
		this.name = name;
	}
	public void display(){
		System.out.println("Content:" + content + " - Name:" + name);
	}
	public void displayName(){
		System.out.println("Name:" + name);
	}
	public void displayContent(){
		System.out.println("Content:" + content);
	}
	
	public static void main(String[] args){
		Tweet one = new Tweet("Bluejay", "Jarod");
		one.display();
		Tweet two = new Tweet("Hummingbird","England");
		two.display();
		Tweet three = new Tweet("Robin","Mosby");
		three.display();
		Tweet four = new Tweet("Cardinal","Spongebob Squarepants");
		four.display();
		four.displayContent();
		four.displayName();
		
		ArrayList<Tweet> tweets = new ArrayList<Tweet>();
		tweets.add(one);
		tweets.add(two);
		tweets.add(three);
		tweets.add(four);
		tweets.get(1).display();
		tweets.get(2).displayContent();
		tweets.get(3).displayName();
	}
}