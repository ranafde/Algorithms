import java.util.Iterator;

public class StackLinkedList<Item> implements Iterable<Item>{
	private Node head = null;

	private class Node{
		private Item data;
		private Node next = null;
	}
	
	public Iterator<Item> iterator(){
		return new StackLinkedListIterator();
	}
	
	private class StackLinkedListIterator implements Iterator<Item>{
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
	
	public void push(Item data){
		Node N = new Node();
		N.data = data;
		if(head == null){
			head = N;
			return;
		}	
		N.next = head;
		head = N;
	}
	
	public Item pop(){
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
		StackLinkedList<Integer> st = new StackLinkedList<Integer>();
		System.out.println(st.isEmpty());
		st.push(15);
		st.push(25);
		st.push(35);
		st.push(45);
		st.push(55);
		st.push(65);
		
		System.out.println(st.pop());
		System.out.println("After popping");
		for(Integer i: st)
			System.out.println(i);
		System.out.println(st.isEmpty());
	}
}
