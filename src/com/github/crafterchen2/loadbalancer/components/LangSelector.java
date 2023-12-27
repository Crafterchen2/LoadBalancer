package com.github.crafterchen2.loadbalancer.components;

import com.github.crafterchen2.loadbalancer.enums.Language;

import javax.swing.*;
import java.awt.*;

public class LangSelector extends JComboBox<Language> {

    //Fields

    //Constructor
    public LangSelector() {
        super(Language.values());
        addActionListener(e -> {
            Language.selected = Language.values()[getSelectedIndex()];
            causeLangUpdate();
        });
        ListCellRenderer<? super Language> oldRenderer = getRenderer();
        setRenderer((list, value, index, isSelected, cellHasFocus) -> {
            Component c = oldRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (getSelectedIndex() == index) {
                Color selectedGreen = new Color(0x40922B);
                if (isSelected) {
                    c.setBackground(selectedGreen);
                }   else {
                    c.setBackground(selectedGreen.brighter());
                }
            }
            return c;
        });
    }

    //Methods
    private void causeLangUpdate(){
        Container lastParent = getParent();
        Container nextParent = lastParent.getParent();
        while (nextParent != null) {
            lastParent = nextParent;
            nextParent = lastParent.getParent();
        }
        lastParent.repaint();
    }

    //Getter
    public Language getSelectedLanguage(){
        return Language.values()[getSelectedIndex()];
    }

    //Setter

    //Overrides from
    ////ComboBox

}
