import java.util.HashMap;
import java.util.Scanner;

public class FlightApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj miejsce wylotu: ");
        String departure = sc.nextLine();
        System.out.println("Podaj lotnisko docelowe: ");
        String arrival = sc.nextLine();

        Flight demandFlight = new Flight(departure, arrival);

        HashMap<String, String> availableFlights = new HashMap<>();

        availableFlights.put("Szczecin", "Dublin");
        availableFlights.put("Moskwa", "Berlin");
        availableFlights.put("Dublin", "Rzym");
        availableFlights.put("Neapol", "Rzym");
        availableFlights.put("Berlin", "Porto");
        availableFlights.put("Rzym", "Warszawa");
        availableFlights.put("Warszawa", "Moskwa");
        availableFlights.put("Majorka", "Neapol");

        Searcher searcher = new Searcher();
        try{
            searcher.searchFlight(demandFlight, availableFlights);
        } catch (RouteNotFoundException e){
            System.out.println("Sorry, there is no flight available");
        }

    }
}
