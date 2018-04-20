/*
Team LineCutters - Joan Chirinos, Mohtasim Howlander, Kashf Mashrafi
APCS2 pd08
L02 -- All Hands on Deque
*/

import java.util.Iterator;

public interface Deque<Card> extends Iterable<Card> {
  //stringifies
  public String toString();

  //Returns the number of elements in this deque
  public int size();

  //Returns true if this collection contains no elements
  public boolean isEmpty();

  //Inserts the specified element at the
  //front of this deque
  public boolean offerFirst(Card c);

  public Card pollFirst();

  public Card peekFirst();

  public boolean offerLast(Card c);

  public Card pollLast();

  public Card peekLast();

  public void addFirst(Card c);

  public Card removeFirst();

  public Card getFirst();

  public void addLast(Card c);

  public Card removeLast();

  public Card getLast();

  public Iterator<Card> iterator();

  public boolean contains(Card c);

  public boolean removeFirstOccurrence(Card c);

  public Iterator<Card> descendingIterator();

  public boolean removeLastOccurrence(Card c);

  //there are methods that basically just call other methods
  //but we chose not to include them

}
