package ch04_javagrundlagen.stringhandling;

import java.util.StringTokenizer;

/**
 * Beispielprogramm zur Demonstration der Extraktion eines Versionsnummer mithilfe eines StringTokenizers
 * 
 * @author Michael Inden
 * 
 * Copyright 2011 by Michael Inden 
 */
public class VersionExtractExample
{
    private VersionExtractExample()
    {
    }

    public static void main(final String[] args)
    {
        final String version = "APPNAME-2.11.77 build(07-07-07 11:11)";
        final int majorVersion = extractMajorVersion(version);
        System.out.println("Major: " + majorVersion);
        
        final int minorVersion = extractMinorVersion(version);
        System.out.println("Minor: " + minorVersion);

        final int patchLevel = extractPatchLevel(version);
        System.out.println("Patch-Level: " + patchLevel);
    }

    /**
     * extracts the major version from a passed version string. <br>
     * <p>
     * Example: When passing in "APPNAME-2.14.77 build(05-03-07 10:06)" The
     * returend major version is 2.
     * </p>
     * 
     * @return the major software version of the passed version string,
     */
public static int extractMajorVersion(final String strImplementationVersion)
{
    final String versions = cutOffAppnameAndBuild(strImplementationVersion);

    final StringTokenizer tokenizer = new StringTokenizer(versions, "._-");
    if (tokenizer.hasMoreTokens())
    {
    	final String versionValue = tokenizer.nextToken().trim();
		return Integer.parseInt(versionValue);
    }
    throw new IllegalArgumentException("passed version has no major version");
}

    /**
     * extracts the minor version from a passed version string. <br>
     * <p>
     * Example: When passing in "APPNAME-2.14.77 build(05-03-07 10:06:06)" The
     * returned minor version is 14.
     * </p>
     * 
     * @return the minor software version of the passed version string
     */
    public static int extractMinorVersion(final String strImplementationVersion)
    {
        final String versions = cutOffAppnameAndBuild(strImplementationVersion);

        final StringTokenizer tokenizer = new StringTokenizer(versions, "._-");
        if (tokenizer.countTokens() > 1)
        {            
            tokenizer.nextToken(); // skip major version
            
        	final String versionValue = tokenizer.nextToken().trim();
    		return Integer.parseInt(versionValue);
        }
        throw new IllegalArgumentException("passed version has no minor version");
    }

    /**
     * extracts the patch level from a passed version string. <br>
     * <p>
     * Example: When passing in "APPNAME-2.14.77 build(05-03-07 10:06)" The
     * returned patch level is 77.
     * </p>
     * 
     * @return the patch level of the passed version string
     */
    public static int extractPatchLevel(final String strImplementationVersion)
    {
        final String versions = cutOffAppnameAndBuild(strImplementationVersion);

        final StringTokenizer tokenizer = new StringTokenizer(versions, "._-");
        if (tokenizer.countTokens() > 2)
        {
            // skip major and minor version
            tokenizer.nextToken();
            tokenizer.nextToken();

        	final String versionValue = tokenizer.nextToken().trim();
    		return Integer.parseInt(versionValue);
        }
        throw new IllegalArgumentException("passed version has no patchlevel");
    }

    /** 
     * schneidet alles bis zum ersten Minus ab und vor den 
     * build-Infos ab 
     */
    private static String cutOffAppnameAndBuild(String strImplementationVersion)
    {
        final int posFirstMinus = strImplementationVersion.indexOf("-");

        String result = strImplementationVersion;
        if (foundOccurence(posFirstMinus))
        {
            final String versionWithoutAppname = strImplementationVersion.substring(posFirstMinus + 1);
            result = versionWithoutAppname;
        }

        final int posBuild = result.indexOf("build");
        if (foundOccurence(posBuild))
        {
            result = result.substring(0, posBuild);
        }

        return result;
    }

    private static boolean foundOccurence(final int posFirstMinus)
    {
        return posFirstMinus != -1;
    }
}
