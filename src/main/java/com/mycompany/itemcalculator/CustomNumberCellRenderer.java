package com.mycompany.itemcalculator;
import javax.swing.table.DefaultTableCellRenderer;
import java.text.DecimalFormat;
/**
 *
 * @author nahu
 */
public class CustomNumberCellRenderer extends DefaultTableCellRenderer{
    private final DecimalFormat formatter;
    
    public CustomNumberCellRenderer(String pattern){
        this.formatter = new DecimalFormat(pattern);
    }
    
    protected void setValue(Object value) {
        // Check if the value is a Number and format it, otherwise use the default formatting
        try {
            if (value instanceof Number) {
                value = formatter.format((Number)value);
            }
        } catch (IllegalArgumentException e) {
            // In case of formatting failure, fall back to the default value
        }
        super.setValue(value);
    }
}
