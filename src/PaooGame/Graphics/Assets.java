package PaooGame.Graphics;

import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class public class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets
{
 public static Font font;

        /// Referinte catre elementele grafice (dale) utilizate in joc.
    public static BufferedImage castravete;

    public static BufferedImage soil;
    public static BufferedImage sol;
    public static BufferedImage heroLeft;
    public static BufferedImage heroRight;
    public static BufferedImage ardei2;
    public static BufferedImage floare_galbena;
    public static BufferedImage exit;
    public static BufferedImage ciment;
    public static BufferedImage ardei;
    public static BufferedImage ceapa;
    public static BufferedImage ceapa2;
    public static BufferedImage nimic;
    public static BufferedImage morcov;
    public static BufferedImage morcov2;
    public static BufferedImage vierme;
    public static BufferedImage floare_mov;
    public static BufferedImage floare_albastra;
    public static BufferedImage clepsidra;
    public static BufferedImage ridiche;
    public static BufferedImage ridiche2;

    public static BufferedImage castravete2;
    public static BufferedImage mouse;
    public static BufferedImage cartita;
    public static BufferedImage[] butoane_start;
    public static BufferedImage[] butoane_save;
    public static BufferedImage[] butoane_reload;
    public static BufferedImage[] butoane_settings;
    public static BufferedImage[] butoane_howtoplay;
    public static BufferedImage[] butoane_exit;
    public static BufferedImage[] usa;

    /*! \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init()
    {
        font=FontLoader.loadFont("res/fonts/slkscr.ttf",15);

            /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        SpriteSheet sheet1 = new SpriteSheet(ImageLoader.LoadImage("/textures/poza2.png"));
        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.LoadImage("/textures/poza3.png"));
        SpriteSheet sheet3 = new SpriteSheet(ImageLoader.LoadImage("/textures/poza.png"));
        SpriteSheet sheet4 = new SpriteSheet(ImageLoader.LoadImage("/textures/poza1.png"));

            /// Se obtin subimaginile corespunzatoare elementelor necesare.
       sol = sheet1.crop(0, 0);
        soil = sheet1.crop(1, 0);
        ciment = sheet1.crop(2, 0);
       heroRight = sheet1.crop(3, 0);
       heroLeft=sheet1.crop(0,1);
       floare_galbena= sheet2.crop(3, 1);
       exit = sheet1.crop(2, 1);
        ardei2 = sheet2.crop(1, 3);
        ardei = sheet1.crop(0, 2);
        morcov = sheet1.crop(1, 2);
        castravete = sheet3.crop(1, 3);
       nimic = sheet1.crop(3, 2);
        ceapa = sheet3.crop(0, 0);
        floare_mov=sheet2.crop(0,1);
        floare_albastra=sheet2.crop(3,0);

        clepsidra=sheet2.crop(2,2);
        ridiche=sheet3.crop(2,3);
        ardei2=sheet2.crop(1,3);
       castravete2=sheet2.crop(2,3);
       ceapa2=sheet2.crop(3,3);
        morcov2 = sheet2.crop(0, 3);
        ridiche2=sheet2.crop(3,2);
        mouse= sheet1.crop(0,3);
        butoane_start=new BufferedImage[2];
        butoane_start[0]=sheet3.crop(1,0);
        butoane_start[1]=sheet3.crop(2,0);
        butoane_save=new BufferedImage[2];
        butoane_save[0]=sheet3.crop(0,1);
        butoane_save[1]=sheet3.crop(3,0);
        butoane_reload=new BufferedImage[2];
        butoane_reload[0]=sheet3.crop(2,1);
        butoane_reload[1]=sheet3.crop(1,1);
        butoane_settings=new BufferedImage[2];
        butoane_settings[0]=sheet3.crop(3,1);
        butoane_settings[1]=sheet3.crop(0,2);
        butoane_howtoplay=new BufferedImage[2];
        butoane_howtoplay[0]=sheet3.crop(2,2);
        butoane_howtoplay[1]=sheet3.crop(1,2);
        cartita=sheet2.crop(1,2);
        vierme=sheet2.crop(0,2);
        butoane_exit=new BufferedImage[2];
        butoane_exit[0]=sheet4.crop(0,0);
        butoane_exit[1]=sheet4.crop(1,0);
        usa=new BufferedImage[2];
        usa[0]=sheet4.crop(2,0);
       usa[1]=sheet4.crop(3,0);
    }
}
