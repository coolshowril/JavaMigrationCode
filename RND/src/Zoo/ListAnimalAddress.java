package Zoo;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class ListAnimalAddress 
{
	static int cursor,rowcount;
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException 
	{
		int j=0;
		Connection con=DBConnectionZoo.getdbconnection();
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  ResultSet.CONCUR_READ_ONLY);
		Statement nst=con.createStatement();
		mainScreen.rs=st.executeQuery("Select * from [Zoo_Address]");
		ResultSetMetaData rsmd = mainScreen.rs.getMetaData();
		ResultSet temp=nst.executeQuery("Select count(1) from [Zoo_Address]");
		temp.next();
		rowcount=temp.getInt(1);
		System.out.println(rowcount);
		int numColumns = rsmd.getColumnCount();
		System.out.println(numColumns);
		String[] columns=new String[numColumns];
		for(int i=1;i<=numColumns;i++)
		{
			columns[i-1]=rsmd.getColumnName(i);
		}
		mainScreen.rs.next();
		System.out.println(j);
		mainScreen.data=new String[rowcount][numColumns];
		//rs.
		for(int b=0;b<rowcount;b++)
		{
			for(int a=0;a<6;a++)
			{
				mainScreen.data[b][a]=mainScreen.rs.getString(a+1);	
			}
			mainScreen.rs.next();
		}
		mainScreen.jf=new JFrame();

		mainScreen.jf.setSize(700, 300);
		mainScreen.jtable=new JTable(mainScreen.data, columns);
		TableColumn tc=new TableColumn();
		mainScreen.jtable.addColumn(tc);

		mainScreen.jtable.getColumnModel().getColumn(7).setHeaderValue("Edit");
		mainScreen.jtable.getColumn("Edit").setCellRenderer(new ButtonRenderer());
		mainScreen.jtable.getColumn("Edit").setCellEditor(new ButtonEditor(new JCheckBox()));
		
		Panel p=new Panel();
		p.add(new JScrollPane(mainScreen.jtable));
		JButton next=new JButton("Next");
		JButton previous=new JButton("Previous");
		p.add(previous);
		p.add(next);
		mainScreen.jf.add(p);
		mainScreen.jf.setVisible(true);
		next.addActionListener(new ActionListener() {					
			public void actionPerformed(ActionEvent e) {
					next();
			}
		});
		previous.addActionListener(new ActionListener() {					
			public void actionPerformed(ActionEvent e) {
				try {
					previous();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	protected static void previous() throws SQLException {
		cursor++;
		/*mainScreen.rs.absolute(cursor*5);
		for(int b=0;b<rowcount;b++)
		{
			for(int a=0;a<6;a++)
			{
				mainScreen.data[b][a]=mainScreen.rs.getString(a+1);	
			}
			mainScreen.rs.next();
		}*/
		System.out.println(cursor);
	}
	protected static void next() {
		// TODO Auto-generated method stub
		cursor--;
		System.out.println(cursor);
	}
}
