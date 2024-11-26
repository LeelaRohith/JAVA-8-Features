import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class MyComparator implements Comparator<Integer>
{
	//If we want n1 before n2, compare method should return negative value
	//If we want n2 before n1, compare method should return positive value
	//If n1 and n2 are equal, compare method should return 0
	public int compare(Integer n1,Integer n2)
	{
//		if(n1<n2)
//			return -1;
//		else if(n1>n2)
//			return 1;
//		else 
//			return 0;
		return (n1<n2)?-1:n1>n2?1:0;
	}
	//Equivalent Lambda Expression : (n1,n2)->{return (n1<n2)?-1:n1>n2?1:0;}
}
public class Main {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ArrayList<Integer> l1 = new ArrayList<>();
		l1.add(20);
		l1.add(5);
		l1.add(95);
		//Collections.sort(l1,new MyComparator());
		Comparator<Integer> c = (n1,n2)->{return (n1<n2)?-1:n1>n2?1:0;};
		Collections.sort(l1,c);
		System.out.println(l1);
	}

}
