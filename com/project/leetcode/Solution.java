
package com.project.leetcode;



import com.project.*;
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    StringBuilder firstNumberString =new StringBuilder();
    StringBuilder secondNumberString = new StringBuilder();
    while(l1!=null) {
        firstNumberString.append(Integer.toString(l1.val));
        l1= l1.next;
    }
     while(l2!=null){
        secondNumberString.append(Integer.toString(l2.val));
        l2= l2.next;
    }
    int firstNumber = Integer.parseInt(firstNumberString.toString());	
    int secondNumber = Integer.parseInt(secondNumberString.toString());	
    int sum = firstNumber + secondNumber;
    String sumString = Integer.toString(sum); 
    
    ListNode finalNode= null;
    ListNode last= null;
  for (int i =0; i<=sumString.length()-1;i++)
    {

      ListNode nextNode= new ListNode(Character.getNumericValue(sumString.charAt(i)));
    	 if (finalNode == null) 
         { 
    		 finalNode = new ListNode(Character.getNumericValue(sumString.charAt(i))); 
    		 continue;
         } 
    	 
        nextNode.next = null; 
        
         last = finalNode; 
        while(last.next!=null)
        	last = last.next;
        
       last.next = nextNode;
      // return lastNode;
        
     }
        
    return last;
}
    
    
}
