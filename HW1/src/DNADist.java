import java.util.Random;

public class DNADist {

	int Hdistance(String a, String b){ //check two Strings of the same size's Hammering distance
		if (a.length() != b.length()){
			System.out.println("These DNAStrings are not the same size");
		}
		int count = 0;
		for (int i=0; i<a.length();i++){
			if (!(a.substring(i,i+1).equals(b.substring(i,i+1)))){
				count++;
			}
		}
		return count;
	}

	String produce(int size){      //this will produce a random DNA String of length 20
		String s = "";
		for (int i = 1; i<=size ; i++){
			Random rnd = new Random();
			int t = rnd.nextInt(4);
			if (t==0){
				s +="A";
			}
			else if (t==1){
				s += "T";
			}
			else if (t==2){
				s += "C";
			}
			else{
				s += "G";
			}
		}
		return s;
	}
	public static void main(String[] args){
		DNADist distFinder = new DNADist();
		System.out.println(distFinder.Hdistance("TTCGG","ATGCA"));
		System.out.println(distFinder.Hdistance("AAAAAAAAAAAAA","AAAATAAAAAAAA"));
		System.out.println(distFinder.Hdistance(distFinder.produce(100), distFinder.produce(100)));
	}
}
