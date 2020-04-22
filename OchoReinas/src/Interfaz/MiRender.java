package Interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MiRender extends DefaultTableCellRenderer
{
   public Component getTableCellRendererComponent(JTable table,
      Object value,
      boolean isSelected,
      boolean hasFocus,
      int row,
      int column)
   {
      super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
      
      
      this.setHorizontalAlignment(CENTER);
      this.setVerticalAlignment(CENTER);
      this.setPreferredSize(new Dimension(100 , 100));
      this.setMaximumSize(new Dimension(100 , 100));
      this.setMinimumSize(new Dimension(100 , 100));
      
      if ((column % 2 == 1 && row % 2 == 1)
              //) {
              || (column % 2 == 0 && row % 2 == 0)) {
          this.setBackground(Color.WHITE);
      } else {
          this.setBackground(Color.BLACK);
      }

      return this;
   }
}
