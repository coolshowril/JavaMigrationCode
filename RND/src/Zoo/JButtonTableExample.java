package Zoo;


/*import ButtonEditor;
import ButtonRenderer;*/

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 * @version 1.0 11/09/98
 */
@SuppressWarnings({ "serial", "unused" })
public class JButtonTableExample extends JFrame 
{

	
}
/**
 * @version 1.0 11/09/98
 */

@SuppressWarnings("serial")
class ButtonRenderer extends JButton implements TableCellRenderer
{

	public ButtonRenderer()
	{
		setOpaque(true);
	}

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column)
	{
		if (isSelected) {
			setForeground(table.getSelectionForeground());
			setBackground(table.getSelectionBackground());
		} else {
			setForeground(table.getForeground());
			setBackground(UIManager.getColor("Button.background"));
		}
		setText("Edit");
		return this;
	}
}

/**
 * @version 1.0 11/09/98
 */

@SuppressWarnings("serial")
class ButtonEditor extends DefaultCellEditor 
{
	protected JButton button;

	private String label;

	private boolean isPushed;

	public ButtonEditor(JCheckBox checkBox)
	{
		super(checkBox);
		button = new JButton();
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
			}
		});
	}

	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column)
	{
		if (isSelected) 
		{
			button.setForeground(table.getSelectionForeground());
			button.setBackground(table.getSelectionBackground());
		} else 
		{
			button.setForeground(table.getForeground());
			button.setBackground(table.getBackground());
		}
		label = "Edit";
		button.setText(label);
		isPushed = true;
		return button;
	}

	public Object getCellEditorValue() 
	{
		if (isPushed) 
		{
			mainScreen.jf.setVisible(true);
			int rowindex=mainScreen.jtable.getSelectedRow();
			int colindex=mainScreen.jtable.getSelectedColumn();
			if(colindex==4)
			{
				AnimalScreen as=new AnimalScreen();
				as.Editdata(Integer.parseInt((String) mainScreen.jtable.getValueAt(rowindex, 0)),(String)mainScreen.jtable.getValueAt(rowindex, 1), 
						(String)mainScreen.jtable.getValueAt(rowindex, 2),
						(String) mainScreen.jtable.getValueAt(rowindex, 3));
			}
			else if(colindex==7)
			{
				ZooAddressFrame as=new ZooAddressFrame();
				as.EditData(Integer.parseInt((String)mainScreen.jtable.getValueAt(rowindex, 0)),
						(String)mainScreen.jtable.getValueAt(rowindex, 1),
						(String)mainScreen.jtable.getValueAt(rowindex, 2),
						(String) mainScreen.jtable.getValueAt(rowindex, 3),
						(String)mainScreen.jtable.getValueAt(rowindex, 4),
						(String)mainScreen.jtable.getValueAt(rowindex, 5),
						(String)mainScreen.jtable.getValueAt(rowindex, 6));
			}
			//ListAnimalData.recievinglabeldummy();
		}
		isPushed = false;
		return new String(label);
	}
}
