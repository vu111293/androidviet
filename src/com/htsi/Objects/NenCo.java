package com.htsi.Objects;

public class NenCo extends Cuon {

	public NenCo(float x, float y, int width, int height, float tocDoCuon) {
		super(x, y, width, height, tocDoCuon);
		// TODO Auto-generated constructor stub
	}
	
	
	public void onRestart(float x, float tocDoCuon) {
		position.x = x;
		velocity.x = tocDoCuon;
	}
}
