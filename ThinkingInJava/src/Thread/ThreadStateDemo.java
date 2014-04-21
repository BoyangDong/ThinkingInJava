package Thread;

public class ThreadStateDemo extends Thread {
	
	Thread thread;
	public ThreadStateDemo(){
		thread = new Thread(this);
		System.out.println("Create a Thread called thread!");
		thread.start();		
	}
	public void run(){
		try{
			System.out.println("thread is working now");
			System.out.println("Now sleep for three sec");
			Thread.sleep(3000);
			System.out.println("Now wake up");
		}catch(InterruptedException e){
			System.out.println("terminate illegally");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ThreadStateDemo();
		System.out.println("main thread is done");
	}

}
