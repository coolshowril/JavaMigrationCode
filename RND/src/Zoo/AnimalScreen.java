package Zoo;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.*;

@SuppressWarnings("unused")
public class AnimalScreen 
{
	public void Editdata(final int animalid,String animalname,String animaltype,String foodtype)
	{

		String[] AnimalType = { "Mammal", "Reptile", "Birds"};
		String[] FoodType = {"Veg","Non-Veg"};
		JFrame frame=new JFrame("Animal Details");
		frame.setSize(700,200);
		
		frame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});


		Label lAnimalName = new Label("Animal Name");
		final JTextField  tAnimalName= new JTextField(20);
		tAnimalName.setText(animalname);
		
		JLabel lAnimalType=new JLabel("Animal Type");
		final JComboBox cAnimalType = new JComboBox(AnimalType);	
		cAnimalType.setSelectedItem(animaltype);
		
		JLabel lFoodType=new JLabel("Food Type");
		final JComboBox cFoodType = new JComboBox(FoodType);
		cFoodType.setSelectedItem(foodtype);
		
		JButton Submit = new JButton("Submit");
		JButton Update=new JButton("Update");
		JButton Clear = new JButton("Clear");
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(5,2));
		p.add(lAnimalName);
		p.add(tAnimalName);
		p.add(lAnimalType);
		p.add(cAnimalType);
		p.add(lFoodType);
		p.add(cFoodType);
		/*Submit.setVisible(false);
		Update.setVisible(false);*/
		if(!"".equals(animalname) && !"".equals(animaltype) && !"".equals(foodtype))
		{
			p.add(Update);
			
		}
		else
		{
			p.add(Submit);
		}
		p.add(Clear);
		frame.add(p);
		frame.setVisible(true);
		
		
		Update.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt)
			{
				int i=ValidateName(tAnimalName.getText());
				if(!"".equals(tAnimalName.getText()) && i!=0)
				{
					try 
					{
						ZooMain.executeQuery("UPDATE [dbo].[Zoo_Animals] SET Animals='" 
								+tAnimalName.getText()+"',AnimalType='"+cAnimalType.getSelectedItem()+
								"',FoodType='"+cFoodType.getSelectedItem()+"' where idZooAnimals="+animalid);
						JOptionPane.showMessageDialog(null, "Data is successfully Updated");
					} 
					catch (FileNotFoundException e) 
					{
						e.printStackTrace();
					} 
					catch (ClassNotFoundException e) 
					{
						e.printStackTrace();
					} 
					catch (IOException e) 
					{
						e.printStackTrace();
					} 
					catch (SQLException e) 
					{
						e.printStackTrace();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Animal Name");
				}
			}
		});
		
		Submit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt)
			{
				int i=ValidateName(tAnimalName.getText());
				if(!"".equals(tAnimalName.getText()) && i!=0)
				{
					try 
					{
						ZooMain.executeQuery("INSERT INTO [dbo].[Zoo_Animals]([Animals],[AnimalType],[FoodType]) VALUES('"
								+tAnimalName.getText()+"','"+cAnimalType.getSelectedItem()+"','"+cFoodType.getSelectedItem()+"')");
						JOptionPane.showMessageDialog(null, "Data is successfully Inserted");
					} 
					catch (FileNotFoundException e) 
					{
						e.printStackTrace();
					} 
					catch (ClassNotFoundException e) 
					{
						e.printStackTrace();
					} 
					catch (IOException e) 
					{
						e.printStackTrace();
					} 
					catch (SQLException e) 
					{
						e.printStackTrace();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Animal Name");
				}
			}
		});
		Clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tAnimalName.setText("");
				cAnimalType.setSelectedIndex(0);
				cFoodType.setSelectedIndex(0);

			}
		});
	}

	public int ValidateName(String name)
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
		AnimalScreen as=new AnimalScreen();
		as.Editdata(0, "", "", "");
	}
}
