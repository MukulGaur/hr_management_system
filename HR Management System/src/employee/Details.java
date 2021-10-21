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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.border.Border;

public class Details extends Frame implements ActionListener{
	
	Label l;
	Button add, view, remove, update;
	Panel p, p1, p2;
	
	

	public Details() {
		
		l = new Label("Employee Details");
		l.setFont(new Font("serif",Font.BOLD,45));
		
		add = new Button("ADD");
		add.setFont(new Font("serif",Font.BOLD,15));
		add.addActionListener(this);
		add.setBackground(Color.BLACK);
		add.setForeground(Color.WHITE);

		view = new Button("VIEW");
		view.setFont(new Font("serif",Font.BOLD,15));
		view.addActionListener(this);
		view.setBackground(Color.BLACK);
		view.setForeground(Color.WHITE);
		
		remove = new Button("REMOVE");
		remove.setFont(new Font("serif",Font.BOLD,15));
		remove.addActionListener(this);
		remove.setBackground(Color.BLACK);
		remove.setForeground(Color.WHITE);
		
		update = new Button("UPDATE");
		update.setFont(new Font("serif",Font.BOLD,15));
		update.addActionListener(this);
		update.setBackground(Color.BLACK);
		update.setForeground(Color.WHITE);
		
		p1 = new Panel();
		p1.setLayout(new FlowLayout());
		p1.add(l);
		
		p2 = new Panel();
		p2.setLayout(new GridLayout(2,2));
		p2.add(add);
		p2.add(view);
		p2.add(remove);
		p2.add(update);
		
		setLayout(new BorderLayout());
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.SOUTH);
		
		
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
			
		});
		
		setVisible(true);
		setSize(350, 250);
		
	}



	public static void main(String[] args) {
		
		Details d = new Details();

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==add){
            setVisible(false);
            new Add_Employee();
        }
        if(e.getSource()==view){
            setVisible(false);
            new View_Employee();
        }
        if(e.getSource()==remove){
            setVisible(false);
            new Remove_Employee();
        }
        if(e.getSource()==update){
            setVisible(false);
            new Search_Employee();
        }
		
	}

}
