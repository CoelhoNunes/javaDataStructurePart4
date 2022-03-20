/****************************************************************************************** 
Purpose/Description: This is a radixSort algorithm in order to sort increasing order within
an array of positive integers. 
*******************************************************************************************/

package dataStructure_A4;

import java.util.Scanner;
import java.util.ArrayList;

public class radixSort {
	
	// Suppressing all of the raw-types warning within the method
	@SuppressWarnings("rawtypes")
	private static final ArrayList[] ARRAY_LISTS = new ArrayList[10];

	public static void main(String[] args) {
		
		int num;
		
		// Creating the user interactions portions (inputting numbers to sort, etc) 
		try (Scanner s = new Scanner(System.in)) {
			System.out.println("Enter numbers of elements to sort: ");
			num = s.nextInt();
			int [] array = new int[num];
			System.out.println("Enter elements: ");
			
			// Loop for the numbers entered by user
			for(int i = 0; i < num; i++)
				array[i] = s.nextInt();
			
			sortRadix(array);
			System.out.print("Numbers that are sorted:\t ");
			
			// After the numbers are sorted inside loop 
			   for(int i = 0; i < num; i++)
			       System.out.print(array[i] + " ");
		}
		System.out.print("\n");
	}
	
	public static void sortRadix(int[] arr) {
		
		// Code is safe to run and no unexpected exceptions will occur 
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] buckets = ARRAY_LISTS;
		
		// Checking the length of the elements inputed 
		for (int i = 0; i < buckets.length; i++) {
			
			buckets[i] = new ArrayList <Integer> ();
		}
		
		// Sorting out the numbers input (boolean)
		boolean flag = false;
		int tempo = -1, divisor = 1;
		
		while (!flag) {
			flag = true;
			
			// Splitting the elements within the list
			for(int i = 0; i < arr.length; i++) {
				tempo = arr[i] / divisor;
				
				if(tempo % 2 != 0) {
					 System.out.println("*** Abort *** the input has at least one key with odd digits\n");
			         System.exit(0);
				}
				
				// Dishing off the numbers into the buckets
				buckets[tempo % 10].add(arr[i]);
				
				// Making sure the divisor is a valid increment for the next digit
				if(flag && tempo > 0) {
					flag = false;
				}
			}
			
			// Allowing for the empty array to consume the numbers
			int y = 0;
			
			for (int x = 0; x < 10; x = x + 2) {
				
				for(Integer i : buckets[x]) {
					arr[y++] = i;
				}
				
				// Clearing the bucket 
				buckets[x].clear();
			}
			// Assigning the results to the divisor
			divisor *= 10;
		}
	}
}

/******************************** Program output ********************************
 * ------------------------------------------------------------------------------
	Enter numbers of elements to sort: 
	8
	Enter elements: 
	24
	12
	4
	366
	45
	66
	8
	14
	*** Abort *** the input has at least one key with odd digits
	---------------------
	---------------------
	Enter numbers of elements to sort: 
	8
	Enter elements: 
	24
	2
	4
	466
	48
	66
	8
	44
	Numbers that are sorted: 2 4 8 24 44 48 66 466 
 * ------------------------------------------------------------------------------
*/