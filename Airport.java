
class Airport{
    public static void main(String[] args){
        Graph map = Cities.makeMap();
        Flight.printDirectFlights(0,1,map);
    }
}
