package duckcorp.machine;

import duckcorp.duck.Duck;
import duckcorp.duck.DuckType;
import duckcorp.duck.MiniDuck;

/**
 * Presse produisant des Mini Canards.
 *
 * TODO (Ex2) :
 *   - Faites hériter cette classe de Machine
 *   - Implémentez le constructeur sans paramètre avec un appel à super
 *   - Implémentez produceDuck(), getPurchaseCost(), getName()
 * @author Roussille Philippe <roussille@3il.fr>
 */
public class MiniPress extends Machine {

    public static final int PURCHASE_COST    = 300;
    public static final int CAPACITY         = 8;
    public static final int MAINTENANCE_COST = 30;

    /**
     * Crée une nouvelle presse miniature.
     */
    public MiniPress() {
        super(DuckType.MINI, CAPACITY, MAINTENANCE_COST);
    }

    /**
     * Produit un mini canard avec une qualité calculée selon l'état de la machine.
     *
     * @return un nouveau MiniDuck
     */
    @Override
    public Duck produceDuck() {
        return new MiniDuck(computeQuality());
    }

    /**
     * Retourne le coüt d'achat d'une presse miniature.
     *
     * @return 300 euros
     */
    @Override
    public int getPurchaseCost() {
        return PURCHASE_COST;
    }

    /**
     * Retourne le nom de cette machine.
     *
     * @return "Presse Mini"
     */
    @Override
    public String getName() {
        return "Presse Mini";
    }
}
