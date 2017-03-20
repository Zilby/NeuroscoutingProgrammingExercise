import java.util.*;

// Our tree class for building our data structure
public class Tree {

    // The top of our tree 
    private Node head;

    // Takes in an integer to build a tree of
    // the corresponding size. Any size less than
    // 1 will evaluate to a size of 1
    public Tree(int size) {
	head = new Node(1);
	buildTree(size); 
    }

    // Builds our tree given the size
    private void buildTree(int size) {
	ArrayList<Node> nodes = new ArrayList<Node>();
	nodes.add(head);
	// iterates through each row of our tree
	for(; size > 1; size--) {
	    // for producing the next row
	    ArrayList<Node> newNodes = new ArrayList<Node>();
	    // iterates through each node in our row
	    for(int i = 0; i < nodes.size(); i++) {
		Node templ, tempr;
		if(i - 1 < 0) {
		    templ = new Node(nodes.get(i).getData());
		} else {
		    templ = new Node(nodes.get(i).getData() + nodes.get(i - 1).getData());
		}
		if(i + 1 >= nodes.size()) {
		    tempr = new Node(nodes.get(i).getData());
		} else {
		    tempr = new Node(nodes.get(i).getData() + nodes.get(i + 1).getData());
		}
		// sets the children to the correct values
		nodes.get(i).setLeft(templ);
		nodes.get(i).setRight(tempr);
		// adds the children to the next row
		newNodes.add(templ);
		newNodes.add(tempr);
	    }
	    nodes = newNodes;
	}
    }

    // Our toString method
    public String toString(){
	if(head==null){
	    return "empty";
	}
	return toStringHelper(head);
    }

    // Our helper for our toString
    private String toStringHelper(Node n){
	String output = "";
	return output;
    }
}
