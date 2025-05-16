package com.nowcoder;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] arr = Arrays.stream(in.nextLine().trim().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();
        com.nowcoder.Listnodebuilder builder = new com.nowcoder.Listnodebuilder();
        com.nowcoder.Listnode head = builder.Listnodebuilder(arr);
        builder.Listnodeprinter(sortList(head));
    }
    public static com.nowcoder.Listnode sortList(com.nowcoder.Listnode head){
        if(head == null || head.next == null) return head;
        com.nowcoder.Listnode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        com.nowcoder.Listnode tmp = slow.next;
        slow.next = null;
        com.nowcoder.Listnode left = sortList(head);
        com.nowcoder.Listnode right = sortList(tmp);
        com.nowcoder.Listnode res = new com.nowcoder.Listnode(0);
        com.nowcoder.Listnode cur = res;
        while(left != null && right != null){
            if(left.val > right.val){
                cur.next = right;
                right = right.next;
            }else{
                cur.next = left;
                left = left.next;
            }
            cur = cur.next;
        }
        if(left != null || right != null){
            cur.next = left==null ? right : left;
        }
        return res.next;
    }
}

class Listnode{
    int val;
    com.nowcoder.Listnode next;
    Listnode(){}
    Listnode(int x){
        this.val = x;
    }
    Listnode(int x, com.nowcoder.Listnode next){
        this.val = x;
        this.next = next;
    }
}

class Listnodebuilder{
    public com.nowcoder.Listnode Listnodebuilder(int[] arr){
        com.nowcoder.Listnode dummy_node = new com.nowcoder.Listnode(0);
        com.nowcoder.Listnode cur = dummy_node;
        for(int i = 0; i < arr.length; i++){
            cur.next = new com.nowcoder.Listnode(arr[i]);
            cur = cur.next;
        }
        return dummy_node.next;
    }
    public void Listnodeprinter(com.nowcoder.Listnode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}