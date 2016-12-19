

class Producer implements Runnable {
	int j=0;
	public void run() {
		//int j=0;
		//synchronized(this){
		for (int i = 0; i < 10; i++) {
			 System.out.println(Thread.currentThread().getName()+" " + i+" "+(j++));
		}
		//}
	}
}
class Producer3 extends Thread {
	int j=0;
	public Producer3(String name) {
		this.setName(name);
	// TODO Auto-generated constructor stub
	}	
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+" " + i+" "+(j++));
		}
	}
}
public class TestRun {
	public static void main(String[] args) {
		Producer p = new Producer();
		//Thread a = new Producer3("A");
		//Producer3 b = new Producer3("B");
		Thread a = new Thread(p,"A");
		Thread b = new Thread(p,"B");
		//Thread a = new Thread(new Producer(),"A");
		//Thread b = new Producer3(new Producer(),"B");
		a.start();
		b.start();
	}
}
