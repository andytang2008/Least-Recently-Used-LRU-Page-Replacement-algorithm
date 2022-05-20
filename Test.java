// Java implementation of above algorithm
 
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.*;
 
class Test
{
    // Method to find page faults using indexes
    static int pageFaults(int pages[], int n, int capacity)
    {
        // To represent set of current pages. We use
        // an unordered_set so that we quickly check
        // if a page is present in set or not
        HashSet<Integer> s = new HashSet<>(capacity);
      
        // To store least recently used indexes
        // of pages.
        HashMap<Integer, Integer> indexes = new HashMap<>();
      
        // Start from initial page
        int page_faults = 0;
        for (int i=0; i<n; i++)
        {
			
			System.out.println("pages[i] = "+pages[i]  +  "   i="+i);
            // Check if the set can hold more pages
            if (s.size() < capacity)
            {
                // Insert it into set if not present
                // already which represents page fault
                if (!s.contains(pages[i]))
                {
                    s.add(pages[i]);
      
                    // increment page fault
                    page_faults++;
                }
      
                // Store the recently used index of
                // each page
                indexes.put(pages[i], i);
            }
      
            // If the set is full then need to perform lru
            // i.e. remove the least recently used page
            // and insert the current page
            else
            {
                // Check if current page is not already
                // present in the set
                if (!s.contains(pages[i]))
                {
                    // Find the least recently used pages
                    // that is present in the set
                    int lru = Integer.MAX_VALUE, val=Integer.MIN_VALUE;
                     
                    Iterator<Integer> itr = s.iterator();
                     
                    while (itr.hasNext()) {
                        int temp = itr.next();
                        if (indexes.get(temp) < lru)
                        {
                            lru = indexes.get(temp);
                            val = temp;
                        }
                    }
					System.out.println("middle s = "+s);
                 
                    // Remove the indexes page
                    s.remove(val);
                   //remove lru from hashmap
                   indexes.remove(val);
                    // insert the current page
                    s.add(pages[i]);
      
                    // Increment page faults
                    page_faults++;
                }
      
                // Update the current page index
                indexes.put(pages[i], i);
            }
			
			display(s, indexes,page_faults);
		
        }
        return page_faults;
    }
			

	static void display(HashSet<Integer> s, HashMap<Integer, Integer> indexes, int page_faults){
			System.out.println("Hashset s ="+s);
			
			for (Integer name: indexes.keySet()) {
				String key = name.toString();
				String value = indexes.get(name).toString();
				System.out.println(" k="+key + " " + " v="+value);
			}
			System.out.println("page_faults ="+page_faults);
			System.out.println("-------------------------------------------");
	}
	

    // Driver method
    public static void main(String args[])
    {
        int pages[] = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};
		System.out.println("pages"+Arrays.toString(pages));
        
        int capacity = 4;
         
        System.out.println("Final page_faults = "+pageFaults(pages, pages.length, capacity));
    }
}
