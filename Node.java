
public class Node{

    private int data;
    private Node left, right;
    
    public Node(int data){
	this.data = data;
	left = null;
	right = null;
    }

    public Node(int data, Node left, Node right){
	this.data = data;
	this.left = left;
	this.right = right;
    }

    public Node getRight(){
	return right;
    }

    public Node getLeft(){
	return left;
    }

    public int getData(){
	return data;
    }

    public void setRight(Node n){
	right = n;
    }

    public void setLeft(Node n){
	left = n;
    }

    public void setData(int data){
	this.data = data;
    }

    public String toString(){
	return "" + data;
    }
}
