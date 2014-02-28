package com.me.PadSim;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Assets {
	public static Sprite sprite_red;
	public static Sprite sprite_blue;
	public static Sprite sprite_green;
	public static Sprite sprite_yellow;
	public static Sprite sprite_purple;
	public static Sprite sprite_pink;
    public static Texture text;
	public static void Load(){
    	text = new Texture(Gdx.files.internal("Texture.png"));
    	text.setFilter(TextureFilter.Linear, TextureFilter.Linear);
    	sprite_green = new Sprite(text,5,5,50,50);
    	sprite_green.flip(false, true);
    	sprite_yellow = new Sprite(text,5,65,50,50);
    	sprite_yellow.flip(false, true);
    	sprite_blue = new Sprite(text,65,5,50,50);
    	sprite_blue.flip(false, true);
    	sprite_red = new Sprite(text,65,65,50,50);
    	sprite_red.flip(false, true);
    	sprite_purple = new Sprite(text,5,125,50,50);
    	sprite_purple.flip(false, true);
    	sprite_pink = new Sprite(text,65,125,50,50);
    	sprite_pink.flip(false, true);
	}
}
