import java.util.PriorityQueue;
//implementado com priorityqueues e não com linkedlist para ser mais fácil ver que arco tem o próximo voo

class Graph{
    class Node{
        String city;
        PriorityQueue<Arc> adjs;

        Node(){
            adjs = new PriorityQueue<Arc>();
        }

        void print(){
            System.out.println(city);
        }

    class Arc implements Comparable<Arc>{
        int endNode;
        float departure;
        float arrival;
        float flightTime;
        String flightNum;
    //    boolean[] days; //segunda-feira é o 0

        Arc(int endNode, float departure, float arrival, float flightTime, String flightNum){
            this.endNode = endNode;
            this.departure = departure;
            this.arrival = arrival;
            this.flightTime = flightTime;
            this.flightNum = flightNum;
            //this.days = days;
        }

        int getEndNode(){
            return endNode;
        }

        float getFlightTime(){
            return flightTime;
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

    /* implementação do grafo*/
    Node verts[];
    int nvs;
    int narcs;

    Graph(int n){
        nvs = n;
        narcs = 0;
        verts = new Node[n+1];
        for(int i=0;i<=n;i++){
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

    void insertNewArc(int curNode, int endNode, float departure, float arrival, float flightTime, String flightNum){
        verts[curNode].adjs.add(new Arc(endNode, departure, arrival, flightTime, flightNum));
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
}
