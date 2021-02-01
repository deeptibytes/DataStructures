package misc;

public class PriorityQueueDemo {

/*
 * Treeset vs Priority Queue
 * 
 * Similarly: 
 * Upon adding element both sort the elements in ascending order by default
 * Unlike List, Does not maintain any order of insertion 
 * Both can be printed
 * Big O of add() in Logn
 * 
 * ANy DS which maintains the order (ascending or descinding) can never have O(1) time
 * 
 * 
 * Difference
 * Set does not allow any duplicate
 * PQ allows duplicates but treeSet does not
 * TreeSet >> remove the element ..remember adding duplicate element lets you compile but it is not added
 * PQ >> remove only removes first occurrance.
 * Treeset has methods like add(object), remove(object), ts.first(0, ts.last()
 * PQ has methods (all queue methods) >>add(object),  poll(), remove(object), peek()
 * We can create MaxHeap and MinHeap using PQ. Default PQ is MinHeap. means if we access very first element (pq.poll()), 
 * we will get smallest element
 * PQ.add is same PQ.offer
 * 
 * If PQ construter is empty, elements will be sorted in ascending order in case of primitives and integer. But PQ of object, we should define a c
 * comparator and pass that in PQ constructer so elements will be sorted based on comparator. 
 * 
 * Adding/removing items to PQ take O(Logn) time. Means if PQ has 5 elements, and we add 6th element. it will O(log5) so the conclusion is 
 * larger the queue is it takes longer time to add the elements. In contrast to PQ, ArrayList add() is constant time
 * To create a PQ with n elemenets, it will take O(N) time
 * 
 */


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
