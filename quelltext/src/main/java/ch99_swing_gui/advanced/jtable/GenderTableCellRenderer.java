package ch99_swing_gui.advanced.jtable;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import ch99_swing_gui.advanced.common.Gender;
import ch99_swing_gui.advanced.common.GenderFemaleIcon;
import ch99_swing_gui.advanced.common.GenderMaleIcon;

/**
 * Beispielklasse zur Demonstration eines Renderers für Symbole von Geschlechtern in einer JTable
 * <br>
 * <b>Neu in Auflage 2</b>
 * 
 * @author Michael Inden
 * 
 * Copyright 2012 by Michael Inden 
 */
public final class GenderTableCellRenderer extends DefaultTableCellRenderer
{
    private static final Icon maleIcon = new GenderMaleIcon();
    private static final Icon femaleIcon = new GenderFemaleIcon();

    @Override
    public Component getTableCellRendererComponent(final JTable table, final Object value, final boolean isSelected,
                    final boolean hasFocus, final int row, final int column)
    {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        final Gender gender = (Gender) value;
        if (gender == Gender.MALE)
            setIcon(maleIcon);
        else if (gender == Gender.FEMALE)
            setIcon(femaleIcon);

        // Anpassung an die Zeilenhöhe
        table.setRowHeight(getIcon().getIconHeight() + 10);

        return this;
    }
}
