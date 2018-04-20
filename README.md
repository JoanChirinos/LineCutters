# LineCutters
###### Joan Chirinos, Mohtasim Howlander, Kashf Mashrafi

## Deque methods to implement, in order of priority
1. size()
2. isEmpty()
3. Java 8 API "Special value" methods
4. Java 8 API "Throws exception" Methods
5. Other methods

## Development Plan
1. Create a Deque interface with methods in order of priority
2. Create QQKachoo class that implements our Deque interface
3. Comment out all methods in Deque
4. Uncomment the topmost un-implemented method in Deque
5. Implement said method in QQKachoo
6. Add testers for said method in QQKachoo's main method
7. Repeat steps 4-6 until Deque is fully implemented

## Method Selection Rationale
We chose to implement the head and tail methods that throw exceptions and the ones that return a special value because we felt like they were the basic pieces of a stack-queue combination. We also implemented methods like size() and isEmpty() to use as helpers for other methods and because they're useful to have when working with most classes such as this one. We implemented the iterators and the "search" methods such as contains() and firstOccurrenceOf() because we believe that search functionality is very useful for a class meant to store data. There were some methods, such as push() and pop(), that had the same function as other methods. This would just be a waste of space and wouldn't be especially valuable. For this reason, we chose not to implement them.

## Underlying Data Structure
We chose to use doubly-linked nodes because they made the most sense in terms of what Deque is meant to be: a series of "storage slots" connected to each other in 2 directions. An array would be a poor choice because it can't be easily expanded and items can't be easily removed. An ArrayList would also be a poor choice because, although it can be easily expanded, it's underlying structure is still an array, thus making it waste either space or time (depending on the implementation) when adding or removing an element to either the front or the end of the AL. Nodes work because they can add and remove elements in contstant time without sacrificing memory.
