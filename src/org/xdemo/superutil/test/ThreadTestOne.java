package org.xdemo.superutil.test;

public class ThreadTestOne implements Runnable{

	@Override
	public void run() {
		/*try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		for(int m=0;m<100;m++){
			System.out.println("线程11111执行完毕。。。。。。。。"+(m+1));
		}
	}

}
