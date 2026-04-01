package duckcorp.duck;

/**
 * Classe abstraite représentant un canard en plastique.
 *
 * TODO (Ex1) :
 *   - Faites implémenter l'interface Qualifiable à cette classe
 *   - Implémentez equals() et hashCode() basés uniquement sur l'id
 *   - Implémentez les méthodes abstraites dans les sous-classes
 * @author Roussille Philippe <roussille@3il.fr>
 */
public abstract class Duck implements Qualifiable {

    private static int counter = 0;

    private final String   id;
    private final DuckType type;
    private final int      qualityScore;

    /** Constructeur fourni. Génère automatiquement un identifiant unique. */
    protected Duck(DuckType type, int qualityScore) {
        this.id           = type.name().charAt(0) + String.format("%04d", ++counter);
        this.type         = type;
        this.qualityScore = Math.max(0, Math.min(100, qualityScore));
    }

    // --- Getters fournis ---

    public String   getId()          { return id; }
    public DuckType getType()        { return type; }
    public int      getQualityScore(){ return qualityScore; }   // satisfera Qualifiable

    // --- Méthodes abstraites à implémenter dans les sous-classes ---

    public abstract double getBasePrice();
    public abstract String describe();

    // --- TODO : equals et hashCode ---

    /**
     * Vérifie l'égalité entre deux canards basée uniquement sur leur identifiant.
     * Deux canards sont égaux si ils ont le même identifiant unique
     *
     * @param o l'objet à comparer avec ce canard
     * @return true si l'objet est un Duck avec le même identifiant, false sinon
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Duck duck = (Duck) o;
        return id.equals(duck.id);
    }

    /**
     * Retourne le code de hachage basé uniquement sur l'identifiant du canard.
     * deux canards égaux auront toujours le même code de hachage.
     *
     * @return le code de hachage basé sur l'identifiant unique du canard
     */
    @Override
    public int hashCode() {
        return id.hashCode();
    }

    // --- toString fourni ---

    @Override
    public String toString() {
        return String.format("[%s] %s — qualité : %d/100", id, describe(), qualityScore);
    }
}
