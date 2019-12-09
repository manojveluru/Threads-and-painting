package com.javaclass.assignments;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class TitleGridPanel extends JPanel implements MouseListener{

	int selectedTile = -1; //this is set to 0-4 when user clicks on a button in toolbar

	static final int squareSide = 25; 
	int GridRow=5,GridCol=5;						

	Image[][] gif2dArray = new Image[GridRow][GridCol]; //we take gifs in here and draw in tilegrid

	//Calling mouse listener
	public TitleGridPanel() {
		CreateMouseListener();
	}

	//Reset method
	public void ResetGridTile() 
	{
		for(int row=0;row<GridRow;row++) 
		{
			for(int col=0;col<GridCol;col++) 
			{
				gif2dArray[row][col] = null; //setting all to null
			}
		}
		this.repaint(); //draw empty grid
	}
	
	public void CreateMouseListener() 
	{
		addMouseListener(this);
	}
	
	/*Filling the panel with selected image*/
	@Override
	public void mouseClicked(MouseEvent e) {
		
			if(selectedTile == -1) 
			{
				System.out.println("Please select any on the top");
			}
			else 
			{
				for(int row=0;row<GridRow;row++) 
				{
					for(int col=0;col<GridCol;col++) 
					{
						gif2dArray[row][col] = MainPanel.imageA[selectedTile]; 
					}
				}
				this.repaint();
			}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	//Creating Space for center panel
	public void paintComponent(Graphics g) 
	{
		  super.paintComponent(g);
		  int gridWidth = GridCol*squareSide;  //need to find center area of the center panel
		  int gridHeight = GridRow*squareSide;
		  int panelWidth = getWidth();
		  int panelHeight = getHeight();
		  int startX = (panelWidth-gridWidth)/2;//get starting point to draw grid based 
		  int startY = (panelHeight-gridHeight)/2;
		  for(int row=0;row<GridRow;row++) 
			{
				for(int col=0;col<GridCol;col++) 
				{
					g.drawImage(gif2dArray[row][col], startX+(squareSide*row), startY+(squareSide*col), this);
				}
			}
		  

	}
}
