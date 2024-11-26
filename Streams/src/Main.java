import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> l1 = new ArrayList<>();
		l1.add(10);
		l1.add(20);
		l1.add(5);
		l1.add(6);
		l1.add(3);
		List<Integer> l2 = l1.stream().filter(i->i%2==0).collect(Collectors.toList());
		System.out.println(l2);
		
		List<Integer> l3 = l1.stream().map(i->i+100).collect(Collectors.toList());
		System.out.println(l3);
		
		long c = l1.stream().filter(i->i<=5).count();
		System.out.println(c);
		 
		System.out.println("Ascending Order : ");
		List<Integer> l4 = l1.stream().sorted().collect(Collectors.toList()); //ascending order by default
		System.out.println(l4);
		
		System.out.println("Descending Order : ");
		List<Integer> l5 = l1.stream().sorted((a,b)->b-a).collect(Collectors.toList());
		System.out.println(l5);
		

		System.out.println("Maximum : ");
		Integer max = l1.stream().max(Integer::compare).get();
		System.out.println(max);
		
		System.out.println("Mimimum ");
		Integer min = l1.stream().min(Integer::compare).get();
		System.out.println(min);
		
		
		l1.stream().forEach(System.out::println); //Method Reference
		System.out.println();
		
		Consumer<Integer> consumer = (i)->System.out.println(i);
		l1.stream().forEach(consumer);
		
		Integer[] a = l1.stream().toArray(Integer[] :: new); //Constructor Reference //Stream to array
		
		System.out.println("Array to stream ");
		Stream.of(a).forEach(System.out::println); // array to stream
		
		Stream<String> s = Stream.of("hi","hello","world");
		s.forEach(System.out::println);
		
		System.out.println("FlatMap Usage :");
		List<String> list = Arrays.asList("Geeks", "GFG", "GeeksforGeeks", "gfg");

        // Using Stream flatMap(Function mapper)
        Stream<Character> characterStream = list.stream()
          .flatMap(str -> Stream.of(str.charAt(2)));
          characterStream.forEach(System.out::println);
		
		

	}

}
