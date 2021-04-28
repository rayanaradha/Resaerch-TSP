
Simulated Annealing



What is Simulated Annealing
===========================

SA concepts come from the real time cooling process. When the temperature is high Atoms can move freely. When the temperature reduces, atoms move also gets reduced. 
Likewise in algorithms we first give a chance to go to several solutions without ignoring them . It helps to jump over the local maxima.but we slowly reduce the chance of getting wrong answers and get the value which is more closely to extract a solution.


How do we achieve this in Algorithms
====================================
In simulated annealing we keep a temperature variable to simulate this heating process. We initially set it high and then allow it to slowly ‘cool’ as the algorithm runs. 
While this temperature variable is high the algorithm will be allowed, with more frequency, to accept solutions that are worse than our current solution. This gives the algorithm the ability to jump out of any local optimums it finds itself in early on in execution.
As the temperature is reduced so it reduces the chance of accepting worse solutions, therefore allowing the algorithm to gradually focus in on an area of the search space in which hopefully, a close to optimum solution can be found.

How we select the neighbouring node
===================================
In the algorithm we generate the neighbours of the current node, need to choose one of them and need to move to it. For that,
We check if the neighbour solution is better than our current solution. If it is, we accept it unconditionally.

A neighbour solution isn’t better. We need to consider a couple of factors.
how much worse the neighbour solution.
how high the current ‘temperature’ of our system is.

Maths behind the selecting next node
====================================
c = current node
n = next node.

evl (c) = evolution value (energy value) of c.
evl (n) = evolution value (energy value) of n.

We can define ΔE, 
ΔE = evl (n)  - evl (c) 

Using ΔE we can define the probability value for the next node, which helps to identify whether that node is acceptable or not. 

Math.exp ( ΔE / T )


We needed this function only the case that evl (c) > evl (n), so every time  this function returns a value between 0 and 1.   

If we consider this function it is clear that,

When Temperature high => acceptable probability value High  => more like the Random search.
When Temperature Low  =>  acceptable probability value less =>  more like the Hill Climbing.

When  ΔE  high => acceptable probability value less.
When  ΔE  less => acceptable probability value high.

In the algorithm we compare this acceptable probability value with a random probability value to determine whether it is acceptable or not. Why?
If the accepted probability is 0.3 for instance, a random number between 0 and 1 will be less than or equal to this value only in 30% of all possible cases. 
A new random number needs to be drawn in every iteration of the algorithm, otherwise the following code would be executed either always or never, for a given run of the algorithm.



How can we Initialize a Temperature Initialisation in the beginning?
====================================================================
For better optimisation, when initialising the temperature variable we should select a temperature that will initially allow for practically any move against the current solution. This gives the algorithm the ability to better explore the entire search space before cooling and settling in a more focused region.



 Algorithm for Simulated Annealing
==================================
Combining all the above described things we can generate the algorithm for simulated annealing.

First we need to set the initial temperature and create a random initial solution.
Then we begin looping until our stop condition is met. Usually either the system has sufficiently cooled, or a good-enough solution has been found.
From here we select a neighbour by making a small change to our current solution
We then decide whether to move to that neighbour solution.
Finally, we decrease the temperature and continue looping. 



Pseudocode for Simulated Annealing
==================================

1:  INITIALIZE startTemperature, endTemperature, maxNumberIterations
2:  coolingRate = eˆ(log(endTemperature/startTemperature)/maxNumberIterations)
3:  INITIALIZE dataStructures
4:  COMPUTE initialSolution
5:  INITIALIZE currentSolution, bestSolution, currentObjective, bestObjective
6:  currentTemperature = startTemperature ∗ initialObjective
7:  globalIteration = 0
8:  WHILE currentTemperature > endTemperature ∗ initialObjective DO
9:        currentTemperature = currentTemperature ∗ coolingRate
10:      EXECUTE randomMove(movesWeight, currentSolution)
11:      tentativeObjective = currentObjective + moveCost
12:      accept = eˆ(currentObjective − tentativeObjective)/currentTemperature)
13:      IF random([0,1]) ≤ accept THEN
14:      currentSolution = tentativeSolution
15:          IF tentativeObjective < bestObjective THEN
16:               bestSolution = tentativeSolution
17:          END IF
18:       END IF
19:       globalIteration = globalIteration +1
20: END WHILE
21: PRINT bestSolution, bestObjective



So, Now time to implement the part, with the all knowledge grather on the simulated annealing process implement this java code which gives a solution for the classical traveling salesman problem.this solution contains 4 classes.

City
Contain the variable/ attribute related to city
Calculate the distance between 2 cities.

Tour Management
Add the initial detail about the all cities.

Tour  
Calculate the complete distance for each possible solution.	

Simulated Annealing
Main function, execute the simulated annealing process.
