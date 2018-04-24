public class DequeTester{

    public static void main(String[] args){
        QQKachoo<String> test = new QQKachoo<String>();
	
	System.out.println("initial state " + test);
	System.out.println(test.isEmpty());

	test.addFirst("A");
	System.out.println(test);
	test.addLast("B");
	test.addFirst("Before A");

	System.out.println("Does it work?   " + test);
	
    }
}
