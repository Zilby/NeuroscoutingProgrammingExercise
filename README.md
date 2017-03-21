# NeuroscoutingProgrammingExercise
The generic programming exercise for Neuroscouting Spring 2017

How to run the script:
-----------------------
Place all the files given in the same directory.
Install any recent version of java (if not preinstalled).
Enter cd /path-to-file-directory/ into a terminal.
Enter javac *.java to compile and java Driver to run. 
Enter your desired tree size and let the program work its magic. 

Basic rundown:
--------------
This is a fairly simple program, consisting of only two classes and a driver.
These two classes are the Tree class and the Node (also often called Leaf) class. 
Being that I did not intend to make this particular project expandable, and since
I did not plan on interfacing with anything other than the tree and driver classes,
I did not include any interfaces or make the node's data type generic.

The node class is essentially a struct, having only three variables (data, left ie:
the left attached node, and right ie: the right attached node), getters, setters, and
a rudimentary toString method. Similarly, the driver is a very small class only
providing the basic function of asking for input and printing out the tree.

The Tree class has the meat of the code. A tree contains only a reference to its head
and its size. The tree's constructor method requires a given size and will build the
tree immediately when given input. buildTree(size) contains all of our code to build
a given tree. The gist of the algorithm is that for each row of the tree, it iterates
through all the nodes in the row creating their children (and their corresponding data
values) and adding them to the next row. Once this has been completed, it updates the
current row of nodes to the next and continues until the size of the tree has been met. 

I briefly experimented with having parent nodes in the children and iterating through
the tree with those, however I decided that this method was less efficient and required
having helper methods and other headaches. The current implementation only visits each
node once, avoids needless variables and functions and is quite short to boot. 

       1               
      / \       
     /   \      
    /     \     
   /       \    
   1       1       
  / \     / \   
 /   \   /   \  
 1   2   2   1   
/ \ / \ / \ / \ 
1 3 3 4 4 3 3 1

The Tree's toString method actually proved equally if not more complex than its build
method. However, it operates in a similar way. First we define how much white space we
need to construct the tree ie: whitespace before the first number in each row,
whitespace between each number in each row, and whitespace before each '/' in the empty
rows. We then add our whitespace to the front and iterate through each node in a
given row adding the data values and the whitespace between them. Once we've finished
that, if we're at the bottom of the tree we're done, but if not we have to add the '/'s
to each row above the next row of children. Finally, we update the current row and
recurse until we're left with an appropriate string for our tree.

Thankfully the trees we're working with are balanced and always have children, otherwise
calculating the branches and whitespaces would have been far more challenging. However,
since they will always have children unless at the bottom, this allowed me to streamline
the code and make it very simple, efficient, and easy to grasp.

Thanks for the opportunity to work on this exercise, it was a good refresher on efficient
tree structures!

Sincerely,
Alex Zilbersher