package com.javaclass.assignments;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class AnimationPanel extends JPanel implements Runnable{

	List<Ball> ballList = new ArrayList<>(); //List of Ball objects
	Dimension ballPanelDimensionPtr = null; //Dimension instance
	Thread threadObjPtr = null; //Thread instance
	Dimension dim = null; //Dimension instance
	
	public AnimationPanel() {
		dim = new Dimension(350,350);
		this.setPreferredSize(dim);
		this.setBackground(Color.WHITE);
	}
	
	public void start() 
	{
		if(threadObjPtr==null) 
		{
			threadObjPtr = new Thread(this,"Instance");
			threadObjPtr.start();
		}
	}
	
	public void stop() 
	{
		threadObjPtr=null;
	}
	
	@Override
	public Dimension getSize()
	{
		ballPanelDimensionPtr = new Dimension(99,99);
		return ballPanelDimensionPtr;
	}
	
	
	
	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		if(ballPanelDimensionPtr==null) 
		{
			ballPanelDimensionPtr = this.getSize();
			ballList.add(new Ball(Color.GREEN, 20,(ballPanelDimensionPtr.width * 2 / 3), (ballPanelDimensionPtr.height - 28),-4, 20));
			ballList.add(new Ball(Color.BLUE, 25,(ballPanelDimensionPtr.width * 2 / 3), (ballPanelDimensionPtr.height - 54),-2, -4));
			ballList.add(new Ball(Color.GRAY, 10,(ballPanelDimensionPtr.height),(ballPanelDimensionPtr.width),2,2));
			ballList.add(new Ball(Color.PINK, 18,(ballPanelDimensionPtr.width), (ballPanelDimensionPtr.height), -4, 12));
			ballList.add(new Ball(Color.ORANGE, 18,(ballPanelDimensionPtr.width* 2 / 3), (ballPanelDimensionPtr.height-18), 4, -12));
		}
		for(Ball b : ballList) 
		{
			b.move(dim);
			b.draw(g);
		}
		
	}

	@Override
	public void run() {
			System.out.println(threadObjPtr);
			while (threadObjPtr  !=  null) 
			{
				this.repaint();
				try {
					threadObjPtr.sleep(100);
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		}
		
}
