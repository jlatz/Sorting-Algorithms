public class recursive{
	public static void main(String...args){

		System.out.println(recur(16));

	}
	public static int recur(int n){
		if (n == 0){
			return 1;
		}
		return 2*recur(n-1) % 100;
	}
}
