package tn.iit.storemanagement.web.rest.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ErrorSM  extends Error{

    public ErrorSM(String message)
    {
        super (message);
    }


    public ErrorSM(String message, Throwable cause) {
        super (message, cause);
    }
    public ErrorSM(String message,String messageException)
    {
        super(message,new Throwable (messageException));
    }

    public ErrorSM(Throwable cause) {
        super (cause);
    }

}
