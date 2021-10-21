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

public class View_Employee extends Frame implements ActionListener{
	
	Label l;
	TextField t;
	Button btnSearch, btnCancel;
	Panel p1, p2;

	public View_Employee() {
		
		l = new Label("Enter the Employee ID : ");
		l.setFont(new Font("serif",Font.BOLD,20));

		
		t = new TextField();
		
		btnSearch = new Button("SEARCH");
		btnSearch.setFont(new Font("serif",Font.BOLD,15));
		btnSearch.addActionListener(this);
		btnSearch.setBackground(Color.BLACK);
		btnSearch.setForeground(Color.WHITE);
		
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
		p2.add(btnSearch);
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
		
		View_Employee ve = new View_Employee();

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnCancel){
            setVisible(false);
            new Details();
        }
        if(e.getSource() == btnSearch){
            setVisible(false);
            new Print_Data(t.getText());
        }
		
	}

}
