import java.util.LinkedList;

class Flight{
    void getDirectFlights(int sourceNode, int endNode, Graph map){
        Linkedlist<Arc> flightList = map.findAllArcs(sourceNode,endNode);
    }
}
