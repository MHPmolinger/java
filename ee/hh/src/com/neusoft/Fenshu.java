package com.neusoft;

public class Fenshu {
public static void main(String[] args) {
	//	2/1	3/2	5/3
	int mu=1;
	int zi=2;
	int temp=0;
	double sum=0;
	for(int i=1;i<=20;i++){
		sum+=(double)zi/mu;
		System.out.println(i>9?i+":"+zi+"/"+mu+"\t"+sum+" ":i+":"+zi+"/"+mu+"\t\t"+sum+" ");
		temp=mu;
		mu=zi;
		zi=mu+temp;
	}
	System.out.println("\n"+sum);
}

}
