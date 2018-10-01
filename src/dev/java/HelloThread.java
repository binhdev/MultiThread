package dev.java;

public class HelloThread extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int index = 1;
		for (int i = 0; i < 10; i++) {
			System.out.println(" - HelloThread running " + index++);
			try {
				Thread.sleep(1000);				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
		}
		
		System.out.println(" -==> HelloThread stopped");
	}
}
