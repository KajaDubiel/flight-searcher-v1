import java.util.HashMap;
import java.util.Map;

public class Searcher {

    public void searchFlight(Flight flight, HashMap<String, String> flights) throws RouteNotFoundException{
        String departure = flight.getDeparturePort();
        String arrival = flight.getArrivalPort();
        boolean flightFound = false;
        for (Map.Entry<String, String> map : flights.entrySet()) {
            if (map.getKey().equals(flight.getDeparturePort())) {
                if (map.getValue().equals(flight.getArrivalPort())) {
                    System.out.println("Choosen flight is available.");
                    flightFound = true;
                } else {
                    departure = map.getValue();
                }
            }
        }

        if(flightFound != true) {
            for (Map.Entry<String, String> map : flights.entrySet()) {

                if (map.getKey().equals(departure)) {
                    if (map.getValue().equals(arrival)) {
                        System.out.println("Found flight with one change in " + departure);
                        flightFound = true;
                    } else {
                        throw new RouteNotFoundException("No flights");
                    }
                }
            }
        }
    }
}
