
/*
 * Given a linked list, swap every two adjacent and return its head.
 * 
 * For example given 1->2->3->4, you should return the list as 2->1->4->3
 * 
 * Algo should use only constant space, cannot modify the values in the list, only the nodes itself can be changed
 * 
 * 11:00
 * 11:06
 */

public class SwapNodePairs {
	public static void main(String[] args){
		SwapNodePairs a = new SwapNodePairs();
		
		Node n1 = new Node(1);
		n1.next = new Node(2);
		n1.next.next = new Node(3);
		n1.next.next.next = new Node(4);
		n1 = a.swap(n1);
		System.out.println("Expect 2: " + n1.val);
		System.out.println("Expect 1: " + n1.next.val);
		System.out.println("Expect 4: " + n1.next.next.val);
		System.out.println("Expect 3: " + n1.next.next.next.val);
		if(n1.next.next.next.next == null){
			System.out.println("Expect null and received null");
		}
		
		Node n2 = new Node(1);
		n2.next = new Node(2);
		n2.next.next = new Node(3);
		n2.next.next.next = new Node(4);
		n2.next.next.next.next = new Node(5);
		n2 = a.swap(n2);
		System.out.println("Expect 2: " + n2.val);
		System.out.println("Expect 1: " + n2.next.val);
		System.out.println("Expect 4: " + n2.next.next.val);
		System.out.println("Expect 3: " + n2.next.next.next.val);
		System.out.println("Expect 5: " + n2.next.next.next.next.val);
		if(n2.next.next.next.next.next == null){
			System.out.println("Expect null and received null");
		}
		
	}
	
	//Set up a helper Node in front of the root, helper.next = root
	//Loop should end if curr == null or curr.next == null (odd)
	//curr points to current node
	//prev points to current.next
	//nextPair pointer points to current.next.next
	
	//After the swap, helper points to curr, curr points to nextPair
	public Node swap(Node n){
		Node helper = new Node(0);
		Node head = helper;
		helper.next = n;
		Node curr = n;
		Node prev, nextPair;
		while(curr != null && curr.next != null){
			prev = curr.next;
			nextPair = curr.next.next;
			
			//swap
			helper.next = prev;
			prev.next = curr;
			curr.next = nextPair;
			
		
			helper = curr;
			curr = nextPair;
		}
		return head.next;
	}
	
	

}
