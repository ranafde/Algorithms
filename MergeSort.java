import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;



public class MergeSort {
	
	public static int[] mergeSort(int[] list){
		if(list.length<=1)
			return list;
		int[] first = new int[list.length/2];
		int[] second = new int[list.length-first.length];
		System.arraycopy(list, 0, first, 0, first.length);
		System.arraycopy(list, first.length, second, 0, second.length);
		
		mergeSort(first);
		mergeSort(second);
		
		merge(first, second, list);
		return list;
	}
	
	public static int[] merge(int[] first, int[] second, int[] list){
		int firstidx = 0, secondidx = 0, listidx = 0;
		
		while(firstidx<first.length && secondidx<second.length)
		{
			if(first[firstidx]>second[secondidx])
				list[listidx++] = second[secondidx++];
			else
				list[listidx++] = first[firstidx++];		
		}
		
		System.arraycopy(first, firstidx, list, listidx, first.length-firstidx);
		System.arraycopy(second, secondidx, list, listidx, second.length-secondidx);
		return list;
	}
	
	public static void main(String[] args) throws Exception
	{
		
		String input="";
		ArrayList<Integer> intarray = new ArrayList<Integer>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//MergeSort s=new MergeSort();
		
		
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
		
		System.out.println("Elements before merge sort:");
		for(int i=0;i<elements.length;i++)
			System.out.println(elements[i]+" ");
		
		elements = mergeSort(elements);
		System.out.println("Elements after merge sort:");
		for(int i=0;i<elements.length;i++)
			System.out.println(elements[i]+" ");
	}

}
