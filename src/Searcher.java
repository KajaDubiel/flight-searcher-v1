import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Searcher {

    public void searchFlight(Flight flight, HashMap<String, String> flights) throws RouteNotFoundException {
        String departure = flight.getDeparturePort();
        String arrival = flight.getArrivalPort();
        String route = departure;
        boolean foundFlight = false;

        for (Map.Entry<String, String> map : flights.entrySet()) {
            if (map.getKey().equals(departure)) {
                if (map.getValue().equals(arrival)) {
                    route = route + " - " + arrival;
                    foundFlight = true;
                } else {
                    departure = map.getValue();
                    route = route + " - " + departure;
                    Flight flight1 = new Flight(departure, arrival);
                    searchFlight(flight1, flights);
                }
            }
        }
        if (foundFlight == true) {
            System.out.println("Your route : " + route);
        } else {
            throw new RouteNotFoundException("EXCEPTION!");
        }
    }
}
