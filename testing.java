class testing
{
   public static void main( String [] args )
   {
      final SimpleBST tree_a = new SimpleBST();
tree_a.insert(50);tree_a.insert(49);tree_a.insert(52);
tree_a.insert(51);
final SimpleBST tree_b = new SimpleBST();
tree_b.insert(9);tree_b.insert(11);tree_b.insert(8);
final boolean similar = tree_a.similar(tree_b);
System.out.println(similar ? "Similar" : "Not similar");
   }
} 
