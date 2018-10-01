package dev.java.threadpool;

public class Receiver implements Runnable {
	
	private Message message;
	
	public Receiver(Message message) {
		super();
		this.message = message;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Waitting message...");
		synchronized (message) {
			try {
				message.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Message content: " + message.getContent());
		}
	}

}
