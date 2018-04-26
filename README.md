# LineCutters
###### Joan Chirinos, Mohtasim Howlader, Kashf Mashrafi

## Deque methods to implement, in order of priority
1. size()
  * Returns the an int which represents the size of the deque. Size should be 0 at initialization, increase by 1 in each add method, and decrease by 1 in each remove method.
2. isEmpty()
  * Returns boolean on whether or not the deque is empty. 
  
3. Java 8 API "Special value" methods
* offerFirst(D newEl) -  adds an element to the front of the Deque
* pollFirst() - returns and remove the first element
* peekFirst() - returns the first element
* offerLast(D newEl) - adds en element to the back of the Deque
* pollLast() - returns and removes the last element
* peekLast() - return the last element

4. Java 8 API "Throws exception" Methods (Same as Special Value methods but throws exceptions rather than returning null)
* addFirst(D c)
* removeFirst(D c)
* getFirst(D c)
* addLast(D c)
* removeLast(D c)
* getLast(D c)

5. Other methods
* iterator() - necesary for Iterable implementation
* contains(D c) - uses iterator to check whether Deque has element c
* removeFirstOccurrence(D toRemove) - removes first occurrence of toRemove
* descendingIterator() - returns new iterator that iterates in the opposite direction

## Development Plan
1. Create a Deque interface with methods in order of priority
2. Create QQKachoo class that implements our Deque interface
3. Comment out all methods in Deque
4. Uncomment the topmost un-implemented method in Deque
5. Implement said method in QQKachoo
6. Add testers for said method in QQKachoo's main method
7. Repeat steps 4-6 until Deque is fully implemented

## Method Selection Rationale
We chose to implement the head and tail methods that throw exceptions and the ones that return a special value because we felt like they were the basic pieces of a collection that acts as both FIFO and LIFO. We also implemented methods like size() and isEmpty() to use as helpers for other methods and because they're useful to have when working with most classes such as this one. We implemented the iterators and the "search" methods such as contains() and firstOccurrenceOf() because we believe that search functionality is very useful for a class meant to store data. There were some methods, such as push() and pop(), that had the same function as other methods. This would just be a waste of space and wouldn't be especially valuable. For this reason, we chose not to implement them.

## Underlying Data Structure
We chose to use doubly-linked nodes because they made the most sense in terms of what Deque is meant to be: a series of "storage slots" connected to each other in 2 directions. An array would be a poor choice because it can't be easily expanded and items can't be easily removed. An ArrayList would also be a poor choice because, although it can be easily expanded, it's underlying structure is still an array, thus making it waste either space or time (depending on the implementation) when adding or removing an element to either the front or the end of the AL. Nodes work because they can add and remove elements in contstant time without sacrificing memory.
