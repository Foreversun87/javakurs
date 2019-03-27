package ch06_collections.optional;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * Beispielprogramm zur Demonstration der Absicherung von mehreren Aufrufen mit "."
 * 
 * @author Michael Inden
 * 
 * Copyright 2014, 2017 by Michael Inden 
 */
public class OptionalSafeResolveExample 
{
	public static void main(String[] args) 
	{
		/*
		 * final Computer computer = new Computer(); final String version =
		 * computer.getGraphicscard().getFimrware().getVersion();
		 * System.out.println(version);
		 * 
		 * final Computer computer2 = new MalfuncitioningComputer(); // NPE final String
		 * version2 = computer2.getGraphicscard().getFimrware().getVersion();
		 * System.out.println(version2);
		 */
		
		final Computer computer = new Computer();
		final Optional<String> version = safeResolve(() -> computer.getGraphicscard().getFimrware().getVersion());
		System.out.println(version);

		final Computer computer2 = new MalfuncitioningComputer();
		final Optional<String> version2 = safeResolve(() -> computer2.getGraphicscard().getFimrware().getVersion());
		System.out.println(version2);
	}

	public static <T> Optional<T> safeResolve(final Supplier<T> resolver) 
	{
		try 
		{
			final T result = resolver.get();
			return Optional.ofNullable(result);
		} 
		catch (final NullPointerException npe) 
		{
			return Optional.empty();
		}
	}
}

class Computer {

	public Graphicscard getGraphicscard() {
		return new Graphicscard();
	}
}

class MalfuncitioningComputer extends Computer {

	public Graphicscard getGraphicscard() {
		return null;
	}
}

class Graphicscard {

	public Firmware getFimrware() {
		return new Firmware();
	}

}

class Firmware {

	public String getVersion() {
		return "V1.2.3";
	}
}