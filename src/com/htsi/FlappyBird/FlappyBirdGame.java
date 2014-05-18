package com.htsi.FlappyBird;

import com.badlogic.gdx.Game;
import com.htsi.AccessData.TruyXuatTaiNguyen;
import com.htsi.Screens.ManHinhGame;


public class FlappyBirdGame extends Game  {

	@Override
	public void create() {
		// TODO Auto-generated method stub
		TruyXuatTaiNguyen.load();
		setScreen(new ManHinhGame());
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
		TruyXuatTaiNguyen.dispose();
	}
}
