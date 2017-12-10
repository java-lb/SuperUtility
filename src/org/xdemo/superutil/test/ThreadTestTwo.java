package org.xdemo.superutil.test;

public class ThreadTestTwo implements Runnable{

	@Override
	public void run() {
		for(int m=0;m<50;m++){
			System.out.println("线程22222执行完毕。。。。。。。。"+(m+1));
		}
	}
}
