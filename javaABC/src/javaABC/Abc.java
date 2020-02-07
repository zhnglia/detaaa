package javaABC;

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
	}
}
