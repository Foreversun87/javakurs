package ch20_unittests.ch20_4_junit_rules;

/**
 * Beispielklasse, die eine Konvertierung vornimmt 
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden
 */
public class Controller 
{
	/* private */static int hexCodedByteValueToInt(final byte byteValue) 
	{
		if (byteValue >= 'A' && byteValue <= 'F') {
			return (10 + (byteValue - 'A'));
		}
		if (byteValue >= '0' && byteValue <= '9') {
			return (byteValue - '0');
		}
		throw new IllegalArgumentException("Unexpected byte value: " + byteValue
				+ ". Must be in Range �0�-�9� (0x30-0x39) or �A�-�F� (0x41-0x46)");
	}

}
