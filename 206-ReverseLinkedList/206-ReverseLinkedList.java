// Last updated: 6/26/2026, 8:54:56 AM
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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        if(head==null)return null;
        while(curr.next!=null){
            ListNode frnd = curr.next;
            curr.next=prev;
            prev=curr;
            curr=frnd;
        }
        curr.next=prev;
        prev=curr;
        return prev;
    }
}