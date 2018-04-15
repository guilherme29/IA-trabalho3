

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
        //O TEMPO É 0 ÀS 0:00 DE SEGUNDA E É ACUMULATIVO SEMPRE

        /* voos edinburgh -> london */
        for(int i=0;i<7;i++){
            mapa.insertNewArc(0, 1, 9.40 + 24*i, 10.50-9.40, "ba4733");
            mapa.insertNewArc(0, 1, 13.40 + 24*i, 14.50-13.40, "ba4773");
        }
        for(int i=0;i<5;i++){
            mapa.insertNewArc(0, 1, 19.40 + 24*i, 20.50-19.40, "ba4833");
        }
        mapa.insertNewArc(0, 1, 19.40 + 24*6, 20.50-19.40, "ba4833");

        /* voos london -> edinburgh */
        for(int i=0;i<7;i++){
            mapa.insertNewArc(1, 0, 9.40 + 24*i, 10.50-9.40, "ba4732");
            mapa.insertNewArc(1, 0, 11.40 + 24*i, 12.50-11.40, "ba4752");
        }
        for(int i=0;i<5;i++){
            mapa.insertNewArc(1, 0, 18.40 + 24*i, 19.50-18.40, "ba4822");
        }
        mapa.insertNewArc(1, 0, 18.40 + 24*6, 19.50-18.40, "ba4822");

        /* voos london -> ljubljana */
        mapa.insertNewArc(1, 2, 13.20 + 24*4, 16.20-13.20, "ju201");
        mapa.insertNewArc(1, 2, 13.20 + 24*6, 16.20-13.20, "ju213");

        /* voos london -> zurich */
        for(int i=0;i<7;i++){
            mapa.insertNewArc(1, 3, 9.10 + 24*i, 11.45-9.10, "ba614");
            mapa.insertNewArc(1, 3, 14.45 + 24*i, 17.20-14.42, "sr805");
        }

        /* voos london -> milan */
        for(int i=0;i<7;i++){
            mapa.insertNewArc(1, 4, 8.30 + 24*i, 11.20-8.30, "ba510");
            mapa.insertNewArc(1, 4, 11.00 + 24*i, 13.50-11.00, "az459");
        }

        /* voos ljubljana -> zurich */
        mapa.insertNewArc(2, 3, 11.30 + 24*1, 12.40-11.30, "ju322");
        mapa.insertNewArc(2, 3, 11.30 + 24*3, 12.40-11.30, "ju322");

        /* voos ljubljana -> london */
        mapa.insertNewArc(2, 1, 11.10 + 24*4, 12.20-11.10, "yu200");
        mapa.insertNewArc(2, 1, 11.25 + 24*4, 12.20-11.25, "yu212");

        /* voos milan -> london */
        for(int i=0;i<7;i++){
            mapa.insertNewArc(4, 1, 9.10 + 24*i, 10.00-9.10, "az458");
            mapa.insertNewArc(4, 1, 12.00 + 24*i, 13.10-12.00, "ba511");
        }

        /* voos milan -> zurich */
        for(int i=0;i<7;i++){
            mapa.insertNewArc(4, 3, 9.25 + 24*i, 10.15-9.25, "sr621");
            mapa.insertNewArc(4, 3, 12.45 + 24*i, 13.35-12.45, "sr623");
        }

        /* voos zurich -> ljubljana */
        mapa.insertNewArc(3, 2, 13.30 + 24*1, 14.40-13.30, "yu323");
        mapa.insertNewArc(3, 2, 13.30 + 24*3, 14.40-13.30, "yu323");

        /* voos zurich -> london */
        for(int i=0;i<6;i++){
            mapa.insertNewArc(3, 1, 9.00 + 24*i, 9.40-9.00, "ba613");
        }
        for(int i=0;i<5;i++){
            mapa.insertNewArc(3, 1, 16.10 + 24*i, 16.55-16.10, "sr806");
        }
        mapa.insertNewArc(3, 1, 16.10 + 24*6, 16.55-16.10, "sr806");

        /* zurich -> milan */
        for(int i=0;i<7;i++){
            mapa.insertNewArc(3, 4, 7.55 + 24*i, 8.45-7.55, "sr620");
        }


        return mapa;
    }
}
