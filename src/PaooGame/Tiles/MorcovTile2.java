package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class   MorcovTile2 extends Tile {

    public MorcovTile2(int id) {
        /// Apel al constructorului clasei de baza
        super(Assets.morcov2, id);
    }
}
