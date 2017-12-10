package org.xdemo.superutil.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200,TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));

		for (int i = 0; i < 15; i++) {
			MyTask myTask = new MyTask(i);
			executor.execute(myTask);
			System.out.println("线程池中线程数目：" + executor.getPoolSize()
					+ "，队列中等待执行的任务数目：" + executor.getQueue().size()
					+ "，已执行玩别的任务数目：" + executor.getCompletedTaskCount());
		}
		executor.shutdown();
		
		/********************************************************************************/
		/*for(int i=0;i<3;i++){
			ThreadTestOne one=new ThreadTestOne();
			ThreadTestTwo two=new ThreadTestTwo();
			
			Thread thread1=new Thread(one);
			Thread thread2=new Thread(two);
			
			System.out.println("主线程开始执行.....................................................................");
			thread1.start();
			thread2.start();
			thread1.join();
			thread2.join();
			System.out.println("主线程执行完毕.....................................................................");
		}*/	
	}
}

	class MyTask implements Runnable {
		private int taskNum;
	
		public MyTask(int num) {
			this.taskNum = num;
		}

		@Override
		public void run() {
			System.out.println("正在执行task " + taskNum);
			try {
				Thread.currentThread();
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("task " + taskNum + "执行完毕");
		}
	}