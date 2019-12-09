package com.javaclass.assignments;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;


public class MainPanel extends JPanel implements ActionListener
{
	String[] imageStringNameA ={"pat1.gif","pat2.gif","pat3.gif","pat4.gif","pat5.gif"};//images
	
	final static Image[] imageA = new Image[5]; //image arr holds 5 images we load using toolkit code
	
	JToolBar MainPanelToolBar = new JToolBar(); //pointer to toolbar for main panel
	TitleGridPanel tileGridPanelPtr = new TitleGridPanel(); //pointer to area where we will “paint” itmes on a tile Grid
	BallAnimation b = new BallAnimation();
	JPanel resetPanel = new JPanel();
	JButton patch1btn;
	JButton patch2btn;
	JButton patch3btn;
	JButton patch4btn;
	JButton patch5btn;
	JButton resetbtn;
	
	public MainPanel() 
	{
		Toolkit tileToolBar = Toolkit.getDefaultToolkit(); //Toolkit initialization
		Dimension d = tileToolBar.getScreenSize();
		
		//Adding images to the image array
		for(int i=0; i<imageStringNameA.length;i++) 
		{
			imageA[i] = (Image)Toolkit.getDefaultToolkit().getImage(imageStringNameA[i]);
		}
		
		this.setLayout(new BorderLayout());
		
		/*Adding images to the MainPanelToolBar at the top*/
		patch1btn = new JButton(new ImageIcon(imageA[0]));
		MainPanelToolBar.add(patch1btn);
		patch1btn.addActionListener(this);
		
		patch2btn = new JButton(new ImageIcon(imageA[1]));
		MainPanelToolBar.add(patch2btn);
		patch2btn.addActionListener(this);
		
		patch3btn = new JButton(new ImageIcon(imageA[2]));
		MainPanelToolBar.add(patch3btn);
		patch3btn.addActionListener(this);
		
		patch4btn = new JButton(new ImageIcon(imageA[3]));
		MainPanelToolBar.add(patch4btn);
		patch4btn.addActionListener(this);
		
		patch5btn = new JButton(new ImageIcon(imageA[4]));
		MainPanelToolBar.add(patch5btn);
		patch5btn.addActionListener(this);
		
		this.add(MainPanelToolBar, BorderLayout.NORTH);
	
		MainPanelToolBar.setBackground(Color.ORANGE); 
		//add(this,BorderLayout.CENTER);
		this.add(tileGridPanelPtr, BorderLayout.CENTER);
		tileGridPanelPtr.setBackground(Color.YELLOW);
		tileGridPanelPtr.ResetGridTile();
		
		//this.add(b,BorderLayout.EAST);
		//Adding reset button to the south region of the panel
		resetbtn = new JButton("Reset");
		resetPanel.add(resetbtn);
		resetbtn.addActionListener(this);
		this.add(resetPanel,BorderLayout.SOUTH);
		resetPanel.setBackground(Color.PINK);
		
	}//end constructor
	

	public void actionPerformed(ActionEvent e)  //put in listener method for button clicks on toolbar
	{
		if(e.getSource() == patch1btn) //was  button A  clicked in toolbar?
		{
			tileGridPanelPtr.selectedTile = 0; //this sets the variable in tileGridPanel object
		}
		else if(e.getSource() == patch2btn) //was  button A  clicked in toolbar?
		{
			tileGridPanelPtr.selectedTile = 1; //this sets the variable in tileGridPanel object
		}
		else if(e.getSource() == patch3btn) //was  button A  clicked in toolbar?
		{
			tileGridPanelPtr.selectedTile = 2; //this sets the variable in tileGridPanel object
		}
		else if(e.getSource() == patch4btn) //was  button A  clicked in toolbar?
		{
			tileGridPanelPtr.selectedTile = 3; //this sets the variable in tileGridPanel object
		}
		else if(e.getSource() == patch5btn) //was  button A  clicked in toolbar?
		{
			tileGridPanelPtr.selectedTile = 4; //this sets the variable in tileGridPanel object
		}
		else if(e.getSource() == resetbtn) 
		{
			tileGridPanelPtr.ResetGridTile();
		}
		
	}
}
