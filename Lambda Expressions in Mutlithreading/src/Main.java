
public class Main {

	public static void main(String[] args) 
	{
		//Runnable is a functional interface.
		//So we can use lambda expressions to implement it instead of MyRunnable class.
		//MyRunnable r = new MyRunnable();
		Runnable r = ()->{
			for(int i=0;i<10;i++)
			{
				System.out.println("Child thread"+(i+1));
			}
		};
		//Now we can delete the MyRunnable class
		Thread th = new Thread(r);
		th.start();
		for(int i=0;i<10;i++)
		{
			System.out.println("Main thread-"+(i+1));
		}
	}

}
