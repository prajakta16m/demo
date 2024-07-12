import java.util.*;
import java.util.stream.*;

public class HashSetExample {
    public static void main(String args[]) {
        
        /*
            HashSet cannot be sorted, so we convert it into a list.
        */
    
        HashSet<String> names = new HashSet<String>();
        names.add("Prajakta");
        names.add("Hali");
        names.add("Mahamuni");
        names.add("Rishiv");
        names.add("Rakshit");
        
        List<String> list = new ArrayList<String>(names);
        Collections.sort(list);
        
        System.out.println(names);
        System.out.println(list);

      /*
          OUTPUT:
          set: [Rakshit, Rishiv, Hali, Mahamuni, Prajakta]
          
          list: [Hali, Mahamuni, Prajakta, Rakshit, Rishiv]
      */
        
    }
    
}
