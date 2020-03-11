public class Sum{
	public static void main(String...args){
		int answer = k(93754);
		System.out.println(answer);

	}
	public static int k(int num){
		int sum = 0;
		int number = num;
		while (number > 0){
			sum = sum + (number%10);
			number = number/10;
			//System.out.println(sum);
		}
		if(sum>9){
			//System.out.println(sum);
			sum = k(sum);
		}
		return sum;
	}
}
