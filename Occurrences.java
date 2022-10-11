import java.io.File;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class Occurrences {
  public static void main(String args[]) {
    if (args.length == 0) System.err.println("No arguments entered, please enter at least one file path...");
    ExecutorService executor = Executors.newCachedThreadPool(); // create a new thread pool
    ConcurrentHashMap<String, Integer> HashMap = new ConcurrentHashMap<String, Integer>(); // create a new ConcurrentHashMap
    for (char c='a'; c<='z'; c++) {
      HashMap.put(String.valueOf(c), 0); // creation of a new HashMap with alla lphabet characters and occurrences = 0
    }
    File[] fileSeen = new File[args.length];
    for (int i=0; i<args.length; i++) {
      File file = new File(args[i]); // directory path
      if (file.isFile() && !Arrays.asList(fileSeen).contains(file)) { // if the file is a correct file and has not already been seen
        executor.execute(new Counter(file, HashMap)); // if it's a correct file execute the thread for this file
        fileSeen[i] = file; // add to list of seen files
      }
      else if (file.isFile() && Arrays.asList(fileSeen).contains(file)) System.out.println("File " + "'" + file.getName() + "'" + " already read");
      else System.err.println("File " + "'" + file.getName() + "'" + " isn't a file or is empty!");
    }
    executor.shutdown(); // shut down the thread pool
  }
}

