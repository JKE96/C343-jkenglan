public class Tweet {
	private String content;
	private String name;
	
	Tweet(String content,String name){
		this.content = content;
		this.name = name;
	}
	public String getBoth(){
		return "Name:" + name + " - Content: " + content;
	}
	public String getName(){
		return "Name:" + name;
	}
	public String getContent(){
		return "Content:" + content;
	}
}