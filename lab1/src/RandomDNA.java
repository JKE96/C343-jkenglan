import java.util.Random;
public class RandomDNA {
	
	String produce(){      //this will produce a random DNA String of length 20
		String s = "";
		for (int i = 1; i<=20 ; i++){
			Random rnd = new Random();
			int t = rnd.nextInt(4);
			if (t==0){
				s = s +"A";
			}
			if (t==1){
				s = s + "T";
			}
			if (t==2){
				s = s + "C";
			}
			if (t==3){
				s = s + "G";
			}
		}
		return s;
	}
	
	public static void main(String[] args){
		RandomDNA dna = new RandomDNA();
		System.out.println(dna.produce());
		}
	}
