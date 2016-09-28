package net.heyzeer0.jittertest;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import net.heyzeer0.jittertest.layouts.StartLayout;

public class Main {
	
	public static void main(String[] args) {
		JFrame frame = new StartLayout("JitterTest 1.0");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(276, 175);
		frame.setVisible(true);
		frame.setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
	}
	
	@Override
	public void finalize() throws Throwable
	{
	    try{
	    }catch(Throwable t){
	        throw t;
	    }finally{
	        super.finalize();
	    }
	}

}
