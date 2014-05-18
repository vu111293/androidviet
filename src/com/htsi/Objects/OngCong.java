package com.htsi.Objects;

import java.util.Random;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

public class OngCong extends Cuon {
	
	private Random r;
	
	private Rectangle ongCongTren, ongCongDuoi, napOngCongTren, napOngCongDuoi;
	private float matDat;
	
	public static final int KHOANG_TRONG_ONG = 45;
	public static final int W_MIENG_ONG = 24;
	public static final int H_MIENG_ONG = 11;
	
	private boolean daCanMuc = false;
	
	
	public OngCong(float x, float y, int width, int height, float tocDoCuon, float matDat) {
		super(x, y, width, height, tocDoCuon);
		// TODO Auto-generated constructor stub
		r = new Random();
		ongCongTren = new Rectangle();
		ongCongDuoi = new Rectangle();
		napOngCongTren = new Rectangle();
		napOngCongDuoi = new Rectangle();
		
		this.matDat = matDat;
	}
	
	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		super.update(delta);
		
		ongCongTren.set(position.x, position.y, width, height);
		ongCongDuoi.set(position.x, position.y + height + KHOANG_TRONG_ONG,
				width, 
				matDat - (position.y + height + KHOANG_TRONG_ONG));
		
		napOngCongTren.set(position.x - (W_MIENG_ONG - width)/2, 
				position.y + height - H_MIENG_ONG,
				W_MIENG_ONG, H_MIENG_ONG);
		napOngCongDuoi.set(position.x - (W_MIENG_ONG - width)/2, 
				ongCongDuoi.y, W_MIENG_ONG, H_MIENG_ONG);
	}
	
	@Override
	public void reset(float newX) {
		// TODO Auto-generated method stub
		super.reset(newX);
		height = r.nextInt(90) + 15;
		daCanMuc = false;
	}
	
	public void onRestart(float x, float tocDoCuon) {
		velocity.x = tocDoCuon;
		reset(x);
	}

	public Rectangle getOngCongTren() {
		return ongCongTren;
	}

	public Rectangle getOngCongDuoi() {
		return ongCongDuoi;
	}

	public Rectangle getNapOngCongTren() {
		return napOngCongTren;
	}

	public Rectangle getNapOngCongDuoi() {
		return napOngCongDuoi;
	}

	public void setOngCongTren(Rectangle ongCongTren) {
		this.ongCongTren = ongCongTren;
	}

	public void setOngCongDuoi(Rectangle ongCongDuoi) {
		this.ongCongDuoi = ongCongDuoi;
	}

	public void setNapOngCongTren(Rectangle napOngCongTren) {
		this.napOngCongTren = napOngCongTren;
	}

	public void setNapOngCongDuoi(Rectangle napOngCongDuoi) {
		this.napOngCongDuoi = napOngCongDuoi;
	}
	
	public boolean vaCham(ConChim conChim) {
		if (position.x < conChim.getX() + conChim.getWidth()) {
			return (Intersector.overlaps(conChim.getWrapperCircle(), ongCongTren)
					|| Intersector.overlaps(conChim.getWrapperCircle(), ongCongDuoi)
					|| Intersector.overlaps(conChim.getWrapperCircle(), napOngCongTren)
					|| Intersector.overlaps(conChim.getWrapperCircle(), napOngCongDuoi));
		}
		return false;
	}
	
	public boolean isDaCanMuc() {
		return daCanMuc;
	}
	
	public void setDaCanMuc(boolean daCanMuc) {
		this.daCanMuc = daCanMuc;
	}

}
