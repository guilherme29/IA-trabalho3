

class Cities{
    Graph makeMap(){ //função para fazer o 'mapa' do exercício
        Graph mapa = new Graph(5);
        for(int i=0;i<5;i++){
            switch(i){
                case 0:{mapa.verts[i].city = "edinburgh";  break;}
                case 1:{mapa.verts[i].city = "london";     break;}
                case 2:{mapa.verts[i].city = "ljubljana";  break;}
                case 3:{mapa.verts[i].city = "zurich";     break;}
                case 4:{mapa.verts[i].city = "milan";      break;}
            }
        }
        //insertNewArc(int curNode, int endNode, double departure, double flightTime, String flightNum)
        /* voos edinburgh -> london */
        for(int i=0;i<7;i++){
            mapa.insertNewArc(1, 0, 9.40 + 24*i, 10.50-9.40, "ba4733");
            mapa.insertNewArc(1, 0, 13.40 + 24*i, 14.50-13.40, "ba4733");
        }

        return mapa;
    }
}
