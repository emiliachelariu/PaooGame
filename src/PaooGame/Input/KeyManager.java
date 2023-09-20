package PaooGame.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*! \class public class KeyManager implements KeyListener
    \brief Gestioneaza intrarea (input-ul) de tastatura.

    Clasa citeste daca au fost apasata o tasta, stabiliteste ce tasta a fost actionata si seteaza corespunzator un flag.
    In program trebuie sa se tina cont de flagul aferent tastei de interes. Daca flagul respectiv este true inseamna
    ca tasta respectiva a fost apasata si false nu a fost apasata.
 */
public class KeyManager implements KeyListener
{
    private boolean[] keys,justPressed; /*!< Vector de flaguri pentru toate tastele. Tastele vor fi regasite dupa cod [0 - 255]*/
    public boolean up;      /*!< Flag pentru tasta "sus" apasata.*/
    public boolean down;    /*!< Flag pentru tasta "jos" apasata.*/
    public boolean left;    /*!< Flag pentru tasta "stanga" apasata.*/
    public boolean right;   /*!< Flag pentru tasta "dreapta" apasata.*/
public boolean aUp,aDown,aLeft,aRight;

    /*! \fn public KeyManager()
        \brief Constructorul clasei.
     */
    public KeyManager()
    {
            ///Constructie vector de flaguri aferente tastelor.
        keys = new boolean[256];
        justPressed = new boolean[keys.length];
    }

    ///Metoda abstracta destinata actualizarii starii curente
    public void Update()
    {
        up    = keys[KeyEvent.VK_W];
        down  = keys[KeyEvent.VK_S];
        left  = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];

        aUp    = keys[KeyEvent.VK_UP];
        aDown  = keys[KeyEvent.VK_DOWN];
        aLeft  = keys[KeyEvent.VK_LEFT];
        aRight = keys[KeyEvent.VK_RIGHT];
    }
    public boolean keyJustPressed(int keyCode){
        if(keyCode < 0 || keyCode >= keys.length)
            return false;
        return justPressed[keyCode];
    }

    /*! \fn public void keyPressed(KeyEvent e)
        \brief Functie ce va fi apelata atunci cand un un eveniment de tasta apasata este generat.

         \param e obiectul eveniment de tastatura.
     */
    @Override
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode()<0 || e.getKeyCode() >= keys.length)
            return ;
            ///se retine in vectorul de flaguri ca o tasta a fost apasata.
        keys[e.getKeyCode()] = true;
    }

    /*! \fn public void keyReleased(KeyEvent e)
        \brief Functie ce va fi apelata atunci cand un un eveniment de tasta eliberata este generat.

         \param e obiectul eveniment de tastatura.
     */
    @Override
    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode()<0 || e.getKeyCode() >= keys.length)
            return ;
            ///se retine in vectorul de flaguri ca o tasta a fost eliberata.
        keys[e.getKeyCode()] = false;
    }

    /*! \fn public void keyTyped(KeyEvent e)
        \brief Functie ce va fi apelata atunci cand o tasta a fost apasata si eliberata.
        Momentan aceasta functie nu este utila in program.
     */
    @Override
    public void keyTyped(KeyEvent e)
    {

    }
}
