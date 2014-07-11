import java.io.BufferedReader;
import java.io.InputStreamReader;


public class InsertionSort {
	
	public static void insertionSort(int[] a){
	
		int i;
		int j;
		int temp;
		
		for(j=1;j<a.length;j++){
			for(i=j-1;i>=0;i--){
				if(a[i]>a[i+1])
				{	
					temp = a[i+1];
					a[i+1] = a[i];
					a[i] = temp;
				}
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
		
		insertionSort(a);
	
		System.out.println("After sort:");
		
		for(int i=0; i<a.length; i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	
	}

}
