import java.util.ArrayList;
import java.util.Random;

public class MyCard implements Card {
	String[] letter = { "A", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	String[] suit = {"S", "H","C","D"};
	ArrayList<String> deck = new ArrayList<String>();

	public static void main(String[] args){
		MyCard card = new MyCard();
		card.initialize();
		card.drawCard();
		card.drawCard();
	}


	@Override
	public void initialize() {

		for (int i = 0; i<this.suit.length; i++){
			for (int b=0; b<this.letter.length; b++ ){
				this.deck.add(letter[b]+ suit[i]);
			}
		}
		System.out.println(this.deck);	
	}

	@Override
	public String drawCard() {
		Random rnd = new Random();
		int t = rnd.nextInt(this.deck.size());
		String aCard = this.deck.get(t);
		this.deck.remove(t);
		System.out.println("Remaining deck" + this.deck);
		System.out.println("You drew " + aCard);
		return aCard;
	}
}
