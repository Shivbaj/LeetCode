package com.leetcode.MergerKSortedLists;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

	public static void main(String args[]) {
	
		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(4);
		list1.next.next = new ListNode(5);
		
		ListNode list2 = new ListNode(1);
		list2.next = new ListNode(3);
		list2.next.next = new ListNode(4);
		
		ListNode list3 = new ListNode(2);
		list3.next = new ListNode(6);
		ListNode[] lists = new ListNode[] {list1,list2,list3};
	
		ListNode finalList = mergeKLists(lists);
	}

	 public static ListNode mergeKLists(ListNode[] lists) {
	      PriorityQueue<Integer> pq = new PriorityQueue<>();
	      for(ListNode head : lists){
	          while(head != null){
	              pq.add(head.val);
	              head = head.next;
	          }
	      }
	      ListNode dummy = new ListNode(-1);
	      ListNode head = dummy;
	      while(!pq.isEmpty()){
	          head.next = new ListNode(pq.remove());
	          head = head.next;
	      }
	      return dummy.next;
	        
	    }
}
