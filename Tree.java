import java.util.*;

// Our tree class for building our data structure
public class Tree {

    // The top of our tree 
    private Node head;
    private int size;

    // Takes in an integer to build a tree of
    // the corresponding size. Any size less than
    // 1 will evaluate to a size of 1
    public Tree(int size) {
	head = new Node(1);
	this.size = Math.max(size, 1);
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
	ArrayList<Node> temp = new ArrayList<Node>();
	temp.add(head);
	return this.toStringHelper(temp, 1);
    }

    // Our helper for our toString
    private String toStringHelper(ArrayList<Node> nodes, int row){
	String output = "";
	// the current level from the bottom (think building/pyramid)
        int level = this.size - row;
        int lineSpaces = (int) Math.pow(2, (Math.max(level - 1, 0)));
	// whitespace in front of first number for this level
        int firstSpaces = (int) Math.pow(2, (level)) - 1;
	// whitespace between each number for this level
        int betweenSpaces = (int) Math.pow(2, (level + 1)) - 1;

	// add the whitespace in front
        output += this.getSpace(firstSpaces);

	// for getting our next row of nodes
        ArrayList<Node> newNodes = new ArrayList<Node>();

	// add the nodes to our string and children to next row
        for (Node node : nodes) {
	    output += node.toString();
	    newNodes.add(node.getLeft());
	    newNodes.add(node.getRight());
	    output += this.getSpace(betweenSpaces);
        }
	// if we've reached the bottom we're done
	if(row == size) {
	    return output;
	}

	// otherwise add the lines to the next nodes
	output += "\n";
        for (int i = 1; i <= lineSpaces; i++) {
            for (int j = 0; j < nodes.size(); j++) {
		output += this.getSpace(firstSpaces - i);
		output += "/";
		output += this.getSpace((i * 2) - 1);
		output += "\\";
		output += this.getSpace((lineSpaces * 2) - i);
            }
            output += "\n";
	}

	// return this level string + lower levels
        return output + toStringHelper(newNodes, row + 1);
    }

    // gives a string of size spaces
    private String getSpace(int size) {
	if(size < 1) {
	    return "";
	}
        char[] arr = new char[size];
	Arrays.fill(arr, ' ');
	return new String(arr);
    }
}
