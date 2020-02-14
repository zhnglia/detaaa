package javaABC;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

class Abc {
	static int m;
	public static void fun() {
		System.out.println(m+"holaa");
	}
	public static void main(String[] args) {
		fun();
		try {
			System.out.print(10 + 10 / 0); 
		} catch(NullPointerException e1) { 
			System.out.print("a"); 
		} catch(RuntimeException e2) { 
			System.out.print("b"); 
		} finally { 
			System.out.print("c"); 
		} 
		fun();
		
		ArrayBlockingQueue<Double> q = new ArrayBlockingQueue<Double>(10);
		
		//第一个线程线程，产生数据放入集合
		new Thread() {
			public void run() {
				System.out.println("按回车产生数据");
				new Scanner(System.in).nextLine();
				double random = Math.random();
				q.offer(random);
			}
		}.start();
		
		//第二个线程线程，从集合取数据，没有数据时会等待
		new Thread() {
			public void run() {
				System.out.println("等待获取数据");
				Double d;
				try {
					d = q.take();
					System.out.println("已经获取数据"+d);
				}catch (Exception e) {
				}
			}
		}.start();
	}
}
