package PaooGame.States;

import PaooGame.Maps.Map;
import PaooGame.Maps.Map3;
import PaooGame.RefLinks;

import java.awt.*;

public class HowToPlayState extends State{
    private Map3 map3;

    public HowToPlayState(RefLinks refLinks){
///Apel al constructorului clasei de baza
        super(refLinks);
        ///Construieste harta jocului
        map3 = new Map3(refLink);
        refLink.SetMap3(map3);
        ///Referinta catre harta construita este setata si in obiectul shortcut pentru a fi accesibila si in alte clase ale programului.
    }
    @Override
    public void Update()
    {
        map3.Update();

    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a jocului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        map3.Draw(g);
        g.drawImage(refLink.getMouseManager().mouse(),refLink.getMouseManager().getMouseX(),refLink.getMouseManager().getMouseY(),20,20,null);

    }
}

