package Thread;
/*
 * java���̵߳�ʵ�ַ�ʽ
 * 1���̳�thread��
 * 2��ʵ��Runnable�ӿ�
 * 3��ʹ��ExecutorService Callable, Futureʵ���з��ؽ���Ķ��߳�
 * 
 * */
public class ThreadShutDownDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runner runner = new Runner();
		Thread thread = new Thread(runner);
		thread.start();//�����̵߳ķ���
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
