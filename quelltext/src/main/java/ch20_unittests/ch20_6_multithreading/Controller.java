package ch20_unittests.ch20_6_multithreading;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Beispielklasse, die einen Controller mit den minimal ben�tigten Methoden 
 * zur Ansteuerung eines Ausgabeger�ts vom Typ IDisplay realisiert 
 * <br>
 * Version 3 
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class Controller
{
    private static final Logger log               = LogManager.getLogger(Controller.class);

    public static final int     ANSWER_MSG_LENGTH = 10;

    public static final int     STATUS_OFFSET     = 7;

    public int onReceivedAnswer(final byte[] answerMsgBytes)
    {
        if (answerMsgBytes != null && (answerMsgBytes.length == ANSWER_MSG_LENGTH))
        {
            final int state = calcState(answerMsgBytes);

            // ...

            return state;
        }
        else
        {
            log.warn("wrong message format! message is = '" + Arrays.toString(answerMsgBytes) + "'");
        }
        return -1;
    }

    private static int calcState(final byte[] answerMsgBytes)
    {
        final byte stateHigh = answerMsgBytes[STATUS_OFFSET];
        final byte stateLow = answerMsgBytes[STATUS_OFFSET + 1];

        return calcState(stateHigh, stateLow);
    }

    /*private*/ static int calcState(final byte highByte, final byte lowByte)
    {
        final String hexNumber = new String(new byte[]{ highByte, lowByte });
        
        return Integer.parseInt(hexNumber, 16);
    }
}
