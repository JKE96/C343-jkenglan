README.txt
Jarod England - C343

7.18
The quick sort algorithm should take O = nlog(n)

a.finding the minimum value with an already sorted algorithm should take one step and the algorithm would work by taking the first element in the list.

finding the minimum value with an unsorted list of numbers would take less time than the quick sort algorithm because the algorithm would just iterate through the entire list of numbers once and keep the minimum value. O = n

b. finding the maximum value with an already sorted algorithm should take one step(unless it is a linkedList) and the algorithm would work by finding the last element in the list.

finding the maximum value with an unsorted list of numbers would take less time than the quick sort algorithm because the algorithm would just iterate through the entire list of numbers once and keep the minimum value. O = n

c. Finding the arithmetic mean would not be benefitted by first sorting the list of numbers.  The mean algorithm would work the same sorted or unsorted and would work by adding n numbers together and dividing by n.

d. Finding the median value of a list of numbers would be benefitted by first sorting the numbers.  After the numbers are sorted then the algorithm would just have to check the n/2 place to find the median value.

e. Finding the mode would not be benefitted by sorting the numbers first.  The mode could be found by iterating through the elements in a list(similar to counting sort) and keeping track of which numbers appear and how often they appear.  The number with the most occurrences would be returned when finding the mode.

———————————————————————————
Counting sort analysis


Since there is an array of size m being made, if m is very large, then the algorithm will make an unnecessarily large array for sorting, so m needs to be relatively small. If n is the number of records, then n would need to be smaller than m to be effective.  If m<n then the running time of the algorithm is O = mn, because it would take n steps to put the elements into an array of accumulated counts and then m steps to “unzip” the array m into another array of size n with the values sorted.

