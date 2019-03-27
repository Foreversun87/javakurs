package ch20_unittests.ch20_4_junit_rules;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 * Unit-Tests zur Demonstration der JUnit Rule TemporaryFolder
 * 
 * @author Michael Inden
 * 
 * Copyright 2014, 2017 by Michael Inden
 */
public class TemporaryFolderTest 
{
   @Rule
   public TemporaryFolder folder = new TemporaryFolder();

   @Test
   public void testUsingTempFolder() throws IOException 
   {
      // $\mbox{\bfseries Ermittle den Inhalt des Temp-Folders, normales File-API }$
      final String[] dirContentsInitial = folder.getRoot().list();
      assertEquals(0, dirContentsInitial.length);

      final File subFolder = folder.newFolder("subfolder");
      final File createdFile = folder.newFile("abc.txt");

      // $\mbox{\bfseries Ermittle den Inhalt des Temp-Folders, normales File-API }$
      final String[] dirContents = folder.getRoot().list();
		
      // $\mbox{\bfseries Als Menge, damit die Reihenfolge keinen Einfluss hat }$
      final List<String> expectedNames = Arrays.asList("subfolder", "abc.txt");
      final Set<String> expectedFiles = new TreeSet<>(expectedNames);
      assertEquals(expectedFiles, new TreeSet<>(Arrays.asList(dirContents)));

      // $\mbox{\bfseries Pr�fe, ob File existiert }$
      assertTrue(createdFile.exists());
   }
}