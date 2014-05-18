package com.htsi.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.htsi.AccessData.QuanLyTruyNhap;
import com.htsi.GameFactory.VeManHinh;
import com.htsi.GameFactory.TheGioiGame;

public class ManHinhGame implements Screen {
	
	private TheGioiGame world;
	private VeManHinh renderer;
	
	private float runTime;
	
	public ManHinhGame() {
		// TODO Auto-generated constructor stub
		System.out.println("Khoi tao GameScreen!");
		
		float screenWidth = Gdx.graphics.getWidth();
		float screenHeight = Gdx.graphics.getHeight();
		
		float gameWidth = 136;
		float gameHeight = screenHeight/(screenWidth/gameWidth);
		
		int midPointY = (int)gameHeight/2;
		
		world = new TheGioiGame(midPointY);
		renderer = new VeManHinh(world, (int)gameHeight, midPointY);
		
		Gdx.input.setInputProcessor(new QuanLyTruyNhap(world));
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		runTime += delta;
		world.update(delta);
		
//		float fps = 1/delta;
//		System.out.println(fps);
			
		renderer.render(runTime);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
