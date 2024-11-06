import java.util.ArrayList;
import java.util.Collections;

class Employee
{
	int id;
	String name;
	Employee(int id,String name)
	{
		this.id=id;
		this.name=name;
	}
	public String toString()
	{
		return id+":"+name;
	}
}
public class Main {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ArrayList<Employee> list = new ArrayList<>();
		list.add(new Employee(24, "Ram"));
		list.add(new Employee(2, "Sita"));
		list.add(new Employee(6, "Pavan"));
		list.add(new Employee(66, "Shyam"));
		list.add(new Employee(16, "Laksman"));
		list.add(new Employee(5, "Akshara"));
		Collections.sort(list,(e1,e2)->(e1.id<e2.id)?-1:(e1.id>e2.id)?1:0);
		System.out.println(list);
		Collections.sort(list,(e1,e2)->e1.name.compareTo(e2.name));
		System.out.println(list);

	}

}
