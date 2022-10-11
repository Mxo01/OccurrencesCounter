import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.io.IOException;

public class Counter implements Runnable {
  File file;
  ConcurrentHashMap<String, Integer> HashMap;

  public Counter(File file, ConcurrentHashMap<String, Integer> HashMap) {
    this.file = file;
    this.HashMap = HashMap;
  }

  public void run() {
    try {
      FileReader fr = new FileReader(this.file); // creation of FileReader object
      FileWriter fw = new FileWriter("Output.txt"); // creation of FileWriter object
      BufferedReader br = new BufferedReader(fr); // creation of BufferedReader object
      int c = 0;
      while (true) {
        if ((c = br.read()) == -1) { // if end of file is reached then break
          System.out.print("File " + this.file.getName() + " read\n");
          break;
        }
        if ("abcdefghijklmnopqrstuvwxyz".contains(String.valueOf((char) c).toLowerCase())) { // if read an alphabet character
          synchronized (this.HashMap) {
            int oldVal = this.HashMap.get(String.valueOf((char) c).toLowerCase()); // get old value of this character from the HashMap
            this.HashMap.replace(String.valueOf((char) c).toLowerCase(), ++oldVal); // then replace it with incremented value
          }
        }
      }
      synchronized (this.HashMap) {
        for (String letter: this.HashMap.keySet()) {
          String key = letter.toString();
          String value = this.HashMap.get(letter).toString();
          fw.write(key + ", " + value + "\n"); // write for each letter his occurrences in output file
        }
      }
      fr.close(); // close the file reader
      fw.close(); // close the file writer
      br.close(); // close the buffer reader
    }
    catch (IOException e) {e.printStackTrace();}
  }
}
