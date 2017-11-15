package com.zf.work;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bird {
	private BufferedImage image;
	private int x;
	private int y;
	private int width;
	private int height;
	private BufferedImage images[];
	private int index=0;
	private double speed=0;
	private double upSpeed;
	private double s;
	private double t;
	private double g;
	
	public Bird(){
		try {
			
			image=ImageIO.read(getClass().getResourceAsStream("0.png"));
			x=225;
			y=200;
			width=image.getWidth();
			height=image.getHeight();
			images=new BufferedImage[8];
			for(int i=0;i<8;i++){
				images[i]=ImageIO.read(getClass().getResourceAsStream(i+".png"));
			}
			upSpeed=15;
			s=0;
			t=0.25;
			g=4;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void fly(){
		index++;
		image=images[index/5%8];
		
	}
	public void move(){
		double v=speed;
		s=v*t+g*t*t/2;
		speed=v-g*t;
		y=y-(int)s;
	}
	
	public void up(){
		speed=upSpeed;
		
	}
	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	

}
