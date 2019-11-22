package rera1n.xlindseyj.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GUI implements ActionListener {
    private JFrame frame = new JFrame();
    public Process process;

    public GUI() {
        JButton button = new JButton("Make it ra1n");
        button.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        
        frame.getContentPane().setPreferredSize(new Dimension(300, 75));
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("ReRa1n");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
			String[] cmd = { "rera1n.sh" };
			process = Runtime.getRuntime().exec(cmd); 
			process.waitFor(); 
			BufferedReader reader=new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			
			String line; 
			while((line = reader.readLine()) != null) { 
				System.out.println(line);
			} 
		} catch (IOException io) {
    	   io.printStackTrace();
   		} catch (InterruptedException ie) {
    	   ie.printStackTrace();
   		}
    }

    public static void main(String[] args) {
        new GUI();
    }
}