package ch04_javagrundlagen.datehandling;

import java.util.Date;

/**
 * Beispielprogramm für die Altersberechnung mithilfe der Klasse Date
 * für Person-Objekte
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014 by Michael Inden 
 */
public final class PersonDateBirthdayCalculationExample
{
    public static void main(final String[] args)
    {
        final Person person = new Person("Micha", new Date(71, 9, 23), "Bremen");
        System.out.println("Age: " + person.getAge());
    }
    
    public static class Person
    {
        private final String name;
        private final String city;
        private final Date   birthday;

        public Person(final String name, final Date birthday, final String city)
        {
            if (name == null)
                throw new IllegalArgumentException("Passed parameter name must not be null!");
            if (city == null)
                throw new IllegalArgumentException("Passed parameter city must not be null!");
            if (birthday == null)
                throw new IllegalArgumentException("Passed parameter birthday must not be null!");

            this.name = name;
            this.city = city;
            this.birthday = birthday;
        }

        public final String getName()
        {
            return name;
        }

        public final String getCity()
        {
            return city;
        }

        public final Date getBirthDay()
        {
            return birthday;
        }

public final int getAge()
{
    final Date now = new Date();

    int correction = 0;
    if (!birthdayWasAlreadyThisYear(now.getMonth(), birthday.getMonth(), now.getDate(), birthday.getDate()))
    {
        correction = -1; 
    }

    return now.getYear() - birthday.getYear() + correction;
}

private boolean birthdayWasAlreadyThisYear(final int monthNow, final int monthBirthDay, 
		                                   final int dayNow, final int dayBirthDay) 
{
	return monthNow > monthBirthDay || (monthNow == monthBirthDay && dayNow >= dayBirthDay);
}
    }
    
}