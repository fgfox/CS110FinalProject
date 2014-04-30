//Griffen Fox
//CS110
//Final Project
// Interface ListInterface for the ADT list.

public interface ListInterface 
{
   // return true if the size of the list is 0
   
   public boolean isEmpty();
   
   // return size of list (number of elements in the list
     
   public int size();
   
   /* add specified item at specified index
      @param item = data to be added to list
      @param index = location to add item
      @throws ListIndexOutOfBoundsException if index less than 1 or list greater than size
   */
   
   public void add(int index, Object item) throws ListIndexOutOfBoundsException;
   
   /* return item at specified index
      @return data of item at index specified
      @param index = location of requested item
      @throws ListIndexOutOfBoundsException if index less than 1 or list greater than size
   */
   
   public Object get(int index) throws ListIndexOutOfBoundsException;
   
   /* remove item at specified index
      @param index = location of item to be removed
      @throws ListIndexOutOfBoundsException if index less than 1 or list greater than size
   */
   
   public void remove(int index) throws ListIndexOutOfBoundsException;
   
   // remove all items in list

   public void removeAll();
} 