package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.Graphics.Text;
import PaooGame.RefLinks;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ItemManager2 {
    private RefLinks refLinks;
    private Hero2 hero2;
    private int count1;
    private int count2,count3,count4,count5;
    private ArrayList<Item2> items2;
    public ItemManager2(RefLinks refLinks,Hero2 hero2){
        this.refLinks=refLinks;
        this.hero2=hero2;

        items2=new ArrayList<Item2>();
    }

    public RefLinks getRefLinks() {
        return refLinks;
    }
    public Hero2 getHero2() {
        return hero2;
    }



    public void setHero2(Hero2 hero2) {
        this.hero2 = hero2;
    }


    public void setRefLinks(RefLinks refLinks) {
        this.refLinks = refLinks;
    }



    public void setItems2(ArrayList<Item2> items2) {
        this.items2 = items2;
    }



    public ArrayList<Item2> getItems2() {
        return items2;
    }


    ///Metoda abstracta destinata actualizarii starii curente
    public void Update()
    { Iterator<Item2> it=items2.iterator();
        while(it.hasNext())
        {
            Item2 item2=it.next();
            item2.Update();
            if(!item2.isActive()){
                it.remove();
                if (item2.id == 1) {///verificare daca este ardei
                    pickUp1();

                }
                else
                if(item2.id==2)///verificare daca esste morcov
                {
                    pickUp2();
                }
                else
                if(item2.id==3)///verificare daca este ridiche
                {
                    pickUp3();
                }
                else
                if(item2.id==4)///verificare daca este ceapa
                {
                    pickUp4();
                }
                else
                if(item2.id==5)///verificare daca este castravete
                {
                    pickUp5();
                }
            }

        }
        hero2.Update();
    }
    ///Metoda abstracta destinata desenarii starii curente
    public void Draw(Graphics g) {
        for(Item2 item2:items2)
            item2.Draw(g);
        hero2.Draw(g);
        /// Se afiseaza pe ecran
        Text.drawString(g,Integer.toString(count1),190,30,false,Color.WHITE, Assets.font);
        Text.drawString(g,Integer.toString(count5),330,30,false,Color.WHITE, Assets.font);
        Text.drawString(g,Integer.toString(count4),470,30,false,Color.WHITE, Assets.font);
        Text.drawString(g,Integer.toString(count2),610,30,false,Color.WHITE, Assets.font);
        Text.drawString(g,Integer.toString(count3),760,30,false,Color.WHITE, Assets.font);
        if(count1==4)
            Text.drawString(g,"done",230,30,false,Color.WHITE,Assets.font);

        if(count2==4)
            Text.drawString(g,"done",640,30,false,Color.WHITE,Assets.font);

        if(count3==3)
            Text.drawString(g,"done",790,30,false,Color.WHITE,Assets.font);

        if(count4==3)
            Text.drawString(g,"done",500,30,false,Color.WHITE,Assets.font);

        if(count5==5)
            Text.drawString(g,"done",360,30,false,Color.WHITE,Assets.font);

    }
    ///adaugare item in lista
    public void addItem2(Item2 item2)
    {
        items2.add(item2);
    }
    ///functia de actualizare a numarului de legume adunate
    public void pickUp1()
    {

        count1++;

    }
    public void pickUp2()
    {

        count2++;

    }
    public void pickUp3()
    {

        count3++;

    }
    public void pickUp4()
    {

        count4++;

    }
    public void pickUp5()
    {

        count5++;

    }}