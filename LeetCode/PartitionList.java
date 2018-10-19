
/* 6:40
 * 7:00
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x
 * You should preserve the original relative order of the nodes in each of the two partitions
 * For example, given 1 -> 4 -> 3 -> 2 -> 5 -> 2 and x = 3, return 1 -> 2 -> 2 -> 4 -> 3 -> 5
 */

public class PartitionList {
	public static void main(String[] args){
		PartitionList a = new PartitionList();
		
		Node n1 = new Node(1);
		n1.next = new Node(4);
		n1.next.next = new Node(3);
		n1.next.next.next = new Node(2);
		n1.next.next.next.next = new Node(5);
		n1.next.next.next.next.next = new Node(2);
		n1 = a.partition(n1, 3);
		System.out.println("Expect 1: " + n1.val);
		System.out.println("Expect 2: " + n1.next.val);
		System.out.println("Expect 2: " + n1.next.next.val);
		System.out.println("Expect 4: " + n1.next.next.next.val);
		System.out.println("Expect 3: " + n1.next.next.next.next.val);
		System.out.println("Expect 5: " + n1.next.next.next.next.next.val);
		if(n1.next.next.next.next.next.next == null){
			System.out.println("Null expected and found");
		}
		
		Node n2 = new Node(5);
		n2.next = new Node(8);
		n2.next.next = new Node(9);
		n2 = a.partition(n2, 3);
		System.out.println("Expect 5: " + n2.val);
		System.out.println("Expect 8: " + n2.next.val);
		System.out.println("Expect 9: " + n2.next.next.val);
		if(n2.next.next.next == null){
			System.out.println("Null expected and found");
		}
		
		Node n3 = new Node(15);
		n3.next = new Node(18);
		n3.next.next = new Node(19);
		n3 = a.partition(n3, 50);
		System.out.println("Expect 15: " + n3.val);
		System.out.println("Expect 18: " + n3.next.val);
		System.out.println("Expect 19: " + n3.next.next.val);
		if(n2.next.next.next == null){
			System.out.println("Null expected and found");
		}
	}
	
	public Node partition(Node n, int x){
		Node lesser = null, greater = null;
		Node lesserCurr = lesser;
		Node greaterCurr = greater;
		Node curr = n;
		
		while(curr != null){
			if(lesser == null && curr.val < x){
				lesser = curr;
				lesserCurr = lesser;
			} else if (greater == null && curr.val >= x){
				greater = curr;
				greaterCurr = greater;
			} else if(curr.val < x){
				lesserCurr.next = curr;
				lesserCurr = lesserCurr.next;
			} else if(curr.val >= x){
				greaterCurr.next = curr;
				greaterCurr = greaterCurr.next;
			}			
			curr = curr.next;
		}
		if(greaterCurr != null){
			greaterCurr.next = null;
		}
		if(lesser == null){
			return greater;
		}
		lesserCurr.next = greater;
		return lesser;		
	}
}
