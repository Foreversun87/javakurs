package ch04_javagrundlagen.fileio;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.TimeUnit;

import ch09_multithreading.intro.SleepUtils;

/**
 * Das Verzeichnisüberwachungsprogramm mit den Neuerungen von JDK 7 gestaltet.
 *  
 * @author Michael Inden
 * 
 * Copyright 2011, 2014, 2017 by Michael Inden 
 */
public class DirectoryCheckerWithWatchService extends DirectoryObserver
{
    private final Path         pathToCheck;
    private final WatchService watchService;
    private WatchKey           registerKey;

    public DirectoryCheckerWithWatchService(final String nameOfDirectoryToCheck) throws IOException
    {
        super(nameOfDirectoryToCheck);
        
        this.pathToCheck = Paths.get(nameOfDirectoryToCheck);
        this.watchService = FileSystems.getDefault().newWatchService();
        this.registerKey = pathToCheck.register(watchService, ENTRY_CREATE, 
        	   			                        ENTRY_DELETE, ENTRY_MODIFY);
    }

    @Override
    public void checkDirectory()
    {
        System.out.println("starting directory check for directory='" + 
                           getDirectoryToCheck() + "'");
        
        int numOfFiles = FileUtils.getContents(getDirectoryToCheck()).length;

        while (!Thread.currentThread().isInterrupted())
        {
            System.out.println("checkDirectory...");
            if (FileUtils.directoryExists(getDirectoryToCheck()))
            {
                numOfFiles = checkForContentsChanged(numOfFiles);
            }
            else
            {
                onDirectoryNotExisting();
                SleepUtils.safeSleep(TimeUnit.SECONDS, getCheckIntervalInSec());
                numOfFiles = 0;
            }
            System.out.println("...checkDirectory");
        }
        
        registerKey.cancel();
    }
    
    @Override
    protected int checkForContentsChanged(final int numOfFiles)
    {
        try
        {
            // $\mbox{\bfseries blockierend auf ï¿½nderungen warten }$
            final WatchKey key = watchService.take();
            
            for (final WatchEvent<?> event : key.pollEvents())
            {
                reportModification(event);
            }
            key.reset();
        }
        catch (final InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        return FileUtils.getContents(getDirectoryToCheck()).length;
    }

    private void reportModification(final WatchEvent<?> event)
    {
        final Path file = (Path) event.context();
        System.out.println(event.kind() + ":" + file);
    }

    public static void main(final String[] args) throws IOException
    {
        // Zugriff auf das systemspezifische tmp-Directory      
        final String tmpDir = System.getProperty("java.io.tmpdir");
        new DirectoryCheckerWithWatchService(tmpDir).checkDirectory();
    }
}