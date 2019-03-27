package ch13_i18n.basics;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Utility-Klasse zur Vereinfachung beim Umgang mit der Klasse Locale
 * 
 * @author Michael Inden
 * 
 * Copyright 2011, 2017 by Michael Inden 
 */
public final class LocaleUtils
{     
public static final Comparator<Locale> byLanguage = 
		                               Comparator.comparing(Locale::getLanguage);
public static final Comparator<Locale> byCountry = 
		                               Comparator.comparing(Locale::getCountry);

public static final Comparator<Locale> LOCALE_COMPARATOR = byLanguage.thenComparing(byCountry);

public static final List<Locale> getSortedLocales()
{
    final Locale[] availableLocale = Locale.getAvailableLocales();

    return Arrays.stream(availableLocale).
    		      sorted(LOCALE_COMPARATOR).
    		      collect(Collectors.toList());
}

public static List<Locale> getLanguageOnlyLocales()
{
    final List<Locale> sortedLocales = getSortedLocales();

    final Predicate<Locale> isLanguageOnly = 
    		                locale -> locale.getCountry().isEmpty();
    		                
	return sortedLocales.stream().
			             filter(isLanguageOnly).collect(Collectors.toList());
}

    private LocaleUtils()
    {
    }
}
