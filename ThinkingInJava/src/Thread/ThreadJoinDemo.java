package Thread;

public class ThreadJoinDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runner2 runner = new Runner2();
		Thread t = new Thread(runner);
		t.start();
		try{
			t.join();
		}catch(InterruptedException e){}
		for(int i = 0; i<5; i++){
			System.out.println("main thread" + i);
		}
	}
}
	class Runner2 implements Runnable{
		public boolean flag = false;
		public void run(){
			for(int i = 0; i<10; i++){
				System.out.println("sub thread" + i);
				if(i == 5){flag = true; break;}
			}
		}
}


