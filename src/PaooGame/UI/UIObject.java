package PaooGame.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class UIObject {
    protected float x,y;
    protected int width,height;
    protected Rectangle bounds;
    protected  boolean hovering=false;
    public UIObject(float x,float y,int width,int height)
    {
        this.x=x;
        this.y=y;
        this.height=height;
        this.width=width;
        bounds=new Rectangle((int)x ,(int) y,width,height);
    }
    ///Metoda abstracta destinata actualizarii starii curente
    public abstract void Update();

    public abstract void Draw(Graphics g);

    public abstract void onClick();

    public void onMouseMove(MouseEvent e)
    {
        if(bounds.contains(e.getX(),e.getY()))
            hovering=true;
        else
            hovering=false;
    }
    public void onMouseRelease(MouseEvent e)
    {
 //daca am apasat pe ceva
        if(hovering)
            onClick();
    }
  public float getX()
  {
      return x;
  }

    public float getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
