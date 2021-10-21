package employee;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Home_Page extends Frame implements ActionListener{
	
	Label top, mid, bottom;
	Button b;
	Panel p, p1;
	
	public Home_Page() {
		
		
		
		b = new Button("ENTER");
		b.setFont(new Font("serif",Font.BOLD,15));
		b.setBackground(Color.BLACK);
		b.setForeground(Color.WHITE);
		
		top = new Label("WELCOME");
		top.setFont(new Font("serif",Font.BOLD,30));
		mid = new Label("TO");
		mid.setFont(new Font("serif",Font.BOLD,30));
		bottom = new Label("HR MANAGEMENT SYSTEM");
		bottom.setFont(new Font("serif",Font.BOLD,30));
		
		p = new Panel();
		p.setLayout(new FlowLayout());
		p.add(top);
		p.add(mid);
		p.add(bottom);
		
		p1= new Panel();
		p1.setLayout(new FlowLayout());
		p1.add(b);
		
		setLayout(new BorderLayout());
		add(p, BorderLayout.CENTER);
		add(p1, BorderLayout.SOUTH);
		
		b.addActionListener(this);
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
			
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == b) {
			
			setVisible(false);
			new Login();
			
		}
		
	}
	
	public static void main(String[] args) {
		
		Home_Page hp = new Home_Page();
		hp.setSize(500, 200);
		hp.setVisible(true);
		
	}

}
