package Thread;
/*
 * java多线程的实现方式
 * 1：继承thread类
 * 2、实现Runnable接口
 * 3、使用ExecutorService Callable, Future实现有返回结果的多线程
 * 
 * */
public class ThreadShutDownDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runner runner = new Runner();
		Thread thread = new Thread(runner);
		thread.start();//启动线程的方法
		for(int i = 0; i < 10; i++){
			if(i%10!=0) System.out.println("in main thread i = " + i);
		}
		System.out.println("Main thread is over");
		runner.shutDown();		
	}
}
	class Runner implements Runnable{
		private boolean flag = true;
		public void run(){
			int i = 0;
			while(flag == true){
				System.out.println("in subthread i is " + i++);
			}System.out.println("Now subThread is over");
		}
		public void shutDown(){
			flag = false; 
		}
	}
