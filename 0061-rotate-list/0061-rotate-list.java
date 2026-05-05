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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0) return head ; 
        int cnt = 0 ; 
        ListNode ptr = head ; 
        while(ptr!=null){
            cnt++;
            ptr = ptr.next ; 
        }
        k = k%cnt ; 
        ptr = head ; 
        for(int i = 0 ; i<cnt-k-1 ; i++){
          ptr = ptr.next ; 
        } 
        ListNode temp = ptr.next ; 
        ptr.next = null ;
        ptr = temp ; 
        if(temp==null) return head ; 
        while(ptr!=null&&ptr.next!=null){
            ptr = ptr.next ; 
        }
        ptr.next = head ; 
      
        return temp ; 
    }
}