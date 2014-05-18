package com.htsi.AccessData;

import com.badlogic.gdx.InputProcessor;
import com.htsi.GameFactory.TheGioiGame;
import com.htsi.Objects.ConChim;

public class QuanLyTruyNhap implements InputProcessor {
	
	private TheGioiGame tgGame;
	private ConChim conChim;
	
	public QuanLyTruyNhap(TheGioiGame gameWorld) {
		// TODO Auto-generated constructor stub
		this.tgGame = gameWorld;
		this.conChim = tgGame.getChim();
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		if(tgGame.sanSang()) {
			tgGame.batDau();
		}
		
		conChim.onClick();
		
		if (tgGame.ketThucGame()) {
			tgGame.khoiDongLai();
		}
		
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
