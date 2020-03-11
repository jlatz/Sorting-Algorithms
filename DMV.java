import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.regex.*;

public class DMV{
	public static void main(String[] args){

		Scanner kb = new Scanner(System.in);
		System.out.print("Please enter a filename: ");
		String fileName = kb.next();

		String[] clerks = new String[20];

		Scanner sc = null;
		try{
			sc = new Scanner(new FileInputStream(fileName));
		}catch (FileNotFoundException e){
			System.out.println("File Not Found: " + e.toString());
			return;
		}
		int clerkIndex = 0;
		String token;
		while (true){
			token = sc.nextLine();
			if(token.equals("F")){
				break;
			}
			clerks[clerkIndex++] = token;
		}

		String[] ticketHolder = new String[20];
		int[] arrivalTime = new int[20];
		int[] duration = new int[20];

		String strToken;
		char charToken;
		
		String arrivalTimeString;
		int arrivalTimeInt;

		String durationString;
		int durationInt;

		int indexCounter = 0;
		while(true){
			sc.useDelimiter("\n");
			token = sc.next();
			charToken = token.charAt(0);

			if (charToken == 'F'){
				break;
			}
			

			if(token.matches("[A-E][0-9]\\s[0-9]{1,2}")){
				arrivalTimeString = token.substring(1,2);
				durationString = token.substring(3);
			}else if(token.matches("[A-E][0-9]{2}\\s[0-9]{1,2}")){
				arrivalTimeString = token.substring(1,3);
				durationString = token.substring(4);
			}else{
				arrivalTimeString = token.substring(1,4);
				durationString = token.substring(5);
			}
			arrivalTimeInt = Integer.parseInt(arrivalTimeString);
			durationInt = Integer.parseInt(durationString);

			strToken = String.valueOf(charToken);
	
			ticketHolder[indexCounter] = strToken;
			arrivalTime[indexCounter] = arrivalTimeInt;
			duration[indexCounter] = durationInt;
			
			indexCounter++;
		}

		int[] ticketOrder = {1,1,1,1,1};
		for(int i = 0; i<ticketHolder.length; i++){
			boolean done = (ticketHolder[i] == null);
			while(!done){
				switch(ticketHolder[i]){
					case "A": 
						ticketHolder[i] += ticketOrder[0];
						ticketOrder[0]++;
						done = true;
						break;
					case "B":
						ticketHolder[i] += ticketOrder[1];
						ticketOrder[1]++;
						done = true;
						break;
					case "C":
						ticketHolder[i] += ticketOrder[2];
						ticketOrder[2]++;
						done = true;
						break;
					case "D":
						ticketHolder[i] +=ticketOrder[3];
						ticketOrder[3]++;
						done = true;
						break;
					case "E":
						ticketHolder[i] += ticketOrder[4];
						ticketOrder[4]++;
						done = true;
						break;
				}	
			}
		}		

			
		boolean[] occupiedClerk = new boolean[20];
		String[] orderSeen = new String[20];

		int timeCounter = -1;
		int orderSeenCounter = 0;
		int p = 0;

		int numClerks = 0;
		for(String clerkCounterStr : clerks){
			if (clerkCounterStr != null){
				numClerks++;
			}
		}
		int[] clerkCounter = new int[numClerks];

		int[] timeSawClerk = new int[20];
		int timeSawClerkCounter = 0;
			

		while(true){
			int nullCounter = 0;
			boolean increment = false;

			if(p == 20){
				p = 0;
			}
			if(ticketHolder[p] != null){		
				timeCounter++;	

				for(int j = 0; j<clerks.length; j++){
					if(clerks[j] == null){
						continue;
					}
					for(int k = 0; k<clerks[j].length(); k++){
						if (ticketHolder[p] == null)
							continue;
						if(ticketHolder[p].charAt(0) == clerks[j].charAt(k)){
							if (occupiedClerk[j] == false){
								occupiedClerk[j] = true;
								clerkCounter[j] = timeCounter + duration[p];
								orderSeen[orderSeenCounter++] = ticketHolder[p];
								timeSawClerk[timeSawClerkCounter++] = timeCounter - arrivalTime[p];
								ticketHolder[p] = null;
								increment = true;
								p++;
							}
						}
					}
				}
				for(int m = 0; m < clerkCounter.length; m++){
					if (timeCounter == clerkCounter[m]){
						p = 0;
						occupiedClerk[m] = false;
					}
				}	
			}
			for(String elm : ticketHolder){
				if(elm == null){
					nullCounter++;
				}
			}
			if(nullCounter == ticketHolder.length){
				break;
			}
			if (increment == false){
				p++;
			}
			
		}

		int numberCustomers = 0;
		for(String orderAnswer: orderSeen){
			if(orderAnswer != null){
				numberCustomers++;
				System.out.println(orderAnswer);
			}
		}

		
		int[] averageWait = new int[20];
		for(int h = 0; h<averageWait.length; h++){
			averageWait[h] = timeSawClerk[h] - arrivalTime[h];
		}

		int totalWait = 0;
		for(int waitIndex : averageWait){
			totalWait += waitIndex;
		}
		double totalAverageWait = totalWait / numberCustomers;
		System.out.println("Total average wait time: "+ totalAverageWait);

			
	}
}
