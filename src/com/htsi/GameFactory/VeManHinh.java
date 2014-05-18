package com.htsi.GameFactory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.htsi.AccessData.TruyXuatTaiNguyen;
import com.htsi.Objects.ConChim;
import com.htsi.Objects.CuonManHinh;
import com.htsi.Objects.NenCo;
import com.htsi.Objects.OngCong;

public class VeManHinh {
	
	private TheGioiGame tgGame;
	private OrthographicCamera camera;
	
	private ShapeRenderer shapeRenderer;
	private SpriteBatch spriteBatch;
	
	private int gameHeight;
	private int midPointY;
	
	private ConChim conChim;
	private CuonManHinh cuonHinh;
	private NenCo nenCoT, nenCoS;
	private OngCong ongCong1, ongCong2, ongCong3;
	
	
	private TextureRegion hinhNen, nenCo, nenT3H;	
	private Animation chimBay;
	private TextureRegion chim;
	// chimBayLen, chimBayXuong;	
	private TextureRegion ongCong, ongCongTren, ongCongDuoi;

	private void initGameObjects() {
		conChim = tgGame.getChim();
		cuonHinh = tgGame.getCuonHinh();
		nenCoT = cuonHinh.getNenCoT();
		nenCoS = cuonHinh.getNenCoS();
		ongCong1 = cuonHinh.getOngCong1();
		ongCong2 = cuonHinh.getOngCong2();
		ongCong3 = cuonHinh.getOngCong3();
	}
	
	private void initAssets() {
		hinhNen = TruyXuatTaiNguyen.hinhNen;
		nenCo = TruyXuatTaiNguyen.nenCo;
		nenT3H = TruyXuatTaiNguyen.nenT3H;
		
		 chim = TruyXuatTaiNguyen.chim;
		// chimBayLen = TruyXuatTaiNguyen.chimBayLen;
		// chimBayXuong = TruyXuatTaiNguyen.chimBayXuong;
		
		chimBay = TruyXuatTaiNguyen.chimBay;
		
		ongCong = TruyXuatTaiNguyen.ongCong;
		ongCongDuoi = TruyXuatTaiNguyen.ongCongDuoi;
		ongCongTren = TruyXuatTaiNguyen.ongCongTren;
	}
	
	private void veNenCo() {
        // Draw the grass
        spriteBatch.draw(nenCo, nenCoT.getX(), nenCoT.getY(),
                nenCoT.getWidth(), nenCoT.getHeight());
        
        spriteBatch.draw(nenCo, nenCoS.getX(), nenCoS.getY(),
        		nenCoS.getWidth(), nenCoS.getHeight());
    }

    private void veNapOngCong() {

        spriteBatch.draw(ongCongTren, ongCong1.getX() - 1,
        		ongCong1.getY() + ongCong1.getHeight() - 14, 24, 14);
        spriteBatch.draw(ongCongDuoi, ongCong1.getX() - 1,
                ongCong1.getY() + ongCong1.getHeight() + 45, 24, 14);

        spriteBatch.draw(ongCongTren, ongCong2.getX() - 1,
        		ongCong2.getY() + ongCong2.getHeight() - 14, 24, 14);
        spriteBatch.draw(ongCongDuoi, ongCong2.getX() - 1,
        		ongCong2.getY() + ongCong2.getHeight() + 45, 24, 14);

        spriteBatch.draw(ongCongTren, ongCong3.getX() - 1,
        		ongCong3.getY() + ongCong3.getHeight() - 14, 24, 14);
        spriteBatch.draw(ongCongDuoi, ongCong3.getX() - 1,
        		ongCong3.getY() + ongCong3.getHeight() + 45, 24, 14);
    }

    private void veOngCong() {

        spriteBatch.draw(ongCong, ongCong1.getX(), ongCong1.getY(), ongCong1.getWidth(),
        		ongCong1.getHeight());
        spriteBatch.draw(ongCong, ongCong1.getX(), ongCong1.getY() + ongCong1.getHeight() + 45,
                ongCong1.getWidth(), midPointY + 66 - (ongCong1.getHeight() + 45));

        spriteBatch.draw(ongCong, ongCong2.getX(), ongCong2.getY(), ongCong2.getWidth(),
                ongCong2.getHeight());
        spriteBatch.draw(ongCong, ongCong2.getX(), ongCong2.getY() + ongCong2.getHeight() + 45,
                ongCong2.getWidth(), midPointY + 66 - (ongCong2.getHeight() + 45));

        spriteBatch.draw(ongCong, ongCong3.getX(), ongCong3.getY(), ongCong3.getWidth(),
                ongCong3.getHeight());
        spriteBatch.draw(ongCong, ongCong3.getX(), ongCong3.getY() + ongCong3.getHeight() + 45,
                ongCong3.getWidth(), midPointY + 66 - (ongCong3.getHeight() + 45));
    }

	
	public VeManHinh(TheGioiGame world, int gameHeight, int midPointY) {
		// TODO Auto-generated constructor stub
		tgGame = world;
		this.gameHeight = gameHeight;
		this.midPointY = midPointY;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 136, this.gameHeight);
		
