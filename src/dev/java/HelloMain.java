package dev.java;

public class HelloMain {
	private int balance = 1000;
	
	public HelloMain() {
		System.out.println("Tai khoan cua ban la " + balance);
	}
	
	private synchronized void withdraw(int amount) {
		System.out.println("Giao dich rut tien dang thuc hien " + amount);
		if(balance < amount) {
			System.out.println("Cannot withdraw!");
			try {
				wait();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.toString());
			}
		}
		balance -= amount;
		System.out.println("Rut tien thanh cong. Tai khoan hien tai cua ban la " + balance);
	}
	
	private synchronized void deposit(int amount) {
		System.out.println("Giao dich nap tien " + amount);
		balance += amount;
		System.out.println("Nap tien thanh cong. Tai khoan hien tai cua ban la " + balance);
		notify();
	}
	
	public static void main(String[] args) throws InterruptedException {
		HelloMain helloMain = new HelloMain();
		Thread t1 = new Thread() {
			public void run() {
				helloMain.withdraw(2000);
			}
		};
		t1.start();
		
		Thread t2 = new Thread() {
			public void run() {
				helloMain.deposit(3000);
			}
		};
		t2.start();
	}
}
