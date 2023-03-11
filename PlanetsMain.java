import java.util.*;

/** 
 * Prints facts about planets - practice using Collections methods
 * Harshitha Sayini
 */


class SortByName implements Comparator<planets.Planet> {

    public int compare(planets.Planet a, planets.Planet b)
    {
        return a.getName().compareTo(b.getName());
    }
}
class SortByDistance implements Comparator<planets.Planet> {

    public int compare(planets.Planet a, planets.Planet b)
    {
        return (int) (a.getDistance()-b.getDistance());
    }
}

class SortByMass implements Comparator<planets.Planet> {

    public int compare(planets.Planet a, planets.Planet b)
    {
        return (int) (a.getMass()-b.getMass());
    }
}

public class PlanetsMain {

    public static void main(String[] args) {

        // Source https://nssdc.gsfc.nasa.gov/planetary/factsheet/
        List<planets.Planet> planets = new ArrayList<>(9);
        planets.add(new planets.Planet("Mercury", 0.33, 58));
        planets.add(new planets.Planet("Venus", 4.87, 108));
        planets.add(new planets.Planet("Earth", 5.97, 150));
        planets.add(new planets.Planet("Mars", .642, 228));
        planets.add(new planets.Planet("Jupiter", 1898, 779));
        planets.add(new planets.Planet("Saturn", 568, 1434));
        planets.add(new planets.Planet("Uranus", 86.8, 2873));
        planets.add(new planets.Planet("Neptune", 102, 4495));
        planets.add(new planets.Planet("Pluto", 0.0146, 5906));

        System.out.println("Orignal order:");
        printPlanets(planets);

        // Randomize the order of the planets
        Collections.shuffle(planets);
        System.out.println("Planets in a random order:");
        printPlanets(planets);

        // Remove pluto
        for(int i = 0; i < planets.size(); i++)
        {
            if(planets.get(i).getName().equals("Pluto"))
                planets.remove(i);
        }
        System.out.println("Removed Pluto:");
        printPlanets(planets);

        // Sort by distance from sun using Natural Ordering (Hint: Implement Planet.compareTo)
        System.out.println("Sorted by distance from sun:");
        Collections.sort(planets, new SortByDistance());
        printPlanets(planets);

        // Sort alphabetically (Hint: you need a Comparator class)
        System.out.println("Sorted alphabetically:");
        Collections.sort(planets, new SortByName());
        printPlanets(planets);

        // Sort by mass (Hint: you need a Comparator class)
        Collections.sort(planets, new SortByMass());
        System.out.println("Sorted by mass:");
        printPlanets(planets);

        // Add each planet in your list to a Map (name => Planet)
        Map<String, planets.Planet> planetMap = new HashMap<>();
        for(int i = 0; i < planets.size(); i++)
        {
            planetMap.put(planets.get(i).getName(), planets.get(i));
        }

        System.out.println("Earth:" + planetMap.get("Earth"));
        // Retrieve and print Mars
        System.out.println("Mars:" + planetMap.get("Mars"));


    }

    /**
     * Print the planet list in a table
     */
    private static void printPlanets(List<planets.Planet> planets) {
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-10s%-15s%-10s%n%n", "Planet", "Mass", "Distance");
        for (planets.Planet planet : planets) {
            System.out.printf("%-10s%-15.3f%-10d%n", planet.getName(),
                    planet.getMass(), planet.getDistance());
        }
        System.out.println("------------------------------------------------------------\n\n");
    }

}
