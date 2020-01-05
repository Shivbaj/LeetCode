package com.leetcode.LicenseKeyFormatting;

public class Solution {
	public static void main (String args[]) {
		String S = "5F3Z-2e-9-w";
		int K = 4;
		String result = licenseKeyFormatting(S,K);
	}

	private static String licenseKeyFormatting(String str, int groups) {
		String formatString = str.replaceAll("-", "");
		System.out.print(formatString);
		StringBuilder sb = new StringBuilder();
		int couter =0;
		for(int i = formatString.length();i>0;i--) {	
			sb.append(formatString.charAt(i-1));
			couter++;
			if(couter>=4 && i!=1) {
				sb.append('-');
				couter =0;
			}
		}
		
		return sb.reverse().toString().toLowerCase();
		// TODO Auto-generated method stub
		
	}

}
