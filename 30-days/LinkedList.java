/**Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]*/
package leetcode;

public class LinkedList{
    ListNode head;
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    } 

    public static LinkedList insert(LinkedList list, int val){
        ListNode node = new ListNode(val);
        node.next = null;
        if (list.head == null)
            list.head = node;
        else{
            ListNode temp = list.head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = node;
        }
        return list;
    }

    public static void show(LinkedList node){
        ListNode curr = node.head;
        while(curr != null){
            System.out.println(curr.val);
            curr = curr.next;
        }
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        int[] values = {1,2,3,4,5};
        //int k = 2;
        for(int i:values)
            list = insert(list, i);
        show(list);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null || k==1)
            return head;
        
        int len = 0;
        ListNode curr = head;
        while(curr!=null){
            len++;
            curr = curr.next;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        curr = head;
        ListNode prev = dummy;
        ListNode next = null;
        while(len>=k){
            curr = prev.next;
            next = curr.next;
            for (int j=1;j<k;j++){
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
            len  = len-k;
        }
        
        return dummy.next;
    }
}


class ReverseNodesInKGroup {
    
}
