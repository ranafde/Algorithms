
import java.util.Iterator;

public class QueueLinkedList<Item> implements Iterable<Item>{
	private Node head = null, last = null;

	private class Node{
		private Item data;
		private Node next = null;
	}
	
	public Iterator<Item> iterator(){
		return new QueueLinkedListIterator();
	}
	
	private class QueueLinkedListIterator implements Iterator<Item>{
		private Node current = head;
		
		public boolean hasNext(){	
			return current != null;
		}
		
		public void remove(){
			/* Not implemented to preserve invariants */
		}
		
		public Item next(){
			Item it = current.data;
			current = current.next;
			return it;
		}
	}
	
	public void enqueue(Item data){
		Node N = new Node();
		Node temp = last;
		N.data = data;
		N.next = null;
		last = N;
		if(isEmpty())
			head = last;
		else
			temp.next = last;
		
	}
	
	public Item dequeue(){
		if(head==null){
			System.out.println("Empty.");
			return null;
		}	
		Node temp = head;
		head = temp.next;
		return temp.data;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public static void main(String[] args){
		QueueLinkedList<Integer> q = new QueueLinkedList<Integer>();
		System.out.println(q.isEmpty());
		q.enqueue(15);
		q.enqueue(25);
		q.enqueue(35);
		q.enqueue(45);
		q.enqueue(55);
		q.enqueue(65);
		
		//System.out.println(q.dequeue());
		System.out.println("After popping");
		for(Integer i: q)
			System.out.println(i);
		System.out.println(q.isEmpty());
	}
}



 


