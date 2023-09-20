package PaooGame.Input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import PaooGame.Graphics.Assets;
import PaooGame.UI.UIManager;
import PaooGame.UI.UIManager2;
import PaooGame.UI.UIManager3;
import PaooGame.UI.UIManager4;

public class MouseManager implements MouseListener,MouseMotionListener {
    private boolean leftPressed,rightPressed;
    private int mouseX,mouseY;
    private BufferedImage imageMouse;
    private UIManager uiManager;
    private UIManager2 uiManager2;
    private UIManager3 uiManager3;
    private UIManager4 uiManager4;
    public MouseManager(){

    }
    public void setUiManager(UIManager uiManager)
    {
        this.uiManager=uiManager;
    }
    public void setUiManager2(UIManager2 uiManager2)
    {
        this.uiManager2=uiManager2;
    }
    public void setUiManager3(UIManager3 uiManager3)
    {
        this.uiManager3=uiManager3;
    }
    public void setUiManager4(UIManager4 uiManager4)
    {
        this.uiManager4=uiManager4;
    }
   public BufferedImage mouse()
   {
       imageMouse=Assets.mouse;
       return imageMouse;
   }
 public boolean isLeftPressed(){
        return leftPressed;
 }
 public boolean isRightPressed(){
        return rightPressed;
 }
 public int getMouseX()
 {
     return mouseX;
 }
    public int getMouseY()
    {
        return mouseY;
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
 if(e.getButton()==MouseEvent.BUTTON1)
     leftPressed=true;
 else if(e.getButton()==MouseEvent.BUTTON3)
     rightPressed=true;


    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1)
            leftPressed=false;
        else if(e.getButton()==MouseEvent.BUTTON3)
            rightPressed=false;
        if (uiManager!=null)
            uiManager.onMouseRelease(e);
        if (uiManager2!=null)
            uiManager2.onMouseRelease(e);
        if (uiManager3!=null)
            uiManager3.onMouseRelease(e);
        if (uiManager4!=null)
            uiManager4.onMouseRelease(e);

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX=e.getX();
        mouseY=e.getY();
        if (uiManager!=null)
            uiManager.onMouseMove(e);
        if (uiManager2!=null)
            uiManager2.onMouseMove(e);
        if (uiManager3!=null)
            uiManager3.onMouseMove(e);
        if (uiManager4!=null)
            uiManager4.onMouseMove(e);
    }
}
