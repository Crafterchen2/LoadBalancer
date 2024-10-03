package com.github.crafterchen2.loadbalancer.enums;

import java.util.Locale;

//Enums {
public enum Language {
	
	ENGLISH(Locale.UK),
	GERMANY(Locale.GERMANY),
	;
	
	//Fields {
	public static final Language defaultLang = ENGLISH;
	
	public static Language selected = defaultLang;
	
	public final Locale locale;
	//} Fields
	
	//Constructor {
	Language(Locale locale) {
		this.locale = locale;
	}
	//} Constructor
	
	
	//Methods {
	public static void resetLanguage() {
		selected = defaultLang;
	}
	//} Methods
	
	//Overrides {
	@Override
	public String toString() {
		return locale.getDisplayName(this.locale);
	}
	//} Overrides
	
}
//} Enums
