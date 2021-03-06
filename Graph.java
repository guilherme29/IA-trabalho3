import java.util.*;
//implementado com priorityqueues e não com linkedlist para ser mais fácil ver que arco tem o próximo voo

class Graph{
        /* implementação do grafo*/
    Node verts[];
    int nvs;
    int narcs;

    Graph(int n){
        nvs = n;
        narcs = 0;
        verts = new Node[n];
        for(int i=0;i<n;i++){
            verts[i] = new Node();
        }
    }

    int numVerts(){
        return nvs;
    }

    int numArcs(){
        return narcs;
    }

    PriorityQueue<Arc> adjsNode(int i){
        return verts[i].adjs;
    }

    void insertNewArc(int curNode, int endNode, int departure, int flightTime, String flightNum){
        verts[curNode].adjs.add(new Arc(curNode, endNode, departure, flightTime, flightNum));
        narcs++;
    }

    Arc findArc(int i,int j){
        for(Arc adj : adjsNode(i)){
            if(adj.getEndNode() == j){
                return adj;
            }
        }
        return null;
    }

    PriorityQueue<Arc> findAllArcs(int i, int j){
        PriorityQueue<Arc> arcList = new PriorityQueue<>(); //assim já vem ordenados.
        for(Arc adj : adjsNode(i)){
            if(adj.getEndNode() == j){
                arcList.add(adj);
            }
        }
        return arcList;
    }

    LinkedList<Arc> findAllArcsDay(int i, int j, String day){
        LinkedList<Arc> arcList = new LinkedList<>();
        for(Arc adj : adjsNode(i)){
            if(adj.getEndNode() == j && Time.dayOfWeek(adj.flightTime).equals(day)){
                arcList.addFirst(adj);
            }
        }
        return arcList;
    }
}

class Arc implements Comparable<Arc>{
    int sourceNode;
    int endNode;
    int departure;
    int flightTime;
    String flightNum;

    Arc(int sourceNode, int endNode, int departure, int flightTime, String flightNum){
        this.sourceNode = sourceNode;
        this.endNode = endNode;
        this.departure = departure;
        this.flightTime = flightTime + 40;
        this.flightNum = flightNum;
    }

    int getEndNode(){
        return endNode;
    }

    int getDeparture(){
        return departure;
    }

    int getFlightTime(){
        return flightTime;
    }

    String getFlightNum(){
        return flightNum;
    }

    public int compareTo(Arc beta){ //a priorityQueue vai sortear com base nesta função.
        if(this.departure<beta.departure){
            return -1;
        }
        else if(this.departure>beta.departure){
            return 1;
        }
        else return 0;
    }
}

class Node implements Comparable<Node>{
    String city;
    PriorityQueue<Arc> adjs;
    int distance;

    Node(){
        adjs = new PriorityQueue<Arc>();
        distance = Integer.MAX_VALUE;
    }

    void print(){
        System.out.println(city);
    }

    int getCityNum(){
        switch(city){
            case "edinburgh":{return 0;}
            case "london":{return 1;}
            case "ljubljana":{return 2;}
            case "zurich":{return 3;}
            case "milan":{return 4;}
            default: return -1;
        }
    }

    public int compareTo(Node beta){
        return this.distance < beta.distance ? -1 : 1;
    }

}
