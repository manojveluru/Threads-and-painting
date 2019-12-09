package com.javaclass.assignments;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Ball {

	Color color;
	int radius;
	int x,y;
	int dx,dy;
	
	public Ball(Color col, int rad, int x, int y, int dx, int dy) 
	{
        this.color = col;
        this.radius = rad;
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
	}
	
	public void move(Dimension dPanel) //Move Function
	{
		if(x <= radius || x >= (dPanel.width - radius)) //Checks to see if ball has hit the edge of the panel.
		{
			dx = -dx;       //If so, switch direction.
		}     
		if(y <= radius || y >= (dPanel.height - radius))        //Same for y direction.
		{
			dy = -dy;
		}  
		x+=dx;	//If not, continue moving the ball in the direction and modify the coordinates to reflect the move.
		y+=dy;

	}
	
	public void draw(Graphics g) //Draws the ball in its new location, chaning x and y each time.
	{
        g.setColor(Color.WHITE);        //Sets color to the background.
        g.fillOval(x - dx, y - dy, 2 * radius, 2 * radius);     //Clears the old ball.
        g.setColor(color);      //Sets the color to whatever the balls color was.
        g.fillOval(x, y, 2 * radius, 2 * radius);       //Draws the ball in the new location.
	}
}
