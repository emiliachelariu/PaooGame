package PaooGame.States;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.Maps.Map;
import PaooGame.UI.ClickListener;
import PaooGame.UI.UIImageButton;
import PaooGame.UI.UIManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/*! \class public class PlayState extends State
    \brief Implementeaza/controleaza jocul.
 */
public class PlayState extends State
{
     /*!< Referinta catre obiectul animat erou (controlat de utilizator).*/
    private Map map;    /*!< Referinta catre harta curenta.*/

    /*! \fn public PlayState(RefLinks refLink)
        \brief Constructorul de initializare al clasei

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */

    public PlayState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza
        super(refLink);
            ///Construieste harta jocului
        map = new Map(refLink);
        refLink.SetMap(map);
            ///Referinta catre harta construita este setata si in obiectul shortcut pentru a fi accesibila si in alte clase ale programului.

    }

    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a jocului.
     */
    @Override
    public void Update()
    {
        map.Update();

    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a jocului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {

        map.Draw(g);
        g.drawImage(refLink.getMouseManager().mouse(),refLink.getMouseManager().getMouseX(),refLink.getMouseManager().getMouseY(),20,20,null);

           }



}