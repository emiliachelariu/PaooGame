package PaooGame.UI;

import PaooGame.RefLinks;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UIManager3 {
    private RefLinks refLinks;
    private ArrayList<UIObject> objects;
    public void setObjects(ArrayList<UIObject> objects) {
        this.objects = objects;
    }



    public ArrayList<UIObject> getObjects() {
        return objects;
    }



    public UIManager3(RefLinks refLinks)
    {
        this.refLinks=refLinks;
        objects=new ArrayList<UIObject>();
    }
    ///Metoda abstracta destinata actualizarii starii curente
    public void Update()
    {
        for(UIObject o:objects)
            o.Update();
    }
    public void Draw(Graphics g)
    {
        for(UIObject o:objects)
            o.Draw(g);
    }
    public void onMouseMove(MouseEvent e)
    {

        for(UIObject o:objects)
            o.onMouseMove(e);
    }
    public void onMouseRelease(MouseEvent e)
    {
        for(UIObject o:objects)
            o.onMouseRelease(e);
    }
    public void addObject(UIObject o)
    {
        objects.add(o);
    }
    public void removeObject(UIObject o)
    {
        objects.remove(o);
    }

    public RefLinks getRefLinks() {
        return refLinks;
    }

    public void setRefLinks(RefLinks refLinks) {
        this.refLinks = refLinks;
    }

}
