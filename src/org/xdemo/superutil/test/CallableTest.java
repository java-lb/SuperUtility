package org.xdemo.superutil.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CallableTest {  
    public static void main(String[] args) {
    	
        ExecutorService exec=Executors.newCachedThreadPool(); 
        
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200,TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
        
        List<Future<String>> results=new ArrayList<Future<String>>();
        
        Future<String> result1=executor.submit(new TaskWithResult(1));
        
        Future<String> result2=executor.submit(new TaskWithResult(2));
          
        /*for(int i=0;i<5;i++) {  
            results.add(exec.submit(new TaskWithResult(i)));  
        }  
          
        for(Future<String> fs :results) {  
            try {  
                System.out.println(fs.get());  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            } catch (ExecutionException e) {  
                e.printStackTrace();  
            }  
        }*/ 
        
        try {
			String str1=result1.get();
			String str2=result2.get();
			System.out.println("线程1返回结果=============================>"+str1);
			System.out.println("线程2返回结果=============================>"+str2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("主线程执行完毕.....................");
    }  
}  
  
	class TaskWithResult implements Callable<String> {  
	    private int id;  
	    public TaskWithResult(int id) {  
	        this.id=id;  
	    }  
	      
	    @Override  
	    public String call() throws Exception {  
	    	
	    	if(id==1){
	    		for(int m=0;m<100;m++){
	    			System.out.println("线程1开始执行...................."+m);
	    		}
	    	}
	    	if(id==2){
	    		Thread.sleep(3000);
	    		for(int m=0;m<100;m++){
	    			System.out.println("线程2开始执行...................."+m);
	    		}
	    	}
	        return "result of TaskWithResult "+id;  
	    }  
	}