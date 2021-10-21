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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Print_Data extends Frame implements ActionListener{
	
	Label head, lemp_id, lname, lage, laddr, lemail, ldesg, ldept, ldob, lphno, lsalary, llemp_id, llname, llage, lladdr, llemail, lldesg, lldept, lldob, llphno, llsalary;
	Button back;
	String emp_id, name, age, addr, email, desg, dept, dob, phno, salary;
	Panel p1, p2, p3;
	
	

	public Print_Data(String e_id) {
		
		
		try{
			
			String q = "select * from employees where emp_id = '"+e_id+"'";
			
			Connection c = MyConnection.getMyConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(q);
			
			while(rs.next()) {
				
				emp_id = rs.getString("emp_id");
				name = rs.getString("name");
				age = rs.getString("age");
				addr = rs.getString("address");
				email = rs.getString("email");
				desg = rs.getString("designation");
				dept = rs.getString("department");
				dob = rs.getString("dob");
				phno = rs.getString("phno");
				salary = rs.getString("salary");
				
			}
			
		}catch(Exception ex) {
			
		}
		
		head = new Label("EMPLOYEE DETAILS");
		head.setFont(new Font("serif",Font.BOLD,30));
		
		
		lemp_id = new Label("Employee Id : ");
		lemp_id.setFont(new Font("serif",Font.BOLD,25));
		llemp_id = new Label(emp_id);
		llemp_id.setFont(new Font("serif",Font.BOLD,25));
		lname = new Label("Name : ");
		lname.setFont(new Font("serif",Font.BOLD,25));
		llname = new Label(name);
		llname.setFont(new Font("serif",Font.BOLD,25));
		lage = new Label("Age : ");
		lage.setFont(new Font("serif",Font.BOLD,25));
		llage = new Label(age);
		llage.setFont(new Font("serif",Font.BOLD,25));
		laddr = new Label("Address : ");
		laddr.setFont(new Font("serif",Font.BOLD,25));
		lladdr = new Label(addr);
		lladdr.setFont(new Font("serif",Font.BOLD,25));
		lemail = new Label("Email : ");
		lemail.setFont(new Font("serif",Font.BOLD,25));
		llemail = new Label(email);
		llemail.setFont(new Font("serif",Font.BOLD,25));
		ldesg = new Label("Designation : ");
		ldesg.setFont(new Font("serif",Font.BOLD,25));
		lldesg = new Label(desg);
		lldesg.setFont(new Font("serif",Font.BOLD,25));
		ldept = new Label("Department : ");
		ldept.setFont(new Font("serif",Font.BOLD,25));
		lldept = new Label(dept);
		lldept.setFont(new Font("serif",Font.BOLD,25));
		ldob = new Label("DOB : ");
		ldob.setFont(new Font("serif",Font.BOLD,25));
		lldob = new Label(dob);
		lldob.setFont(new Font("serif",Font.BOLD,25));
		lphno = new Label("Phno : ");
		lphno.setFont(new Font("serif",Font.BOLD,25));
		llphno = new Label(phno);
		llphno.setFont(new Font("serif",Font.BOLD,25));
		lsalary = new Label("Salary : ");
		lsalary.setFont(new Font("serif",Font.BOLD,25));
		llsalary = new Label(salary);
		llsalary.setFont(new Font("serif",Font.BOLD,25));
		
		back = new Button("BACK");
		back.setFont(new Font("serif",Font.BOLD,15));
		back.addActionListener(this);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		
		p1 = new Panel();
		p1.setLayout(new FlowLayout());
		p1.add(head);
		
		p2 = new Panel();
		p2.setLayout(new GridLayout(10,2));
		p2.add(lemp_id);
		p2.add(llemp_id);
		p2.add(lname);
		p2.add(llname);
		p2.add(lage);
		p2.add(llage);
		p2.add(laddr);
		p2.add(lladdr);
		p2.add(lemail);
		p2.add(llemail);
		p2.add(ldesg);
		p2.add(lldesg);
		p2.add(ldept);
		p2.add(lldept);
		p2.add(ldob);
		p2.add(lldob);
		p2.add(lphno);
		p2.add(llphno);
		p2.add(lsalary);
		p2.add(llsalary);
		
		
		p3 = new Panel();
		p3.setLayout(new FlowLayout());
		p3.add(back);
		
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
		setSize(500, 700);
		
		
		
	}

	public static void main(String[] args) {
		new Print_Data("456");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == back) {
			setVisible(false);
			new View_Employee();
		}
		
	}

}
