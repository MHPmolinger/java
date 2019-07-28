package com.neusoft;
	public class CountPrime  implements  Runnable {
	    private  int  start  ;
	    private  int   end;
	    int  zonghe;
		@Override
		public void run() {
			 int  a=countPrimeNumber(this.start, this.end);
		}
		public   int  countPrimeNumber(int  start,int  end){
			long  starttime=System.currentTimeMillis();
			int count=0;
			boolean  flag ;
			for(int i=start;i<=end;i++){
				  flag=true;
				  for(int j=2;j<i;j++){
					  if(i%j==0){
						  flag=false;
						  break;
					  }
				  }
				  if(flag){
					  count++;
				  }
			}
			 long  endtime=System.currentTimeMillis();
			 System.out.println(endtime-starttime);
			return count;
		}
		public  CountPrime(int  start,int  end){
			this.start=start;
			this.end=end;
		}
		public   CountPrime(){}
		  public static void main(String[] args) {
			  Thread  t1=new Thread(new CountPrime(0,10000));
			  t1.start();
			  Thread  t2=new Thread(new CountPrime(9999,20000));
			  t2.start();			  
			  Thread  t3=new Thread(new CountPrime(19999,30000));
			  t3.start();
			  CountPrime obj=new CountPrime();
			  System.out.println(obj.countPrimeNumber(0, 30000));
		}
	}
