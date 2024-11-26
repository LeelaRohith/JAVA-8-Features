import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


public class Main {

	public static void main(String[] args) 
	{
	
		
		//Streams : 
		//1. Count frequency of each word in a list using stream API
		
		List<String> l1 = new ArrayList<>(Arrays.asList("Hello","World","Programmingggg"));
	    Map<String,Long> wordFrequency = l1.stream().collect(Collectors.groupingBy(w->w,Collectors.counting()));
	    wordFrequency.forEach((w,f)->System.out.println(w+" "+f));
	    
	    //2.Sorting the list of objects based on mutiple field using Stream API
	    
	    List<Customer> customers = Arrays.asList(
	            new Customer("Alice", 30, "New York"),
	            new Customer("Bob", 25, "Los Angeles"),
	            new Customer("Charlie", 30, "Chicago"),
	            new Customer("David", 25, "Chicago"),
	            new Customer("Eve", 30, "New York")
	        );
	    List<Customer> sortedCustomers = customers.stream()
	    		.sorted(Comparator.comparing(Customer::getAge)
	    		        .thenComparing(Customer::getName,Comparator.reverseOrder())
	    		        .thenComparing(Customer::getCity))
	    		.collect(Collectors.toList());
	    System.out.println(sortedCustomers);
	    
	    //3.Grouping list of objects based on a property
	    
	    Map<Integer,List<Customer>> groupByAge = customers.stream()
	    		.collect(Collectors.groupingBy(Customer::getAge));
	    System.out.println(groupByAge);
	    
	    //4.Longest string in a list of strings
	    Optional<String> longestString = l1.stream()
	            .max(Comparator.comparing(String::length));
	    
	    System.out.println("Longest :"+longestString.get());
	    
	    //5.Second highest number
	    List<Integer> numbers = Arrays.asList(3, 7, 2, 9, 4, 7, 9, 10);

        
        Optional<Integer> secondHighest = numbers.stream()
            .distinct() // Remove duplicates
            .sorted(Comparator.reverseOrder()) // Sort in descending order
            .skip(1) // Skip the first element (highest)
            .findFirst(); // Get the second element

        secondHighest.ifPresent(num -> System.out.println("Second highest number: " + num));
	    
	    
	    

	}

}
