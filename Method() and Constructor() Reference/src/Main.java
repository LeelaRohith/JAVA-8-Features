import java.awt.image.SampleModel;

class Test
{
	public void m1()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println("Child Thread");
		}
	}
}
interface Interf
{
	Sample get(String s);
}
class Sample
{
	String name;
	public Sample(String name) 
	{
	   System.out.println("Sample class Constructor");
	   this.name=name;
	   
	}
}
public class Main 
{
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Runnable r = ()->{
//			for(int i=0;i<10;i++)
//			{
//				System.out.println("Child Thread"+i);
//			}
//		};
		Test test = new Test();
		Runnable r = test::m1; 
		//Runnable run() method is referring to Test class m1() method
		//Functional interface method is referring to already existing method in Test class
		//Biggest advantage is code reusability
		Thread t = new Thread(r);
		t.start();
		for(int i=0;i<10;i++)
		{
			System.out.println("Main Thread"+i);
		}
		Interf i = Sample::new;
		//Interface get() method is referring to Sample class constructor
		Sample s1=i.get("Hello");
		System.out.println(s1.name);
		
		
		

	}

}
