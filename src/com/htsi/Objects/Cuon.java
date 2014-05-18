package com.htsi.Objects;

import com.badlogic.gdx.math.Vector2;

public class Cuon {
	
	protected Vector2 position;
	protected Vector2 velocity;
	protected int width;
	protected int height;
	protected boolean cuonSangTrai;
	
	public Cuon(float x, float y, int width, int height, float tocDoCuon) {
		
		position = new Vector2(x,y);
		velocity = new Vector2(tocDoCuon, 0);
		this.width = width;
		this.height = height;
		cuonSangTrai = false;
	}
	
	public void update(float delta) {
		position.add(velocity).cpy().scl(delta);
		if (position.x + width < 0) {
			cuonSangTrai = true;
		}
	}
	
	public void dung() {
		velocity.x = 0;
	}
	
	
	public void reset(float newX) {
		position.x = newX;
		cuonSangTrai = false;
	}
	
	public boolean isCuonSangTrai() {
		return cuonSangTrai;
	}
	
	public float getTailX() {
		return position.x + width;
	}
	
	public float getX() {
		// TODO Auto-generated method stub
		return position.x;
	}
	
	public float getY() {
		// TODO Auto-generated method stub
		return position.y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

}
