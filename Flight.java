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
            printFlight(flight);
        }
    }

    public static void printFlight(Arc flight){
        System.out.println(Cities.getCity(flight.sourceNode) + " -> " + Cities.getCity(flight.endNode));
        System.out.println("Departure: " + Time.getTime(flight.getDeparture()));
        System.out.println("Arrival: " + Time.getTime(flight.getDeparture() + flight.getFlightTime() - 40));
        System.out.println("Flight num: " + flight.getFlightNum());
        System.out.println("------------");
    }

    public static void printDijkstraFlight(int sourceNode, int endNode, Graph map){
        int[] pai = new int[5];
        Arc[] paiPath = new Arc[5]; //arco que vai dar ao pai de cada nó
        //as distancias já são guardadas nos próprios nós.
        for(int i=0;i<5;i++){
            pai[i] = -1;
        }
        map.verts[sourceNode].distance = 0;
        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        for(int i=0;i<5;i++){ queue.add(map.verts[i]);} //adiciona-se as cidades todas à queue.

        while(!queue.isEmpty()){
            Node v = queue.remove();
            for(Arc arc : v.adjs){
                if(v.distance + arc.getFlightTime() < map.verts[arc.endNode].distance && v.distance  <= arc.getDeparture() ){
                    //faz-se apenas se o voo ainda não aconteceu.
                    map.verts[arc.endNode].distance = v.distance + arc.getFlightTime();
                    pai[endNode] = v.getCityNum();
                    paiPath[endNode] = arc;
                    queue.add(map.verts[endNode]);//expande-se o nó
                }
            }
        }
        LinkedList<Arc> trip = new LinkedList<>();
        trip.addFirst(paiPath[endNode]);
        while(trip.peek().sourceNode != sourceNode){
            trip.addFirst(paiPath[trip.peek().sourceNode]);
        }
        for(Arc flight : trip){
            printFlight(flight);
        }
        System.out.println("HEY");
        printFlight(paiPath[3]);
        printFlight(paiPath[4]);

    }

    public static void printPath(int[] pai, Arc[] paiPath, int sourceNode, int endNode){

    }

}
