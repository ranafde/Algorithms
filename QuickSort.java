import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;


public class QuickSort {
	
	public static void quickSort(int[] numbers, int low, int high){
		if(low>=high)
			return;
		int pivot = partitionArray(numbers, 0, high);
		quickSort(numbers, 0, pivot-1);
		quickSort(numbers, pivot+1, high);
	}
	
	public static int partitionArray(int[] numbers, int lo, int hi)
	{
		/*Choose a pivot*/
		Random rand = new Random();
		int p = rand.nextInt(hi+1) + lo;
		int temp;
	
		/* Bring pivot to the first location of the array */
		temp = numbers[p];
		numbers[p] = numbers[0];
		numbers[0] = temp;
		
		int i = 0, j = i+1;
		while(j<=hi)
		{
			if(numbers[0] < numbers[j]){
				
			}
			else{ 
				i++;
				temp = numbers[j];
				numbers[j] = numbers[i];
				numbers[i] = temp;
			}
			j++;
		}
		
		/* Put the pivot back to its location in the array */
		temp = numbers[i];
		numbers[i] = numbers[0];
		numbers[0] = temp;
		
		/* Return pivot's index */
		return i;
	}
	
	
	public static void main(String args[]) throws Exception{
		String input="";
		ArrayList<Integer> intarray = new ArrayList<Integer>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter numbers. To stop write \"stop\":");
		
		while(!(input=bf.readLine()).equalsIgnoreCase("stop"))
		{
			int num = Integer.parseInt(input);
			intarray.add(num);
		}
		
		int elements[] = new int[intarray.size()];
		Iterator<Integer> iter = intarray.iterator();
		for(int i=0; iter.hasNext();i++){
			elements[i]=iter.next();
		}
		
		System.out.println("Elements before quick sort:");
		for(int i=0;i<elements.length;i++)
			System.out.println(elements[i]+" ");
		
		quickSort(elements,0, elements.length-1);
		
		System.out.println("Elements after quick sort:");
		for(int i=0;i<elements.length;i++)
			System.out.println(elements[i]+" ");
	}

}
