package employee;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Remove_Employee extends Frame implements ActionListener{
	
	Label l;
	TextField t;
	Button btnRemove, btnCancel;
	Panel p1, p2;
	

	public Remove_Employee() {
		
		l = new Label("Enter the Employee Id : ");
		l.setFont(new Font("serif",Font.BOLD,20));
		
		t = new TextField("");
		
		btnRemove = new Button("REMOVE");
		btnRemove.setFont(new Font("serif",Font.BOLD,15));
		btnRemove.addActionListener(this);
		btnRemove.setBackground(Color.BLACK);
		btnRemove.setForeground(Color.WHITE);
		
		btnCancel = new Button("CANCEL");
		btnCancel.setFont(new Font("serif",Font.BOLD,15));
		btnCancel.addActionListener(this);
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setForeground(Color.WHITE);
		
		p1 = new Panel();
		p1.setLayout(new GridLayout(1,2));
		p1.add(l);
		p1.add(t);
		
		p2 = new Panel();
		p2.setLayout(new FlowLayout());
		p2.add(btnRemove);
		p2.add(btnCancel);
		
		setLayout(new BorderLayout());
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
			
		});
		
		setVisible(true);
		setSize(450, 150);
		
		
	}



	public static void main(String[] args) {
		
		Remove_Employee re = new Remove_Employee();

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		String id = t.getText();
		
		if(e.getSource() == btnCancel){
            setVisible(false);
            new Details();
        }
        if(e.getSource() == btnRemove){
            
        	String q = "delete from employee where emp_id = '"+id+"'";
        	
        	try {
        		
        		Connection c = MyConnection.getMyConnection();
    			PreparedStatement ps = c.prepareStatement("delete from employees where emp_id=(?)");
    			ps.setString(1, id);
        		
    			int i = ps.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Record Deleted Successfully");
				
    			
        	} catch(Exception ex) {
        		
        		JOptionPane.showMessageDialog(null, "Error");
				System.out.println("Error!  " + ex);
        		
        	}
        	
        	
        }
		
	}

}
