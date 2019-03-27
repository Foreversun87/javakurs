package ch13_i18n.basics;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Beispielklasse zur Demonstration der Formatierung von Datumswerten mit dem
 * SimpleDateFormat und unterschiedlicher Anzahl aPlatzhaltern 
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class SimpleDateFormatExample 
{
	public static void main(final String[] args) throws ParseException 
	{		
		final DateFormat df1 = new SimpleDateFormat("dd.MM.y");
		final DateFormat df2 = new SimpleDateFormat("dd.MM.yy");
		final DateFormat df3 = new SimpleDateFormat("dd.MM.yyy");
		final DateFormat df4 = new SimpleDateFormat("dd.MM.yyyy");
		
		final Date firstOfDecember = new Date(2017-1900, 11, 1);
		System.out.println(df1.format(firstOfDecember));
		System.out.println(df2.format(firstOfDecember));
		System.out.println(df3.format(firstOfDecember));
		System.out.println(df4.format(firstOfDecember));	
		
		
		final DateFormat dfm1 = new SimpleDateFormat("d.M.y");
		final DateFormat dfm2 = new SimpleDateFormat("dd.MM.yy");
		final DateFormat dfm3 = new SimpleDateFormat("dd.MMM.yyy");
		final DateFormat dfm4 = new SimpleDateFormat("dd.MMMM.yyyy");
		
		final Date firstOfAugust = new Date(2017-1900, 7, 1);
		System.out.println(dfm1.format(firstOfAugust));
		System.out.println(dfm2.format(firstOfAugust));
		System.out.println(dfm3.format(firstOfAugust));
		System.out.println(dfm4.format(firstOfAugust));
		System.out.println(dfm1.format(firstOfDecember));
		System.out.println(dfm2.format(firstOfDecember));
		System.out.println(dfm3.format(firstOfDecember));
		System.out.println(dfm4.format(firstOfDecember));
	}
}
