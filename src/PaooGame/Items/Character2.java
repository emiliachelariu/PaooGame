package PaooGame.Items;

import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

/*! \class public abstract class Character extends Item
    \brief Defineste notiunea abstracta de caracter/individ/fiinta din joc.

    Notiunea este definita doar de viata, viteza de deplasare si distanta cu care trebuie sa se
    miste/deplaseze in urma calculelor.
 */
public abstract class Character2  extends Item2
{

    public static final float DEFAULT_SPEED         = 3.0f; /*!< Viteza implicita a unu caracter.*/
    public static final int DEFAULT_CREATURE_WIDTH  = 48;   /*!< Latimea implicita a imaginii caracterului.*/
    public static final int DEFAULT_CREATURE_HEIGHT = 48;   /*!< Inaltimea implicita a imaginii caracterului.*/

    protected int life;     /*!< Retine viata caracterului.*/
    protected float speed;  /*!< Retine viteza de deplasare caracterului.*/
    protected float xMove;  /*!< Retine noua pozitie a caracterului pe axa X.*/
    protected float yMove;  /*!< Retine noua pozitie a caracterului pe axa Y.*/

    /*! \fn public Character(RefLinks refLink, float x, float y, int width, int height)
        \brief Constructor de initializare al clasei Character

        \param refLink Referinta catre obiectul shortcut (care retine alte referinte utile/necesare in joc).
        \param x Pozitia de start pa axa X a caracterului.
        \param y Pozitia de start pa axa Y a caracterului.
        \param width Latimea imaginii caracterului.
        \param height Inaltimea imaginii caracterului.
     */
    public Character2(RefLinks refLink, float x, float y, int width, int height,int id)
    {
        ///Apel constructor la clasei de baza
        super(refLink, x,y, width, height,id);
        //Seteaza pe valorile implicite pentru viata, viteza si distantele de deplasare

        speed   = DEFAULT_SPEED;
        xMove   = 0;
        yMove   = 0;
    }

    /*! \fn public void Move()
        \brief Modifica pozitia caracterului
     */
    public void Move()
    {
        ///Modifica pozitia caracterului pe axa X.
        ///Modifica pozitia caracterului pe axa Y.

        if(!checkEntityCollisions2(xMove, 0f))
            MoveX2();
        if(!checkEntityCollisions2(0f, yMove))
            MoveY2();
    }

    /*! \fn public void MoveX()
        \brief Modifica pozitia caracterului pe axa X.
     */

    public void MoveX2()
    {
        if(xMove>0)
        {
            //Moving right
            int tx=(int)(x+xMove+bounds.x+ bounds.width)/ Tile.TILE_WIDTH;
            if(!collisionWithTile2(tx,(int)(y+ bounds.y)/Tile.TILE_HEIGHT)&& !collisionWithTile2(tx,(int)(y+ bounds.y+ bounds.height)/Tile.TILE_HEIGHT))
            {
                x+=xMove;
            }
        }
        else if(xMove<0)//Moving left
        {
            int tx=(int)(x+xMove+bounds.x)/ Tile.TILE_WIDTH;
            if(!collisionWithTile2(tx,(int)(y+ bounds.y)/Tile.TILE_HEIGHT)&& !collisionWithTile2(tx,(int)(y+ bounds.y+ bounds.height)/Tile.TILE_HEIGHT))

                x+=xMove;
        }

    }

    /*! \fn public void MoveY()
        \brief Modifica pozitia caracterului pe axa Y.
     */
    public void MoveY2()
    {
        ///Aduna la pozitia curenta numarul de pixeli cu care trebuie sa se deplaseze pe axa Y.
        if(yMove<0)//Up
        {
            int ty=(int)(y+yMove+ bounds.y)/Tile.TILE_HEIGHT;
            if(!collisionWithTile2((int)(x+ bounds.x)/Tile.TILE_WIDTH,ty)&& !collisionWithTile2((int)(x+ bounds.x+bounds.width)/Tile.TILE_WIDTH,ty))
            {
                y+=yMove;
            }
        }
        else
        if(yMove>0)//Down
        {
            int ty=(int)(y+yMove+ bounds.y+ bounds.height)/Tile.TILE_HEIGHT;
            if(!collisionWithTile2((int)(x+ bounds.x)/Tile.TILE_WIDTH,ty)&& !collisionWithTile2((int)(x+ bounds.x+bounds.width)/Tile.TILE_WIDTH,ty))
                y+=yMove;
        }

    }

    protected boolean collisionWithTile2(int x,int y)
    {
        return refLink.GetMap2().GetTile(x,y).IsSolid();
    }
    /*! \fn public int GetLife()
        \brief Returneaza viata caracterului.
     */
    public int GetLife()
    {
        return life;
    }

    /*! \fn public int GetSpeed()
        \brief Returneaza viteza caracterului.
     */
    public float GetSpeed()
    {
        return speed;
    }

    /*! \fn public void SetLife(int life)
        \brief Seteaza viata caracterului.
     */
    public void SetLife(int life)
    {
        this.life = life;
    }

    /*! \fn public void SetSpeed(float speed)
        \brief
     */
    public void SetSpeed(float speed) {
        this.speed = speed;
    }

    /*! \fn public float GetXMove()
        \brief Returneaza distanta in pixeli pe axa X cu care este actualizata pozitia caracterului.
     */
    public float GetXMove()
    {
        return xMove;
    }

    /*! \fn public float GetYMove()
        \brief Returneaza distanta in pixeli pe axa Y cu care este actualizata pozitia caracterului.
     */
    public float GetYMove()
    {
        return yMove;
    }

    /*! \fn public void SetXMove(float xMove)
        \brief Seteaza distanta in pixeli pe axa X cu care va fi actualizata pozitia caracterului.
     */
    public void SetXMove(float xMove)
    {
        this.xMove = xMove;
    }

    /*! \fn public void SetYMove(float yMove)
        \brief Seteaza distanta in pixeli pe axa Y cu care va fi actualizata pozitia caracterului.
     */
    public void SetYMove(float yMove)
    {
        this.yMove = yMove;
    }
}

