package Zoo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.plaf.OptionPaneUI;

@SuppressWarnings("unused")
public class ZooAddressFrame extends DBConnectionZoo {

	/**
	 * @param args
	 */
	public void EditData(final Integer z,String zooname,String Address1,String Address2,String City,String State,String Country) {
		Frame frm=new Frame("Zoo Address");

		frm.setSize(650,350);
		
		
		frm.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		Panel p = new Panel();
		Panel p1 = new Panel();

		Label jzooName = new Label("Zoo Name");
		final TextField lzooName = new TextField(30);
		lzooName.setText(zooname);
		
		Label jAddress1 =new Label("Address1");
		final TextField lAddress1=new TextField(40);
		lAddress1.setText(Address1);

		Label jAddress2 =new Label("Address2");
		final TextField lAddress2=new TextField(40);
		lAddress2.setText(Address2);

		Label jcity =new Label("City");
		final TextField lcity=new TextField(20);
		lcity.setText(City);

		Label jState =new Label("State");
		final TextField lstate=new TextField(20);
		lstate.setText(State);

		Label jCountry =new Label("Country");
		final  TextField lcountry=new TextField(20);
		lcountry.setText(Country);


		p.setLayout(new GridLayout(7,2));
		p.add(jzooName);
		p.add(lzooName);
		p.add(jAddress1);
		p.add(lAddress1);
		p.add(jAddress2);
		p.add(lAddress2);
		p.add(jState);
		p.add(lstate);
		p.add(jcity);
		p.add(lcity);
		p.add(jCountry);
		p.add(lcountry);
		Button save=new Button("Save");
		Button Update=new Button("Update");
		Button Clear= new Button("Clear");
		
		if(!"".equals(Address1) && !"".equals(Address2) && !"".equals(City) && !"".equals(State) && !"".equals(Country))
		{
			p.add(Update);
		}
		else 
		{
			p.add(save);
		}
		
		p.add(Clear);

		p1.add(p);
		frm.add(p1,BorderLayout.PAGE_START);
		frm.setVisible(true);
		
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				String name= lzooName.getText();
				String address1= lAddress1.getText();
				String address2= lAddress2.getText();
				String city= lcity.getText();
				String state= lstate.getText();
				String country= lcountry.getText();
				int i=ValidateName(name);

				if((!"".equals(name))&&(!"".equals(address1))&&(!"".equals(city))&&(!"".equals(state))&&(!"".equals(country))&&(i!=0))
				{
					try 
					{

						String sql= "UPDATE [dbo].[Zoo_Address] SET Address1='"+lAddress1.getText()+"',Address2='"+lAddress2.getText()+"'," +
								"City='"+lcity.getText()+"',State='"+lstate.getText()+"',Country='"+lcountry.getText()+"'" +
								" where idZooAddress="+z;

						Connection con1= DBConnectionZoo.getdbconnection();
						Statement stmt= con1.createStatement();
						stmt.execute(sql);
						JOptionPane.showMessageDialog(null, "Data is successfully Updated");
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
				else
				{
					JOptionPane.showMessageDialog(null, "invalid field value");
				}
			}

		});
		

		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				String name= lzooName.getText();
				String address1= lAddress1.getText();
				String address2= lAddress2.getText();
				String city= lcity.getText();
				String state= lstate.getText();
				String country= lcountry.getText();
				int i=ValidateName(name);

				if((!"".equals(name))&&(!"".equals(address1))&&(!"".equals(city))&&(!"".equals(state))&&(!"".equals(country))&&(i!=0))
				{
					try 
					{

						String sql= ("INSERT INTO [dbo].[Zoo_Address]([ZooName],[Address1],[Address2],[City] ,[State] ,[Country]) VALUES" +
								"('"+name+"','"+address1+"','"+address2+"'," +"'"+city+"','"+state+"','"+country+"')");

						Connection con1= DBConnectionZoo.getdbconnection();
						Statement stmt= con1.createStatement();
						stmt.execute(sql);
						JOptionPane.showMessageDialog(null, "Data is successfully inserted");
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
				else
				{
					JOptionPane.showMessageDialog(null, "invalid field value");
				}
			}

		});

		Clear.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				lzooName.setText("");
				lAddress1.setText("");
				lAddress2.setText("");
				lcity.setText("");
				lstate.setText("");
				lcountry.setText("");
			}
		});


	}
	public static int ValidateName(String name)
	{
		for (int i = 0; i < name.length(); i++) 
		{
			char c = name.charAt(i);
			if (Character.isDigit(c)) 
			{
				return 0;	
			}
		}
		return 1;
	}
	
	
	public static void main(String[] args) {
		ZooAddressFrame zaf=new ZooAddressFrame();
		zaf.EditData(0, "","", "", "", "", "");
	}
}