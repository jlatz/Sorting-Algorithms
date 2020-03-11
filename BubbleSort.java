import java.io.*;
import java.util.*;
public class BubbleSort{
	public static void main(String...args){
	
		int[] list = {11,4,8,7,15,6,2};
		for(int i=0; i<list.length-1; i++){
			for(int j=0; j<list.length-1; j++){
				if(list[j]>list[j+1]){
					int temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
				}
			}
		}
		//for(int elm : list){ System.out.println(elm); }
		System.out.println(Arrays.toString(list));
			

	}
}
