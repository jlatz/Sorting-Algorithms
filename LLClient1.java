import java.io.*;
import java.util.*;
import java.lang.Math;

public class LLClient1 {

	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		int data = getInt(console);
		LL list = new LL(data);
		data = getInt(console);
		while (data != 0) {
			if (data < list.getData() && data > 0) {
				list = lessThan(list, data);
			}	
			else if (data >= list.getData()){
				list = greaterThan(list, data);
			} 
			else if (data < 0){
				list = delete(list, data);
			}

			printLL(list);
			data = getInt(console);
		}
		printLL(list);
	}
	
	public static int getInt(Scanner console){
		System.out.println("Enter an integer or 0 to end.");
		int input = console.nextInt();
		return input;
	}

	public static LL lessThan(LL list, int data){
		LL temp = new LL( data);
                temp.setPoint(list);
                list = temp;
		return list;
	}
	public static LL greaterThan(LL list, int data){
		LL position = list.getPoint();
                LL lastPosition = list;
		while (position != null && data >= position.getData()){
			position = position.getPoint();
                        lastPosition = lastPosition.getPoint();
                }
		LL temp = new LL(data);
                lastPosition.setPoint(temp);
                temp.setPoint(position);
		return list;


	}
	public static LL delete(LL list, int data){
		data = Math.abs(data);
                LL lastPosition = list;
                LL position = lastPosition.getPoint();
		LL nextPosition = position.getPoint();
		while (position != null && data != position.getData()){ 	
			position = position.getPoint();
                        lastPosition = lastPosition.getPoint();
	
			if (nextPosition == null){ //position.getData() would equal the last number in the list
				System.out.printf("%d was not found in the list\n", data);
                                break;
                        }

                       	nextPosition = nextPosition.getPoint();
		}
		
		lastPosition.setPoint(nextPosition);
		return list;
	}

	public static void printLL(LL list){
		LL pos = list;
		System.out.print(pos.getData());
		while (pos.getPoint()!= null){
			pos = pos.getPoint();
			System.out.print(", "+pos.getData());
		}
		System.out.println();
	}
}
