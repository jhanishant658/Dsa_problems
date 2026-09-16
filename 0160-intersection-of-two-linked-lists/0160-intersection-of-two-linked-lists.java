/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptr = headA ;
        while(ptr!=null){
            ListNode ptr1 = headB ; 
            while(ptr1!=null){
                if(ptr==ptr1) return ptr ; 
                ptr1 = ptr1.next ; 
            }
            ptr = ptr.next ; 
        }
        return null;
    }
}