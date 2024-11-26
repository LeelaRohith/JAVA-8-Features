/*
Does'nt support :
class Left 
{
	void m1()
	{
		System.out.println("This is left method")
	}
}
class Right
{
	void m2()
	{
		System.out.println("This is right method");
	}
	
}
class Ex extends Left,Right
{
	..Ex will get confused which m1() to be called. Because of this case multiple inheritance is not supported with respect to classes
}


interface Left 
{
	void m1();
	
}
interface Right
{
	void m1();
	
}
class Ex implements Left,Right
{
	//Here Ex has the power to provide its own implementation of m1()
	public void m1() {
		
	}
}
*/
interface Left
{
	default void m1()
	{
		System.out.println("This is a left method");
	}
}
interface Right
{
	default void m1()
	{
		System.out.println("This is a Right method");
	}
}
class Ex implements Left,Right
{
	//Ex has m1()
	//Now Ex will confuse when we want to invoke m1() because both Left,Right has m1;
	//We have to override the m1() to make this work
	//At class level this kind of solution is not there in java 8 also
	public void m1()
	{
		System.out.println("This method overrides default method");
		Left.super.m1(); //Calls the default method of Left
		Right.super.m1(); //Calls the default method of Right
	}
	
}
interface Interf
{
	static void m1()
	{
		System.out.println("This is a static method.");
	}
}
class Test implements Interf{
	//....Interface static methods are not available to implementation class
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex ex = new Ex();
	    ex.m1();
	  
	    
	    Interf.m1();
	    Test test = new Test();
	    //test.m1(); ....Interface static methods are not available to implementation class
	    
		

	}

}
