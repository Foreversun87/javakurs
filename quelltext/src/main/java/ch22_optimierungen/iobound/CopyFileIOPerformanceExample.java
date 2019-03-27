package ch22_optimierungen.iobound;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

import ch03_oodesign.generics.Pair;
import ch08_applikationsbausteine.old.FileUtils;
import ch08_applikationsbausteine.old.StreamUtils;

/**
 * Beispielprogramm zur Demonstration verschiedener Optimierungstechniken beim Kopieren von Dateien
 * 
 * @author Michael Inden
 *
 * Copyright 2011, 2014 by Michael Inden
 */
public final class CopyFileIOPerformanceExample
{
	private static final String BIG_FILE_PDF = "bookdpunkt.pdf";
	private static final String SMALL_FILE_PDF = "jdk8-Auszug.pdf";

	public static final String DEMO_FILE_PATH = "src/main/resources/demofiles/";

	private CopyFileIOPerformanceExample() {
	}

	public static void main(final String[] args) throws IOException 
	{
		System.out.println("Measuring " + new File(SMALL_FILE_PDF).getAbsolutePath());
		final long durationUnbuffered = measureFileCopyByteWise(SMALL_FILE_PDF) / 1_000_000;
		final long durationBuffered = measureFileCopyBuffered(SMALL_FILE_PDF) / 1_000_000;
		final long durationOwnBuffered = measureFileCopyOwnBuffered(SMALL_FILE_PDF) / 1_000_000;
		final long durationChannels = measureFileCopyUsingChannels(SMALL_FILE_PDF) / 1_000_000;

		printResults(durationUnbuffered, durationBuffered, durationOwnBuffered, durationChannels);

		System.out.println();

		System.out.println("Measuring " + new File(BIG_FILE_PDF).getAbsolutePath());
		final long durationUnbuffered2 = measureFileCopyByteWise(BIG_FILE_PDF) / 1_000_000;
		final long durationBuffered2 = measureFileCopyBuffered(BIG_FILE_PDF) / 1_000_000;
		final long durationOwnBuffered2 = measureFileCopyOwnBuffered(BIG_FILE_PDF) / 1_000_000;
		final long durationChannels2 = measureFileCopyUsingChannels(BIG_FILE_PDF) / 1_000_000;

		printResults(durationUnbuffered2, durationBuffered2, durationOwnBuffered2, durationChannels2);
	}

	private static void printResults(final long durationUnbuffered, final long durationBuffered, final long durationOwnBuffered,
					final long durationChannels) {
		System.out.println("A durationUnbuffered " + durationUnbuffered);
		System.out.println("B durationBuffered " + durationBuffered);
		System.out.println("C durationOwnBuffered " + durationOwnBuffered);
		System.out.println("D durationChannels " + durationChannels);

		System.out.println("File-Read duration / unbuffered= " + durationUnbuffered + " / buffered= " + durationBuffered + " ==> SPEED-UP "
						+ (float) durationUnbuffered / (float) durationBuffered);
		System.out.println("File-Read duration / unbuffered= " + durationUnbuffered + " / own buffered= " + durationOwnBuffered + " ==> SPEED-UP "
						+ (float) durationUnbuffered / (float) durationOwnBuffered);
		System.out.println("File-Read duration / buffered= " + durationBuffered + " / own buffered= " + durationOwnBuffered + " ==> SPEED-UP "
						+ (float) durationBuffered / (float) durationOwnBuffered);

		System.out.println("File-Read duration / own buffered = " + durationOwnBuffered + " / channels= " + durationChannels + " ==> SPEED-UP "
						+ (float) durationOwnBuffered / (float) durationChannels);
	}

	private static Pair<FileInputStream, FileOutputStream> prepareOutputFileAndStreams(final String fileName) throws FileNotFoundException,
					IOException {
		final File file = new File(DEMO_FILE_PATH + fileName);
		if (!file.exists()) {
			throw new FileNotFoundException(file.getAbsolutePath());
		}

		System.out.println("Calculation result for file = " + fileName + " / size = " + file.length());

		final File newFile = new File(DEMO_FILE_PATH + "Copy of " + fileName);
		newFile.createNewFile();

		final FileInputStream inStream = new FileInputStream(DEMO_FILE_PATH + fileName);
		final FileOutputStream outStream = new FileOutputStream(newFile);

		return new Pair<FileInputStream, FileOutputStream>(inStream, outStream);
	}

	private static long measureFileCopyByteWise(final String fileName) throws FileNotFoundException, IOException {
		final Pair<FileInputStream, FileOutputStream> inAndOutStream = prepareOutputFileAndStreams(fileName);

		// Definition zur Lesbarkeit
		final InputStream inStream = inAndOutStream.getFirst();
		final OutputStream outStream = inAndOutStream.getSecond();

		final long time0 = System.nanoTime();

		StreamUtils.copyBytewise(inStream, outStream);

		final long time1 = System.nanoTime();

		StreamUtils.safeClose(inStream);
		StreamUtils.safeClose(outStream);

		return (time1 - time0);
	}

	private static long measureFileCopyBuffered(final String fileName) throws FileNotFoundException, IOException {
		final Pair<FileInputStream, FileOutputStream> inAndOutStream = prepareOutputFileAndStreams(fileName);

		// Definition zur Lesbarkeit
		final InputStream inStream = inAndOutStream.getFirst();
		final OutputStream outStream = inAndOutStream.getSecond();

		final InputStream bufferedInStream = StreamUtils.decorateWithBuffer(inStream);
		final OutputStream bufferedOutStream = StreamUtils.decorateWithBuffer(outStream);

		final long time0 = System.nanoTime();

		StreamUtils.copyBytewise(bufferedInStream, bufferedOutStream);

		final long time1 = System.nanoTime();

		StreamUtils.safeClose(bufferedInStream);
		StreamUtils.safeClose(bufferedOutStream);

		return (time1 - time0);
	}

	private static long measureFileCopyOwnBuffered(final String fileName) throws FileNotFoundException, IOException {
		final Pair<FileInputStream, FileOutputStream> inAndOutStream = prepareOutputFileAndStreams(fileName);

		// Definition zur Lesbarkeit
		final InputStream inStream = inAndOutStream.getFirst();
		final OutputStream outStream = inAndOutStream.getSecond();

		final long time0 = System.nanoTime();

		StreamUtils.copyOwnBuffering(inStream, outStream);

		final long time1 = System.nanoTime();

		StreamUtils.safeClose(inStream);
		StreamUtils.safeClose(outStream);

		return (time1 - time0);
	}

	private static long measureFileCopyUsingChannels(final String fileName) throws FileNotFoundException, IOException {
		final Pair<FileInputStream, FileOutputStream> inAndOutStream = prepareOutputFileAndStreams(fileName);

		// Definition zur Lesbarkeit
		final FileInputStream inStream = inAndOutStream.getFirst();
		final FileOutputStream outStream = inAndOutStream.getSecond();

		// Lese/Schreibkan�le besorgen
		final FileChannel sourceChannel = inStream.getChannel();
		final FileChannel destChannel = outStream.getChannel();

		final long time0 = System.nanoTime();

		sourceChannel.transferTo(0, sourceChannel.size(), destChannel);

		final long time1 = System.nanoTime();

		FileUtils.safeClose(sourceChannel);
		FileUtils.safeClose(destChannel);

		return (time1 - time0);
	}
}
