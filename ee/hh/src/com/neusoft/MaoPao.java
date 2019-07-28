package com.neusoft;

public class MaoPao {
public static void main(String[] args) {
	long startTime=System.currentTimeMillis();
	int[] x={2,5,89,45,3,5,90,11,4};
	int temp=0;
	for(int i=0;i<x.length-1;i++){
		for(int j=0;j<x.length-1-i;j++){
			if(x[j]<x[j+1]){
				temp=x[j];
			x[j]=x[j+1];
			x[j+1]=temp;}
		}
	}
	for(int i=0;i<100000;i++)
		System.out.println("");;
	for(int a:x)
		System.out.print(a+"\t");
	long endTime=System.currentTimeMillis();
	System.out.println(endTime-startTime);
		
}
}
