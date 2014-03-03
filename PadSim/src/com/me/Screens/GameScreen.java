package com.me.Screens;

import java.lang.reflect.Array;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.PadSim.*;

public class GameScreen implements Screen, InputProcessor{
	int picked_x = -1;
	int picked_y = -1;
	int origin_x;
	int origin_y;
	int drag = 0;
    OrthographicCamera camera;
    private PadSim game;
    SpriteBatch batch;
    Board board;
    int[][] clear_board = new int[6][5];
    public GameScreen(PadSim game){
    	this.game = game;
    	camera =  new OrthographicCamera();
    	camera.setToOrtho(true,720,1280);
    	batch = new SpriteBatch();
    	board = new Board();
    	Gdx.input.setInputProcessor(this);
    	
    }
    
    public void render(float delta) {
        // Draws the RGB color 10, 15, 230, at 100% opacity

        Gdx.gl.glClearColor(10/255.0f, 15/255.0f, 230/255.0f, 1f);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
    	camera.update();
    	batch.setProjectionMatrix(camera.combined);
    	batch.begin();
		for (int x =0; x<6; x++) {
			for (int y =0; y<5; y++){
				if (x== picked_x && y==picked_y){
					batch.setColor(1f,1f,1f,.5f);
				}
				switch(board.getColor(x,y)){
					case 0: batch.draw(Assets.sprite_red, 120*x,660+120*y,120,120);
					break;
					case 1: batch.draw(Assets.sprite_blue, 120*x,660+120*y,120,120);
					break;
					case 2: batch.draw(Assets.sprite_green, 120*x,660+120*y,120,120);
					break;
					case 3: batch.draw(Assets.sprite_yellow, 120*x,660+120*y,120,120);
					break;
					case 4: batch.draw(Assets.sprite_purple, 120*x,660+120*y,120,120);
					break;
					case 5: batch.draw(Assets.sprite_pink, 120*x,660+120*y,120,120);
					break;
				}
				batch.setColor(1f,1f,1f,1f);
			}
		}
		if(drag == 1){
	        int PosX = Gdx.input.getX();
	        int PosY = Gdx.input.getY();
			switch(board.getColor(picked_x,picked_y)){
			case 0: batch.draw(Assets.sprite_red, PosX-30,PosY,120,120);
			break;
			case 1: batch.draw(Assets.sprite_blue, PosX-30,PosY,120,120);
			break;
			case 2: batch.draw(Assets.sprite_green, PosX-30,PosY,120,120);
			break;
			case 3: batch.draw(Assets.sprite_yellow, PosX-30,PosY,120,120);
			break;
			case 4: batch.draw(Assets.sprite_purple,PosX-30,PosY,120,120);
			break;
			case 5: batch.draw(Assets.sprite_pink, PosX-30,PosY,120,120);
			break;
			}
	    }
    	batch.end();
        
    }

    @Override
    public void resize(int width, int height) {
        System.out.println("GameScreen - resizing");
    }

    @Override
    public void show() {
        System.out.println("GameScreen - show called");
    }

    @Override
    public void hide() {
        System.out.println("GameScreen - hide called");     
    }

    @Override
    public void pause() {
        System.out.println("GameScreen - pause called");        
    }

    @Override
    public void resume() {
        System.out.println("GameScreen - resume called");       
    }

    @Override
    public void dispose() {
        // Leave blank
    }

    public boolean keyDown (int keycode) {
        return false;
     }

     @Override
     public boolean keyUp (int keycode) {
        return false;
     }

     @Override
     public boolean keyTyped (char character) {
        return false;
     }

     @Override
     public boolean touchDown (int x, int y, int pointer, int button) {
    	 if (drag == 0){
    		int PosX = Gdx.input.getX();
    		int PosY = Gdx.input.getY();
    		if (PosX > 719){
    			picked_x = 5;
    		}
    		else{
    			picked_x = PosX/120;
    		}
    		picked_y = (PosY-660)/104;
    		origin_x = PosX;
    		origin_x = PosY;
    	 }
    	 drag = 1;
    	 return true;
    		 
     }

     @Override
     public boolean touchUp (int x, int y, int pointer, int button) {
        drag = 0;
        picked_x = -1;
        picked_y = -1;
        check_clear();
        return true;
     }
     @Override
     public boolean touchDragged (int x, int y, int pointer) {
    	drag = 1;
    	if ( Gdx.input.getX() - origin_x > 100 || Gdx.input.getY() - origin_y > 100){
    		board.swap(picked_x,picked_y, Gdx.input.getX()/120,(Gdx.input.getY()-660)/104);
    		picked_x = Gdx.input.getX()/120;
    		picked_y = (Gdx.input.getY()-660)/104;
    	}
        return true;
     }
     public boolean touchMoved (int x, int y) {
        return false;
     }
     @Override
     public boolean scrolled (int amount) {
        return false;
     }

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}
	
	public void check_clear(){
		int count;
		for (int k = 0; k < 5; k++){			
			for (int i = 0; i < 4; i++){
				count = board.check_row(i, k, 0, 0);
				if (count > 2){
					for (int j = 0;j < count;j++){
						clear_board[j+i][k] = board.getColor(j+i, k)+1;
					}
				}
				if (count > 1){
					i = i + count -1;
				}
			}
		}
		count = 0;
		for (int k = 0; k < 6; k++){			
			for (int i = 0; i < 3; i++){
				count = board.check_column(k, i, 0, 0);
				if (k ==0){
					//System.out.println(count);
				}
				if (count > 2){
					for (int j = 0;j < count;j++){
						clear_board[k][j+i] = board.getColor(k, j+i)+1;
					}
				}
				if (count > 1){
					i = i + count -1;
				}
				
			}
			
		}
		
		for (int c = 0; c<5 ;c++){
			System.out.println(""+clear_board[0][c]+clear_board[1][c]+clear_board[2][c]+clear_board[3][c]+clear_board[4][c]+clear_board[5][c]);
		}
		clear_board = new int[6][5];
	}
	
	
	
	
  
}
