package com.zf.work;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Pillar {
	private BufferedImage pillar;
	private int x;
	private int y;
	private int width;
	private int height;
	private int gap=144;
	public static int count=0;
	public int distance=200;
	private Random rand=new Random();
	public Pillar(){
		try {
			count++;
			pillar=ImageIO.read(getClass().getResourceAsStream("column.png"));
			width=pillar.getWidth();
			height=pillar.getHeight();
			x=500+(count-1)*distance;
			y=rand.nextInt(300)+100-height/2;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void step(){
		x--;
		if(x==-width){
			x=2*distance+2*width;
			y=rand.nextInt(300)+100-height/2;
		}
	}
	public BufferedImage getPillar() {
		return pillar;
	}
	public void setPillar(BufferedImage pillar) {
		this.pillar = pillar;
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
	public int getGap() {
		return gap;
	}
	public void setGap(int gap) {
		this.gap = gap;
	}
	

}
