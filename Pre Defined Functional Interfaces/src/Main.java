import java.util.Date;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
/* 
Predicate : Conditional checks i.e Boolean checks
interface Predicate<T>
{
	boolean test(T t);
	//Default methods : .and(), .or(), .negate()
}

Function : input-->perform some operation-->output
interface Function<T,R>
{
    public R apply(T t);
    //Default method : andThen()
    
}

Consumer : takes input and doesn't return anything
interface Consumer<T>
{
   public void accept(T t);
}

Supplier : Just supplies required objects and it won't take any input-->supplier
interface Supplier<R>
{
  public R get();
}

BiPredicate : Takes 2 input arguments
interface BiPredicate<T1,T2>
{
   public boolean test(T1 t1,T2 t2);
}

BiFunction : 
interface BiFunction<T,U,R>
{
  public R apply(T t,U u);
  
}

BiConsumer :
interface BiConsumer<T,U>
{
  public void accept(T t,U u);
}
*/

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
           Predicate<Integer> evenOrOddPredicate = (i)->i%2==0;
           System.out.println(evenOrOddPredicate.test(20));
           
           Predicate<String> lenghthGreaterthan5 = (s)->s.length()>5 || s.length()>10;
           System.out.println(lenghthGreaterthan5.test("Hello world"));
           
           //Predicate Joining : p1.and(p2), p1.or(p2)
           int a[]= {12,2,5,9,6,3,2,4,11,20,17};
           Predicate<Integer> p1 = (i)->i%2==0;
           Predicate<Integer> p2=(i)->i>10;
           for(int i=0;i<a.length;i++)
           {
        	   if(p1.and(p2).test(a[i]))
        	   {
        		   System.out.println(a[i]);
        	   }
           }
           
           Function<Integer, Integer> sqaure = i->i*i;
           System.out.println(sqaure.apply(5));
           
           Function<String,Integer> strLength = s->s.length();
           System.out.println(strLength.apply("Rohith"));
           
           //Function Chaining
           Function<Integer, Integer> f1 = i->2*i;
           Function<Integer,Integer> f2=i->i*i*i;
           System.out.println(f1.andThen(f2).apply(2)); //first f1 then its result will be given to f2
           System.out.println(f1.compose(f2).apply(2)); //first f2 then its result will be given to f1
           
           Consumer<String> c = s->System.out.println("My name is "+s);
           c.accept("Rohith");
           
           //Consumer Chaining : f1.andThen(f2)
           
           Supplier<Date> s = ()->new Date();
           System.out.println(s.get());
           
           Supplier<String> otp = ()->{
        	   String otpString="";
        	   for(int i=0;i<6;i++)
        	   {
        		   otpString = otpString+(int)(Math.random()*10);
        	   }
        	   return otpString;
           };
           
           System.out.println(otp.get());
           
           BiPredicate<Integer, Integer> sumEvenOrNot = (num1,num2)->(num1+num2)%2==0;
           System.out.println(sumEvenOrNot.test(10, 20));
           
           BiFunction<Integer, Integer,Integer> sum = (num1,num2)->num1+num2;
           System.out.println(sum.apply(3,2));           
           
           
           
	}

}
