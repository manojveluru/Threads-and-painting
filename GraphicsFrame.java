package com.javaclass.assignments;
/*******************************************
Programmer Name: Manoj Veluru, Vasista Gutta
Zid: Z1840907, Z1839489
Course : CSCI502
Assignment: 5
Instructor: James Leon
TA: Sindhuja Parimi
Deadline: 12/02/2019
********************************************/
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

public class GraphicsFrame extends JFrame{

	public GraphicsFrame() 
	{
		super();
		MainPanel mainPanelPtr = new MainPanel();//create mainpanel that overwrites the frame
		this.add(mainPanelPtr, BorderLayout.CENTER);//main panel covers entire frame
		BallAnimation b = new BallAnimation();
		this.add(b,BorderLayout.EAST);
		getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.LIGHT_GRAY));
	}
	
	public static void main(String[] args) 
	{
		createAndShowGUI();
	}

	private static void createAndShowGUI() {
		//Frame initialization
		GraphicsFrame frame = new GraphicsFrame();
		frame.setSize(700,450);
		
		frame.setVisible(true);
	}
}
