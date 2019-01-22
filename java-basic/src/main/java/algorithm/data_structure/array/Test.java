package algorithm.data_structure.array;

public class Test {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    ArrayList arr = new ArrayList();
    arr.add(4);
    arr.print();
    System.out.println();
    
    arr.insert(0, 11);
    arr.print();
    System.out.println();
    
    arr.insert(0, 123);
    arr.print();
    System.out.println();
    
    arr.insert(2, 999);
    arr.print();
    System.out.println();
    
    arr.remove(0);
    arr.print();
    System.out.println();
    
    arr.add(123);
    arr.print();
    System.out.println();
    
    System.out.println(arr.get(0));
    arr.set(0, 586);
    arr.print();
    System.out.println();
 
  }

}
