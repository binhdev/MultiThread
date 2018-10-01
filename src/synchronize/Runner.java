package synchronize;

public class Runner {
	private int dem;
	private Object lock = new Object();
	
	private void increment() {
		for (int i = 0; i < 10000; i++) {
			dem++;
		}
	}
	
	public void processOne() {
		synchronized (lock) {
			increment();
		}
	}
	
	public void processTwo() {
		synchronized (lock) {
			increment();			
		}
	}
	
	public void showResult() {
		System.out.println("Dem = " + dem);
	}
}
