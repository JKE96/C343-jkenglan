Jarod England C343 3/26/16

1. 9.10

public boolean Search(String s){ //name of function is search

ArrayList<Letters> letters; //the array list of letters

if (letters[0] == s){ //checks the first position
return true;
}

for(int i = 1; i< letters.length; i++){ //checks the rest of the positions and switches positions according to the transpose self-organizing heuristic
if(letters[i] == s){
temp = letters[i-1];
letters[i-1] = letters[i];
letters[i] = temp;

return true;
}}
return false; //returns false if the letter is not found

}

2. 9.13
a.This would work as an implementation for insertions and searches and would clump numbers together within n
b.This would be a bad implementation because if h(k) =1 all the time then there would be no need for a hash table
c.This would not work for searches because it uses random.
d.This would work as an implementation and work for searches and insertions and it would work as a good hash function.

3. 9.14

0: -
1: -
2: 9
3: 3
4: 2
5: 12
6: -

0 has a 1/7 percentage of being filled next
1 has a 1/7 percentage of being filled next
6 has a 5/7 percentage of being filled next