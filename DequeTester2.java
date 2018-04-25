public class DequeTester2
{
    public static void main(String[] args) {
	QQKachoo<String> tester = new QQKachoo<String>();

	System.out.print("testing for empty: ");
	System.out.println(tester.isEmpty());//true
	
	System.out.print("adding first element: ");
	tester.offerFirst("I");
	System.out.println(tester.peekFirst());
	System.out.print("adding first element: ");
	tester.offerFirst("am");
	System.out.println(tester.peekFirst());
	System.out.print("adding first element: ");
	tester.offerFirst("a");
	System.out.println(tester.peekFirst());
	System.out.print("adding first element: ");
	tester.offerFirst("tester");
	System.out.println(tester.peekFirst());

    }
}
