package com.htsi.GameFactory;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.htsi.AccessData.TruyXuatTaiNguyen;
import com.htsi.Objects.ConChim;
import com.htsi.Objects.CuonManHinh;


public class TheGioiGame {
	
	private ConChim chim;
	private CuonManHinh cuonHinh;
	
	private Rectangle tbKetThucGame;
	
	private int diemSo = 0;
	public int midPointY;
	
	public enum TinhTrangGame {
		SAN_SANG, DANG_BAY, CHET_QUEO
	}
	
	private TinhTrangGame tinhTrangGame;

	
	public TheGioiGame(int midPointY) {
		// TODO Auto-generated constructor stub
		this.midPointY = midPointY;
		chim = new ConChim(33, midPointY - 5, 17, 12);
		cuonHinh = new CuonManHinh(this, midPointY + 66);
		
		tbKetThucGame = new Rectangle(0, midPointY + 66,  136, 11);
		tinhTrangGame = TinhTrangGame.SAN_SANG;
	}
	
	public void updateSS(float delta) {
		
	}
	
	public void updateDB(float delta) {
		if (delta > .15f) {
			delta = .15f;
		}
		chim.update(delta);
		cuonHinh.update(delta);
		
		if(cuonHinh.vaCham(chim) && chim.isConSong()) {
			cuonHinh.dungCuocChoi();
			chim.chetQueo();
			TruyXuatTaiNguyen.tiengChetQueo.play();
		}
		
		if (Intersector.overlaps(chim.getWrapperCircle(), tbKetThucGame)) {
			cuonHinh.dungCuocChoi();
			chim.chetQueo();
			chim.decelerate();
			tinhTrangGame = TinhTrangGame.CHET_QUEO;
		}
	}
	
	
	
	public void update(float delta) {
		
		switch (tinhTrangGame) {
		case SAN_SANG:
			updateSS(delta);
			break;
			
		case DANG_BAY:
		default:
			updateDB(delta);
			break;
		}
	}
	
	public ConChim getChim() {
		return chim;
	}
	
	public CuonManHinh getCuonHinh() {
		return cuonHinh;
	}
	
	public int getDiemSo() {
		return diemSo;
	}
	
	public void ghiDiem(int diem) {
		diemSo += diem;
	}
	
	public boolean sanSang() {
		return tinhTrangGame == TinhTrangGame.SAN_SANG;
	}
	
	public void batDau() {
		tinhTrangGame = TinhTrangGame.DANG_BAY;
	}
	
	public void khoiDongLai() {
		tinhTrangGame = TinhTrangGame.SAN_SANG;
		diemSo = 0;
		chim.veViTriBanDau(midPointY - 5);
		cuonHinh.cuonLaiTuDau();
		tinhTrangGame = TinhTrangGame.SAN_SANG;
	}
	
	public boolean ketThucGame() {
		return tinhTrangGame == TinhTrangGame.CHET_QUEO;
	}

}
