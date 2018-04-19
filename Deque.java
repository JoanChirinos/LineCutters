/*
Team LineCutters - Joan Chirinos, Mohtasim Howlander, Kashf Mashrafi
APCS2 pd08
L02 -- All Hands on Deque
*/

public interface Deque<Card>
{
  //stringifies
  public String toString();

  //Returns the number of elements in this deque
  public int size();

  //Returns true if this collection contains no elements
  public boolean isEmpty();

  //Inserts the specified element at the
  //front of this deque
  public boolean offerFirst(Card c);

  //public Card pollFirst();

  //public Card peekFirst();

  //public boolean offerlLast(Card c);

  //public Card pollLast();

  //public Card peekLast();

  //public void addFirst(Card c);

  //public Card removeFirst();

  //public Card getFirst();

  //public void addLast(Card c);

  //public Card removeLast();

  //public Card getLast();

}
