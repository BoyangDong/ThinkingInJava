package Thread;

public class SynchronizedThread {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User u = new User("Bobo", 100);
		MyThread t1 = new MyThread("thread A", u, 10);
		MyThread t2= new MyThread("thread B", u, 20);
		MyThread t3 = new MyThread("thread C", u, -50);
		MyThread t4 = new MyThread("thread F", u, 30);
		MyThread t5 = new MyThread("thread E", u, 20);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

}
class MyThread extends Thread{
	private User u;
	private int y = 0;
	MyThread(String name, User u, int y){
		super(name);
		this.u = u;
		this.y = y; 
	}
	public void run(){
		u.operation(y);
	}
}
class User{
	private String code;
	private int cash;
	User(String code, int cash){
		this.code = code;
		this.cash = cash; 
	}
	public String getCode(){return code;}
	public void setCode(String code){this.code = code;}	

public void operation(int x){
	try{
		Thread.sleep(1000);
		synchronized(this){
			this.cash += x;
			System.out.println(Thread.currentThread().getName()+"over"
					+"User now has "+cash + " left.");
		}Thread.sleep(1000); 
	}catch (InterruptedException e){
		e.printStackTrace();
	}
}	
	
public synchronized void oper(int x){
	try{
		Thread.sleep(1000);
		this.cash += x;
		System.out.println(Thread.currentThread().getName()+" add "+x+" rest "+cash);
		Thread.sleep(1000);
	}catch(InterruptedException e){
		e.printStackTrace();
	}
}
	public String toString(){
		return "User code"+code+"cash"+cash;
	}
}

