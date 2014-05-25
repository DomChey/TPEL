package TPE_SS14_IMB08.PUE3;


/**
* Einfache Datenstruktur zur Verwaltung einer Reihe von Elementen.
*
* @param <T> Typ der gespeicherten Elemente.
*/
public interface List<T> extends Iterable<T> {
/**
* Ueberpueft, ob ein Element bereits vorhanden ist.
*
* @param e Element auf das geprueft werden soll
* @return true wenn vorhanden, andernfalls false
*/
public abstract boolean contains(Object e);
/**
* Fuegt am Ende ein Element hinzu.
*
* @param e Element, das hinzugefuegt werden soll.
* @return ist immer true
*/
public abstract boolean add(T e);
public abstract void addLast(T e);
/**
* Fuegt am Anfang ein Element hinzu.
*
* @param e Element, das angefuegt werden soll.
*/
public abstract void addFirst(T e);
/**
* Liefert das erste Element zurueck, ohne es zu entfernen.
*
* @return das erste Element.
*/
public abstract T peekFirst();
/**
* Ueberprueft, ob Elemente vorhanden sind.
*
* @return true wenn die Datenstruktur leer ist, andernfalls false
*/
public abstract boolean isEmpty();
/**
* Entfernt das erste Element und liefert es zurueck.
*
* @return das erste Element
*/
public abstract T pollFirst();
/**
* Loescht den Inhalt der List.
*/
public abstract void clear();

}

