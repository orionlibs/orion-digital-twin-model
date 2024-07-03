package io.github.orionlibs.orion_digital_twin_model.entity;

import io.github.orionlibs.core.abstraction.OrionCheckedException;

public class InvalidODTMException extends OrionCheckedException
{
    private static final String DefaultErrorMessage = "Invalid JSON-LD for the given DTDLv3.";


    public InvalidODTMException()
    {
        super(DefaultErrorMessage);
    }


    public InvalidODTMException(Object exceptionData)
    {
        super(exceptionData, DefaultErrorMessage);
    }


    public InvalidODTMException(String message)
    {
        super(message);
    }


    public InvalidODTMException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public InvalidODTMException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public InvalidODTMException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}
