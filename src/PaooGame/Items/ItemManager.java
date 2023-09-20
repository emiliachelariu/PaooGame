package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.Graphics.Text;
import PaooGame.RefLinks;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ItemManager {
    private RefLinks refLinks;

    private Hero hero;
private int count1;
    private int count2,count3,count4,count5;
    private ArrayList<Item> items;
    public ItemManager(RefLinks refLinks,Hero hero){
        this.refLinks=refLinks;
        this.hero=hero;

        items=new ArrayList<Item>();
        addItem(hero);
    }

    public RefLinks getRefLinks() {
        return refLinks;
    }
    public Hero getHero() {
        return hero;
    }



    public void setHero(Hero hero) {
        this.hero = hero;
    }


    public void setRefLinks(RefLinks refLinks) {
        this.refLinks = refLinks;
    }



    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }



    public ArrayList<Item> getItems() {
        return items;
    }


    ///Metoda abstracta destinata actualizarii starii curente
    public void Update()
    { Iterator<Item> it=items.iterator();
while(it.hasNext())
        {
            Item item=it.next();
           item.Update();
           if(!item.isActive()) {

               it.remove();
               if (item.id == 1) {///verificare daca este ardei
                   pickUp1();

               }
               else
                   if(item.id==2)///verificare daca este morcov
                   {
                       pickUp2();
                   }
                   else
                       if(item.id==3)///verificare daca este ridiche
                       {
                           pickUp3();
                       }
                       else
                           if(item.id==4)///verificare daca este ceapa
                           {
                               pickUp4();
                           }
                           else
                               if(item.id==5)///verificare daca este castravete
                               {
                                   pickUp5();
                               }
           }

        }
hero.Update();
    }
    ///Metoda abstracta destinata desenarii starii curente
    public void Draw(Graphics g) {
        for(Item item:items)
            item.Draw(g);
        hero.Draw(g);
        /// Se afiseaza pe ecran
        Text.drawString(g,Integer.toString(count1),190,30,false,Color.WHITE, Assets.font);
        Text.drawString(g,Integer.toString(count5),330,30,false,Color.WHITE, Assets.font);
        Text.drawString(g,Integer.toString(count4),470,30,false,Color.WHITE, Assets.font);
        Text.drawString(g,Integer.toString(count2),610,30,false,Color.WHITE, Assets.font);
        Text.drawString(g,Integer.toString(count3),760,30,false,Color.WHITE, Assets.font);
        if(count1==3)
            Text.drawString(g,"done",230,30,false,Color.WHITE,Assets.font);

            if(count2==2)
                Text.drawString(g,"done",640,30,false,Color.WHITE,Assets.font);

                if(count3==3)
                    Text.drawString(g,"done",790,30,false,Color.WHITE,Assets.font);

                    if(count4==3)
                        Text.drawString(g,"done",500,30,false,Color.WHITE,Assets.font);

                        if(count5==1)
                            Text.drawString(g,"done",360,30,false,Color.WHITE,Assets.font);
    }
    public void addItem(Item item)
    {
        items.add(item);
    }///functie de adaugare item in lista
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

    }
}