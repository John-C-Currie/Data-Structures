import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TestMovies {
   List<MovieInfo> movieList = new ArrayList<>();

   public static void main(String[] args) {
      new TestMovies().go();
   }

   public void go() {
      populateList();
      System.out.println("Movies, Unsorted:");
      System.out.println(movieList); //output as read from file

      Collections.sort(movieList);  
      System.out.println("\nMovies, Sorted by Title:");
      System.out.println(movieList); //output as sorted by title

      Collections.sort(movieList, new MovieInfo.GenreOrder()); 
      System.out.println("\nMovies, Sorted by Genre:");
      System.out.println(movieList); //output as sorted by genre

      Collections.sort(movieList, new MovieInfo.ActorOrder()); 
      System.out.println("\nMovies, Sorted by Actor:");
      System.out.println(movieList); //output as sorted by actor

   }

   public void populateList() {
      // read the file, create MovieInfo instances, and
      // populate the ArrayList movieList with these instances
      try {
         Scanner scanner = new Scanner(new File("Assignment1/movieInfo.txt"));
         while(scanner.hasNextLine())
         {
            String[] line = scanner.nextLine().split("/");
            movieList.add(new MovieInfo(line[0], line[1], line[2]));
         }
      } catch (FileNotFoundException e) { throw new RuntimeException(e); }
   }

}