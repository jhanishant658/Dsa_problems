/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode ptr = head ; 
        int count = 0 ;
        while(ptr!=null){
           count++ ;
           ptr = ptr.next ; 
        }
        System.out.println(count) ; 
        ptr = head ; 
        for(int i = 0 ;i<count/2 ; i++){
            ptr = ptr.next ; 
        }
        return ptr ;   
    }
}