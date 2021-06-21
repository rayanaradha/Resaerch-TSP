 import java.util.*;

 public class SimulatedAnnealing {

    // Calculate the acceptance probability
    public static double acceptanceProbability(double energy, double newEnergy, double temperature) {
        // If the new solution is better, accept it
        if (newEnergy < energy) {
            return 1.0;
        }
        // If the new solution is worse, calculate an acceptance probability
        return Math.exp((energy - newEnergy) / temperature);
    }


    public static void main(String[] args) {
       
        //getting input data
        Scanner x = new Scanner(System.in);        
        int t = x.nextInt();
        for(int i=0; i<t ;i++){
          int a = x.nextInt();
          double b =  x.nextDouble();
          double c =  x.nextDouble();
          String d = Integer.toString(a);
          City city = new City(d,b,c);
          TourManager.addCity(city);
        }
        x.close();
        long startTime = System.nanoTime();
          
        // Set initial temp
        double temp = 10000;

        // Cooling rate
        double coolingRate = 0.003;

        // Initialize intial solution
        Tour currentSolution = new Tour();
        currentSolution.generateIndividual();
       
        // Set as current best
        Tour best = new Tour(currentSolution.getTour());
        
        // Loop until system has cooled
        while (temp > 1) {
            // Create new neighbour tour
            Tour newSolution = new Tour(currentSolution.getTour());

            // Get a random positions in the tour
            int tourPos1 = (int) (newSolution.tourSize() * Math.random());
            int tourPos2 = (int) (newSolution.tourSize() * Math.random());

            // Get the cities at selected positions in the tour
            City citySwap1 = newSolution.getCity(tourPos1);
            City citySwap2 = newSolution.getCity(tourPos2);

            // Swap them
            newSolution.setCity(tourPos2, citySwap1);
            newSolution.setCity(tourPos1, citySwap2);
                     
            // Get energy of solutions
            double currentEnergy = currentSolution.getDistance();
            double neighbourEnergy = newSolution.getDistance();

            // Decide if we should accept the neighbour
            if (acceptanceProbability(currentEnergy, neighbourEnergy, temp) > Math.random()) {
   
                currentSolution = new Tour(newSolution.getTour());
            }
 
            // Keep track of the best solution found
            if (currentSolution.getDistance() < best.getDistance()) {
                best = new Tour(currentSolution.getTour());
            }

            // Cool system
            temp *= 1-coolingRate;

          
        }
       
         System.out.println(best);
         System.out.println("Best solution distance: " + best.getDistance());
            
         long endTime = System.nanoTime();
         long diff = endTime-startTime;
         System.out.println("Runing Time :"+diff/1000000+"ms");

    }
}
