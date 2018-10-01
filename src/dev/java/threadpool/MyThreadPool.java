package dev.java.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPool {
	private static final int DEFAULT_THREAD  = 5;
	private static final int MAX_THREAD  = 5;
	private static final int INTERVAL_OF_THREAD  = 1;
	private static final int THREAD_IN_QUEUE  = 100;
	
	public static void main(String[] args) {
//		ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(THREAD_IN_QUEUE);
//		ThreadPoolExecutor pool = new ThreadPoolExecutor(DEFAULT_THREAD, MAX_THREAD, INTERVAL_OF_THREAD, TimeUnit.SECONDS, queue);
//		for (int i = 0; i < 20; i++) {
//			pool.execute(new RunPool(i));
//		}
		
		ExecutorService pool = Executors.newFixedThreadPool(DEFAULT_THREAD);
		for (int i = 0; i < 20; i++) {
			pool.submit(new RunPool(i));
		}
	}
}

class RunPool implements Runnable{
	
	private int id;
	
	public RunPool(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Processing thread " + id);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Process thread finished " + id);
	}
	
}