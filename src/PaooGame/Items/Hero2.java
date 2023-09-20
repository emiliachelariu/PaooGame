package PaooGame.Items;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.ArrayList;

import PaooGame.RefLinks;
import PaooGame.Graphics.Assets;

/*! \class public class Hero extends Character
    \brief Implementeaza notiunea de erou/player (caracterul controlat de jucator).

    Elementele suplimentare pe care le aduce fata de clasa de baza sunt:
        imaginea (acest atribut poate fi ridicat si in clasa de baza)
        deplasarea
        atacul (nu este implementat momentan)
        dreptunghiul de coliziune
 */
public class Hero2 extends Character2
{
    private BufferedImage image;    /*!< Referinta catre imaginea curenta a eroului.*/


    /*! \fn public Hero(RefLinks refLink, float x, float y)
        \brief Constructorul de initializare al clasei Hero.

        \param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
        \param x Pozitia initiala pe axa X a eroului.
        \param y Pozitia initiala pe axa Y a eroului.
     */
    public Hero2(RefLinks refLink, float x, float y,int id)
    {
        ///Apel al constructorului clasei de baza
        super(refLink, x,y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT,id);
        ///Seteaza imaginea de start a eroului
        image = Assets.heroRight;
        ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea implicita(normala)
        normalBounds.x = 11;
        normalBounds.y = 15;
        normalBounds.width = 25;
        normalBounds.height = 33;

    }

    /*! \fn public void Update()
        \brief Actualizeaza pozitia si imaginea eroului.
     */
    @Override
    public void Update()
    {
        ///Verifica daca a fost apasata o tasta
        GetInput();
        ///Actualizeaza pozitia
        Move();
        ///Actualizeaza imaginea
        if(refLink.GetKeyManager().left == true)
        {
            image = Assets.heroLeft;
        }
        if(refLink.GetKeyManager().right == true) {
            image = Assets.heroRight;
        }

        checkAttacks();

    }
    private void checkAttacks() {

        Rectangle cb2 = getCollisionBounds2(0,0);
        Rectangle ar2 = new Rectangle();
        int arSize2 = 20;
        ar2.width = arSize2;
        ar2.height = arSize2;
        if (refLink.GetKeyManager().aUp) {
            ar2.x = cb2.x + cb2.width / 2 - arSize2 / 2;
            ar2.y = cb2.y - arSize2;

        } else if (refLink.GetKeyManager().aDown) {
            ar2.x = cb2.x + cb2.width / 2 - arSize2 / 2;
            ar2.y = cb2.y + cb2.height;

        } else if (refLink.GetKeyManager().aLeft) {
            ar2.x = cb2.x - arSize2;
            ar2.y = cb2.y + cb2.height / 2 - arSize2 / 2;

        } else if (refLink.GetKeyManager().aRight) {
            ar2.x = cb2.x + cb2.width;
            ar2.y = cb2.y + cb2.height / 2 - arSize2 / 2;

        } else {
            return;
        }



        for (Item2 item2 : refLink.GetMap2().getItemManager2().getItems2())
        {
            if (item2.equals(this))
                continue;
            if (item2.getCollisionBounds2(0,0).intersects(ar2)) {
                item2.hurt(3);
                return;
            }
        }

    }
    @Override
    public void die(){
        System.exit(0);
    }

    /*! \fn private void GetInput()
        \brief Verifica daca a fost apasata o tasta din cele stabilite pentru controlul eroului.
     */
    private void GetInput()
    {
        ///Implicit eroul nu trebuie sa se deplaseze daca nu este apasata o tasta
        xMove = 0;
        yMove = 0;
        ///Verificare apasare tasta "sus"
        if(refLink.GetKeyManager().up)
        {
            yMove = -speed;
        }
        ///Verificare apasare tasta "jos"
        if(refLink.GetKeyManager().down)
        {
            yMove = speed;
        }
        ///Verificare apasare tasta "left"
        if(refLink.GetKeyManager().left)
        {
            xMove = -speed;
        }
        ///Verificare apasare tasta "dreapta"
        if(refLink.GetKeyManager().right)
        {
            xMove = speed;
        }
    }

    /*! \fn public void Draw(Graphics g)
        \brief Randeaza/deseneaza eroul in noua pozitie.

        \brief g Contextul grafi in care trebuie efectuata desenarea eroului.
     */
    @Override
    public void Draw(Graphics g)
    {

        g.drawImage(image, (int)x, (int)y, width, height, null);

        ///doar pentru debug daca se doreste vizualizarea dreptunghiului de coliziune altfel se vor comenta urmatoarele doua linii
       // g.setColor(Color.blue);
        //g.fillRect((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);
    }
}
