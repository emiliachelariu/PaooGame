package PaooGame.Maps;

import PaooGame.Graphics.Assets;
import PaooGame.Graphics.Text;
import PaooGame.Items.*;
import PaooGame.RefLinks;
import PaooGame.States.State;
import PaooGame.Tiles.Tile;
import PaooGame.UI.*;
import PaooGame.UI.UIManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/*! \class public class Map
    \brief Implementeaza notiunea de harta a jocului.
 */
public class Map2
{
    private RefLinks refLink;   /*!< O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.*/
    private int width;          /*!< Latimea hartii in numar de dale.*/
    private int height;         /*!< Inaltimea hartii in numar de dale.*/
    private int [][] tiles;     /*!< Referinta catre o matrice cu codurile dalelor ce vor construi harta.*/



    private ItemManager2 itemManager2;

    private UIManager3 uiManager3;
    private JLabel counterLabel2;
    Timer timer2;
    int second,minute;
    String ddSecond,ddMinute;
    DecimalFormat dFormat=new DecimalFormat();

    /*! \fn public Map(RefLinks refLink)
            \brief Constructorul de initializare al clasei.

            \param refLink O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
         */
    public Map2(RefLinks refLink)
    {
        /// Retine referinta "shortcut".
        this.refLink = refLink;
        ///incarca harta de start. Functia poate primi ca argument id-ul hartii ce poate fi incarcat.
        itemManager2=new ItemManager2(refLink,new Hero2(refLink,48, 139,0));

        itemManager2.addItem2(new Ardei2(refLink,390,94,1));
        itemManager2.addItem2(new Ardei2(refLink,780,92,1));
        itemManager2.addItem2(new Ardei2(refLink,500,280,1));
        itemManager2.addItem2(new Castravete2(refLink,200,94,5));
        itemManager2.addItem2(new Morcov2(refLink,250,375,2));
        itemManager2.addItem2(new Morcov2(refLink,820,375,2));
        itemManager2.addItem2(new Ceapa2(refLink,390,384,4));
        itemManager2.addItem2(new Ceapa2(refLink,650,290,4));
        itemManager2.addItem2(new Ceapa2(refLink,350,290,4));
        itemManager2.addItem2(new Ridiche2(refLink,620,380,3));
        itemManager2.addItem2(new Morcov2(refLink,240,200,2));
        itemManager2.addItem2(new Castravete2(refLink,90,200,5));
        itemManager2.addItem2(new Morcov2(refLink,90,240,2));
        itemManager2.addItem2(new Castravete2(refLink,620,200,5));
        itemManager2.addItem2(new Ridiche2(refLink,670,100,3));
        itemManager2.addItem2(new Castravete2(refLink,780,200,5));
        itemManager2.addItem2(new Ridiche2(refLink,150,290,3));
        itemManager2.addItem2(new Ardei2(refLink,200,290,1));
        itemManager2.addItem2(new Castravete2(refLink,760,390,5));
        LoadWorld();

        itemManager2.getHero2().SetX(48);
        itemManager2.getHero2().SetY(139);

        uiManager3= new UIManager3(refLink);
        refLink.getMouseManager().setUiManager3(uiManager3);

        uiManager3.addObject(new UIImageButton(890, -20, 70, 70, Assets.butoane_exit, new ClickListener() {
            @Override
            public void onClick() {
                refLink.getMouseManager().setUiManager3(null);
                System.exit(0);
            }
        }));

        counterLabel2=new JLabel("");
        counterLabel2.setBounds(300,230,100,100);
        counterLabel2.setFont(Assets.font);
        counterLabel2.setText("00:40");
        second=40;
        minute=0;
        countDownTimer2();

        timer2.start();
    }

    /*! \fn public  void Update()
        \brief Actualizarea hartii in functie de evenimente (un copac a fost taiat)
     */
    public ItemManager2 getItemManager2() {
        return itemManager2;
    }
    ///Metoda abstracta destinata actualizarii starii curente
    public  void Update()
    {
        itemManager2.Update();
uiManager3.Update();
    }

