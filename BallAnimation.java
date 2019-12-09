package com.javaclass.assignments;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BallAnimation extends JPanel implements ActionListener{
	JButton start; //Start button
	JButton stop;  //Stop button
	JPanel pan = new JPanel();
	AnimationPanel animationPanel = new AnimationPanel(); //AnimationPanel instance
	BallAnimation()
	{
		pan.setBackground(Color.CYAN);
		start = new JButton("Start");
		pan.add(start);
		start.addActionListener(this);
		stop = new JButton("Stop");
		pan.add(stop);
		stop.addActionListener(this);
		this.setLayout(new BorderLayout());
		this.add(pan,BorderLayout.SOUTH);
		this.add(animationPanel,BorderLayout.EAST);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == start) //When Start was clicked
		{
			stop.setEnabled(true);
			start.setEnabled(false);
			animationPanel.start();
		}
		else if(e.getSource() == stop) //When stop was clicked
		{
			start.setEnabled(true);
			stop.setEnabled(false);
			animationPanel.stop();
		}
				
	}
}
