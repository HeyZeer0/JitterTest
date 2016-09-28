package net.heyzeer0.jittertest.layouts;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class CompletedLayout extends JFrame {

	private static final long serialVersionUID = 1L;
	
	boolean opened = false;
	
	public CompletedLayout(String title, Integer pontuação) {
		super(title);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CountLayout.class.getResource("/net/heyzeer0/jittertest/resources/icone.png")));
		getContentPane().setBackground(new Color(220, 220, 220));
		//getContentPane().setLayout(null);
		
		setUndecorated(true);
		getContentPane().setLayout(null);
		
		JLabel lblLoading = new JLabel(pontuação.toString());
		lblLoading.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoading.setFont(new Font("Arial", Font.BOLD, 20));
		lblLoading.setBounds(11, 38, 298, 34);
		getContentPane().add(lblLoading);
		
		JLabel label = new JLabel("SUA PONTUA\u00C7\u00C3O");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setBounds(11, 11, 298, 40);
		getContentPane().add(label);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setBackground(Color.LIGHT_GRAY);
		textPane_1.setBounds(10, 11, 299, 61);
		getContentPane().add(textPane_1);
		
		setTitle("Report Program");
		
		Timer timer = new Timer(3000, new ActionListener() {
			  @Override
			  public void actionPerformed(ActionEvent arg0) {
			    dispose();
			    
			    if(!opened) {
					JFrame frame = new StartLayout("JitterTest 1.0");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setSize(276, 175);
					frame.setVisible(true);
					frame.setResizable(false);
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
					
					opened = true;
			    }
			    
			  }
		});
		
		
		timer.setRepeats(false);
		timer.start();
		
		
	}

}
