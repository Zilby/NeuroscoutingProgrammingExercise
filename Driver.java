import java.util.Scanner;

public class Driver{

    public static void main(String[] args){
	System.out.print("Enter desired tree size: ");
	Scanner scan = new Scanner(System.in);
	int i = scan.nextInt();
	Tree t = new Tree(i);
	System.out.println(t.toString());
    }
}
