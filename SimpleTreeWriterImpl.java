import java.io.PrintStream;
import java.util.List;
/**
 * Abstract definition of an object for printing a simple binary tree structure. 
 *
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SimpleTreeWriterImpl implements SimpleTreeWriter{

    /**
     * Set the PrintStream object to be used for output.
     * An implementing class may wish to supplement this functionality with a constructor 
     * that achieves the the same effect. 
     */

	PrintStream writer;

    public SimpleTreeWriterImpl(PrintStream stream){
	this.setDestination(stream);
}

    public void setDestination(PrintStream stream){
	this.writer = new PrintStream(stream);
 }

    /**
     * Print a textual representation of the given tree structure to the PrintStream object
     * specified with <code>setDestination</code>.
     */
    public void write(BinaryTreeNode tree){

	int height = tree.getHeight();
	int largest = tree.getLargest();
	String length = "" + largest;
	int digits = length.length();

	List<BinaryTreeNode> list = TreeUtils.levelZero(tree);
	for(int x = 0; x < height; x++){
		//printing the outer spaces
		int spacer = ((int)(Math.pow(2, height - x) - 1)/2);
		int counter = 1;
		for(int i = 0; i < ((digits)*spacer); i++){
			writer.print(" ");
		}
		//printing stuff in the middle
		for(BinaryTreeNode foo: list){
			if(TreeUtils.isPlaceHolder(foo)){
				for(int s = 0; s < digits; s++){writer.print(" ");}
			}
			else{
				writer.print(String.format("%0"+digits+"d", foo.getItem()));
			}
			if(list.indexOf(foo) == (list.size() -1)){
				continue;}
			for(int s = 0; s <((digits) * ((int)(Math.pow(2, height - x) - 1))); s++){
			if(counter%2 == 0){
				writer.print(" ");}
			else{
				writer.print("-");}
			}
			counter++;
		}
		counter = 1;
		for(int i = 0; i < ((digits)*spacer); i++){
                        writer.print(" ");
                }

		writer.println();
		list = TreeUtils.nextLevel(list);
	}

}
}
