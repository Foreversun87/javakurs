package ch20_unittests.ch20_6_multithreading;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

import ch09_multithreading.intro.SleepUtils;

/**
 * Testklasse für die Klasse MessageConcatenator 
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014, 2017 by Michael Inden
 */
public class MessageConcatenatorTest 
{
    private MessageConcatenator messageConcatenator;
    private IDisplay            testDisplay;

    @Before
    public void setUp()
    {
        testDisplay = new SimulationDisplay();
        messageConcatenator = new MessageConcatenator(testDisplay);
    }

    // ...

	@Test
    public void testExplicitFlush()
    {
        // Deaktivieren des AUTO-FLUSHINGs  
        messageConcatenator.enableAutoFlush(false);

        messageConcatenator.sendMessage(createTextMsg(SampleData.TEXT_40));
        assertEquals(40 + 10, messageConcatenator.getBufferedMsgLength());

        // Explizites Flushen, Erwartung: Rest 0  
        messageConcatenator.flush();
        assertEquals(0, messageConcatenator.getBufferedMsgLength());
    }

	@Test
    public void testOverflow()
    {
        // Deaktivieren des AUTO-FLUSHINGs 
        messageConcatenator.enableAutoFlush(false);

        // Fï¿½lle Puffer bis kurz vor Lï¿½ngen-ï¿½berschreitung: 90 + 110 + 30 = 230 
        messageConcatenator.sendMessage(createTextMsg(SampleData.TEXT_80));
        assertEquals(80 + 10, messageConcatenator.getBufferedMsgLength());
        messageConcatenator.sendMessage(createTextMsg(SampleData.TEXT_100));
        assertEquals(90 + 100 + 10, messageConcatenator.getBufferedMsgLength());
        messageConcatenator.sendMessage(createTextMsg(SampleData.TEXT_20));
        assertEquals(200 + 20 + 10, messageConcatenator.getBufferedMsgLength());

        // Erzwinge Flush durch Längen-Überschreitung: 230 + 70 = 300
        // Daher sollte die folgende Nachricht den Puffers leeren 
        messageConcatenator.sendMessage(createTextMsg(SampleData.TEXT_60));
        // Hier sollte noch ein Rest von 70 Bytes existieren 
        assertEquals(60 + 10, messageConcatenator.getBufferedMsgLength());
    }

	@Test
    public void testAutoFlush()
    {
        // Aktivieren des AUTO-FLUSHINGs
        messageConcatenator.enableAutoFlush(true);

        messageConcatenator.sendMessage(createTextMsg(SampleData.TEXT_80));
        assertEquals(80 + 10, messageConcatenator.getBufferedMsgLength());

        // Prüe Auto-Flush: Warte 1 Sekunde, dann Erwartung: Rest 0
        waitForOneSecond();
        assertEquals(0, messageConcatenator.getBufferedMsgLength());
    }

	@Test
    public void testOverflow_Then_AutoFlush()
    {
        // Aktivieren des AUTO-FLUSHINGs 
        messageConcatenator.enableAutoFlush(true);

        // Erzwinge Flush durch Längen-ï¿½berschreitung
        messageConcatenator.sendMessage(createTextMsg(SampleData.TEXT_80));
        assertEquals(80 + 10, messageConcatenator.getBufferedMsgLength());
        messageConcatenator.sendMessage(createTextMsg(SampleData.TEXT_100));
        assertEquals(90 + 100 + 10, messageConcatenator.getBufferedMsgLength());

        // Die nächste Nachricht der Länge 90 passt nicht mehr: 90 + 110 + 90 = 290 
        messageConcatenator.sendMessage(createTextMsg(SampleData.TEXT_80));
        assertEquals(80 + 10, messageConcatenator.getBufferedMsgLength());

        // Prüfe Auto-Flush: Warte 1 Sekunde, dann Erwartung: Rest 0
        waitForOneSecond();
        assertEquals(0, messageConcatenator.getBufferedMsgLength());
    }

    @Test
    public void testAutoFlush_Then_Overflow()
    {
        // Aktivieren des AUTO-FLUSHINGs
        messageConcatenator.enableAutoFlush(true);

        // Sende Nachricht
        messageConcatenator.sendMessage(createTextMsg(SampleData.TEXT_100));
        assertEquals(100 + 10, messageConcatenator.getBufferedMsgLength());

        // Prüfe Auto-Flush: Warte 1 Sekunde, dann Erwartung: Rest 0
        waitForOneSecond();
        assertEquals(0, messageConcatenator.getBufferedMsgLength());

        // Erzwinge Flush durch Längen-Überschreitung
        messageConcatenator.sendMessage(createTextMsg(SampleData.TEXT_100));
        assertEquals(100 + 10, messageConcatenator.getBufferedMsgLength());
        messageConcatenator.sendMessage(createTextMsg(SampleData.TEXT_100));
        assertEquals(110 + 100 + 10, messageConcatenator.getBufferedMsgLength());

        // Die nächste Nachricht der Länge 50 passt nicht mehr: 220 + 50 = 270
        messageConcatenator.sendMessage(createTextMsg(SampleData.TEXT_40));
        assertEquals(40 + 10, messageConcatenator.getBufferedMsgLength());
    }

    private static void waitForOneSecond()
    {
        SleepUtils.safeSleep(TimeUnit.SECONDS, 1);
    }

    private static DisplayMsg createTextMsg(final String text)
    {
        return new DisplayMsg(text);
    }
}
