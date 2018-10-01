package dev.java.threadpool;

public class App {
	public static void main(String[] args) {
		Message message = new Message();
		Thread senderThread = new Thread(new Sender(message));
		Thread receiverThread = new Thread(new Receiver(message));
		
		senderThread.start();
		receiverThread.start();
	}
}
