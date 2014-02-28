package com.me.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.PadSim.*;

public class GameScreen implements Screen{

    OrthographicCamera camera;
    private PadSim game;
    SpriteBatch batch;
    Board board;
    public GameScreen(PadSim game){
    	this.game = game;
    	camera =  new OrthographicCamera();
    	camera.setToOrtho(true,720,1280);
    	batch = new SpriteBatch();
    	board = new Board();
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
				switch(board.getColor(x,y)){
				case 0: batch.draw(Assets.sprite_red, 50*x,50*y);
				break;
				case 1: batch.draw(Assets.sprite_blue, 50*x,50*y);
				break;
				case 2: batch.draw(Assets.sprite_green, 50*x,50*y);
				break;
				case 3: batch.draw(Assets.sprite_yellow, 50*x,50*y);
				break;
				case 4: batch.draw(Assets.sprite_purple, 50*x,50*y);
				break;
				case 5: batch.draw(Assets.sprite_pink, 50*x,50*y);
				break;
				}
				
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

}
