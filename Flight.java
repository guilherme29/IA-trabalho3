import java.util.LinkedList;
import java.util.PriorityQueue;

class Flight{
    public static void printDirectFlights(int sourceNode, int endNode, Graph map){
        PriorityQueue<Arc> flightList = map.findAllArcs(sourceNode,endNode);
        if(flightList.isEmpty()){
            System.out.println("Não há voos diretos.");
            return;
        }
        System.out.println("Lista dos voos diretos entre: " + Cities.getCity(sourceNode) + " -> " + Cities.getCity(endNode));
        for(Arc flight : flightList){
            printFlight(sourceNode,flight);
        }
    }

    public static void printFlight(int sourceNode, Arc flight){
        System.out.println(Cities.getCity(sourceNode) + " -> " + Cities.getCity(flight.endNode));
        System.out.println("Departure: " + Time.getTime(flight.getDeparture()));
        System.out.println("Arrival: " + Time.getTime(flight.getDeparture() + flight.getFlightTime() - 40));
        System.out.println("Flight num: " + flight.getFlightNum());
    }

}
