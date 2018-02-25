import java.util.HashMap;
import java.util.Map;

public class Searcher {

    public void searchFlight(Flight flight, HashMap<String, String> flights) throws RouteNotFoundException{
        String departure = flight.getDeparturePort();
        String arrival = flight.getArrivalPort();
        String newDeparture;
        String route = departure;
        boolean foundFlight = false;

        for(Map.Entry<String, String> map: flights.entrySet()){
            if(map.getKey().equals(departure)){
                if(map.getValue().equals(arrival)){
                    System.out.println("Choosen flight from " + departure + " to " + arrival + " is available.");
                    foundFlight = true;
                    break;
                } else {
                    newDeparture = map.getValue();
                }

                for(Map.Entry<String, String> mapWithChange: flights.entrySet()){
                    if(mapWithChange.getKey().equals(newDeparture)){
                        if(mapWithChange.getValue().equals(arrival)){
                            route = route + " - " + newDeparture;
                            System.out.println("Route with one change in " + newDeparture + " found. Recomended schedule: " + route +  " - " + arrival);
                            foundFlight = true;
                            break;
                        }
                    }
                }
            }
        }
        if(foundFlight == false){
            throw new RouteNotFoundException("Choosen flight is not available");
        }
    }
}
