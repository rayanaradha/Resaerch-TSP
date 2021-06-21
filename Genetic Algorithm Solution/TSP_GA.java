import java.util.*;

public class TSP_GA {

    public static void main(String[] args) {

      //getting input data
      Scanner x = new Scanner(System.in);        
      int t = x.nextInt();
      for(int i=0; i<t ;i++){
        int a = x.nextInt();
        int b = (int) x.nextDouble();
        int c = (int) x.nextDouble();
          String d = Integer.toString(a);
          City city = new City(d,b,c);
          TourManager.addCity(city);
      }
      x.close();
      long startTime = System.nanoTime();

        // Initialize population
        Population pop = new Population(50, true);
     // System.out.println("Initial distance: " + pop.getFittest().getDistance());

       // Evolve population for 100 generations
        pop = GA.evolvePopulation(pop);
        for (int i = 0; i < 100; i++) {
            pop = GA.evolvePopulation(pop);
        }

        // Print final results
        System.out.println(pop.getFittest());
        System.out.println("Final distance: " + pop.getFittest().getDistance());
        System.out.println("Solution:");
       

        long endTime = System.nanoTime();
        long diff = endTime-startTime;
        System.out.println("Runing Time :"+diff/1000000+"ms");
    }
}


