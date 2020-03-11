
public class LLClient {

	public static void main(String[] args){
		LL list = new LL(12);
		LL first = new LL(7);
		first.setPoint(list);
		list = first;
		LL second = new LL(5);
		list.setPoint(second);
		second.setPoint(first);
		printLL(list);
		/*
		LL second = new LL(8);
		first.setPoint(second);
		printLL(list);
		LL third = new LL(6);
		list.setPoint(third);
		third.setPoint(first);
		printLL(list);
		*/
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
