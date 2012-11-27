package Zoo;


/*import ButtonEditor;
import ButtonRenderer;*/

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class ListAnimalData {
	
	
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException 
	{
		int j=0;
		Connection con=DBConnectionZoo.getdbconnection();
		Statement st=con.createStatement();
		Statement nst=con.createStatement();
		ResultSet rs=st.executeQuery("Select * from [Zoo_Animals]");
		ResultSetMetaData rsmd = rs.getMetaData();
		ResultSet temp=nst.executeQuery("Select count(1) from [Zoo_Animals]");
		temp.next();
		int rowcount=temp.getInt(1);
		System.out.println(rowcount);
		int numColumns = rsmd.getColumnCount();
		String[] columns=new String[numColumns];
		for(int i=1;i<=numColumns;i++)
		{
			columns[i-1]=rsmd.getColumnName(i);
		}
		/*while(rs.next())
		{
			j++;
		}*/
		rs.next();
		System.out.println(j);
		String[][] data=new String[rowcount][numColumns+1];
		//rs.
		for(int b=0;b<rowcount;b++)
		{

			for(int a=0;a<numColumns;a++)
			{
				data[b][a]=rs.getString(a+1);
				
			}
			data[b][numColumns]="Edit";
			rs.next();
		}
		mainScreen.jf=new JFrame();
		
		mainScreen.jf.setSize(700, 300);
		mainScreen.jtable=new JTable(data, columns);
		TableColumn tc=new TableColumn();
		mainScreen.jtable.addColumn(tc);

		mainScreen.jtable.getColumnModel().getColumn(4).setHeaderValue("Edit");
		mainScreen.jtable.getColumn("Edit").setCellRenderer(new ButtonRenderer());
		mainScreen.jtable.getColumn("Edit").setCellEditor(new ButtonEditor(new JCheckBox()));
		/*for(int i=0;i<8;i++)
		{
			jtable.setValueAt("Edit", i, 4);
		}*/
		mainScreen.jf.add(new JScrollPane(mainScreen.jtable));
		mainScreen.jf.setVisible(true);
	}

	/*static void recievinglabel(int i)
	{
		int temp;
		for(int j=0;j<8;j++)
		{
			temp=Integer.parseInt((String) mainScreen.jtable.getValueAt(j, 4));
			if(i==temp)
			{
				System.out.println(Integer.parseInt((String) jtable.getValueAt(j, 4)));
				AnimalScreen as=new AnimalScreen();
				as.Editdata((String)jtable.getValueAt(j, 1), (String)jtable.getValueAt(j, 2),(String) jtable.getValueAt(j, 3));
				break;
			}
		}
	}*/

	/*public static void recievinglabeldummy() 
	{
		jf.setVisible(false);
		int rowindex=jtable.getSelectedRow();
		int colindex=jtable.getSelectedColumn();
		System.out.println(rowindex+" "+colindex);
		AnimalScreen as=new AnimalScreen();
		as.Editdata((String)jtable.getValueAt(rowindex, 1), (String)jtable.getValueAt(rowindex, 2),(String) jtable.getValueAt(rowindex, 3));
		ZooAddressFrame as=new ZooAddressFrame();
		as.EditData((String)jtable.getValueAt(rowindex, 1),(String)jtable.getValueAt(rowindex, 2),(String) jtable.getValueAt(rowindex, 3),(String)jtable.getValueAt(rowindex, 4),(String)jtable.getValueAt(rowindex, 5));
	}*/
}
