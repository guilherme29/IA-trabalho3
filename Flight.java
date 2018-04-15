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
        System.out.println(Cities.getCity(sourceNode) + " -> " + Cities.getCity(flight.endNode));
        double depD = 0; //departure day
        double depH = (flight.departure*100)/60;  //departure hours
        if(depH>=24){
            depD = depH /24;
            depH = depH %24;
        }
        double depM = (flight.departure*100) %60; //departure mins
        System.out.print("Departure: " + getDay(depD) + " ");
        System.out.printf("%d:%d%n",depH,depM);

        double arrD = 0; //arrival day
        double arrH = ((flight.departure + flight.flightTime-0.40)*100)/60; //arival hours
        if(arrH>=24){
            arrD = arrH /24;
            arrH = arrH %24;
        }
        double arrM = ((flight.departure + flight.flightTime-0.40)*100)%60;
        System.out.print("Arrival: " + getDay(arrD) + " ");
        System.out.printf("%d:%d%n",arrH,arrM);
        System.out.println("Flight Num:" + flight.flightNum);
        System.out.println();

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

    String getDay(double i){
        if(i == 0) return "mo";
        else if(i == 1) return "tu";
        else if(i == 2) return "we";
        else if(i == 3) return "th";
        else if(i == 4) return "fr";
        else if(i == 5) return "sa";
        else if(i == 5) return "su";
        else return null;
    }
}
