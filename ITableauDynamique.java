package model.tableau;

/**
 * Interface décrivant tous les services d'un TableauDynamique de type T.
 * @param <T> le type d'objet contenu
 */
public interface ITableauDynamique<T> {
    /**
     * Méthode chargée de renvoyer le tableau d'objet (GETTER).
     * @return T[] le tableau de T
     */
    T[] toArray();

    /**
     * Méthode chargée de renvoyer si le tableau est vide ou pas.
     * @return boolean TRUE si vide sinon FALSE
     */
    boolean isEmpty();

    /**
     * Méthode chargée de renvoyer la longueur du tableau.
     * @return int, la longueur
     */
    int length();

    /**
     * Méthode chargée de renvoyer le nombre d'élément non NULL dans le tableau.
     * @return int, le nombre
     */
    int count();

    /**
     * Méthode chargée d'effacer le contenu du tableau.
     */
    void clear();

    /**
     * Méthode chargée de supprimer un objet dans le tableau.
     * @param obj: T, un objet de type T
     * @throws Exception sera levée en cas de problème
     */
    void remove(T obj)throws Exception;

    /**
     * Méthode chargée d'ajouter un objet dans le tableau.
     * @param obj: T, un objet de type T
     * @throws Exception sera levée en cas de problème
     */
    void add(T obj) throws Exception;

    /**
     * Méthode chargée de renvoyer si l'objet existe dans le tableau.
     * @param obj:T, l'objet à rechercher
     * @return boolean, TRUE si existe, sinon FALSE
     */
    boolean contains(T obj) ;

    /**
     * Méthode chargée de renvoyer l'indice de l'objet si il existe dans le tableau.
     * @param obj:T, l'objet recherché
     * @return int -1 si pas trouvé, sinon l'indice (à partir de 0)
     */
    int indexOf(T obj);

    /**
     * Méthode chargée de trier le contenu du tableau.
     * @throws Exception sera levée en cas de problème (tableau d'Object par exemple)
     */
    void sort() throws Exception;
}