		spriteBatch = new SpriteBatch();
		spriteBatch.setProjectionMatrix(camera.combined);
		
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(camera.combined);
		
		initGameObjects();
		initAssets();
		
	}
	
	
	public void render(float runTime) {
		
		
		Gdx.gl.glClearColor(255, 255, 255, 1.0f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		shapeRenderer.begin(ShapeType.Filled);
		
		shapeRenderer.setColor(81/255.0f, 191/255.0f, 205/255.0f, 1.0f);		
		shapeRenderer.rect(0, 0, 136, midPointY +  77);
		
		shapeRenderer.setColor(223/255.0f, 215/255.0f, 150/255.0f, 1.0f);
		shapeRenderer.rect(0, midPointY + 77, 136, 52);
		
		shapeRenderer.end();
		
		spriteBatch.begin();
		
		spriteBatch.disableBlending();
	 	spriteBatch.draw(hinhNen, 0, midPointY + 23, 136, 43);		
		spriteBatch.draw(nenT3H, 48, 30, 40, 40);
		
		spriteBatch.enableBlending();

		
		veOngCong();
		veNapOngCong();
		
		veNenCo();
		
		if (conChim.khongCanBay()) {
			spriteBatch.draw(chim, conChim.getX(), conChim.getY(), 
					conChim.getWidth()/2.0f, conChim.getHeight()/2.0f, 
					conChim.getWidth(), conChim.getHeight(), 
					1, 1, conChim.getRotation());
		} else {
			spriteBatch.draw(chimBay.getKeyFrame(runTime), conChim.getX(), conChim.getY(), 
					conChim.getWidth()/2.0f, conChim.getHeight()/2.0f, 
					conChim.getWidth(), conChim.getHeight(), 
					1, 1, conChim.getRotation());
		}
		
			
		spriteBatch.end();
		
		/*
		 shapeRenderer.begin(ShapeType.Filled);
				
		// Ve~ shape hinh` nen`
		shapeRenderer.setColor(81/255.0f, 191/255.0f, 205/255.0f, 1.0f);
		shapeRenderer.rect(0, 0, 136, midPointY +  77);
		

		// Ve~ shape co?
		shapeRenderer.setColor(111/255.0f, 186/255.0f, 45/255.0f, 1.0f);
		shapeRenderer.rect(0, midPointY + 66, 136, 11);
		
		// Ve~ shape dat'
		shapeRenderer.setColor(223/255.0f, 215/255.0f, 150/255.0f, 1.0f);
		shapeRenderer.rect(0, midPointY + 77, 136, 52);
		
				
		// Nghi~ ve~ shape
		shapeRenderer.end();
		
		// Ve~ sprite 
		spriteBatch.begin();
		
		// Ve~ sprite hinh` nen`
		spriteBatch.disableBlending();
	 	spriteBatch.draw(hinhNen, 0, midPointY + 23, 136, 43);		
		spriteBatch.draw(nenT3H, 48, 30, 40, 40);
		
		veNenCo();

		veOngCong();
		


		spriteBatch.enableBlending();
		veNapOngCong();
		
		
		// Ve~ sprite con chim
		if (conChim.khongCanBay()) {
			spriteBatch.draw(chim, conChim.getX(), conChim.getY(), 
					conChim.getWidth()/2.0f, conChim.getHeight()/2.0f, 
					conChim.getWidth(), conChim.getHeight(), 
					1, 1, conChim.getRotation());
		} else {
			spriteBatch.draw(chimBay.getKeyFrame(runTime), conChim.getX(), conChim.getY(), 
					conChim.getWidth()/2.0f, conChim.getHeight()/2.0f, 
					conChim.getWidth(), conChim.getHeight(), 
					1, 1, conChim.getRotation());
		}
		

	
		String diem = tgGame.getDiemSo() + "";
		TruyXuatTaiNguyen.shadow.draw(spriteBatch, "" + tgGame.getDiemSo(), (136/2)-(3*diem.length()), 12);
		TruyXuatTaiNguyen.font.draw(spriteBatch, "" + tgGame.getDiemSo(), (136/2)-(3*diem.length()), 11);
		
		 if (tgGame.sanSang()) {
	            // Draw shadow first
	            TruyXuatTaiNguyen.shadow.draw(spriteBatch, "BAT DAU", (136 / 2)
	                    - (42), 76);
	            // Draw text
	            TruyXuatTaiNguyen.font.draw(spriteBatch, "BAT DAU", (136 / 2)
	                    - (42 - 1), 75);
	        } else {

	            if (tgGame.ketThucGame()) {
	                TruyXuatTaiNguyen.shadow.draw(spriteBatch, "Chet Queo", 25, 56);
	                TruyXuatTaiNguyen.font.draw(spriteBatch, "Chet Queo", 24, 55);
	                
	                TruyXuatTaiNguyen.shadow.draw(spriteBatch, "Choi nua?", 23, 76);
	                TruyXuatTaiNguyen.font.draw(spriteBatch, "Choi nua?", 24, 75);
	                
	                
	                
	            }
	            
	            String score = tgGame.getDiemSo() + "";

	            TruyXuatTaiNguyen.shadow.draw(spriteBatch, "" + tgGame.getDiemSo(), (136 / 2)
	                    - (3 * score.length()), 12);
	            TruyXuatTaiNguyen.font.draw(spriteBatch, "" + tgGame.getDiemSo(), (136 / 2)
	                    - (3 * score.length() - 1), 11);
	        }
		
		spriteBatch.end();
		*/
		/*
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(223/255.0f, 215/255.0f, 150/255.0f, 1.0f);
		shapeRenderer.circle(conChim.getWrapperCircle().x, conChim.getWrapperCircle().y,
				conChim.getWrapperCircle().radius);
		
		shapeRenderer.rect(ongCong1.getOngCongTren().x, 
				ongCong1.getOngCongTren().y,
				ongCong1.getOngCongTren().width, 
				ongCong1.getOngCongTren().height);
		
		shapeRenderer.rect(ongCong2.getOngCongTren().x, 
				ongCong2.getOngCongTren().y,
				ongCong2.getOngCongTren().width, 
				ongCong2.getOngCongTren().height);
		
		shapeRenderer.rect(ongCong3.getOngCongTren().x, 
				ongCong3.getOngCongTren().y,
				ongCong3.getOngCongTren().width, 
				ongCong3.getOngCongTren().height);
		
		shapeRenderer.rect(ongCong1.getOngCongDuoi().x, 
				ongCong1.getOngCongDuoi().y,
				ongCong1.getOngCongDuoi().width, 
				ongCong1.getOngCongDuoi().height);
		
		shapeRenderer.rect(ongCong2.getOngCongDuoi().x, 
				ongCong2.getOngCongDuoi().y,
				ongCong2.getOngCongDuoi().width, 
				ongCong2.getOngCongDuoi().height);
		
		shapeRenderer.rect(ongCong3.getOngCongDuoi().x, 
				ongCong3.getOngCongDuoi().y,
				ongCong3.getOngCongDuoi().width, 
				ongCong3.getOngCongDuoi().height);
		
		shapeRenderer.rect(ongCong1.getNapOngCongTren().x, 
				ongCong1.getNapOngCongTren().y,
				ongCong1.getNapOngCongTren().width, 
				ongCong1.getNapOngCongTren().height);
		
		shapeRenderer.rect(ongCong2.getNapOngCongTren().x, 
				ongCong2.getNapOngCongTren().y,
				ongCong2.getNapOngCongTren().width, 
				ongCong2.getNapOngCongTren().height);
		
		shapeRenderer.rect(ongCong3.getNapOngCongTren().x, 
				ongCong3.getNapOngCongTren().y,
				ongCong3.getNapOngCongTren().width, 
				ongCong3.getNapOngCongTren().height);
		
		shapeRenderer.rect(ongCong1.getNapOngCongDuoi().x, 
				ongCong1.getNapOngCongDuoi().y,
				ongCong1.getNapOngCongDuoi().width, 
				ongCong1.getNapOngCongDuoi().height);
		
		shapeRenderer.rect(ongCong2.getNapOngCongDuoi().x, 
				ongCong2.getNapOngCongDuoi().y,
				ongCong2.getNapOngCongDuoi().width, 
				ongCong2.getNapOngCongDuoi().height);
		
		shapeRenderer.rect(ongCong3.getNapOngCongDuoi().x, 
				ongCong3.getNapOngCongDuoi().y,
				ongCong3.getNapOngCongDuoi().width, 
				ongCong3.getNapOngCongDuoi().height);
		
		shapeRenderer.end(); */
	}
	

}
