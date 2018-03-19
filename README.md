ArraySolution is a response to a question.
write 3 methods that can be used to return an array that has no duplicates.

This is the result.

Since I (needed to) include an implementation of `ArraySolution`, I've
expanded the brief to include QuickSort as sorting the array with O(n log(n)

## The Main Class

The primary class this project provides are `DeDup` and
`QuickSort`. 


## The Basic Idea

The `DeDup`  class has three method implemented with the time complexity case.
`removeDuplicatesWithStream` : Using Stream Api with
`removeDupUsingHashSet` : with HashTable O(1) access to maintaint the original order
`removeDuplicatesWithNewArr` : with O(n) access to interate over the array without using any datastructure.

Time complexity is O(n), where n is the length of the string, and space complexity is O(n).
We can reduce our space usage a little bit by using a bit vector.

Alternatively, we could do the following:
1. Check every item of the array with every other item of the array for duplicate occurrences. This will take O(n^2) time and no space.
2. If we are allowed to destroy the input array, we could sort the array in O(n log n) time and then linearly check the array for neighboring Items that are identical. Careful, though - many sorting algorithms take up extra space.
 It is implemented with
`HashSet`s (one of them) which by default have zero allocation and O(1) access. It
will be maintained the original order of Array after removing the duplicates



## Building and running the unit tests

### Pre-requisites

This repository uses [Maven 3.x] to
build and test the project. Maven, in turn, needs a JDK 1.8 and above, and accesses
Maven for Junit.

### Building and testing

The command:

    maven package

should build and (unit) test the jar.

### Using Eclipse

The project includes Eclipse `.project` and `.settings` files, so should
work as an Eclipse project out of the box. However, there is no
`.classpath` file supplied, since this often has explicit full file
paths. maven will generate the correct one for you:

     maven eclipse::eclipse

will do this.

