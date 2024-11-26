# Streams

## Questions :

**1.What is a stream API:**
Stream API is an API that is introduced in Java 8 which is used to process collections of objects.It provides a functional programming approach to process collections of objects. It allows you to perform operations like filtering, mapping, and reducing on data

Functional Operations:
Streams support various functional operations, including:
filter: Selects elements based on a given predicate.
map: Transforms each element into another form.
reduce: Combines elements into a single result.
collect: Accumulates elements into a collection or another data structure.

**2.Difference between Collections and Stream ? :**

Collection is an in-memory data structure, which holds all the values that the data structure currently has.It provides many interfaces like (Set, List, Queue, Deque) and Classes like (ArrayList, Vector, LinkedList, PriorityQueue, HashSet).

A stream is not a data structure instead it takes input from the Collections, Arrays, or I/O channels (these are sources for the stream). Streams don’t change the original data structure, they only provide the result as per the pipelined methods

Unlike collections, streams are not designed to store data. They represent a pipeline of operations that are applied to a data source.

**3.Intermediate Operations vs Terminal Operations :**
A Stream supports several operations and these operations are divided into intermediate and terminal operations.

All intermediate operations return Stream (can be chained), while terminal operations don't. Intermediate Operations are:
Read the use of each operation from google

`filter(Predicate<T>)  
map(Function<T>)  
flatMap(Function<T>)  
sorted(Comparator<T>)  
peek(Consumer<T>)  
distinct()
limit(long n)
skip(long n)`

Terminal operations produces a non-stream (cannot be chained) result such as primitive value, a collection or no value at all.
Read the use of each operation from google

Terminal Operations are:

`forEach  
forEachOrdered  
toArray
reduce
collect
min
max
count
anyMatch
allMatch
noneMatch
findFirst    
findAny`

**Difference based on how they are invoked**
The distinction between this operations is that an intermediate operation is lazy while a terminal operation is not. When you invoke an intermediate operation on a stream, the operation is not executed immediately. It is executed only when a terminal operation is invoked on that stream. In a way, an intermediate operation is memorized and is recalled as soon as a terminal operation is invoked. You can chain multiple intermediate operations and none of them will do anything until you invoke a terminal operation. At that time, all of the intermediate operations that you invoked earlier will be invoked along with the terminal operation.

Note that all intermediate operations will NOT be executed without a terminal operation at the end. So the pattern will be:

`stream()
    .intemediateOperation1()
    .intemediateOperation2()
    ...
    .intemediateOperationN()
    .terminalOperation();`

**4.Can a stream be re-used? why or why not?**
Once a terminal operation is performed on a stream, it is considered consumed and cannot be reused. The streams are not reusable due to their internal structure and the nature of their operations, which are generally designed to be consumed and processed in a single pass.

If we observe its internals, a Stream represents a sequence of elements supporting sequential and parallel aggregate operations. Conceptually, a stream can be thought of as a pipeline of computational steps. The intermediate steps process the elements and return a new Stream, whereas the terminal steps trigger the actual processing of the elements.

In runtime, streams maintain the internal state during their execution. Once a terminal operation is performed, the internal state is consumed and the stream is considered closed. Allowing reuse would require additional mechanisms to reset the internal state and reinitialize the source which would complicate the design and reduce performance

**5. Difference between Stream.of() and Arrays.stream(array argument)**

Arrays.stream() method only works for primitive arrays of int[], long[], and double[] type, and returns IntStream, LongStream and DoubleStream respectively. For other primitive types, Arrays.stream() won’t work. On the other hand, Stream.of() returns a generic Stream of type T (Stream). Hence, it can be used with any type.
Ex : character array cannot be coverted into stream using Arrays.stream() we have to use stream.of() for charcater array.

**6.Difference between Stream.map() and Stream.flatMap()?**
Stream.map() : The map operation takes a Function, which is called for each value in the input stream and produces one result value, which is sent to the output stream.

Stream.flatMap() : The flatMap() operation is more powerful and is primarily used when dealing with nested structures, such as a stream of lists or a stream of optional values. It not only transforms elements but also flattens the resulting stream of streams (or other nested structures) into a single stream.

` Example:

List<List<Integer>> numbers = Arrays.asList(  
 Arrays.asList(1, 2, 3),  
 Arrays.asList(4, 5, 6),  
 Arrays.asList(7, 8, 9)  
);  
List<Integer> flattenedNumbers = numbers.stream()  
 .flatMap(List::stream)  
 .collect(Collectors.toList()); `

**7. What is distinct() in stream?How does it work?**
The Stream.distinct() method in Java is used to remove duplicate elements from a stream. It ensures that only unique elements are processed. This method is useful when you want to filter out duplicate values and work with distinct data in your stream. distinct() is often used with other stream operations like filter() or map() to refine the stream’s content before further processing

**Internally:**
The distinct() method utilizes a HashSet to keep track of the elements it has encountered. When an element is passed to distinct(), it checks if the element is already present in the HashSet. If it is, the element is discarded; otherwise, it is added to the HashSet and passed along in the resulting stream.

**8. What is the purpose of sorted() method in stream? Can it handle custom sorting?**

Since Java 8, the sorted() method is part of the Stream API and is used to sort the elements of a stream. By default, elements are sorted in the natural order, but we can apply for a custom order using a Comparator

**9.What is parallel stream and how does it is different from sequential stream?**
Refer : <https://www.baeldung.com/java-when-to-use-parallel-stream>

**10.What is peek() in stream? When should it be used?**
The peek() method in a Java stream is used to perform an action on each element within the stream as it passes through the pipeline, essentially allowing you to "peek" at the element without modifying it; this is **primarily used for debugging purposes, like logging the values at different stages of the stream processing** to understand how data is being transformed.

“This method exists mainly to support debugging, where you want to see the elements as they flow past a certain point in a pipeline“.

`Stream.of("one", "two", "three", "four")
  .filter(e -> e.length() > 3)
  .peek(e -> System.out.println("Filtered value: " + e))
  .map(String::toUpperCase)
  .peek(e -> System.out.println("Mapped value: " + e))
  .collect(Collectors.toList());`

**11. Difference between skip() and limit()**
Read this article (also read about why limit is a short circuting operation): <https://www.baeldung.com/java-stream-skip-vs-limit>

## Programming Questions :

Refer programming questions folder
