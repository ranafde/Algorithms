import java.io.BufferedReader;
import java.io.InputStreamReader;


public class BubbleSort {
	
	public static void bubbleSort(int[] a){
		int temp;
		
		for(int i = 1; i<a.length; i++)
			for(int j=0; j<a.length-i; j++)
			{
				if(a[j]>a[j+1]){
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		
	}
	
	public static void main(String args[]) throws Exception{
		int[] a = new int[5];
		String str ="";
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<a.length; i++){
			str = bf.readLine();
			a[i] = Integer.parseInt(str);
		}
			
		System.out.println("Before sort:");
	
		for(int i=0; i<a.length; i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
		
		bubbleSort(a);
	
		System.out.println("After sort:");
		
		for(int i=0; i<a.length; i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	
	}

}
