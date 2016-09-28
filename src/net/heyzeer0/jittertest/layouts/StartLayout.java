package net.heyzeer0.jittertest.layouts;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Toolkit;

public class StartLayout extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
    static Point mouseDownCompCoords;
	
	public StartLayout(String title) {
		super(title);
		setIconImage(Toolkit.getDefaultToolkit().getImage(StartLayout.class.getResource("/net/heyzeer0/jittertest/resources/icone.png")));
		getContentPane().setBackground(new Color(220, 220, 220));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("by HeyZeer0");
		lblNewLabel.setBounds(157, 62, 75, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblTitulo = new JLabel("JitterTest 1.0");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 30));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 11, 255, 75);
		getContentPane().add(lblTitulo);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setBackground(Color.GREEN);
		btnIniciar.setForeground(Color.DARK_GRAY);
		btnIniciar.setBounds(91, 87, 89, 23);
		getContentPane().add(btnIniciar);
		btnIniciar.setBorderPainted(false);
		btnIniciar.setFocusable(false);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBackground(Color.RED);
		btnSair.setBounds(91, 121, 89, 23);
		getContentPane().add(btnSair);
		btnSair.setBorderPainted(false);
		btnSair.setFocusable(false);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBackground(Color.LIGHT_GRAY);
		textPane.setBounds(10, 11, 255, 153);
		getContentPane().add(textPane);
		setUndecorated(true);
		
		mouseDownCompCoords = null;
		
		btnIniciar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
				JFrame frame = new CountLayout("JitterTest 1.0");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(276, 175);
				frame.setVisible(true);
				frame.setResizable(false);
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
			}
			

		});
		
		btnSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(0);
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
