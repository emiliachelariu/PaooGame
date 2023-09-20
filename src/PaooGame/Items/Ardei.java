package PaooGame.Items;


import java.awt.*;
import java.awt.image.BufferedImage;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

public class Ardei extends StaticItem{
    protected RefLinks refLinks;
    private BufferedImage image;


    protected Rectangle bounds;
    public Ardei(RefLinks refLink, int x, int y,int id) {
        super(refLink, x,y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT,id);

    }

    @Override
    public void Update(){

    }
    @Override
    public void die(){

    }
    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(Assets.ardei,(int)x,(int)y,width,height,null);
    }

}
