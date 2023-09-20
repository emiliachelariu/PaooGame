package PaooGame.Maps;

import PaooGame.Graphics.Assets;
import PaooGame.Graphics.Text;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;
import PaooGame.UI.ClickListener;
import PaooGame.UI.UIImageButton;
import PaooGame.UI.UIManager3;
import PaooGame.UI.UIManager4;

import java.awt.*;

public class Map3 {

    private RefLinks refLink;   /*!< O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.*/
    private int width;          /*!< Latimea hartii in numar de dale.*/
    private int height;         /*!< Inaltimea hartii in numar de dale.*/
    private int [][] tiles;     /*!< Referinta catre o matrice cu codurile dalelor ce vor construi harta.*/
    private UIManager4 uiManager4;
    public Map3(RefLinks refLink)
    {

        this.refLink = refLink;
        uiManager4= new UIManager4(refLink);
        refLink.getMouseManager().setUiManager4(uiManager4);

        uiManager4.addObject(new UIImageButton(890, -20, 70, 70, Assets.butoane_exit, new ClickListener() {
            @Override
            public void onClick() {
                refLink.getMouseManager().setUiManager4(null);
                System.exit(0);
            }
        }));
    }
    ///Metoda abstracta destinata actualizarii starii curente
    public  void Update()
    {
uiManager4.Update();
    }

    public void Draw(Graphics g) {
        ///Se parcurge matricea de dale (codurile aferente) si se deseneaza harta respectiva
        for(int y = 0; y < refLink.GetGame().GetHeight()/Tile.TILE_HEIGHT; y++)
        {
            for(int x = 0; x < refLink.GetGame().GetWidth()/Tile.TILE_WIDTH; x++)
            {
                GetTile2(x, y).Draw(g, (int)x * Tile.TILE_HEIGHT, (int)y * Tile.TILE_WIDTH);
            }
        }
        /// Se afiseaza pe ecran
        Text.drawString(g,"Mecanica jocului: ",10,30,false,Color.WHITE,Assets.font);
        Text.drawString(g," Rosia are 4 directii de deplasare: ",30,50,false,Color.WHITE,Assets.font);
        Text.drawString(g,"-sus (tasta W) ",70,65,false,Color.WHITE,Assets.font);
        Text.drawString(g,"-jos (tasta S) ",70,80,false,Color.WHITE,Assets.font);
        Text.drawString(g,"-stanga (tasta A)  ",70,95,false,Color.WHITE,Assets.font);
        Text.drawString(g,"-dreapta (tasta D)  ",70,110,false,Color.WHITE,Assets.font);
        Text.drawString(g,"Rosia are 4 directii de atac:",30,130,false,Color.WHITE,Assets.font);
        Text.drawString(g,"-sus (tasta UP)",70,145,false,Color.WHITE,Assets.font);
        Text.drawString(g,"-jos (tasta DOWN)",70,160,false,Color.WHITE,Assets.font);
        Text.drawString(g,"-stanga (tasta LEFT)",70,175,false,Color.WHITE,Assets.font);
        Text.drawString(g,"-dreapta (tasta RIGHT)",70,190,false,Color.WHITE,Assets.font);
        Text.drawString(g,"Componentele pasive din joc in care rosia nu are acces:",30,250,false,Color.WHITE,Assets.font);
        Text.drawString(g,"-iarba,sol, flori,ziduri si pietre care impiedica rosia sa mearga pe acel spatiu ",50,270,false,Color.WHITE,Assets.font);
        Text.drawString(g,"Componente active pe care rosia le va intalni in calea ei:",30,290,false,Color.WHITE,Assets.font);
        Text.drawString(g,"-cartita si insectele, celelalte legume (castraveti, ridichi, ceapa, ardei, morcovi) .",70,310,false,Color.WHITE,Assets.font);
        Text.drawString(g,"Punctele se vor aduna in functie de cate legume reuseste rosia sa adune fara a interactiona cu ",10,350,false,Color.WHITE,Assets.font);
        Text.drawString(g," daunatorii.",-5,365,false,Color.WHITE,Assets.font);

        Text.drawString(g,"Jocatorul va fi considerat castigator când reuseste sa duca la bun sfarsit toate sarcinile.",10,390,false,Color.WHITE,Assets.font);

        uiManager4.Draw(g);

    }
    public Tile GetTile2(int x, int y)
    {

        if(x < 0 || y < 0 || x >= width || y >= height)
        {
            return Tile.soilTile;
        }
        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
        {
            return Tile.cimentTile;
        }
        return t;
    }

    /*! \fn private void LoadWorld()
        \brief Functie de incarcare a hartii jocului.
        Aici se poate genera sau incarca din fisier harta. Momentan este incarcata static.
     */

    /*! \fn private int MiddleEastMap(int x ,int y)
        \brief O harta incarcata static.

        \param x linia pe care se afla codul dalei de interes.
        \param y coloana pe care se afla codul dalei de interes.
     */

}


