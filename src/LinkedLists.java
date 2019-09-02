import java.util.HashSet;

public class LinkedLists {
    static class Node {
        Node next = null;
        int val;

        public Node(int v) {
            val = v;
        }

        void append(int v) {
            Node end = new Node(v);
            Node n = this;
            while(n.next != null) {
                n=n.next;
            }
            n.next = end;
        }
    }

    public static void main(String[] args) {
//        Remove duplicates
        Node list = new Node(14);
        list.append(5);
        list.append(4);
        list.append(3);
        list.append(9);
        list.append(4);
        list.append(8);
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(6);
        list.append(2);
        list.append(3);
        list.append(8);
        list.append(7);
        list.append(6);

//        Node answer = removeDupsByHash(list);
        Node answer = removeDupsNoExtraSpace(list);
        Node begin = answer;
//        System.out.println(answer);
        while(answer != null) {
            System.out.print(answer.val + "|");
            answer = answer.next;
        }
        System.out.println();

//        Return kth element to last

        int kth = kthToLast(begin, 9);

        System.out.printf("%d is %d elements from the end\n", 9, kth);

    }

    private static int kthToLast(Node n, int target) {
        Node mark = n;
        Node findLast = n;
        int diff = 0;
        boolean marked = false;

        while(findLast != null) {
            if(mark.val != target && !marked) {
                mark = mark.next;
            }
            else if(!marked && mark.val == target) {
                marked = true;
            }
            if(marked) {
                diff++;
            }
            findLast = findLast.next;
        }

        return diff-1;
    }


    private static Node removeDupsNoExtraSpace(Node list) {
        Node slow = list;
        Node fast;
        Node beginning = list;

        while(slow != null) {
            fast = slow;
//            System.out.println(fast.val);
            while(fast.next != null) {
                if(fast.next.val == slow.val) {
                    fast.next = fast.next.next;
                }
                if(fast.next != null) fast = fast.next;
            }
            slow = slow.next;
        }

        return list;
    }

    private static Node removeDupsByHash(Node list) {
        HashSet<Integer> hs = new HashSet<>();
        Node hashPoint = list;
        Node prev = hashPoint;

        hs.add(hashPoint.val);
        hashPoint = hashPoint.next;
        while(hashPoint != null) {
            if(!hs.add(hashPoint.val)) {
                prev.next = hashPoint.next;
            }
            else {
                prev = hashPoint;
            }

            hashPoint = hashPoint.next;

        }

        return list;
    }
}
