import java.util.Scanner;

public class Driver{

    public static void main(String[] args){
	Scanner scan = new Scanner(System.in);
	int i = scan.nextInt();
	Tree t = new Tree(i);
	System.out.println(t.toString());
    }
}
