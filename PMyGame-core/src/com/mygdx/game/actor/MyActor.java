package com.mygdx.game.actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Selection;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class MyActor extends Image {
	public String name;
	public Selection<MyActor> listActor;
    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setColor(this.getColor());
        
        ((TextureRegionDrawable)getDrawable()).draw(batch, getX(),getY(),
                getOriginX(),getOriginY(),
                getWidth(),getHeight(),
                getScaleX(),getScaleY(),
                getRotation());
    }
   

    public MyActor(Texture texture, String name){
        super(texture);
        this.name = name;
        setBounds(getX(),getY(),getWidth()/2,getHeight()/2);
        addListener(getObject());
        
        
    }
    
    public ClickListener getObject() {
    	return new ClickListener() {
        	@Override
        	public void clicked(InputEvent event, float x, float y) {
        		// TODO Auto-generated method stub
        		super.clicked(event, x, y);
        		//System.out.println("" + event + " " + x + " " + y + " " + MyActor.this.name);
        	}
        };
    }
}