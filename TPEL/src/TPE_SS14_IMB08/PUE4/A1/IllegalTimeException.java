/**
 * 
 */
package TPE_SS14_IMB08.PUE4.A1;

/**
 * Eine Exception, wenn ungueltige Werte fuer Uhrzeiten gewaehlt werden.
 * 
 * @author IMB08
 *
 */
public class IllegalTimeException extends Exception {

   
    private static final long serialVersionUID = 1L;
    
    /**
     * Erstellt eine neue IllegalTimeExceotion ohne nahere Informationen
     */
    public IllegalTimeException() {
        super();
    }
    
    /**
     * Erstellt eine neue IllegalTimeException mit einer String-Message, die 
     * naehre Auskuenfte ueber die Ursache gibt.
     * 
     * @param message Information, warum Exception geworfen wurde.
     */
    public IllegalTimeException(String message){
        super(message);
    }
    
    /**
     * Erstellt eine neue IllegalTimeException mit einer Ursache, warum sie
     * geworfen wurde
     * 
     * @param cause Ursache der Exception
     */
    public IllegalTimeException(Throwable cause){
        super(cause);
    }
    
    /**
     * Erstellt eine neue IllegalTimeExcpetion mit einer Ursache, warum sie
     * geworfen wurde und einer Message im Format-String, die diese Ursache
     * naeher beschreibt.
     * 
     * @param message Information warum Exception geworfen wurde
     * 
     * @param cause Ursache der Exception
     */
    public IllegalTimeException(String message, Throwable cause){
        super(message, cause);
    }

}
