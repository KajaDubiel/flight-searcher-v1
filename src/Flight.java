public class Flight {
    private String departurePort;
    private String arrivalPort;

    public Flight(String departurePort, String arrivalPort) {
        this.departurePort = departurePort;
        this.arrivalPort = arrivalPort;
    }

    public String getDeparturePort() {
        return departurePort;
    }

    public String getArrivalPort() {
        return arrivalPort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (!departurePort.equals(flight.departurePort)) return false;
        return arrivalPort.equals(flight.arrivalPort);
    }

    @Override
    public int hashCode() {
        int result = departurePort.hashCode();
        result = 31 * result + arrivalPort.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "departurePort='" + departurePort + '\'' +
                ", arrivalPort='" + arrivalPort + '\'' +
                '}';
    }
}
