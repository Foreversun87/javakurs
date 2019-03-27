package ch08_applikationsbausteine.configuration;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Diese Klasse modelliert einen Highscore-Eintrag
 * 
 * @author Michael Inden
 * 
 * Copyright 2016 by Michael Inden
 */
public final class Highscore implements Serializable
{
	private final String name;
	private final int points;
	private final int level;
	private final LocalDate day;

	public Highscore(final String name, final int points, final int level, final LocalDate day) 
	{
		this.name = name;
		this.points = points;
		this.level = level;
		this.day = day;
	}

	@Override
	public String toString() 
	{
		return "Highscore [name=" + name + ", points=" + points + ", level=" + level + ", date=" + day + "]";
	}
	
	public String getName() 	{ return name; }
	public int getPoints() 		{ return points; }
	public int getLevel() 		{ return level; }
	public LocalDate getDay() 	{ return day; }
}