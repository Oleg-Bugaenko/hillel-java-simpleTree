public class MyApp {
    public static void main(String[] args) {
        SimpleTree<Integer> simpleTree = new SimpleTree<>();

        simpleTree.add(5);
        simpleTree.add(10);
        simpleTree.add(3);
        simpleTree.add(7);
        simpleTree.add(20);
        simpleTree.add(15);
        simpleTree.add(8);

        for (Integer i: simpleTree) {
            System.out.printf("%d ,", i);
        }


    }
}
