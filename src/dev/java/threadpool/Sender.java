package dev.java.threadpool;

public class Sender implements Runnable {
	
	private Message message;	
	
	public Sender(Message message) {
		this.message = message;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (message) {
			message.setContent("Xin chao");
			message.notifyAll();
		}		
	}
}
