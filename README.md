# Alphabetic characters occurences counter


It simply counts the number of occurrences of each letter of the alphabet (from "A" to "Z")
excluding all special and numeric characters (including spaces and newlines).

## Documentation

In this project i decided to use a [ConcurrentHashMap](https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ConcurrentHashMap.html) to store all the occurrences related 
to a file and each time those values ​​are changed (so if at least 2 files are passed, the 
HashMap first stores the contents of a file and then updates it by adding the occurrences 
contained in the second file, and so on ...)


I used a [CachedThreadPool](https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/Executors.html#newCachedThreadPool())
to manage multiple files and to work concurrently (although in this case only one file 
is associated with each thread).

You are probably looking for some utilities to read or write to file/stream and the package that makes it easier is definitely
[File](https://docs.oracle.com/javase/7/docs/api/java/io/File.html) but the real work with
the files is in [Counter.java](https://github.com/Mxo01/OccurrencesCounter/blob/master/Counter.java)
where i used a [FileReader](https://docs.oracle.com/javase/7/docs/api/java/io/FileReader.html) 
in combination with a [BufferedReader](https://docs.oracle.com/javase/7/docs/api/java/io/BufferedReader.html)
to read from the file 
and a [FileWriter](https://docs.oracle.com/javase/7/docs/api/java/io/FileWriter.html) to write an output file the execution result in the following format:

\<character\>,\<occurences\>\
\<character\>,\<occurences\>\
\<character>,\<occurences>\
\<character>,\<occurences>\
...


For multi-threading see [Thread](https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html) but in this project i've used a cached thread pool, see [ExecturService](https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ExecutorService.html) and [Executors](https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/Executors.html).


## Installation (Windows)

First of all you need to install jdk from [Downloads](https://www.oracle.com/java/technologies/downloads/).

So check everything is ok:
```bash
  javac --version
  java --version
```
If you're using Visual Studio Code check this [Extension](https://code.visualstudio.com/docs/java/extensions).

On Linux it is much simpler and you just have to write a few lines of code on the terminal and you are done.
    
## Authors

For doubts or concerns mariodimodica.01@gmail.com. 
- [@mxo01](https://github.com/Mxo01)