package PaooGame.Items;


import java.awt.*;
import java.awt.image.BufferedImage;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

public class Ridiche2 extends StaticItem2{

    private BufferedImage image;

    public Ridiche2(RefLinks refLink, float x, float y,int id) {
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
        g.drawImage(Assets.ridiche,(int)x,(int)y,width,height,null);
    }

}
