package algorithm.date_structure.array;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import algorithm.data_structure.array.ArrayList3;

public class ArrayListTest3 {
  @Test
  public void testAdd() {
    ArrayList3 arr = new ArrayList3();
    arr.add(111);
    arr.add(222);
    arr.add(333);
    arr.add(444);
    arr.add(555);
    assertArrayEquals(new Object[] {111,222,333,444,555}, arr.toArray());
  }
  
  @Test
  public void testGet() {
    ArrayList3 arr = new ArrayList3();
    arr.add(111);
    arr.add(222);
    arr.add(333);
    arr.add(444);
    arr.add(555);
   assertEquals(111, arr.get(0));
   assertEquals(555, arr.get(4));
   assertEquals(333, arr.get(2));
  }
  
  @Test
  public void testSets() {
    ArrayList3 arr = new ArrayList3();
    arr.add(111);
    arr.add(222);
    arr.add(333);
    arr.add(444);
    arr.add(555);
    
    arr.set(0, 123);
    assertEquals(123, arr.get(0));
    arr.set(4, 892);
    assertEquals(892, arr.get(4));
    arr.set(2, 456789);
    assertEquals(456789, arr.get(2));
  }
  
  @Test
  public void testInsert() {
    ArrayList3 arr = new ArrayList3();
    arr.add(111);
    arr.add(222);
    arr.add(333);
    arr.add(444);
    arr.add(555);
    
    arr.insert(0, 8978);
    assertEquals(8978, arr.get(0));
    assertEquals(111, arr.get(1));
    assertEquals(222, arr.get(2));
    assertEquals(333, arr.get(3));
    assertEquals(444, arr.get(4));
    assertEquals(555, arr.get(5));
    assertArrayEquals(new Object[] {8978,111,222,333,444,555}, arr.toArray());

  }
  @Test
  public void testRemove() {
    ArrayList3 arr = new ArrayList3();
    arr.add(111);
    arr.add(222);
    arr.add(333);
    arr.add(444);
    arr.add(555);
    
    
    arr.remove(0);
    
    assertArrayEquals(new Object[] {222,333,444,555}, arr.toArray());

  }

}
