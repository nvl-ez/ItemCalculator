package com.mycompany.itemcalculator;

import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;
import javax.swing.JTable;
import java.awt.Color;

/**
 *
 * @author nahu
 */
public class ValueBasedColorRenderer extends DefaultTableCellRenderer {

    float min;
    float max;

    public ValueBasedColorRenderer(float min, float max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Reset to default state
        c.setBackground(null);
        c.setForeground(Color.BLACK);

        if (!isSelected) {
            try {
                // Assuming the value is numeric and you want to color based on its magnitude
                float cellValue = Float.parseFloat(value.toString());
                float ratio = Math.min(Math.max((cellValue - min) / (max - min), 0f), 1f); // Ensure ratio is between 0 and 1

                // Interpolate between red and green based on the ratio
                int red = (int) ((1.0 - ratio) * 255.0);
                int green = (int) (ratio * 255.0);

                c.setBackground(new Color(red, green, 0)); // Color cell green if value is greater than 100

                // Add more conditions as needed
            } catch (NumberFormatException e) {
                // If value is not numeric, handle exception or ignore
            }
        }

        return c;
    }
}
