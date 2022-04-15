package model.tableau;

import java.util.*;
import java.util.function.Consumer;

/**
 * Classe permettant de gérer un tableau d'objet de type T.
 * @param <T> le type d'objet donné sur l'appel du constructeur
 */
public class Tableau<T> implements  ITableauDynamique<T>,Iterable<T>{
    private T[] tab;

    public Tableau(){
        //tab = (T[]) (new Object[0]);
    }

    public Tableau(T[] tab) throws Exception {
        setTab(tab);
     }

    private void setTab( T[] tab ) throws Exception {
        if(Objects.isNull(tab)){
            throw new Exception("ERR sur setTab(): l'objet vaut NULL!");
        }
        this.tab = tab;
    }

    /**
     * Méthode chargée de recopier le tableau passé en paramètre
     * @param t: T[], le tableau à recopier et agrandir
     * @param decalage: int +1 pour ajouter 1 cellule au atableau, -1 pour enlever
     * @return T[] le tableau recopié
     */
    private T[] recopierAgrandir(T[] t,int decalage){

        T[] tab1 =(T[]) new Object[t.length+decalage];

        //System.out.println("tab1.lg:"+tab1.length);
        int idx=0;
        for (int i=0;i<t.length;i++){
            if(Objects.nonNull(t[i])) {
                tab1[idx] = t[i];
                idx++;
            }
        }

        return tab1;
    }

    @Override
    public T[] toArray() {
        return tab;
    }

    @Override
    public boolean isEmpty() {
        int ctr=0;
        for (T obj: tab ) {
            if(obj!=null){
                ctr++;
            }
        }
        return (ctr==0);
    }

    @Override
    public int length() {
        if(Objects.isNull(tab)){
            return 0;
        }else {
            return tab.length;
        }
    }

    @Override
    public int count() {
        int ctr=0;
        if(Objects.nonNull(tab)) {
            for (T obj : tab) {
                if (Objects.nonNull(obj)) {
                    ctr++;
                }
            }
        }
        return ctr;
    }

    @Override
    public void clear() {
        tab = null;
     }

    @Override
    public boolean contains( T obj )  {
        if(length()<=0){
            return false;
        }
        boolean trouve=false;
        int idx=0;
        if(Objects.nonNull(tab)) {
            do {
                if (Objects.nonNull(tab[idx]) && tab[idx].equals(obj)) {
                    trouve = true;
                } else {
                    idx++;
                }
            } while (!trouve && idx < tab.length);
        }
        return trouve;
    }

    @Override
    public int indexOf( T obj ) {
        boolean trouve=false;
        int idx=0;
        if(Objects.nonNull(tab)) {
            do {
                if (Objects.nonNull(tab[idx]) && tab[idx].equals(obj)) {
                    trouve = true;
                } else {
                    idx++;
                }
            } while (!trouve && idx < tab.length);
        }
        if (trouve){
            return idx;
        }else{
            return -1;
        }
    }

    @Override
    public void remove( T obj ) throws Exception {
        if(Objects.isNull(obj)){
            throw new Exception("ERR sur remove(): l'objet vaut NULL!");
        }
        if(Objects.isNull(tab)){
            throw new Exception("ERR sur remove(): le tableau est vide(NULL)");
        }
        if (contains(obj)){
            // recup indice
            int idxToSupp = indexOf(obj);
             this.tab[idxToSupp]=null;

            //recopie des éléments du tableau, en décalant vers haut
            //MEP du tableau
            this.tab = recopierAgrandir(tab,-1);
        }
    }

    @Override
    public void add( T obj ) throws Exception {
         if(Objects.isNull(obj)){
            throw new Exception("ERR sur add(): l'objet vaut NULL!");
        }
        if(this.contains(obj)){
            throw new Exception("ERR sur add(): l'objet existe déjà!");
        }
        if(Objects.isNull(tab)){
            tab = (T[]) new Object[1];
        }else{
            //Redim du tablo+1 && recopie
            //MEP du nouveau tableau
            this.tab = recopierAgrandir(tab,1);
        }

        //MEP valeur ds tablo 1
        tab[count()] = obj;

     }

    @Override
    public Iterator<T> iterator() {
            Iterator<T> it = new Iterator<T>() {

                private int currentIndex = 0;

                @Override
                public boolean hasNext() {
                    return currentIndex < tab.length && tab[currentIndex] != null;
                }

                @Override
                public T next() {
                    return tab[currentIndex++];
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
            return it;
        }

    @Override
    public void forEach( Consumer<? super T> action ) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }

    @Override
    public String toString(){
        StringBuilder sb1 = new StringBuilder("\nContenu tableau: ");
        sb1.append(System.lineSeparator());

        sb1.append(" [ ");
        for (Object obj: tab ) {
            if(Objects.nonNull(obj)) {
                sb1.append(obj.toString()).append(" , ");
            }else{
                sb1.append("NULL , ");
            }
        }
        String str = sb1.substring(0,sb1.toString().length()-3);

        StringBuilder sb = new StringBuilder(str);
        sb.append(" ]");
        sb.append(System.lineSeparator());

        return sb.toString();
    }

    @Override
    public void sort() throws Exception{
        try {
            Arrays.sort(tab);
        }catch(Exception ex){
            throw new Exception("ERR sort(): le tri n'est pas possible !");
        }
    }
}