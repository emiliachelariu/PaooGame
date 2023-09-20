package PaooGame.States;
import PaooGame.Graphics.Assets;
import PaooGame.Maps.Map2;
import PaooGame.RefLinks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/*! \class public class PlayState extends State
    \brief Implementeaza/controleaza jocul.
 */
public class SecondPlayState extends State
{
    /*!< Referinta catre obiectul animat erou (controlat de utilizator).*/
    private Map2 map2;    /*!< Referinta catre harta curenta.*/
    private JLabel counterLabel2;
    Timer timer2;
    int second,minute;
    String ddSecond,ddMinute;
    DecimalFormat dFormat=new DecimalFormat();
    /*! \fn public PlayState(RefLinks refLink)
        \brief Constructorul de initializare al clasei

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
 */
    public SecondPlayState(RefLinks refLink)
    {
        ///Apel al constructorului clasei de baza
        super(refLink);
        ///Construieste harta jocului
        map2 = new Map2(refLink);
        refLink.SetMap2(map2);
        ///Referinta catre harta construita este setata si in obiectul shortcut pentru a fi accesibila si in alte clase ale programului.
        counterLabel2=new JLabel("");
        counterLabel2.setBounds(300,230,100,100);
        counterLabel2.setFont(Assets.font);
        counterLabel2.setText("00:50");
        second=50;
        minute=0;
        countDownTimer2();
        timer2.start();
    }

    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a jocului.
     */
    @Override
    public void Update()
    {
        map2.Update();

    }

    @Override
    public void Draw(Graphics g)
    {
        map2.Draw(g);
        g.drawImage(refLink.getMouseManager().mouse(),refLink.getMouseManager().getMouseX(),refLink.getMouseManager().getMouseY(),20,20,null);

    }
    public void countDownTimer2(){
        timer2=new Timer(1000, new ActionListener() {
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
