package com.htsi.Objects;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.htsi.AccessData.TruyXuatTaiNguyen;

public class ConChim {
	
	private Vector2 position;
	private Vector2 velocity;
	private Vector2 acceleration;
	
	private float rotation;
	private int width;
	private int height;
	
	private Circle wrapperCircle;
	private boolean conSong = true;

	
	public ConChim(float x, float y, int width, int height) {
		// TODO Auto-generated constructor stub
		this.width = width;
		this.height = height;
		position = new Vector2(x, y);
		velocity = new Vector2(0, 0);
		acceleration = new Vector2(0, 460);
		wrapperCircle = new Circle();
	}
	
	public void update(float delta) {
		// System.out.println(delta);

		velocity.add(acceleration.cpy().scl(delta));
		
		// System.out.println(velocity.y);

		if (velocity.y > 200) {
			velocity.y = 200;
		}
		
		if (position.y < -13) {
			position.y = -13;
			velocity.y = 0;
		}

		position.add(velocity.cpy().scl(delta));
		
		wrapperCircle.set(position.x + 9, position.y + 6, 6.5f);
		
		// System.out.println(position.y);


		if (velocity.y < 0) {
			rotation -= 600*delta;
			
			if (rotation < -20) {
				rotation = -20;
			}
		}
		
		if (dangRoi()) {
			rotation += 400*delta;
			
			if(rotation > 90) {
				rotation = 90;
			}
		}
				
	}
	
	public boolean isConSong() {
		return conSong;
	}
	
	public Circle getWrapperCircle() {
		return wrapperCircle;
	}
	
	public boolean dangRoi() {
		return velocity.y > 110;
	}
	
	public boolean khongCanBay() {
		return velocity.y > 70 || !conSong;
	}
	
	public void onClick() {
		if (conSong) {
			TruyXuatTaiNguyen.tiengVoCanh.play();
			velocity.y = -140;
		}
	}
	
	public float getX() {
		return position.x;
	}
	
	public float getY() {
		return position.y;
	}

	public float getRotation() {
		return rotation;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void chetQueo() {
		// TODO Auto-generated method stub
		conSong = false;
		velocity.y = 0;
	}

	public void decelerate() {
		// TODO Auto-generated method stub
		acceleration.y = 0;
	}

	public void veViTriBanDau(int y) {
		// TODO Auto-generated method stub
		rotation = 0;
		position.y = y;
		velocity.x = 0;
		velocity.y = 0;
		acceleration.x = 0;
		acceleration.y = 460;
		conSong = true;
	}

}
