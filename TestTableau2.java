package model.tableau;


import java.util.Arrays;

public class TestTableau2 {

    private static void afficherTableau( String msg, Tableau tab){
        StringBuilder sb = new StringBuilder(msg);

        sb.append(tab.toString());
        sb.append("length=").append(tab.length());

        System.out.println(sb.toString());
    }

    public static void main( String[] args ) {
        //Test String
        try {
            String str1="COUCOU";
            String str2="tintin";
            String str3="gilou";
            String str4 = "Albertus.DUMBELDORE";

            Tableau<String> tab  = new Tableau<String>();

            tab.remove(str3);
            afficherTableau("00] aps remove(): tableau d'objets",tab);

            tab.add(str1);
            afficherTableau("aps  1eradd : ",tab);
            //tab.clear();
            //afficherTableau("aps clear : ",tab);

            tab.add(str2);
            afficherTableau("aps  add : ",tab);
            tab.add(str3);
            tab.add(str4);
            afficherTableau("0] String[]: tableau d'objets",tab);

            tab.sort();
            afficherTableau("1] sort(): tableau d'objets",tab);

            tab.remove(str3);
            afficherTableau("2] aps remove(): tableau d'objets",tab);


/*
            //Tableau d'object
            Object[] tabObjets = new Object[5];
            tabObjets[0] = str1;
            tabObjets[1] = str2;
            tabObjets[2] = new Integer(12);
            tabObjets[3] = str3;
            tabObjets[4] = new Double(6.55);

            Tableau<Object> tabW= new Tableau<>(tabObjets);

            int nb1 = 256;
            tabW.add(nb1);
            tabW.add(str4);
            afficherTableau("1] forEach(): tableau d'objets",tabW);

            tabW.remove(nb1);
            afficherTableau("2] aps remove(): tableau d'objets",tabW);

            tabW.add(nb1);
            afficherTableau("3] aps add(): tableau d'objets",tabW);

             tabW.sort();
*/
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
