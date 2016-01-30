
public class Client {
	public static void main(String[] args){
		IntList numbers = new IntList();
		System.out.println(numbers.checkEmpty());
		numbers.makeSize(3);
		System.out.println(numbers.checkEmpty());
		numbers.insert(1, 0);
		numbers.insert(2, 1);
		numbers.insert(3, 2);
		System.out.println(numbers.toString());
		System.out.println("---------------------");
		numbers.reinitialize();
		System.out.println(numbers.checkEmpty());
		numbers.makeSize(22);
		System.out.println( numbers.howMany());
		numbers.insert(1996, 5);
		System.out.println(numbers.toString());
		numbers.delete(5);
		System.out.println(numbers.toString());
	}
}
