class Solution {
    public int pairSum(ListNode head) {

        // Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        ListNode prev = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        // Calculate maximum twin sum
        int max = 0;
        ListNode ptr1 = head;
        ListNode ptr2 = prev;

        while (ptr2 != null) {
            max = Math.max(max, ptr1.val + ptr2.val);
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return max;
    }
}