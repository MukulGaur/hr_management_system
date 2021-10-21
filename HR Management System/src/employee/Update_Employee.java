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
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Update_Employee extends Frame implements ActionListener{
	
	Label head, lemp_id, lname, lage, laddr, lemail, ldesg, ldept, ldob, lphno, lsalary;
	Button btnBack, btnUpdate;
	TextField emp_id, name, age, addr, email, desg, dept, dob, phno, salary;
	Panel p1, p2, p3;
	String e_id;
	
	

	public Update_Employee(String id) {
		
		e_id = id;
		
		lname = new Label("Name : ");
		lname.setFont(new Font("serif",Font.BOLD,25));
		lage = new Label("Age : ");
		lage.setFont(new Font("serif",Font.BOLD,25));
		laddr = new Label("Address : ");
		laddr.setFont(new Font("serif",Font.BOLD,25));
		lemail = new Label("Email : ");
		lemail.setFont(new Font("serif",Font.BOLD,25));
		ldesg = new Label("Designation : ");
		ldesg.setFont(new Font("serif",Font.BOLD,25));
		ldept = new Label("Department : ");
		ldept.setFont(new Font("serif",Font.BOLD,25));
		ldob = new Label("DOB : ");
		ldob.setFont(new Font("serif",Font.BOLD,25));
		lphno = new Label("Phno : ");
		lphno.setFont(new Font("serif",Font.BOLD,25));
		lsalary = new Label("Salary : ");
		lsalary.setFont(new Font("serif",Font.BOLD,25));
		
		name = new TextField();
		age = new TextField();
		addr = new TextField();
		email = new TextField();
		desg = new TextField();
		dept = new TextField();
		dob = new TextField();
		phno = new TextField();
		salary = new TextField();
		
		head = new Label("EMPLOYEE DETAILS");
		head.setFont(new Font("serif",Font.BOLD,30));
		
		btnBack = new Button("BACK");
		btnBack.setFont(new Font("serif",Font.BOLD,15));
		btnBack.addActionListener(this);
		btnBack.setBackground(Color.BLACK);
		btnBack.setForeground(Color.WHITE);
		
		btnUpdate = new Button("UPDATE");
		btnUpdate.setFont(new Font("serif",Font.BOLD,15));
		btnUpdate.addActionListener(this);
		btnUpdate.setBackground(Color.BLACK);
		btnUpdate.setForeground(Color.WHITE);
		
		p1 = new Panel();
		p1.setLayout(new FlowLayout());
		p1.add(head);
		
		p2 = new Panel();
		p2.setLayout(new GridLayout(9,2));
		p2.add(lname);
		p2.add(name);
		p2.add(lage);
		p2.add(age);
		p2.add(laddr);
		p2.add(addr);
		p2.add(lemail);
		p2.add(email);
		p2.add(ldesg);
		p2.add(desg);
		p2.add(ldept);
		p2.add(dept);
		p2.add(lphno);
		p2.add(phno);
		p2.add(lsalary);
		p2.add(salary);
		p2.add(ldob);
		p2.add(dob);
		
		p3 = new Panel();
		p3.setLayout(new FlowLayout());
		p3.add(btnUpdate);
		p3.add(btnBack);
		
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
		setSize(500, 450);
		
		show_data(id);
		
	}

	int i=0;

	private void show_data(String id2) {
		
		try{
			
			String q = "select * from employees where emp_id = '"+id2+"'";
			
			Connection c = MyConnection.getMyConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(q);
			
			if(rs.next()) {
				
				i=1;
				
				name.setText(rs.getString(2));
				age.setText(rs.getString(3));
				addr.setText(rs.getString(4));
				email.setText(rs.getString(5));
				desg.setText(rs.getString(6));
				dept.setText(rs.getString(7));
				dob.setText(rs.getString(8));
				phno.setText(rs.getString(9));
				salary.setText(rs.getString(10));
				
			}
			
			if(i==0) {
				JOptionPane.showMessageDialog(null, "Id not found!");
				new Search_Employee();
			}
			
			
			
		}catch(Exception ex) {
			setVisible(false);
			setSize(600, 500);
		}
		
	}



	public static void main(String[] args) {
		String s = "4569";
		new Update_Employee(s);

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnUpdate && i==1){
            try{
            	
            	String str = "update employees set name='"+name.getText()+"',age='"+age.getText()+"',address='"+addr.getText()+"',email='"+email.getText()+"',designation='"+desg.getText()+"',department='"+dept.getText()+"',dob='"+dob.getText()+"',phno='"+phno.getText()+"',salary='"+salary.getText()+"' where emp_id='" + e_id + "'";
            	
            	Connection c = MyConnection.getMyConnection();
				PreparedStatement ps = c.prepareStatement(str);
				ps.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"successfully updated");
                setVisible(false);
                new Search_Employee();
            }catch(Exception ex){
                System.out.println("The error is:"+ex);
            }
        }
        if(e.getSource()==btnBack){
            setVisible(false);
            new Details();
        }
		
	}

}
