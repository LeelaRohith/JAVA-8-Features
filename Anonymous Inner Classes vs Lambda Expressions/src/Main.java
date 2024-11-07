/*
 Anonymous Inner Class:
 Thread t = new Thread()
 {
    .......
    Here we are creating class that extends Thread class (subclass of Thread)
    So it is known as anonymouus inner class
 }
 
 Runnable r = new Runnable()
 {
   .....
   Runnable is an interface we are not allowed to create object for it
   But here we are providing the implementation of Runnable
   This object is an instance of implementation class.
   So it is allowed
 }
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable r1 = new Runnable()
				{
			       public void run()
			       {
			    	   for(int i=0;i<10;i++)
			    	   {
			    		   System.out.println("Child Thread from Anonumous Inner class"+(i+1));
			    	   }
			       }
				};
		Runnable r2 = ()->{
			for(int i=0;i<10;i++)
	    	   {
	    		   System.out.println("Child Thread from Lambda Expressions"+(i+1));
	    	   }
		};
		Thread t = new Thread(r2);
		t.start();
		for(int i=0;i<10;i++)
 	   {
 		   System.out.println("Main Thread"+(i+1));
 	   }
	}

}
/*
 Anonymous Inner class vs Lambda Expressions:
 -- Anonymous Inner classes are more powerful because they allow you to implement interfaces with more than 2 methods
 Ex :
 interface A
 {
   void m1();
   void m2();
 }
 
 A a = new A()
 {
    public void m1()
    {
    .....
    }
    public void m2()
    {
    .......
    }
 }
 
 -- If anonymous inner class implements an interface that contains only one abstract method, then inner class 
    can be replaced by lambda expressions
 */
