package net.heyzeer0.jittertest.layouts;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class CountLayout extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
    static Point mouseDownCompCoords;
    
    boolean firstclicked = false;
    Integer clicks = 0;
    
    boolean opened = false;
	
	public CountLayout(String title) {
		super(title);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CountLayout.class.getResource("/net/heyzeer0/jittertest/resources/icone.png")));
		getContentPane().setBackground(new Color(220, 220, 220));
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("0");
		label.setFont(new Font("Arial", Font.BOLD, 30));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 77, 255, 42);
		getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("by HeyZeer0");
		lblNewLabel.setBounds(156, 54, 75, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblTitulo = new JLabel("JitterTest 1.0");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 30));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 11, 255, 65);
		getContentPane().add(lblTitulo);
		
		JButton btnIniciar = new JButton("CLIQUE AQUI");
		btnIniciar.setBackground(Color.GREEN);
		btnIniciar.setForeground(Color.DARK_GRAY);
		btnIniciar.setBounds(62, 120, 143, 23);
		getContentPane().add(btnIniciar);
		btnIniciar.setBorderPainted(false);
		btnIniciar.setFocusable(false);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setBackground(new Color(220, 220, 220));
		textPane_1.setBounds(20, 77, 231, 75);
		getContentPane().add(textPane_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBackground(Color.LIGHT_GRAY);
		textPane.setBounds(10, 11, 255, 153);
		getContentPane().add(textPane);
		setUndecorated(true);
		
		mouseDownCompCoords = null;
		
		btnIniciar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!firstclicked) {
					//start count
					
					Timer timer = new Timer(10000, new ActionListener() {
						  @Override
						  public void actionPerformed(ActionEvent arg0) {
						    dispose();
						    
						    if(!opened) {
						    	JFrame frame = new CompletedLayout("JitterTest 1.0", clicks);
								frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								frame.setSize(320 , 84);
								frame.setVisible(true);
								frame.setResizable(false);
								Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
								frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2 + 25);
								
								clicks = 0;
								opened = true;
						    }
						    
						  }
					});
					
					
					timer.setRepeats(false);
					timer.start();
					
				}
				
				clicks++;
				label.setText(clicks.toString());
			}
		
		});
		
        addMouseListener(new MouseListener(){
            public void mouseReleased(MouseEvent e) {
                mouseDownCompCoords = null;
            }
            public void mousePressed(MouseEvent e) {
                mouseDownCompCoords = e.getPoint();
            }
            public void mouseExited(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseClicked(MouseEvent e) {}
            
        });

        addMouseMotionListener(new MouseMotionListener(){
            public void mouseMoved(MouseEvent e) {
            }

            public void mouseDragged(MouseEvent e) {
                Point currCoords = e.getLocationOnScreen();
                setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
            }
        });
		
		
	}
}
