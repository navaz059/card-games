package Exceptions;

import java.nio.charset.MalformedInputException;

/**
 * Created by Navaz on 14, Nov, 2020
 */
public class PlayerCardException extends IndexOutOfBoundException {
    public PlayerCardException(String message) {
        super(message);
    }
}
