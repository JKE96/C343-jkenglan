//a simple BST tree (so we call it BSTJr) for C343
public class BSTJr <K extends Comparable<?super K>> {
	BinNode<K> root;
	BinNode<K> curr;
	//for balance checking: if a node is unbalanced, the tree will be unbalanced
	BinNode<K> unbalanced = null;
	public BSTJr() {
		root = null;
		curr = null;
	}
	public void build(K[] ks) {
		for(int i = 0; i < ks.length; i ++) insert(ks[i]);
	}
	public void insert(K k) {
		BinNode<K> t = new BinNode<K>(k);
		if(root == null) {
			root = curr = t;
		}
		else {
			curr = search(root, k);
			if(k.compareTo(curr.getKey()) < 0) curr.setLeft(t);
			else curr.setRight(t);
		}
	}
	public BinNode<K> search(BinNode<K> entry, K k) {
		if(entry == null) return null;
		else { 
			entry.setSize(entry.getSize() + 1); //update the size of the subtree by one
			if(entry.isLeaf()) return entry;
			if(k.compareTo(curr.getKey()) < 0) {
				if(entry.getLeft() != null) return search(entry.getLeft(), k);
				else return entry;
			}
			else {
				if(entry.getRight() != null) return search(entry.getRight(), k);
				else return entry;
			}
		}
	}
	public void display() { 
		if(root == null) return;
		System.out.println("Preorder enumeration: key(size-of-the-subtree)");
		preorder(root); 
		System.out.println();
	}
	public void preorder(BinNode<K> entry) {
		System.out.print(entry.getKey() + "(" + entry.getSize() + ") ");
		if(entry.getLeft() != null) preorder(entry.getLeft());
		if(entry.getRight() != null) preorder(entry.getRight());
	}
	
	private int getHeight(BinNode<K> bn){
		if (bn ==null){return 0;}
		
		int a = getHeight(bn.getLeft());
		int b = getHeight(bn.getRight());
		if(Math.abs(a-b) > 1)
			unbalanced = bn;
		return Math.max(a,b) + 1;
		}
	
	private void CheckBalance(BinNode<K> bn){
		getHeight(bn);
		if (unbalanced == null){
			System.out.println("the tree is balanced");
		}
		else{
			System.out.println("the tree is unbalanced");
		}
	}
	
	public static void main(String[] argv) {
		BSTJr<Integer> tree = new BSTJr<Integer>();
		Integer[] ks = {37, 24, 42, 7, 2, 40, 120};
		tree.build(ks);
		tree.display();
		
		//Testing CheckBalance
		BinNode one = new BinNode(10);
		BinNode two = new BinNode(20);
		BinNode three = new BinNode(30);
		one.setLeft(two);
		one.setRight(three);
		tree.CheckBalance(one);
		
		BinNode unbal = new BinNode(99);
		unbal.setRight(two);
		two.setRight(three);
		tree.CheckBalance(unbal);
	}
}