package PaooGame.States;

import PaooGame.GameWindow.GameWindow;
import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.UI.ClickListener;
import PaooGame.UI.UIImageButton;
import PaooGame.UI.UIManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Timer;

/*! \class public class MenuState extends State
    \brief Implementeaza notiunea de menu pentru joc.
 */

public class MenuState extends State {
    /*! \fn public MenuState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    private UIManager uiManager;


    public MenuState(RefLinks refLink) {
        ///Apel al constructorului clasei de baza.
        super(refLink);
        uiManager = new UIManager(refLink);
        refLink.getMouseManager().setUiManager(uiManager);

        uiManager.addObject(new UIImageButton(390, 60, 150, 150, Assets.butoane_start, new ClickListener() {
            @Override
            public void onClick() {

                refLink.getMouseManager().setUiManager(null);
                State.SetState(refLink.GetGame().playState);

            }
        }));


        uiManager.addObject(new UIImageButton(390, 200, 150, 150, Assets.butoane_howtoplay, new ClickListener() {
            @Override
            public void onClick() {
                refLink.getMouseManager().setUiManager(null);
                State.SetState(refLink.GetGame().howtoplayState);


            }
        }));
        uiManager.addObject(new UIImageButton(390, 340, 150, 150, Assets.butoane_settings, new ClickListener() {
            @Override
            public void onClick() {
                refLink.getMouseManager().setUiManager(null);
                State.SetState(refLink.GetGame().playState);


            }
        }));
        uiManager.addObject(new UIImageButton(850, -30, 90, 90, Assets.butoane_exit, new ClickListener() {
            @Override
            public void onClick() {
                refLink.getMouseManager().setUiManager(null);
                System.exit(0);


            }
        }));
    }


    @Override
    public void Update() {
        uiManager.Update();

    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g) { //mouse
        g.drawImage(refLink.getMouseManager().mouse(), refLink.getMouseManager().getMouseX(), refLink.getMouseManager().getMouseY(), 20, 20, null);
        //g.setColor(Color.RED);
        //g.fillRect(refLink.getMouseManager().getMouseX(),refLink.getMouseManager().getMouseY(),8,8);
        uiManager.Draw(g);
    }

}