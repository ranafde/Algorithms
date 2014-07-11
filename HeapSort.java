import java.io.BufferedReader;
import java.io.InputStreamReader;


public class HeapSort {

	private static int heapsize; 
	
	public static int Parent(int cid){
		return cid/2;
	}
	
	public static int Left(int pid){
		return pid*2;
	}
	
	public static int Right(int pid){
		return pid*2 + 1;
	}
	
	public static void MaxHeapify(int []a, int idx){
		int left = Left(idx);
		int right = Right(idx);
		int largest;
		int temp; 
		
		if(left<=heapsize && a[left]>a[idx])
			largest = left;
		else
			largest = idx;
		if(right<=heapsize && a[right]>a[largest])
			largest = right;
		if(largest!=idx){
			temp = a[largest];
			a[largest] = a[idx];
			a[idx] = temp;
			MaxHeapify(a,largest);
		}
		else{
			return;
		}	
	}
	
	public static void BuildMaxHeap(int a[]){
		heapsize = a.length-1;
		for(int j = heapsize; j>=1; j--)
			MaxHeapify(a,j);
	}
	
	public static void heapSort(int a[]){
		int temp;
		BuildMaxHeap(a);
		for(int j=a.length-1; j>=2; j--){
			temp = a[j];
			a[j] = a[1];
			a[1] = temp;
			heapsize--;
			MaxHeapify(a,1);
		}
	}
	
	public static void main(String args[]) throws Exception{
		int[] a = new int[6];
		String str ="";
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=1; i<a.length; i++){
			str = bf.readLine();
			a[i] = Integer.parseInt(str);
		}
			
		System.out.println("Before sort:");
	
		for(int i=1; i<a.length; i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
		
		//BuildMaxHeap(a);
		heapSort(a);
	
		System.out.println("After sort:");
		
		for(int i=1; i<a.length; i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
		//System.out.println("Parent of "+a[5]+" is : "+a[Parent(5)]);
	
	}
}
