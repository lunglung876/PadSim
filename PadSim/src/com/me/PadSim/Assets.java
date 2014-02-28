package com.me.PadSim;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Assets {
	public static Sprite sprite;
    public static Texture text;
	public static void Load(){
    	text = new Texture(Gdx.files.internal("dark.png"));
    	text.setFilter(TextureFilter.Linear, TextureFilter.Linear);
    	sprite = new Sprite(text);
	}
}
