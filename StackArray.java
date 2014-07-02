import java.util.Iterator;

class StackArray<Item> implements Iterable<Item>{
	private Item[] s;
	private int N = 0;

	
	public Iterator<Item> iterator(){
		return new StackArrayIterator();
	}
	
	private class StackArrayIterator implements Iterator<Item>{
		private int current = N;

		public boolean hasNext(){
			return current > 0;
		}
		
		public Item next(){
			return s[--current];
		}
		
		public void remove(){
			// not implemented to preserve invariant
		}
	}
	
	public StackArray(int capacity){
		s = (Item[]) new Object[capacity];
	}
	
	public boolean isEmpty(){
		return N==0;
	}
	
	public void push(Item it){
		if(N==s.length){
			resize(2*s.length);
		}
		s[N++] = it;
	}
	
	public Item pop(){
		Item it;
		it = s[--N];
		s[N] = null;
		if(N>0 && N==s.length/4){
			resize(s.length/2);
		}
		return it;
	}

	public int size()
	{
		return s.length;
	}
	

	private void resize(int capacity){
		Item[] it = (Item[]) new Object[capacity];
		for(int i=0; i<N; i++)
			it[i] = s[i];
		s = it;
	}
	
	public static void main(String[] args){
		StackArray<Integer> in = new StackArray<Integer>(1);
		in.push(15);
		in.push(25);
		//System.out.println(in.pop());
		in.push(35);
		in.push(45);
		in.push(55);
		in.push(65);
		/*System.out.println(in.pop());
		System.out.println(in.pop());
		System.out.println(in.pop());*/
		for(int i: in){
			System.out.println(i);
		}	
		System.out.println(in.isEmpty());
		System.out.println(in.size());
	}
	
}
