package com.mycompany.itemcalculator;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author nahu
 */
public class CustomBorderRenderer extends DefaultTableCellRenderer {
    private Border rightBorder;

    public CustomBorderRenderer() {
        // Define the right-side border to simulate the vertical line
        rightBorder = BorderFactory.createMatteBorder(0, 0, 0, 1, Color.GRAY); // Customize the color and thickness if needed
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Check if this is a column after which a "line" should be drawn
        if (column % 2 == 0) { // For every second column
            setBorder(rightBorder);
        } else {
            setBorder(noFocusBorder); // Use default no-focus border to avoid drawing lines
        }

        return c;
    }
    
}
