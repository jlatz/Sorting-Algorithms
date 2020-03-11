import java.util.*;

public class BubbleSortNew{

	public static void main(String[] args){

		int[] list = {15,1,9,8,20,2,14,13};
		int swap = list.length-1;
		int iterate = swap;
		while(swap > 0){
			swap = 0;
			for(int j=0;j<iterate;j++){
				if(list[j]>list[j+1]){
					int temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
					swap = j;
					//System.out.println(swap);
				}
			}
		}	
		System.out.println(Arrays.toString(list));
		
	}
}	

