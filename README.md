# TableauList: Un tableau géré presque comme une ArrayList(java)

![DCLA](./DCLA_tableauDYN.png?raw=true "Le diagramme des classes")


Deux classes suffisent:
-une interface ItableauDynamique
-une classe Tableau

Le typage serait fait à l'intanciation de la classe Tableau<T>:
  
- une classe d'objet java: string, Integer
- ou Object
  
Simple à utiliser !(cfs javadoc)

#Exemples d'utilisation:
  
 ## le code de l'exemple 
 <code lang='java'>
   
         //Test String
        try {
            String str1="COUCOU";
            String str2="tintin";
            String str3="gilou";
            String str4 = "Albertus.DUMBELDORE";

            Tableau<String> tab  = new Tableau<String>();

            tab.add(str1);
            afficherTableau("aps  1eradd : ",tab);

            tab.clear();
            afficherTableau("aps clear : ",tab);

            tab.add(str2);
            afficherTableau("aps  add : ",tab);
            tab.add(str3);
            tab.add(str4);
            afficherTableau("0] String[]: tableau d'objets",tab);

            tab.sort();
            afficherTableau("1] sort(): tableau d'objets",tab);

            tab.remove(str3);
            afficherTableau("2] aps remove(): tableau d'objets",tab);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
  </code>
 
    
## résultat pour un tableau de chaîne:
  ![Capture écran 1](./Capture1_tableauString.PNG?raw=true "Capture d'écran")

 
