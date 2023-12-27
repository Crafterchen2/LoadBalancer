package com.github.crafterchen2.loadbalancer.enums;

import java.util.Locale;

public enum Language {

    //Entries
    ENGLISH(Locale.UK),
    GERMANY(Locale.GERMANY),
    ;

    //Fields
    public static final Language defaultLang = ENGLISH;

    public static Language selected = defaultLang;

    public final Locale locale;

    //Constructor
    Language(Locale locale) {
        this.locale = locale;
    }


    //Methods
    public static void resetLanguage(){
        selected = defaultLang;
    }

    //Getter

    //Setter

    //Overrides from
    ////Enum
    @Override
    public String toString() {
        return locale.getDisplayName(this.locale);
    }

}
