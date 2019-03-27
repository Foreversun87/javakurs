package ch04_javagrundlagen.fileio;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import ch09_multithreading.intro.SleepUtils;

/**
 * Beispielprogramm für die Überwachung eines Verzeichnisses:
 * Meldet, wenn Dateien hinzugefügt oder gelöscht werden
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014, 2017 by Michael Inden 
 */
public class DirectoryObserver
{
    protected static final int DEFAULT_CHECK_INTERVAL_IN_SEC = 5;

    private final int  checkIntervalInSec;
    private final File directoryToCheck;

    public DirectoryObserver(final String nameOfDirectoryToCheck)  
    {
        this(nameOfDirectoryToCheck, DEFAULT_CHECK_INTERVAL_IN_SEC);
    }

    public DirectoryObserver(final String nameOfDirectoryToCheck, 
                             final int checkIntervalInSec)  
    {
        this.checkIntervalInSec = checkIntervalInSec;
        this.directoryToCheck = new File(nameOfDirectoryToCheck);
    }

    public void checkDirectory()
    {
        System.out.println("starting directory check");
        
        int numOfFiles = FileUtils.getContents(directoryToCheck).length;

        while (!Thread.currentThread().isInterrupted())
        {
            System.out.println("checkDirectory... '" + directoryToCheck + "'");
            if (FileUtils.directoryExists(directoryToCheck))
            {
                numOfFiles = checkForContentsChanged(numOfFiles);
            }
            else
            {
                onDirectoryNotExisting();
                numOfFiles = 0;
            }
            SleepUtils.safeSleep(TimeUnit.SECONDS, checkIntervalInSec);
            System.out.println("...checkDirectory");
        }
    }

    protected int checkForContentsChanged(final int numOfExpectedFiles)
    {
        final String[] currentContents = FileUtils.getContents(directoryToCheck);

        if (currentContents.length != numOfExpectedFiles)
        {
            onContentsChanged(currentContents.length, numOfExpectedFiles);
        }
        return currentContents.length;
    }

    // Callback-Methode 
    protected void onContentsChanged(final int newFileCount, 
                                     final int oldFileCount)
    {
        System.out.println("new FileCount=" + newFileCount + " / " + 
                           "old FileCount=" + oldFileCount);
    }

    // Callback-Methode  
    protected void onDirectoryNotExisting()
    {
        System.out.println("missing directory='" + directoryToCheck + "'");
    }

    public static void main(final String[] args) throws IOException
    {
		// Zugriff auf das systemspezifische tmp-Directory 
		final String tmpDir = System.getProperty("java.io.tmpdir");
		new DirectoryObserver(tmpDir).checkDirectory();
   }    
    //...

    protected final int getCheckIntervalInSec()
    {
        return checkIntervalInSec;
    }

    protected final File getDirectoryToCheck()
    {
        return directoryToCheck;
    }
}