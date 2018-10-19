
/*
 * Write a program to find the node at which the intersection of two singly linked list begins
 * 
 * a1 - a2 - a3 
 *               \
 *                c1 - c2 - c3
 *               /
 * b1 - b2 - b3
 * 
 * 
 */
import java.util.HashSet;

public class LinkedListIntersection {
	public static void main(String[] args){
		Node n1 = new Node(1);
		n1.next = new Node(2);
		n1.next.next = new Node(3);
		n1.next.next.next = new Node(6);
		n1.next.next.next.next = new Node(5);
		Node n2 = new Node(11);
		n2.next = new Node(12);
		n2.next.next = new Node(13);
		n2.next.next.next = n1.next.next.next;
		
		LinkedListIntersection a = new LinkedListIntersection();
		Node intersection1 = a.findIntersection(n1, n2);
		Node intersection2 = a.findIntersectionLinear(n1, n2);
		
		System.out.println("Expect 6: " + intersection1.val);
		System.out.println("Expect 6: " + intersection2.val);
	}
	
	//O(mn)
	public Node findIntersection(Node n, Node m){
		Node mHead = m;
		Node mCurr = mHead;
		Node nCurr = n;
		while(nCurr != null){
			while(mCurr != null){
				if(nCurr == mCurr){
					return nCurr;
				}
				mCurr = mCurr.next;
			}
			mCurr = mHead;
			nCurr = nCurr.next;
		}
		return null;
	}
	
	//O(m+n)
	public Node findIntersectionLinear(Node n, Node m){
		HashSet<Node> set = new HashSet<>();
		Node nCurr = n;
		while(nCurr != null){
			set.add(nCurr);
			nCurr = nCurr.next;
		}
		
		Node mCurr = m;
		while(mCurr != null){
			if(set.contains(mCurr)){
				return mCurr;
			}
			mCurr = mCurr.next;
		}
		return null;		
	}
}
