package algorithm.data_structure.array;

public class Test {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    ArrayList2 arr = new ArrayList2();
    ArrayList2 arr2 = new ArrayList2(10);
    arr.add(111);
    
    arr.add(222);
    arr.add(333);
    arr.add(444);
    arr.add(555);
    arr.add(null);
    arr.add(null);
    
    arr.reverse();
    arr.print();
   
    
 
  }

}
