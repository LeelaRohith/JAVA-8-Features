import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) 
	{
	
		
		//Streams : 
		//1. Count frequency of each word in a list using stream API
		List<String> l1 = new ArrayList<>(Arrays.asList("Hello","World"));
	    Map<String,Long> wordFrequency = l1.stream().collect(Collectors.groupingBy(w->w,Collectors.counting()));
	    wordFrequency.forEach((w,f)->System.out.println(w+" "+f));

	}

}
