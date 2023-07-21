package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class main_misc {
	
	
	public static final int MAX = 1_000_000;
	
	public static void main(String[] args) {
		
	System.out.println(count_2(25));
	System.out.println(count_2(215));
		
	}
	
	private static int count_2(int n){
		
		int count = 0;
		
		//count the number of 2 on each possible digit up to n-1
		
		int mult = 10;
		while(mult <= n*10){
			
			int num = (n/mult) + 1; //number of ranges that contains 2
			
			int dec_counted = 2*(mult/10);//2,20,200,...
			
			int last = (num-1)*(mult) + dec_counted; // last range that will be counted
			
			if(last > n){
				//sometimes the last can be grater than n,ex 220 > 215 we dont count this interval
				num--;
				last = last - mult;
			}
			
			int tmp = count;
			
			if(last + (mult/10) > n){//ex: n = 215,the last when mult = 1000 will be 200
				count += (num-1)*(mult/10);//count all
				count += (n - last +1);//count only the interval that is <= n
			}
			else {
				count += num*mult/10;
			}
			mult *= 10;
		}
		return count;
	}
	
	
}
