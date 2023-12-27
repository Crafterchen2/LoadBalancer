package com.github.crafterchen2.loadbalancer.enums;

public enum Translation {

    //Entries
    NO_BELT,
    BELT_MK_1,
    BELT_MK_2,
    BELT_MK_3,
    BELT_MK_4,
    BELT_MK_5,
    SEC,
    MIN,
    HOUR,
    DAY,
    WEEK,
    MONTH,
    YEAR,
    ;

    //Fields

    //Constructor

    //Methods
    public static String translate(Translation key, Language lang){
        return switch (lang) {
            case ENGLISH -> switch (key) {
                case NO_BELT -> "No Belt";
                case BELT_MK_1 -> "Conveyor belt MK 1";
                case BELT_MK_2 -> "Conveyor belt MK 2";
                case BELT_MK_3 -> "Conveyor belt MK 3";
                case BELT_MK_4 -> "Conveyor belt MK 4";
                case BELT_MK_5 -> "Conveyor belt MK 5";
                case SEC -> "Second";
                case MIN -> "Minute";
                case HOUR -> "Hour";
                case DAY -> "Day";
                case WEEK -> "Week";
                case MONTH -> "Month";
                case YEAR -> "Year";
            };
            case GERMANY -> switch (key) {
                case NO_BELT -> "Kein Fließband";
                case BELT_MK_1 -> "Fließband MK 1";
                case BELT_MK_2 -> "Fließband MK 2";
                case BELT_MK_3 -> "Fließband MK 3";
                case BELT_MK_4 -> "Fließband MK 4";
                case BELT_MK_5 -> "Fließband MK 5";
                case SEC -> "Sekunde";
                case MIN -> "Minute";
                case HOUR -> "Stunde";
                case DAY -> "Tag";
                case WEEK -> "Woche";
                case MONTH -> "Monat";
                case YEAR -> "Jahr";
            };
        };
    }

    public String translate(Language lang){
        return translate(this,lang);
    }

    public static String translate(Translation key){
        return translate(key,Language.selected);
    }

    public String translate(){
        return translate(this);
    }

    //Getter

    //Setter

    //Overrides from
    ////<class>

}
