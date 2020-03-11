import java.util.*;
public class MergeSort{
	public static void main(String[] args){
		int[] one = {3,7,2,11};
		int[] two = {4,9,5,8};

		int oneLen = one.length;
		int twoLen = two.length;
		int[] three = new int[oneLen + twoLen];

		int onePos = 0;
		int twoPos = 0;
		while(onePos < oneLen && twoPos < twoLen){
			if(one[onePos] <= two[twoPos]){
				three[onePos + twoPos] = one[onePos];
				onePos++;
			}else{
				three[onePos + twoPos] = two[twoPos];
				twoPos++;
			}
		}
		if(onePos < oneLen){
			for(int i = onePos; i<oneLen; i++){
				three[twoPos + i] = one[i];
			}
		}else{
			for(int i = twoPos; i<twoLen; i++){
				three[onePos + i] = two[i];
			}
		}
		System.out.println(Arrays.toString(three));
	}
}
			
