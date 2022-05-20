// Java program for page replacement algorithms
import java.util.ArrayList;
 import java.util.*;
public class LRU {
     
    // Driver method
    public static void main(String[] args) {
        int capacity = 4;
        int arr[] = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};
         System.out.println(Arrays.toString(arr));
        // To represent set of current pages.We use
        // an Arraylist
        ArrayList<Integer> s=new ArrayList<>(capacity);
        int count=0;
        int page_faults=0;
        for(int i:arr)
        {
            // Insert it into set if not present
            // already which represents page fault
					System.out.println("-----------------------------");
					System.out.println("S.size()="+s.size()    + "  i="+i);
					
            if(!s.contains(i))
				{
					

				 System.out.println("Before equal S="+s   );
				// Check if the set can hold equal pages
					if(s.size()==capacity)
						{
							
							System.out.println("before move 0 in S="+s   );
							s.remove(0);
							s.add(capacity-1,i);
							System.out.println("After move 0 in S="+s   );
						}
					else{
						s.add(count,i);
					}
						// Increment page faults
					page_faults++;
					 
					count++;
					  System.out.println("After  equal S="+s   );
							System.out.println("Middle page_faults ="+page_faults);
			  
				}
            else
				{
					// Remove the indexes page
					s.remove((Object)i);
					// insert the current page
					s.add(s.size(),i);    

				System.out.println("Else S="+s   );					
				}
         
        }
        System.out.println("Final page_faults="+page_faults);
    }
}