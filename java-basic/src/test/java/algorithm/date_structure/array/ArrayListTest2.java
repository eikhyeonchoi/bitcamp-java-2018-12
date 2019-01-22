package algorithm.date_structure.array;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import algorithm.data_structure.array.ArrayList2;
import ch14.b.A;

public class ArrayListTest2 {
  @Test
  public void testAdd() {
    ArrayList2 arr = new ArrayList2();
    arr.add(100);
    arr.add(200);
    arr.add(300);
    arr.add(400);
    
    assertArrayEquals(new Object[] {100,200,300,400}, arr.toArray());
  }
  
  @Test
  public void testGet() {
    ArrayList2 arr = new ArrayList2();
    arr.add(100);
    arr.add(200);
    arr.add(300);
    arr.add(400);
    
    assertEquals(100, arr.get(0));
    assertEquals(300, arr.get(2));
    assertEquals(400, arr.get(3));
  }
  
  @Test
  public void testSet() {
    ArrayList2 arr = new ArrayList2();
    arr.add(100);
    arr.add(200);
    arr.add(300);
    arr.add(400);
    
    assertEquals(100, arr.set(0, 500));
    assertEquals(500, arr.get(0));
    assertEquals(400, arr.set(3, 700));
    assertEquals(700, arr.get(3));
  }
  
  @Test
  public void testInsert() {
    ArrayList2 arr = new ArrayList2();
    arr.add(100);
    arr.add(200);
    arr.add(300);
    arr.add(400);
    
    arr.insert(0, 777);
    assertArrayEquals(new Object[] {777, 100, 200, 300, 400}, arr.toArray());
    arr.insert(2, 888);
    assertArrayEquals(new Object[] {777, 100,888, 200, 300, 400}, arr.toArray());
  }
  
  @Test
  public void testRemove() {
    ArrayList2 arr = new ArrayList2();
    arr.add(111);
    arr.add(222);
    arr.add(333);
    arr.add(444);
    arr.add(555);
    arr.add(666);
    
    arr.remove(0);
    assertArrayEquals(new Object[] {222, 333, 444, 555, 666}, arr.toArray());
    arr.remove(2);
    assertArrayEquals(new Object[] {222, 333, 555, 666}, arr.toArray());
  }
  
  @Test
  public void testReverse() {
    ArrayList2 arr = new ArrayList2();
    arr.add(1);
    arr.add(2);
    arr.add(3);
    arr.add(4);
    arr.add(5);
    arr.add(6);
    
    arr.reverse();
    assertArrayEquals(new Object[] {6, 5, 4, 3, 2, 1}, arr.toArray());
  }
  
  
  
  
  
}
