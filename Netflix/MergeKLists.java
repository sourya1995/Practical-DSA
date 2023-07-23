/* 
 * Feature 2 - return top movies across the world - problem : MERGE K LISTS
 */

public class MergeKLists {
    public static ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }

            prev = prev.next;
        }

        if(l1 == null)
            prev.next = l2;
        else
            prev.next = l1;

        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) { 
        if(lists.length > 0){
            int step = 1;
            while(step < lists.length){
                for(int i = 0; i < lists.length - step; i += step * 2){
                    lists[i] = merge2Lists(lists[i], lists[i + step]);
                }
                step *= 2;
            }
            return lists[0];
        } else {
            return null;
        }
    }
}


