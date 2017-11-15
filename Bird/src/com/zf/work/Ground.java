package com.zf.work;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ground {
	private BufferedImage ground;
	private int x;
	private int y;
	public  Ground(){
		try {
			ground=ImageIO.read(getClass().getResource("ground.png"));
			x=0;
			y=500;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void step(){
		x--;
		if(x==-100){
			x=0;
		}
	}
	public BufferedImage getGround() {
		return ground;
	}
	public void setGround(BufferedImage ground) {
		this.ground = ground;
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

}
