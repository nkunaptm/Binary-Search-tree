import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Utility procedures for binary tree structures.
 * 
 * @version 25/2/2015
 */
public class TreeUtils {
        
    /**
     * Determine whether one tree node structure is similar (has the same structure) as another.
     */
    public static boolean similar(BinaryTreeNode treeStructOne, BinaryTreeNode treeStructTwo) {
		if ((treeStructOne == null) && (treeStructTwo == null)){
    		return true;
		}
    	else {
    		if ((treeStructOne.hasLeft() == treeStructTwo.hasLeft()) && (treeStructOne.hasRight() == treeStructTwo.hasRight())){
    			if (treeStructOne.hasLeft() && treeStructOne.hasRight() ){
    				return similar(treeStructOne.getLeft(), treeStructTwo.getLeft()) && similar(treeStructOne.getRight(), treeStructTwo.getRight()) ;
    			}
    			else if (treeStructOne.hasRight() && !treeStructOne.hasLeft() ){
    				return similar(treeStructOne.getRight(), treeStructTwo.getRight());
    			}
    			else if (!treeStructOne.hasRight() && treeStructOne.hasLeft() ){
                                return similar(treeStructOne.getLeft(), treeStructTwo.getLeft());
                        }
			else{
				return true;}
    		}
    		else{
    			return false;
    		}
    	}
    }
    
    /**
     * Obtain a list containing the root node of the given structure i.e. tNode itself.
     */
    public static List<BinaryTreeNode> levelZero(BinaryTreeNode tNode) {
        // Your code here
	List<BinaryTreeNode> list = new ArrayList<BinaryTreeNode>();
	
		list.add(tNode);
		return list;
    }
    
    
    /**
     * Given a list of nodes, obtain the next level. 
     * 
     * <p>
     * If the tree structure is incomplete, <code>BinaryTreeNode.EMPTY_NODE</code> is inserted as a place holder for each
     * missing node.
     * </p>
     */
    public static List<BinaryTreeNode> nextLevel(List<BinaryTreeNode> level) {
		// Your code here

		List<BinaryTreeNode> list = new ArrayList<BinaryTreeNode>();

	for(BinaryTreeNode holder : level){
		if (holder.hasLeft()){list.add(holder.getLeft());}
		else {list.add(BinaryTreeNode.EMPTY_NODE); }
		if (holder.hasRight()){list.add(holder.getRight());}
		else {list.add(BinaryTreeNode.EMPTY_NODE); }		
	}
	return list;
    }
    
    /**
     * Determine whether node is a place holder i.e. <code>node==BinaryTreeNode.EMPTY_NODE</code>
     */
    public static boolean isPlaceHolder(BinaryTreeNode node) {
		// Your code here
		if (node==BinaryTreeNode.EMPTY_NODE){return true;}
		else{
		return false;
		}
    }
    
}
