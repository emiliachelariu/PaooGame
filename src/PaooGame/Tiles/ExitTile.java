package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class   ExitTile extends Tile
{

    public ExitTile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.exit, id);
    }
}
