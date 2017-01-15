package LinkedListPackage;

public class MainClass {
    public static void main(String[] args) throws SpecialException {
        List list = new List();

        list.addToFront(2);
        list.addToFront(1);
        list.addToBack(4);
        list.addToBack(5);
        list.addToBack("a");
        list.addToBack("b");

        System.out.println(list);
//        System.out.println("Get test: " + list.get(2));


        list.deleteFromEnd();
        list.set(2, "new");
//        list.add(0, "NEW");
//        list.deleteFromBegin();
        System.out.println(list);
        System.out.println(list.get(1));
        }
        }
