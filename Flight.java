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
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>" + v.city +" ");
                printFlight(arc);
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
        /*
        while(trip.peek().sourceNode != sourceNode){
            trip.addFirst(paiPath[trip.peek().sourceNode]);
        }
        for(Arc flight : trip){
            printFlight(flight);
        }
        */

    }

    public static void allPathFlight(int source, int nodeA, int nodeB, int nodeC, Graph map){
        PathFlight(source, nodeA, nodeB, nodeC, map);
        PathFlight(source, nodeA, nodeC, nodeB, map);
        PathFlight(source, nodeB, nodeA, nodeC, map);
        PathFlight(source, nodeB, nodeC, nodeA, map);
        PathFlight(source, nodeC, nodeA, nodeB, map);
        PathFlight(source, nodeC, nodeB, nodeA, map);
    }

    public static void PathFlight(int source, int nodeA, int nodeB, int nodeC, Graph map){
        LinkedList<Arc> flights1 = map.findAllArcsDay(source, nodeA, "tu");
        LinkedList<Arc> flights2 = map.findAllArcsDay(nodeA, nodeB, "we");
        LinkedList<Arc> flights3 = map.findAllArcsDay(nodeB, nodeC, "th");
        LinkedList<Arc> flights4 = map.findAllArcsDay(nodeC, source, "fr");
        for(Arc a : flights1){
            for(Arc b : flights2){
                for(Arc c : flights3){
                    for(Arc d : flights4){
                        System.out.println("-------------Rota:-------------");
                        printFlight(a);
                        printFlight(b);
                        printFlight(c);
                        printFlight(d);
                    }
                }
            }
        }
    }
}
