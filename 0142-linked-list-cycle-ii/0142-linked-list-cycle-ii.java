/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode ptr = head;
        HashSet<ListNode> set = new HashSet<>();
        while(ptr!=null){
            if(set.contains(ptr))break;
             set.add(ptr);
             ptr=ptr.next;
        }
        return ptr;
    }
}