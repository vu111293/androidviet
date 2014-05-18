package com.htsi.Objects;

import com.htsi.AccessData.TruyXuatTaiNguyen;
import com.htsi.GameFactory.TheGioiGame;

public class CuonManHinh {
	
	private NenCo nenCoT, nenCoS;
	private OngCong ongCong1, ongCong2, ongCong3;
	
	public static final int TOC_DO_CUON_MAN_HINH = -1;
	public static final int KHOANG_CACH_ONG = 49;
	
	private TheGioiGame gameWorld;
	
	public CuonManHinh(TheGioiGame gameWorld, float y) {
		// TODO Auto-generated constructor stub
		this.gameWorld = gameWorld;
		nenCoT = new NenCo(0, y, 143, 11, TOC_DO_CUON_MAN_HINH);
		nenCoS = new NenCo(nenCoT.getTailX(), y, 143, 11, TOC_DO_CUON_MAN_HINH);
		
		ongCong1 = new OngCong(210, 0, 22, 60, TOC_DO_CUON_MAN_HINH, y);
		ongCong2 = new OngCong(ongCong1.getTailX() + KHOANG_CACH_ONG, 0, 22, 70, TOC_DO_CUON_MAN_HINH, y);
		ongCong3 = new OngCong(ongCong2.getTailX() + KHOANG_CACH_ONG, 0, 22, 60, TOC_DO_CUON_MAN_HINH, y);
	}
	
	public void update(float delta) {
		
		nenCoS.update(delta);
		nenCoT.update(delta);
		ongCong1.update(delta);
		ongCong2.update(delta);
		ongCong3.update(delta);
		
		if (ongCong1.isCuonSangTrai()) {
			ongCong1.reset(ongCong3.getTailX() + KHOANG_CACH_ONG);

		} else if (ongCong2.isCuonSangTrai()) {
			ongCong2.reset(ongCong1.getTailX() + KHOANG_CACH_ONG);
			System.out.println(delta);

		} else if (ongCong3.isCuonSangTrai()) {
			ongCong3.reset(ongCong2.getTailX() + KHOANG_CACH_ONG);
			System.out.println(delta);

		}
		
		if (nenCoT.isCuonSangTrai()) {
			nenCoT.reset(nenCoS.getTailX());
		} else if (nenCoS.isCuonSangTrai()) {
			nenCoS.reset(nenCoT.getTailX());
		}
		
	}
	
	public void dungCuocChoi() {
		nenCoS.dung();
		nenCoT.dung();
		ongCong1.dung();
		ongCong2.dung();
		ongCong3.dung();
	}
	
	public boolean vaCham(ConChim conChim) {
		
		if (!ongCong1.isDaCanMuc()
                && ongCong1.getX() + (ongCong1.getWidth() / 2) < conChim.getX()
                        + conChim.getWidth()) {
            ghiDiem(1);
            ongCong1.setDaCanMuc(true);
            TruyXuatTaiNguyen.tiengGhiDiem.play();
        } else if (!ongCong2.isDaCanMuc()
                && ongCong2.getX() + (ongCong2.getWidth() / 2) < conChim.getX()
                        + conChim.getWidth()) {
        	ghiDiem(1);
            ongCong2.setDaCanMuc(true);
            TruyXuatTaiNguyen.tiengGhiDiem.play();

        } else if (!ongCong3.isDaCanMuc()
                && ongCong3.getX() + (ongCong3.getWidth() / 2) < conChim.getX()
                        + conChim.getWidth()) {
        	ghiDiem(1);
        	ongCong3.setDaCanMuc(true);
            TruyXuatTaiNguyen.tiengGhiDiem.play();

        }
		
		return (ongCong1.vaCham(conChim) ||
				ongCong2.vaCham(conChim) ||
				ongCong3.vaCham(conChim));
		
//		return false;
	}
	
	private void ghiDiem(int i) {
		// TODO Auto-generated method stub
		gameWorld.ghiDiem(i);
	}

	public NenCo getNenCoS() {
		return nenCoS;
	}
	
	public NenCo getNenCoT() {
		return nenCoT;
	}
	
	public OngCong getOngCong1() {
		return ongCong1;
	}
	
	public OngCong getOngCong2() {
		return ongCong2;
	}
	
	public OngCong getOngCong3() {
		return ongCong3;
	}

	public void cuonLaiTuDau() {
		// TODO Auto-generated method stub
		nenCoT.onRestart(0, TOC_DO_CUON_MAN_HINH);
		nenCoS.onRestart(nenCoT.getTailX(), TOC_DO_CUON_MAN_HINH);
		ongCong1.onRestart(210, TOC_DO_CUON_MAN_HINH);
		ongCong2.onRestart(ongCong1.getTailX() + KHOANG_CACH_ONG, TOC_DO_CUON_MAN_HINH);
		ongCong3.onRestart(ongCong2.getTailX() + KHOANG_CACH_ONG, TOC_DO_CUON_MAN_HINH);
		
	}

}
