package algorithm.date_structure.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import algorithm.data_structure.test.LinkedList;

public class LinkedListTest {

  @Test
  public void testAdd() {
    LinkedList list = new LinkedList();
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    
    assertEquals(100, list.get(0));
    assertEquals(5, list.size());
  }
  
  @Test
  public void testSet() {
    LinkedList list = new LinkedList();
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    
    assertEquals(100, list.set(0,55));
    assertEquals(55, list.get(0));
    
    assertEquals(200, list.set(1,66));
    assertEquals(66, list.get(1));
    assertEquals(5, list.size());
  }
  
  @Test
  public void testToArray() {
    LinkedList list = new LinkedList();
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    
    assertArrayEquals(new Object[] {100,200,300,400,500}, list.toArray());
  }
  
  @Test
  public void testRemove() {
    LinkedList list = new LinkedList();
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    
    assertEquals(100, list.remove(0));
    assertArrayEquals(new Object[] {200,300,400,500}, list.toArray());
    assertEquals(300, list.remove(1));
    assertArrayEquals(new Object[] {200,400,500}, list.toArray());
  }
  
  @Test
  public void testInsert() {
    LinkedList list = new LinkedList();
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    
    assertEquals(0, list.insert(1, 150));
    assertArrayEquals(new Object[] {100,150,200,300,400,500}, list.toArray());
    assertEquals(0, list.insert(0, 55));
    assertArrayEquals(new Object[] {55,100,150,200,300,400,500}, list.toArray());
  }
  
  
  
  
  
  
  
  
}
