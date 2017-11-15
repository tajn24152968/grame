package com.zf.work;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
public class BirdGame extends JPanel{
	private BufferedImage bg,start;
	private Ground ground;
	private Bird bird;
	//private Pillar pillars;
	private int state=0;
	private final static int START=1;
	private final static int RUNNING=2;
	private final static int GAMEOVER=3;
	private Pillar pillar[]=new Pillar[2];
	private static int score=0;
			
	
	/*构造方法，修饰符+类名+形参
	作用：初始化
	*/
  public BirdGame(){
	  try {
		  //读取图片
		bg=ImageIO.read(getClass().getResourceAsStream("bg.png"));
		start=ImageIO.read(getClass().getResourceAsStream("start.png"));
		
		ground=new Ground();
		bird=new Bird();
		for(int i=0;i<2;i++){
		pillar[i]=new Pillar();
		}
		state=START;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
  @Override
public void paint(Graphics g) {
	// TODO Auto-generated method stub
	super.paint(g);
	g.drawImage(bg,0,0,null);
	
	
	switch (state) {
	case START:
		g.drawImage(start, 0, 0,null);
		
		break;
	case RUNNING:
		for(int i=0;i<2;i++){
	g.drawImage(pillar[i].getPillar(), pillar[i].getX(), pillar[i].getY(),null);
		}
			
			break;

	case GAMEOVER:
				
				break;
	}
	g.drawImage(ground.getGround(),ground.getX(), ground.getY(), null);
	g.drawImage(bird.getImage(), bird.getX(), bird.getY(),null);
	Font font=new Font(Font.SANS_SERIF,Font.ITALIC,40);
	g.setFont(font);
	g.setColor(Color.white);
	g.drawString(score+"", 40, 60);
}
 public void action(){
	 MyMouseListener listener=new MyMouseListener();
	 this.addMouseListener(listener);
	 while(true){
		 switch (state) {
			case START:
			ground.step();
			bird.fly();
			
				break;
			case RUNNING:
				ground.step();
				bird.fly();
				for(int i=0;i<2;i++){
					pillar[i].step();
					if(pillar[i].getX()==bird.getX()){
						score++;
					}
				}
				bird.move();
					break;

			case GAMEOVER:
						
						break;
			}
		
		 try {
			Thread.sleep(1000/60);
			repaint();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
 }
 class MyMouseListener extends MouseAdapter{
	 @Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mousePressed(e);
		switch (state) {
		case START:
			state=RUNNING;
			break;
		case RUNNING:
				bird.up();
				break;

		case GAMEOVER:
					
					break;
		}
	}
 }
}
