package com.project.graphs;

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class TrappingRainWater {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
	    int countOfTesCase = sc.nextInt();
	    for(int p = 0; p < countOfTesCase; p++){
	        int size = sc.nextInt();
	        int array[] = new int[size];
	        for(int i=0; i<size; i++){
	            array[i] = sc.nextInt();
	            
	        }
	        int ouptput = countTrappimgRainwater(array);
	        System.out.println("The final outcome "+ ouptput);
	}
	}	
	public static int countTrappimgRainwater(int array[])
	{
	    int count=0;
	    int minimum = findmin(array);
	    count = minimum * array.length ;
	    for(int j=0;j<array.length;j++)
	    {
	        array[j]= array[j]- minimum;
	        if(array[j]<0)
	        {
	            count= count- array[j];
	        }
	        
	    }
	    return count;
	}
	public static int findmin(int array[])
	  {
	        int min=array[0];
	        for(int i=0;i<array.length;i++)
	        {
	            if(array[i]<min)
	            min = array[i];
	        }
	        return min;
	    
    	}
}