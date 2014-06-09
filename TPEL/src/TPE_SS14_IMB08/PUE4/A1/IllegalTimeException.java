/**
 * 
 */
package TPE_SS14_IMB08.PUE4.A1;

/**
 * @author IMB08
 *
 */
public class IllegalTimeException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * 
     */
    public IllegalTimeException() {
        super();
    }
    public IllegalTimeException(String message){
        super(message);
    }
    
    public IllegalTimeException(Throwable cause){
        super(cause);
    }
    
    public IllegalTimeException(String message, Throwable cause){
        super(message, cause);
    }

}
