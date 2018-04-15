import java.util.LinkedList;
import java.util.PriorityQueue;

class Flight{
    void getDirectFlights(int sourceNode, int endNode, Graph map){
        PriorityQueue<Arc> flightList = map.findAllArcs(sourceNode,endNode);
        if(flightList.isEmpty()){
            System.out.println("Não há voos diretos.");
            return;
        }
        System.out.println("Lista dos voos diretos entre");
    }
}
