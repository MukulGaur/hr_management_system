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
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Login extends Frame implements ActionListener{
	
	TextField user;
	JPasswordField pass;
	Label luser, lpass;
	Button btnLogin, btnCancel;
	Frame f;
	Panel p1, p2;
	
	public Login() {
		
		user = new TextField();
		pass = new JPasswordField();
		
		luser = new Label("Username: ");
		luser.setFont(new Font("serif",Font.BOLD,20));
		
		lpass = new Label("Password: ");
		lpass.setFont(new Font("serif",Font.BOLD,20));
		
		btnLogin = new Button("LOGIN");
		btnLogin.setFont(new Font("serif",Font.BOLD,15));
		btnLogin.addActionListener(this);
		btnLogin.setBackground(Color.BLACK);
		btnLogin.setForeground(Color.WHITE);
		
		btnCancel = new Button("CANCEL");
		btnCancel.setFont(new Font("serif",Font.BOLD,15));
		btnCancel.addActionListener(this);
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setForeground(Color.WHITE);
		
		p1 = new Panel(new GridLayout(2,2));
		p1.add(luser);
		p1.add(user);
		p1.add(lpass);
		p1.add(pass);
		
		p2 = new Panel(new FlowLayout());
		p2.add(btnLogin);
		
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
		setSize(250, 150);
		
		
	}

	public static void main(String[] args) {
		
		Login l = new Login();
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			
			String u = user.getText();
            String p = pass.getText();
            
            String q = "select * from login where username='"+u+"' and password='"+p+"'";
			
			Connection c = MyConnection.getMyConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(q);
			
			if(rs.next()) {
				
				new Details();
				setVisible(false);
				
			}
			
			else {
				JOptionPane.showMessageDialog(null, "Invalid username or password");
			}
			
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
