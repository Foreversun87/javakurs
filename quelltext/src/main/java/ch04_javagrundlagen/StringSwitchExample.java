package ch04_javagrundlagen;

/**
 * Beispiel zur Demonstration der Vereinfachung von switch-Anweisungen: Es kann
 * nun über einen Stringwert die entsprechende case-Anweisung angesprungen
 * werden.
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden
 */
public final class StringSwitchExample
{
    public static void main(final String[] args)
    {
        final String[] sampleArgs = new String[] { "HeLp", "qUiT" };

        for (final String userCommand : sampleArgs)
        {
            switch (userCommand.toLowerCase())
            {
            // Angabe von Stringliteralen möglich
            case "quit":
                quit();
                break;
            case "help":
                showHelp();
                break;
            default:
                throw new IllegalArgumentException("Unsupported command '" + userCommand + "'");
            }
        }
    }

    private static void quit()
    {
        System.out.println("Quit");
    }

    private static void showHelp()
    {
        System.out.println("showHelp");
    }
}