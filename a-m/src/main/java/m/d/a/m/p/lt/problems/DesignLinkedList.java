package m.d.a.m.p.lt.problems;

public class DesignLinkedList {
    public static void main(final String[] args) {
        // test1();
        // test2();
        // test3();
        // test4();
        // test5();

        // test6();
        // test7();
        // test8();
        // test9();
        test10();
    }

    static void test1() {
        MyLinkedList2 list = new MyLinkedList2();
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.print();
    }

    static void test2() {
        MyLinkedList2 list = new MyLinkedList2();
        list.addAtHead(1);
        list.addAtHead(2);
        list.addAtHead(3);
        list.print();
    }

    static void test3() {
        MyLinkedList2 list = new MyLinkedList2();
        System.out.println(list.get(0));
        list.addAtTail(1);
        list.addAtTail(2);
        System.out.println(list.get(1));
        System.out.println(list.get(3));
        System.out.println(list.get(-10));
    }

    static void test4() {
        MyLinkedList2 list = new MyLinkedList2();
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.addAtIndex(3, 5);
        list.addAtIndex(0, 10);
        list.print();
    }

    static void test5() {
        MyLinkedList2 list = new MyLinkedList2();
        list.addAtTail(1);
        list.deleteAtIndex(0);
        list.print();
        list.addAtTail(1);
        list.addAtTail(2);
        list.deleteAtIndex(0);
        list.print();
    }

    static void test6() {
        MyLinkedList list = new MyLinkedList();
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.print();
    }

    static void test7() {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtHead(2);
        list.addAtHead(3);
        list.print();
    }

    static void test8() {
        MyLinkedList list = new MyLinkedList();
        System.out.println(list.get(0));
        list.addAtTail(1);
        list.addAtTail(2);
        System.out.println(list.get(1));
        System.out.println(list.get(3));
        System.out.println(list.get(-10));
    }

    static void test9() {
        MyLinkedList list = new MyLinkedList();
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.addAtIndex(3, 5);
        list.addAtIndex(0, 10);
        list.print();
    }

    static void test10() {
        MyLinkedList list = new MyLinkedList();
        list.addAtTail(1);
        list.deleteAtIndex(0);
        list.print();
        list.addAtTail(1);
        list.addAtTail(2);
        list.deleteAtIndex(0);
        list.print();
    }

    static class MyLinkedList {
        SinglyListNode head;

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            if (head == null) {
                head = new SinglyListNode(val);
            } else {
                SinglyListNode current = head;
                while (current.next != null && current.next.next != null) {
                    current = current.next;
                }
                if (current.next != null) {
                    current.next.next = new SinglyListNode(val);
                } else {
                    current.next = new SinglyListNode(val);
                }
            }
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            if (head == null) {
                head = new SinglyListNode(val);
            } else {
                SinglyListNode newNode = new SinglyListNode(val);
                newNode.next = head;
                head = newNode;
            }
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            if (index < 0 || head == null) {
                return -1;
            }
            SinglyListNode current = head;
            while (index > 0 && current != null) {
                current = current.next;
                index--;
            }
            return (current != null && index == 0) ? current.val : -1;
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index == 0) {
                SinglyListNode newNode = new SinglyListNode(val);
                newNode.next = head;
                head = newNode;
            } else {
                SinglyListNode current = head;
                while (index-- > 1 && current != null) {
                    current = current.next;
                }
                if (current != null) {
                    SinglyListNode newNode = new SinglyListNode(val);
                    newNode.next = current.next;
                    current.next = newNode;
                }
            }
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index == 0) {
                if (head != null) {
                    head = head.next;
                }
            } else if (index > 0) {
                int r = 0;
                SinglyListNode current = head;
                SinglyListNode prev = current;
                while (current != null) {
                    if (r == index) {
                        break;
                    }
                    r++;
                    prev = current;
                    current = current.next;
                }

                if (r == index && prev != null) {
                    if (current != null) {
                        prev.next = current.next;
                    } else {
                        prev.next = null;
                    }
                }
            }
        }

        void print() {
            SinglyListNode current = head;
            while (current != null) {
                System.out.println(current.val);
                current = current.next;
            }
        }

        class SinglyListNode {
            int val;
            SinglyListNode next;

            SinglyListNode(int x) {
                val = x;
            }
        }
    }

    static class MyLinkedList2 {
        SinglyListNode head;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList2() {

        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            if (index < 0 || head == null) {
                return -1;
            }
            int r = 0;
            SinglyListNode current = head;
            while (current != null) {
                if (r == index) {
                    return current.val;
                }
                r++;
                current = current.next;
            }
            return -1;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            if (head == null) {
                head = new SinglyListNode(val);
            } else {
                SinglyListNode newNode = new SinglyListNode(val);
                newNode.next = head;
                head = newNode;
            }
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            if (head == null) {
                head = new SinglyListNode(val);
            } else {
                SinglyListNode current = head;
                SinglyListNode prev = current;
                while (current != null) {
                    prev = current;
                    current = current.next;
                }
                SinglyListNode newNode = new SinglyListNode(val);
                prev.next = newNode;
            }
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index < 0) {
                return;
            }
            int r = 0;
            SinglyListNode current = head;
            SinglyListNode prev = current;
            while (current != null) {
                if (r == index) {
                    break;
                }
                r++;
                prev = current;
                current = current.next;
            }
            if (r == index && prev != null) {
                SinglyListNode newNode = new SinglyListNode(val);
                SinglyListNode next = prev.next;
                prev.next = newNode;
                newNode.next = next;
            }
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index == 0) {
                if (head != null) {
                    head = head.next;
                }
            } else if (index > 0) {
                int r = 0;
                SinglyListNode current = head;
                SinglyListNode prev = current;
                while (current != null) {
                    if (r == index) {
                        break;
                    }
                    r++;
                    prev = current;
                    current = current.next;
                }

                if (r == index && prev != null) {
                    if (current != null) {
                        prev.next = current.next;
                    } else {
                        prev.next = null;
                    }
                }
            }
        }

        void print() {
            SinglyListNode current = head;
            while (current != null) {
                System.out.println(current.val);
                current = current.next;
            }
        }

        class SinglyListNode {
            int val;
            SinglyListNode next;

            SinglyListNode(int x) {
                val = x;
            }
        }
    }
}
