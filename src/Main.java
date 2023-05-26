import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BST<Integer, String> bst = new BST();

        bst.put(5, "E");
        bst.put(3, "C");
        bst.put(7, "G");
        bst.put(2, "B");
        bst.put(4, "D");
        bst.put(6, "F");
        bst.put(8, "H");

        System.out.println("> Defense(contains method): ");
        System.out.println("1) 4 ,D");
        System.out.println("2) 10, E");

        System.out.println(bst.contains(4, "D"));
        System.out.println(bst.contains(10, "E"));

        Iterable it = bst.iterator();
        for(Object el: it) {
            System.out.println(el);
        }



        System.out.println("Value at key 5: " + bst.get(5));
        System.out.println("Value at key 2: " + bst.get(2));
        System.out.println("Value at key 8: " + bst.get(8));
        System.out.println("Value at key 100(should return null): " + bst.get(100));

        bst.delete(3);
        bst.delete(7);

        System.out.println("Value deleted at key 3: " + bst.get(3));
        System.out.println("Value deleted at key 7: " + bst.get(7));
        System.out.println(bst.contains(4,"D"));
    }
}