package com.zf.work;

import javax.swing.JFrame;

public class StartGame {

	public static void main(String[] args) {
		JFrame frame=new JFrame();
		frame.setBounds(300, 400, 450, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BirdGame game=new BirdGame();
		frame.add(game);
		frame.setVisible(true);
		game.action();
	}

}
