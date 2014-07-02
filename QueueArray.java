import java.util.Iterator;



class QueueArray<Item> implements Iterable<Item>{
	private Item[] s;
	static private int head = 0;
	static private int tail = 0;
	static private int elements = 0;
	static private int capacity = 0;

	
	public Iterator<Item> iterator(){
		return new QueueArrayIterator();
	}
	
	private class QueueArrayIterator implements Iterator<Item>{
		private int current = head;
		private int count  = 0;

		public boolean hasNext(){
			return (count != elements);
		}
		
		public Item next(){
			if(current != tail && current == s.length)
				current = 0;
			count++;
			return s[current++];
		}
		
		public void remove(){
			// not implemented to preserve invariant
		}
	}
	
	public QueueArray(int capacity){
		s = (Item[]) new Object[capacity];
		this.capacity = capacity;
	}
	
	public boolean isEmpty(){
		return elements==0;
	}
	
	public boolean isFull(){
		return elements == capacity;
	}
	
	public void enqueue(Item it){
		if(elements==capacity){
			resize(2*s.length);
		}
		else if(tail == capacity)
			tail = 0;
		s[tail++] = it;
		elements++;
	}
	
	public Item dequeue(){
		Item it;	
		if(head == s.length && elements > 0)
			head = 0;
		else if(elements == 0)
			return null;
		it = s[head];
		if(elements>0 && elements==capacity/4){			
			resize(s.length/2);
		}
		s[head++] = null;
		--elements;
		return it;
	}

	public int size()
	{
		return s.length;
	}
	

	private void resize(int size){
		Item[] it = (Item[]) new Object[size];
		int count = 0;	
		int i = head;
		while(count!=elements){
			if(i==s.length && elements > 0)
				i = 0;
			it[count++] = s[i++];
		}
		s = it;
		head = 0;
		tail = count;
		this.capacity = size;
	}
	
	public static void main(String[] args){
		QueueArray<Integer> in = new QueueArray<Integer>(1);
		in.enqueue(15);
		in.enqueue(25);
		//System.out.println("Dequeuing:"+ in.dequeue() +", elements are now: "+elements);
		//System.out.println("Head: "+head+" Tail: "+tail);
		in.enqueue(35);
		//System.out.println("Dequeuing:"+ in.dequeue() +", elements are now: "+elements);
		in.enqueue(45);
		in.enqueue(55);		
		//System.out.println("Dequeuing:"+ in.dequeue() +", elements are now: "+elements);
		in.enqueue(65);
		in.enqueue(75);
		in.enqueue(85);
		
		//System.out.println(in.isEmpty());
		System.out.println("Iterating");
		//System.out.println("Capacity: "+in.size());
		//System.out.println("Head: "+head+" Tail: "+tail+" ELements: "+elements);
		for(int i: in){			
			System.out.println(i);
		}
		
		// Dequeuing
		System.out.println("Dequeuing");
	
		System.out.println("Dequeuing: "+in.dequeue());
		System.out.println("Dequeuing: "+in.dequeue());
		System.out.println("Dequeuing: "+in.dequeue());
		System.out.println("Dequeuing: "+in.dequeue());
		System.out.println("Dequeuing: "+in.dequeue());
		System.out.println("Dequeuing: "+in.dequeue());
		System.out.println("Dequeuing: "+in.dequeue());
		//System.out.println("Dequeuing: "+in.dequeue());
		
		System.out.println(".......");
	
		System.out.println(in.isFull());
		System.out.println(in.size());
		System.out.println("Head: "+head+" Tail: "+tail+" ELements: "+elements);
		System.out.println("Capacity: "+capacity);
		in.enqueue(15);
		in.enqueue(25);
		System.out.println("Iterating");
		for(int i: in){			
			System.out.println(i);
		}
	}
	
}



 
