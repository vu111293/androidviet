package com.htsi.AccessData;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TruyXuatTaiNguyen {
	
	public static BitmapFont font, shadow;
	
	public static Sound tiengChetQueo;
	public static Sound tiengVoCanh;
	public static Sound tiengGhiDiem;
	
	public static Texture texture;
	public static TextureRegion nenT3H, hinhNen, nenCo;
	
	public static Animation chimBay;
	public static TextureRegion chim, chimBayLen, chimBayXuong;
	
	public static TextureRegion ongCong, ongCongTren, ongCongDuoi;


	
	public static void load() {
		
		texture = new Texture(Gdx.files.internal("data/texture4.png"));
		texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		nenT3H = new TextureRegion(texture, 158, 16, 40, 40);
		nenT3H.flip(false, true);
		
		//hinhNen = new TextureRegion(texture, 0, 0, 136, 43);
		hinhNen = new TextureRegion(texture, 0, 0, 136, 62);
		hinhNen.flip(false, true);
		
		nenCo = new TextureRegion(texture, 0, 62, 143, 11);
		// nenCo = new TextureRegion(texture, 0, 62, 165, 11);

		nenCo.flip(false, true);
		
		chimBayXuong = new TextureRegion(texture, 136, 0, 17, 12);
//		chimBayXuong = new TextureRegion(texture, 216, 0, 68, 48);

		chimBayXuong.flip(false, true);
		
//		chim = new TextureRegion(texture, 284, 0, 68, 48);
		chim = new TextureRegion(texture, 153, 0, 17, 12);

		chim.flip(false, true);
		
//		chimBayLen = new TextureRegion(texture, 352, 0, 68, 48);		
		chimBayLen = new TextureRegion(texture, 170, 0, 17, 12);
		chimBayLen.flip(false, true);		
		
		TextureRegion[] chims = {chimBayXuong, chim, chimBayLen};
		chimBay = new Animation(0.06f, chims);
		chimBay.setPlayMode(Animation.LOOP_PINGPONG);
		
		ongCong = new TextureRegion(texture, 136, 16, 22, 3);
		ongCong.flip(false, true);
		
		ongCongTren = new TextureRegion(texture, 192, 0, 24, 14);
		ongCongDuoi = new TextureRegion(ongCongTren);
		ongCongDuoi.flip(false, true);
		
		tiengChetQueo = Gdx.audio.newSound(Gdx.files.internal("data/die.wav"));
		tiengVoCanh = Gdx.audio.newSound(Gdx.files.internal("data/flap.wav"));
		tiengGhiDiem = Gdx.audio.newSound(Gdx.files.internal("data/coin.wav"));

		font = new BitmapFont(Gdx.files.internal("data/text.fnt"));
		font.setScale(.25f, -.25f);
		shadow = new BitmapFont(Gdx.files.internal("data/shadow.fnt"));
		shadow.setScale(.25f, -.25f);

	}
	
	public static void dispose() {
		texture.dispose();
		font.dispose();
		shadow.dispose();
	}

}
