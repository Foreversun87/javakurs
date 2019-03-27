package ch20_unittests.ch20_4_junit_rules;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class TemporaryFolderTest_WithHamcrest 
{
	@Rule
	public TemporaryFolder folder = new TemporaryFolder();
	
	@Test
	public void testUsingTempFolder() throws IOException 
	{				
		final File subdFolder = folder.newFolder("subfolder");
		final File subFolderWithPath = folder.newFolder("subpath", "subfolder");
		
		final File createdFile = folder.newFile("newFile.txt");

		// List the contents of the temp-folder, normal File-API
		final String[] currentContents = folder.getRoot().list();
		
		// Hamcrest-Variante 1 mit Arrays
		final String[] expectedAsArray = { "subfolder", "subpath", "newFile.txt" };
		assertThat(expectedAsArray, arrayContainingInAnyOrder(currentContents));

		// Hamcrest-Variante 2 mit Iterable
		final List<String> expectedAsList = Arrays.asList("subfolder", "subpath", "newFile.txt");
		assertThat(expectedAsList, containsInAnyOrder(currentContents));
	}
	
	@Test
	public void testUsingTempFolder_Again() throws IOException 
	{
		final String[] currentContents = folder.getRoot().list();
		assertThat(currentContents.length, is(0));
	}
}
