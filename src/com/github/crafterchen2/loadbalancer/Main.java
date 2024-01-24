package com.github.crafterchen2.loadbalancer;

import com.github.crafterchen2.loadbalancer.components.LangSelector;
import com.github.crafterchen2.loadbalancer.components.UnitSelector;
import com.github.crafterchen2.loadbalancer.enums.Unit;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        debugLocale(Locale.GERMAN);
        debugLocale(Locale.GERMANY);
        System.out.println(Unit.YEAR.getFactor());
        for (int i = -8; i <= 8; i++) {
            System.out.println(i+": "+(i % 4));
        }
        System.out.println(Unit.SEC);
        System.out.println(Unit.MIN);
        System.out.println(Unit.HOUR);
        System.out.println(Unit.DAY);
        System.out.println(Unit.WEEK);
        System.out.println(Unit.MONTH);
        System.out.println(Unit.YEAR);
        JFrame frame = new JFrame("frame");
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(new JPanel(null));
        LangSelector ls = new LangSelector();
        ls.setBounds(50,50,300,25);
        JPanel p = new JPanel(null);
        p.setBounds(25,25,350,75);
        p.setBackground(Color.BLUE);
        p.add(ls);
        frame.add(p);
        UnitSelector us = new UnitSelector();
        us.setBounds(50,130,300,25);
        frame.add(us);
        LangSelector ols = new LangSelector();
        ols.setBounds(50,160,300,25);
        frame.add(ols);
        frame.setVisible(true);
    }

    private static void debugLocale(Locale l){
        debugLocale(l, Locale.ENGLISH);
    }

    private static void debugLocale(Locale l, Locale l2){
        System.out.println("Debug for "+l.toString()+" and "+l2.toString());
        System.out.println(":> getCountry()            "+l.getCountry());
        System.out.println(":> getDisplayCountry()     "+l.getDisplayCountry());
        System.out.println(":> getDisplayCountry(l2)   "+l.getDisplayCountry(l2));
        System.out.println(":> getLanguage()           "+l.getLanguage());
        System.out.println(":> getDisplayLanguage()    "+l.getDisplayLanguage());
        System.out.println(":> getDisplayLanguage(l2)  "+l.getDisplayLanguage(l2));
        System.out.println(":> getDisplayName()        "+l.getDisplayName());
        System.out.println(":> getDisplayName(l2)      "+l.getDisplayName(l2));
        System.out.println(":> getScript()             "+l.getScript());
        System.out.println(":> getDisplayScript()      "+l.getDisplayScript());
        System.out.println(":> getDisplayScript(l2)    "+l.getDisplayScript(l2));
        System.out.println(":> getVariant()            "+l.getVariant());
        System.out.println(":> getDisplayVariant()     "+l.getDisplayVariant());
        System.out.println(":> getDisplayVariant(l2)   "+l.getDisplayVariant(l2));
        System.out.println(":> toLanguageTag()         "+l.toLanguageTag());
    }


}