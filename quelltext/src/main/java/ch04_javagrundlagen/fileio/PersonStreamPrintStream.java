package ch04_javagrundlagen.fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

/**
 * Beispielprogramm zur Verarbeitung von Person-Objekten mit
 * einfachen File-Streams. Achtung: Hier noch ohne Ressourcen-Handling.
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2014, 2017 by Michael Inden 
 */
public final class PersonStreamPrintStream
{
    public static void writePersonToPrintStream(final Person person, final PrintStream printStream) throws IOException
    {
        printStream.println(person.getName());
        printStream.println(person.getCity());
        printStream.println(person.getBirthcay().getTime());
    }

    public static Person readPersonWithScanner(final Scanner scanner) throws IOException
    {
        final String name = scanner.next();
        final String city = scanner.next();
        final long time = scanner.nextLong();
        final Date birthday = new Date(time);

        return new Person(name, birthday, city);
    }

    public static void main(final String[] args) throws Exception
    {
        final Person newBorn = new Person("Mike", new Date(71, 1, 7), "Zürich");

        final String tmpDir = System.getProperty("java.io.tmpdir");
        final File file = new File(tmpDir, "Person.ps.txt");
        try (final FileOutputStream fos = new FileOutputStream(file);
                        final PrintStream printStream = new PrintStream(fos))
        {
            writePersonToPrintStream(newBorn, printStream);
        }

        try (final FileInputStream fis = new FileInputStream(file); final Scanner scanner = new Scanner(fis))
        {
            final Person readInPerson = readPersonWithScanner(scanner);
            System.out.println("Gleich? " + newBorn.equals(readInPerson));
        }
    }

    public static final class Person
    {
        private final String name;

        private final Date   birthday;

        private final String city;

        public Person(final String name, final Date birthday, final String city)
        {
            if (name == null || birthday == null || city == null)
                throw new IllegalArgumentException("parameters 'name', 'birthday' and 'city' must not be null!");

            this.name = name;
            this.birthday = birthday;
            this.city = city;
        }

        public final String getName()
        {
            return name;
        }

        public final Date getBirthcay()
        {
            return birthday;
        }

        public final String getCity()
        {
            return city;
        }

        public boolean equals(Object other)
        {
            if (other == null) // Null-Akzeptanz
                return false;

            if (this == other) // reflexive
                return true;

            if (this.getClass() != other.getClass()) // same type ?
                return false;

            final Person otherPerson = (Person) other;
            return this.getName().equals(otherPerson.getName()) && this.getCity().equals(otherPerson.getCity())
                   && this.getBirthcay().equals(otherPerson.getBirthcay());
        }

        public String toString()
        {
            final StringBuffer buf = new StringBuffer();

            buf.append("Person: ");

            buf.append("Name='");
            buf.append(getName());
            buf.append("' ");
            buf.append("City='");
            buf.append(getCity());
            buf.append("' ");
            buf.append("Birthday='");
            buf.append(getBirthcay());
            buf.append("'");

            return buf.toString();
        }
        
        // Vermeide FindBugs Warning, obwohl diese Klasse niemals in Hash-Container verwendet wird
        @Override
        public int hashCode()
        {
        	return Objects.hash(this.name, this.birthday, this.city);
        } 
    }
}