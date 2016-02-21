Jarod England - C343

5.14: The BST Property is defined so nodes with equal value equal to the value of the root appear only in the right subtree rather than allowing equal-valued nodes to appear in either subtree because it is defined in this way, helps keep the structure of the tree, and helps when doing certain algorithms.

5.15a:                   V———————————15—————————————V 
			 5—V		     V——————20———————V
			   7		V————18		     25
					16


5.15b.
Preorder: 15, 5, 20, 7, 18, 25, 16

Inorder: 5, 5, 15, 16, 18, 20, 25

Postorder: 7, 5, 16, 18, 25, 20, 15

5.24
The smallest element in a max-heap would reside in the leaves at the bottom of the tree.



Problem 4.
	The Kth smallest value in a binary search tree is which smallest value you are referring to in the search tree. If the k value is 1, for example, then the algorithm would find the smallest value in the binary search tree. If the k value is 2 then it would find the second smallest in the search tree, and so on. 
	The size variable is extremely useful when finding the Kth smallest value in a BST.  The size variable seems to be the simple modification that was made to the BST.  My function works by having four cases.  First it checks if any of the children of the node are null. If they are, then you have hit the bottom of the tree and that key needs to be returned.  In the next case it checks if the left child size plus one is equal to the a variable(the a variable is based off of k and gets smaller as the function iterates through the tree). If it is then the key that has been searched for is found.  If the left child size plus one is less than a, then it iterates through the right side of the tree and minuses the left side off of the value of a.  If neither of these cases happen then a is smaller than the left size of the tree and it will iterate through the left side of the tree.
