package Thread;

public class SumUpTesting {

	public static void main(String[] args) {
		ThreadB b = new ThreadB();
		System.out.println("before start");
		b.start();
		System.out.println("after start");
		synchronized(b){
			try{
				System.out.println("Waiting for complete");
				b.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		System.out.println(b.total);
		
	}
}
class ThreadB extends Thread{
	int total;
	public void run(){
		System.out.println("in run method ");
		synchronized(this){
			try {
				for(int i = 0; i < 100; i++){
					total += i;
					System.out.println("total: "+total);
					wait(100);
				}					
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		notify();
	}

}

