package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.*;

public class BoboBank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyAccount myAccount = new MyAccount("5262 2610", 10000);
		Lock lock = new ReentrantLock();
		Action u1 = new Action("Yuan", lock, myAccount, +2000);
		Action u2 = new Action("Tom", lock, myAccount, -5000);
		Action u3 = new Action("Bobo", lock, myAccount, +3150);
		
		ExecutorService pool = Executors.newCachedThreadPool();  
		pool.execute(u2);
		pool.execute(u3);
		pool.execute(u1);
		
		pool.shutdown();
	}
}
class Action implements Runnable{
	private MyAccount myAccount;
	int iocash;
	String name;
	Lock myLock;

	Action(String name, Lock myLock, MyAccount myAccount, int iocash){
		this.name = name;
		this.myLock = myLock;
		this.myAccount = myAccount;
		this.iocash = iocash; 
	}

	public void run(){
		myLock.lock();
		System.out.println(name+" is workin "+ myAccount +"action:" + iocash
				+", ");
		myAccount.setSaving(myAccount.getSaving()+iocash);
		System.out.println("Now saving becomes "+ myAccount.getSaving());
		myLock.unlock();
	}
}


class MyAccount{	
	private String accountNum;
	private int saving;
	
	MyAccount(String accountNum, int saving){
		this.accountNum = accountNum;
		this.saving = saving;
	}
	public String getAccountNum(){
		return accountNum;
	}
	public int getSaving(){
		return saving; 
	}
	public int saving(){
		return saving;
	}
	public void setAccountNum(String accountNum){
		this.accountNum = accountNum;		
	}
	public void setSaving(int saving){
		this.saving = saving;
	}
	public String toString(){
		return "Account #:" + accountNum +"\nSaving:" + saving; 
	}
}
