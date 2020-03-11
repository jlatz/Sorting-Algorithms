public class KnapsackRe{
	public static void main(String[] args){
		int val[] = {-1,10,20,30}; //value of items
		int wt[] = {-1,30,20,10}; //weight of items

		int n = 3; //total items
		int W = 60; //capacity of knapsack

		System.out.printf("Max value that knapsack can hold is: %d\n", Knapsack(W, n, val, wt));

	}

	public static int Knapsack(int W, int n, int val[], int wt[]){
		int i,w = 0;	

		//value table having n+1 rows and W+1 columns
		int V[][] = new int[n+1][W+1];
	
		//fill the row i=0 the value 0
		for(w = 0; w <= W; w++){
			V[0][w] = 0;
		}
	
		//fill the column w=0 with value 0
		for(i = 0; i <= n; i++){
			V[i][0] = 0;
		}

		//fill the value table
		for(i = 1; i<=n; i++){
			for(w = 1; w <= W; w++){
				if(wt[i] <= w){
					V[i][w] = max(V[i-1][w], val[i] + V[i-1][w-wt[i]]);
				}else{
					V[i][w] = V[i-1][w];
				}
			}

		}
		print(W, n, V);
		return V[n][W];
				
	}

	public static int max(int a, int b){
		return (a > b)? a : b;
	}

	public static void print(int W, int n, int V[][]){
		for(int j = 0; j<=n; j++){
			for(int k = 0; k<=W; k++){
				System.out.print(V[j][k] + "  ");
			}
			System.out.println();
		}

	}
}
