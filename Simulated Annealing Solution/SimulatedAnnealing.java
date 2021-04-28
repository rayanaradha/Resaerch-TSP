public class SimulatedAnnealing {

    // Calculate the acceptance probability
    public static double acceptanceProbability(int energy, int newEnergy, double temperature) {
        // If the new solution is better, accept it
        if (newEnergy < energy) {
            return 1.0;
        }
        // If the new solution is worse, calculate an acceptance probability
        return Math.exp((energy - newEnergy) / temperature);
    }

    public static void line(){
        System.out.println("------------------------------------------------------");
    }

    public static void main(String[] args) {
      
        // Create and add our cities
        City city = new City("a",60, 200);
        TourManager.addCity(city);
        City city2 = new City("b",180, 200);
        TourManager.addCity(city2);
        City city3 = new City("c",80, 180);
        TourManager.addCity(city3);
        City city4 = new City("d",140, 180);
        TourManager.addCity(city4);
        City city5 = new City("e",20, 160);
        TourManager.addCity(city5);
        City city6 = new City("f",100, 160);
        TourManager.addCity(city6);
        City city7 = new City("g",200, 160);
        TourManager.addCity(city7);
        City city8 = new City("h",140, 140);
        TourManager.addCity(city8);
        City city9 = new City("i",40, 120);
        TourManager.addCity(city9);
        City city10 = new City("j",100, 120);
        TourManager.addCity(city10);
        City city11 = new City("k",180, 100);
        TourManager.addCity(city11);
        City city12 = new City("l",60, 80);
        TourManager.addCity(city12);
        City city13 = new City("m",120, 80);
        TourManager.addCity(city13);
        City city14 = new City("n",180, 60);
        TourManager.addCity(city14);
        City city15 = new City("o",20, 40);
        TourManager.addCity(city15);
        City city16 = new City("p",100, 40);
        TourManager.addCity(city16);
        City city17 = new City("q",200, 40);
        TourManager.addCity(city17);
        City city18 = new City("r",20, 20);
        TourManager.addCity(city18);
        City city19 = new City("s",60, 20);
        TourManager.addCity(city19);
        City city20 = new City("t",160, 20);
        TourManager.addCity(city20);
        line();
        System.out.println("Add all city into a tour manager :");
        System.out.println(TourManager.destinationCities);
        System.out.println();
        System.out.println("Number of cities :"+TourManager.numberOfCities());
        line();

       // Set initial temp
        double temp = 10000;

        // Cooling rate
        double coolingRate = 0.003;

        // Initialize intial solution
        Tour currentSolution = new Tour();
        
        currentSolution.generateIndividual();
        System.out.println("Create initial random path :");
        System.out.println(currentSolution.getTour());
        System.out.println();  
        System.out.println("Initial solution distance: " + currentSolution.getDistance());
        System.out.println("Current temp :" +temp);
        line();

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
            
            System.out.println("new random path :");
            System.out.println(newSolution.getTour());
            System.out.println();
         
            System.out.println("solution distance for new random path: " + newSolution.getDistance());

            // Get energy of solutions
            int currentEnergy = currentSolution.getDistance();
            int neighbourEnergy = newSolution.getDistance();

            // Decide if we should accept the neighbour
            if (acceptanceProbability(currentEnergy, neighbourEnergy, temp) > Math.random()) {
                System.out.println("Accepct the new solution");
                currentSolution = new Tour(newSolution.getTour());
            }
            else{
                System.out.println("Not accepct the new solution");
            }

            // Keep track of the best solution found
            if (currentSolution.getDistance() < best.getDistance()) {
                best = new Tour(currentSolution.getTour());
            }

            System.out.println("current solution :");
            System.out.println(newSolution.getTour());
            System.out.println("Current solution distance: " + newSolution.getDistance());
            System.out.println();
            System.out.println("best solution so far we got:");
            System.out.println(best);
            System.out.println("Best solution distance: " + best.getDistance());
            
            // Cool system
            temp *= 1-coolingRate;
            System.out.println("Current temp :" +temp);
            line();
        }
       
    }
}
