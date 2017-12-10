package org.xdemo.superutil.test;

import java.util.concurrent.Callable;

public class CallableOne implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		Thread.sleep(5000);
		return 12;
	}

}
