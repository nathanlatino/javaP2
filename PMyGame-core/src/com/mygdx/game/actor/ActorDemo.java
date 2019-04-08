package com.mygdx.game.actor;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import net.dermetfan.gdx.scenes.scene2d.Scene2DUtils;

public class ActorDemo extends ApplicationAdapter {
	   public Stage stage;

	   @Override
	   public void create () {
		  ScreenViewport sview = new ScreenViewport();
		  sview.setScreenSize(1000, 1000);
	      stage = new Stage(sview);
	      stage.addActor(new MyActor(new Texture(Gdx.files.internal("badlogic.jpg")),"smile"));
	      stage.addActor(new MyActor(new Texture(Gdx.files.internal("pik.png")),"pik"));
	      stage.addListener(getObject());
	      Gdx.input.setInputProcessor(stage);
	      stage.setKeyboardFocus(stage.getActors().first());

	   }

	   @Override
	   public void render () {
	      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	      stage.act(Gdx.graphics.getDeltaTime());
	      stage.draw();
	   }
	   
	   public ClickListener getObject() {
	    	return new ClickListener() {
	        	@Override
	        	public void clicked(InputEvent event, float x, float y) {
	        		for (Actor actor: ActorDemo.this.stage.getActors()) {
	        			MyActor act = (MyActor)actor.hit(x, y, true);
	        			if(act != null) {
	        				System.out.println(act.name);
	        				System.out.println(act.getZIndex());
	        			}
	        				
	        			
					}
	        	}
	        };
	   }
}
