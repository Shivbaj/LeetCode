package com.leetcode.handOfStraight;

import java.util.PriorityQueue;

import com.leetcode.openTheLock.Solution;

public class HandOfStraight {


	 public static void main(String[] args) { 
		HandOfStraight sol = new HandOfStraight();
		int[] hand = new int[]{1,2,3,6,2,3,4,7,8}; 	
		int  W = 3;
		boolean result = sol.isNStraightHand(hand,W);
		System.out.print(result);
		}

	public boolean isNStraightHand(int[] hand, int W) {
		 if (hand.length % W != 0) {
	            return false;
	        }
	        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	        for (int num: hand) {
	            minHeap.add(num);
	        }
	        
	        while (minHeap.size() != 0) {
	            int start = minHeap.poll();
	            for (int i = 1; i < W; i++) {
	                if (minHeap.remove(start + i)) {
	                    continue;
	                }
	                else {
	                    return false;
	                }
	            }
	        }
	        return true;
	}
}
