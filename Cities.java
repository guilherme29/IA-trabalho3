

class Cities{
    public static Graph makeMap(){ //função para fazer o 'mapa' do exercício
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
        //O TEMPO É 0 ÀS 0:00 DE SEGUNDA E É ACUMULATIVO SEMPRE

        // voos edinburgh -> london 
        for(int i=0;i<7;i++){
            mapa.insertNewArc(0, 1, (9*60+40) + 24*60*i, (10*60+50)-(9*60+40), "ba4733");
            mapa.insertNewArc(0, 1, (13*60+40) + 24*60*i, (14*60+50)-(13*60+40), "ba4773");
        }
        for(int i=0;i<5;i++){
            mapa.insertNewArc(0, 1, (19*60+40) + 24*60*i, (20*60+50)-(19*60+40), "ba4833");
        }
        mapa.insertNewArc(0, 1, (19*60+40) + 24*6, (20*60+50)-(19*60+40), "ba4833");

        // voos london -> edinburgh
        for(int i=0;i<7;i++){
            mapa.insertNewArc(1, 0, (9*60+40) + 24*60*i, (10*60+50)-(9*60+40), "ba4732");
            mapa.insertNewArc(1, 0, (11*60+40) + 24*60*i, (12*60+50)-(11*60+40), "ba4752");
        }
        for(int i=0;i<5;i++){
            mapa.insertNewArc(1, 0, (18*60+40) + 24*60*i, (19*60+50)-(18*60+40), "ba4822");
        }
        mapa.insertNewArc(1, 0, (18*60+40) + 24*60*6, (19*60+50)-(18*60+40), "ba4822");

        // voos london -> ljubljana
        mapa.insertNewArc(1, 2, (13*60+20) + 24*60*4, (16*60+20)-(13*60+20), "ju201");
        mapa.insertNewArc(1, 2, (13*60+20) + 24*60*6, (16*60+20)-(13*60+20), "ju213");

        // voos london -> zurich
        for(int i=0;i<7;i++){
            mapa.insertNewArc(1, 3, (9*60+10) + 24*60*i, (11*60+45)-(9*60+10), "ba614");
            mapa.insertNewArc(1, 3, (14*60+45) + 24*60*i, (17*60+20)-(14*60+45), "sr805");
        }

        // voos london -> milan
        for(int i=0;i<7;i++){
            mapa.insertNewArc(1, 4, (8*60+30) + 24*60*i, (11*60+20)-(8*60+30), "ba510");
            mapa.insertNewArc(1, 4, (11*60+00) + 24*60*i, (13*60+50)-(11*60+00), "az459");
        }

        // voos ljubljana -> zurich
        mapa.insertNewArc(2, 3, (11*60+30) + 24*60*1, (12*60+40)-(11*60+30), "ju322");
        mapa.insertNewArc(2, 3, (11*60+30) + 24*60*3, (12*60+40)-(11*60+30), "ju322");

        // voos ljubljana -> london
        mapa.insertNewArc(2, 1, (11*60+10) + 24*60*4, (12*60+20)-(11*60+10), "yu200");
        mapa.insertNewArc(2, 1, (11*60+25) + 24*60*4, (12*60+20)-(11*60+25), "yu212");

        // voos milan -> london
        for(int i=0;i<7;i++){
            mapa.insertNewArc(4, 1, (9*60+10) + 24*60*i, (10*60+00)-(9*60+10), "az458");
            mapa.insertNewArc(4, 1, (12*60+00) + 24*60*i, (13*60+10)-(12*60+00), "ba511");
        }

        // voos milan -> zurich
        for(int i=0;i<7;i++){
            mapa.insertNewArc(4, 3, (9*60+25) + 24*60*i, (10*60+15)-(9*60+25), "sr621");
            mapa.insertNewArc(4, 3, (12*60+45) + 24*60*i, (13*60+35)-(12*60+45), "sr623");
        }

        // voos zurich -> ljubljana
        mapa.insertNewArc(3, 2, (13*60+30) + 24*60*1, (14*60+40)-(13*60+30), "yu323");
        mapa.insertNewArc(3, 2, (13*60+30) + 24*60*3, (14*60+40)-(13*60+30), "yu323");

        // voos zurich -> london
        for(int i=0;i<6;i++){
            mapa.insertNewArc(3, 1, (9*60+00) + 24*60*i, (9*60+40)-(9*60+00), "ba613");
        }
        for(int i=0;i<5;i++){
            mapa.insertNewArc(3, 1, (16*60+10) + 24*60*i, (16*60+55)-(16*60+10), "sr806");
        }
        mapa.insertNewArc(3, 1, (16*60+10) + 24*60*6, (16*60+55)-(16*60+10), "sr806");

        // voos zurich -> milan
        for(int i=0;i<7;i++){
            mapa.insertNewArc(3, 4, (7*60+55) + 24*60*i, (8*60+45)-(7*60+55), "sr620");
        }


        return mapa;
    }

    public static String getCity(int i){
        switch(i){
            case 0:{return "edinburgh";}
            case 1:{return "london";}
            case 2:{return "ljubljana";}
            case 3:{return "zurich";}
            case 4:{return "milan";}
            default: return null;
        }
    }
}
