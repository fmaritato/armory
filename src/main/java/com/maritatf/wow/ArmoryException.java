package com.maritatf.wow;
/**
 * @author fmaritato
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ArmoryException extends Exception {

    private static transient Log log = LogFactory.getLog(ArmoryException.class);

    public ArmoryException() {
    }

    public ArmoryException(Throwable cause) {
        super(cause);
    }

    public ArmoryException(String message) {
        super(message);
    }

    public ArmoryException(String message, Throwable cause) {
        super(message, cause);
    }

}
