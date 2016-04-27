// KD tree with insert and exact match functions
// getNeighbors(Key[] key, int r) is going to be implemented by the students

public class KDtree<Key extends Comparable<? super Key>, E> {
	private BinNode<Key, E> root;
	private int totalNode;
	private BinNode<Key, E> curr; // works with find()
	private String enumStr; // for enumeration
	private int dim; // dimension of the key
	private int level; // which level; important for insertion & search

	public KDtree(int d) {
		root = curr = null;
		totalNode = 0;
		dim = d;
		level = 0;
	}

	public BinNode<Key, E> find(Key[] k) {
		if (root == null)
			return null;
		else {
			return find(root, 0, k);
		}
	}

	public BinNode<Key, E> find(BinNode<Key, E> entry, int thislevel, Key[] k) {
		if (entry == null)
			return null;
		curr = entry;
		level = thislevel; // update level
		if (entry.getKey() == k) {
			return curr;
		} else {
			if (entry.isLeaf())
				return null;
			Key[] key2 = entry.getKey();
			if (k[level % dim].compareTo(key2[level % dim]) >= 0) { // make sure
																	// the
																	// "right"
																	// key is
																	// used
				return find(entry.getRight(), thislevel + 1, k); // note
																	// thislevel
																	// + 1
			} else {
				return find(entry.getLeft(), thislevel + 1, k);
			}
		}
	}

	public void insert(Key[] k, E v) {
		BinNode<Key, E> node = new BinNode<Key, E>(k, v);
		insert(node);
		// insert(root, node);
	}

	public void insert(BinNode<Key, E> node) {
		find(node.getKey());
		if (curr == null) {
			root = node;
		} else {
			Key[] key1 = node.getKey();
			Key[] key2 = curr.getKey();
			if (key1[level % dim].compareTo(key2[level % dim]) >= 0) {
				if (curr.getRight() != null)
					node.setRight(curr.getRight());
				curr.setRight(node);
			} else {
				if (curr.getLeft() != null)
					node.setLeft(curr.getLeft());
				curr.setLeft(node);
			}
		}
		totalNode++;
	}

	public void preorder() {
		enumStr = "";
		System.out.println("Total node = " + totalNode);
		if (root != null)
			preorder(root);
		System.out.println("Preorder enumeration: " + enumStr);
	}

	private void preorder(BinNode<Key, E> node) {
		if (node != null)
			System.out.println("root " + node.toString());
		if (node.getLeft() != null)
			System.out.println("   left " + node.getLeft().toString());
		if (node.getRight() != null)
			System.out.println("   right " + node.getRight().toString());

		if (node != null) {
			enumStr += node.toString();
		}
		if (node.getLeft() != null)
			preorder(node.getLeft());
		if (node.getRight() != null)
			preorder(node.getRight());
	}

	// gets the neighbors within a certain distance r

	public void getNeighborsHelper(BinNode<Key, E> node, Key[] key, int r) {
		if (node != null) {
			if (compareDist(key, node.getKey(), r)) {
				System.out.println("root " + node.toString() + " within range " + r);
			}
		}
		if (node.getLeft() != null) {
			getNeighborsHelper(node.getLeft(), key, r);
		}
		if (node.getRight() != null) {
			getNeighborsHelper(node.getRight(), key, r);
		}
	}

	public void getNeighbors(Key[] key, int r) {
		if (root != null) {
			if (compareDist(key, root.getKey(), r)) {
				System.out.println("root " + root.toString() + " within range " + r);
			}
		}
		if (root.getLeft() != null) {
			getNeighborsHelper(root.getLeft(), key, r);
		}
		if (root.getRight() != null) {
			getNeighborsHelper(root.getRight(), key, r);
		}
	}

	// helper function that checks if distances are within range and returns
	// true if in range r
	public boolean compareDist(Key[] first, Key[] second, int r) {
		int size = first.length;
		int a = 0; // the running total of lengths before being square rooted
		for (int i = 0; i < size; i++) {
			int b = ((Integer) first[i] - (Integer) second[i]);
			a += b * b;
		}
		double ans = Math.sqrt(a); // square roots to finish the distance
									// operation ans is the distance between
									// first and second keys
		if (ans < r) {
			return true;
		}
		return false; 
	}
	

	// design your own examples to test the program!!
	public static void main(String[] args) {

		
		KDtree<Integer, String> kdt = new KDtree<Integer, String>(2);
		Integer[] dataA = { 40, 45 };
		kdt.insert(dataA, "A");
		Integer[] dataB = { 15, 70 };
		kdt.insert(dataB, "B");
		Integer[] dataC = { 70, 10 };
		kdt.insert(dataC, "C");
		Integer[] dataD = { 69, 50 };
		kdt.insert(dataD, "D");
		Integer[] dataE = { 66, 85 };
		kdt.insert(dataE, "E");
		Integer[] dataF = { 85, 95 };
		kdt.insert(dataF, "F");

		kdt.preorder();

		Integer[] dataG = { 85, 93 }; // G, close to F
		System.out.println("Query location: " + dataG[0] + " " + dataG[1]);
		BinNode<Integer, String> node = kdt.find(dataG); // exact match

		if (node == null) {
			System.out.println("point not found");
		} else {
			System.out.println("point found: " + node.toString());
		}

		int r = 3;
		kdt.getNeighbors(dataG, r); // get close neighbors

		System.out.println("\nTest number two implemented below--------------------------------\n");
		KDtree<Integer, String> kdtree = new KDtree<Integer, String>(3);
		Integer[] dataOne = { 45, 40, 51 };
		kdtree.insert(dataOne, "a");
		Integer[] dataTwo = { 44, 41, 52 };
		kdtree.insert(dataTwo, "b");
		Integer[] dataThree = { 1, 1, 1 };
		kdtree.insert(dataThree, "c");

		Integer[] dataFour = { 42, 42, 50 };
 
		// kdtree.preorder();

		kdtree.getNeighbors(dataFour, 10);

	}

}
