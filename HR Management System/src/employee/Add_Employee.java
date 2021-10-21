package employee;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagLayout;
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
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Add_Employee extends Frame implements ActionListener{
	
	Label head, name, age, address, email, desgn, emp_id, dept, dob, phno, salary;
	TextField tname, tage, taddress, temail, tdesgn, temp_id, tdept, tdob, tphno, tsalary;
	Button btnSubmit, btnCancel;
	Panel p1, p2, p3;
	
	
	

	public Add_Employee() {
		
		head = new Label("New Employee Details");
		head.setFont(new Font("serif",Font.BOLD,35));
		head.setForeground(Color.black);
		
		name = new Label("Name ");
		name.setFont(new Font("serif",Font.ITALIC,25));
		name.setForeground(Color.black);
		
		age = new Label("Age ");
		age.setFont(new Font("serif",Font.ITALIC,25));
		age.setForeground(Color.black);
		
		address = new Label("Address ");
		address.setFont(new Font("serif",Font.ITALIC,25));
		address.setForeground(Color.black);
		
		email = new Label("Email Id ");
		email.setFont(new Font("serif",Font.ITALIC,25));
		email.setForeground(Color.black);
		
		desgn = new Label("Designation ");
		desgn.setFont(new Font("serif",Font.ITALIC,25));
		desgn.setForeground(Color.black);
		
		emp_id = new Label("Employee Id ");
		emp_id.setFont(new Font("serif",Font.ITALIC,25));
		emp_id.setForeground(Color.black);
		
		dept = new Label("Department ");
		dept.setFont(new Font("serif",Font.ITALIC,25));
		dept.setForeground(Color.black);
		
		dob = new Label("Date of Birth ");
		dob.setFont(new Font("serif",Font.ITALIC,25));
		dob.setForeground(Color.black);
		
		phno = new Label("Phno");
		phno.setFont(new Font("serif",Font.ITALIC,25));
		phno.setForeground(Color.black);
		
		salary = new Label("Salary");
		salary.setFont(new Font("serif",Font.ITALIC,25));
		salary.setForeground(Color.black);
		
		tname = new TextField();
		
		tage = new TextField();
		
		taddress = new TextField();
		
		temail = new TextField();
		
		tdesgn = new TextField();
		
		temp_id = new TextField();
		
		tdept = new TextField();
		
		tdob = new TextField();
		
		tphno = new TextField();
		
		tsalary = new TextField();
		
		
		btnSubmit = new Button("SUBMIT");
		btnSubmit.setBackground(Color.BLACK);
		btnSubmit.setForeground(Color.WHITE);
        
		btnCancel = new Button("CANCEL");
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setForeground(Color.WHITE);
		
		btnSubmit.addActionListener(this);
		btnCancel.addActionListener(this);
		
		
		p1 = new Panel();
		p1.setLayout(new FlowLayout());
		p1.add(head);
		
		p2 = new Panel();
		p2.setLayout(new GridLayout(5,4));
		p2.add(name);
		p2.add(tname);
		p2.add(age);
		p2.add(tage);
		p2.add(address);
		p2.add(taddress);
		p2.add(email);
		p2.add(temail);
		p2.add(desgn);
		p2.add(tdesgn);
		p2.add(emp_id);
		p2.add(temp_id);
		p2.add(dept);
		p2.add(tdept);
		p2.add(dob);
		p2.add(tdob);
		p2.add(phno);
		p2.add(tphno);
		p2.add(salary);
		p2.add(tsalary);
		
		p3 = new Panel();
		p3.setLayout(new FlowLayout());
		p3.add(btnSubmit);
		p3.add(btnCancel);
		
		setLayout(new BorderLayout());
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		add(p3, BorderLayout.SOUTH);
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
			
		});
		
		setVisible(true);
		setSize(650, 300);

		
	}

	public static void main(String[] args) {
		
		Add_Employee ae = new Add_Employee();

	}




	@Override
	public void actionPerformed(ActionEvent e) {
		
		String emp_id = temp_id.getText();
		String name = tname.getText();
		int age = Integer.parseInt(tage.getText());
		String address = taddress.getText();
		String email = temail.getText();
		String designation = tdesgn.getText();
		String dept = tdept.getText();
		String dob = tdob.getText();
		String phno = tphno.getText();
		int salary = Integer.parseInt(tsalary.getText());
		
		if(e.getSource() == btnCancel){
            setVisible(false);
            new Details();
        }
		
		if(e.getSource() == btnSubmit){
            
			try {
				
				Connection c = MyConnection.getMyConnection();
				PreparedStatement ps = c.prepareStatement("insert into employees values(?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1, emp_id);
				ps.setString(2, name);
				ps.setInt(3, age);
				ps.setString(4, address);
				ps.setString(5, email);
				ps.setString(6, designation);
				ps.setString(7, dept);
				ps.setString(8, dob);
				ps.setString(9, phno);
				ps.setInt(10, salary);
				
				int i = ps.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Details Inserted Successfully");
				setVisible(false);
				new Details();
				
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Error" + ex);
				System.out.println("Error!  " + ex);
			}
			
        }		
		
	}

}
