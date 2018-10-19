
/*
 * Remove all elements from a linkedlist of integers that have value val 
 */

public class RemoveLinkedListElements {
	public static void main(String[] args){
		RemoveLinkedListElements a = new RemoveLinkedListElements();
		
		Node n1 = new Node(5);
		n1.next = new Node(6);
		n1.next.next = new Node(7);
		n1.next.next.next = new Node(5);
		n1.next.next.next.next = new Node(8);
		n1.next.next.next.next.next = new Node(5);
		
		n1 = a.remove(n1, 5);
		System.out.println("Expect 6: " + n1.val);
		System.out.println("Expect 7: " + n1.next.val);
		System.out.println("Expect 8: " + n1.next.next.val);
		if(n1.next.next.next == null){
			System.out.println("Expect null and received null");
		}
	}
	
	public Node remove(Node n, int val){
		Node sentinel = new Node(0);
		sentinel.next = n;
		Node curr = sentinel;
		
		while(curr.next != null){
			if(curr.next.val == val){
				Node temp = curr.next;
				curr.next = temp.next;
			} else {
				curr = curr.next;
			}
		}		
		return sentinel.next;
	}
}
