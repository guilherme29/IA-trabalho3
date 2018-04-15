import java.util.LinkedList;
import java.util.PriorityQueue;

class Flight{
    void getDirectFlights(int sourceNode, int endNode, Graph map){
        PriorityQueue<Arc> flightList = map.findAllArcs(sourceNode,endNode);
        if(flightList.isEmpty()){
            System.out.println("Não há voos diretos.");
            return;
        }
        System.out.println("Lista dos voos diretos entre: " + Cities.getCity(sourceNode) + " -> " + Cities.getCity(endNode));
        for(Arc a : flightList){

        }
    }

    void printFlight(int sourceNode, Arc flight){
        System.out.println(Cities.getCity(sourceNode) + " -> " + Cities.getCity(flight.endNode))
        int depH = (flight.departure*100)/60;  //departure hours
        int depD = 0; //departure day
        if(depH>=24){
            depD = depH /24;
            depH = depH %24;
        }
        int depM = (flight.departure*100) %60; //departure mins
        System.out.println("Departure: " + flight.departure);
        //System.out.println("Arrival: " + flight)
    }

    String getDay(int i){
        switch(i){
            case 0: return "mo";
            case 1: return "tu";
            case 2: return "we";
            case 3: return "th";
            case 4: return "fr";
            case 5: return "sa";
            case 6: return "su";
            default: return null;
        }
    }
}