    /*! \fn public void Draw(Graphics g)
        \brief Functia de desenare a hartii.

        \param g Contextl grafi in care se realizeaza desenarea.
     */
    public void Draw(Graphics g)
    {
        ///Se parcurge matricea de dale (codurile aferente) si se deseneaza harta respectiva
        for(int y = 0; y < refLink.GetGame().GetHeight()/Tile.TILE_HEIGHT; y++)
        {
            for(int x = 0; x < refLink.GetGame().GetWidth()/Tile.TILE_WIDTH; x++)
            {
                GetTile(x, y).Draw(g, (int)x * Tile.TILE_HEIGHT, (int)y * Tile.TILE_WIDTH);
            }
        }
        itemManager2.Draw(g);
        uiManager3.Draw(g);
        /// Se afiseaza pe ecran
        Text.drawString(g,"/4",200,30,false,Color.WHITE,Assets.font);
        Text.drawString(g,"/5",340,30,false,Color.WHITE,Assets.font);
        Text.drawString(g,"/3",480,30,false,Color.WHITE,Assets.font);
        Text.drawString(g,"/4",620,30,false,Color.WHITE,Assets.font);
        Text.drawString(g,"/3",770,30,false,Color.WHITE,Assets.font);
        g.drawString(counterLabel2.getText(),30,30);
    }

    /*! \fn public Tile GetTile(int x, int y)
        \brief Intoarce o referinta catre dala aferenta codului din matrice de dale.

        In situatia in care dala nu este gasita datorita unei erori ce tine de cod dala, coordonate gresite etc se
        intoarce o dala predefinita (ex. grassTile, mountainTile)
     */

    public Tile GetTile(int x, int y)
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
    private void LoadWorld()
    {
        //atentie latimea si inaltimea trebuiesc corelate cu dimensiunile ferestrei sau
        //se poate implementa notiunea de camera/cadru de vizualizare al hartii
        ///Se stabileste latimea hartii in numar de dale.
        width = 20;
        ///Se stabileste inaltimea hartii in numar de dale
        height = 10;
        ///Se construieste matricea de coduri de dale
        tiles = new int[width][height];
        //Se incarca matricea cu coduri
        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                tiles[x][y] = MiddleEastMap(y, x);
            }
        }
    }

    /*! \fn private int MiddleEastMap(int x ,int y)
        \brief O harta incarcata static.

        \param x linia pe care se afla codul dalei de interes.
        \param y coloana pe care se afla codul dalei de interes.
     */
    private int MiddleEastMap(int x ,int y)
    {
        ///Definire statica a matricei de coduri de dale.
        final int map2[][] = {
                {6, 3, 3, 11, 3,3, 18, 3, 3, 19, 3, 3, 20, 3, 3, 21, 3, 3, 3, 3},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 1, 13, 0, 0, 0, 0,0, 0, 0, 0, 0, 12, 0, 0, 0, 0, 0, 1, 2},
                {2, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 8, 1, 0, 1, 2},
                {2, 1, 0, 1, 1, 0, 0, 0, 0, 0,12, 0, 0, 0, 0, 0, 0, 13, 1, 2},
                {2, 1, 0, 8, 1, 0, 1, 9, 1, 1, 1, 1,0, 1, 1, 0, 1, 0, 10, 2},
                {2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 2},
                {2, 1, 13, 10, 1, 0, 1,1, 0, 1, 1, 1, 0, 1, 1, 0, 9, 0, 1, 4},
                {2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}};
        return map2[x][y];
    }
    public void countDownTimer2(){
        timer2=new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                second--;
                ddSecond=dFormat.format(second);
                ddMinute=dFormat.format(minute);
                counterLabel2.setText(ddMinute+":"+ddSecond);
                if(second==-1)
                {
                    second=59;
                    minute--;
                    ddSecond=dFormat.format(second);
                    ddMinute=dFormat.format(minute);
                    counterLabel2.setText(ddMinute+":"+ddSecond);
                }
                if(minute==0 &&second==0)
                {
                    timer2.stop();
                    System.exit(0);
                }

                // System.out.println(counterLabel.getText());
            }
        });
    }
}