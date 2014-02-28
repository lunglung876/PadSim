package com.me.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.PadSim.Assets;
import com.me.PadSim.PadSim;

public class GameScreen implements Screen{

    OrthographicCamera camera;
    private PadSim game;
    SpriteBatch batch;
    public GameScreen(PadSim game){
    	this.game = game;
    	camera =  new OrthographicCamera();
    	camera.setToOrtho(true,1280,800);
    	batch = new SpriteBatch();

    }
    
    public void render(float delta) {
        // Draws the RGB color 10, 15, 230, at 100% opacity

        Gdx.gl.glClearColor(10/255.0f, 15/255.0f, 230/255.0f, 1f);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
    	camera.update();
    	batch.setProjectionMatrix(camera.combined);
    	batch.begin();
    	
    	batch.draw(Assets.sprite, 50,50);
    	
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
