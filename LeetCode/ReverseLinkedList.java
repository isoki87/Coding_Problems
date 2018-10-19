
/*
 * Reverse a singly linked list
 * 
 * 11 10
 * 11 17
 */

public class ReverseLinkedList {
	public static void main(String[] args){
		ReverseLinkedList a = new ReverseLinkedList();
		Node n1 = new Node(1);
		n1.next = new Node(2);
		n1.next.next = new Node(3);
		n1.next.next.next = new Node(4);
		n1.next.next.next.next = new Node(5);
		n1 = a.reverse(n1);
		System.out.println("Expect 5: " + n1.val);
		System.out.println("Expect 4: " + n1.next.val);
		System.out.println("Expect 3: " + n1.next.next.val);
		System.out.println("Expect 2: " + n1.next.next.next.val);
		System.out.println("Expect 1: " + n1.next.next.next.next.val);
		if(n1.next.next.next.next.next == null){
			System.out.println("Expect null and received null");
		}
		
	}
	
	public Node reverse(Node n){
		if(n == null){
			return null;
		}
		Node prev = null;
		Node curr = n;
		Node next = curr.next;
		
		while(next != null){
			Node temp = next.next;
			curr.next = prev;
			next.next = curr;
			
			prev = curr;
			curr = next;
			next = temp;		
		}
		
		return curr;
	}

}
