import java.math.BigInteger;

public class HTNaive {

    private ListeBigI[] t;

    public HTNaive(int m) {
        t = new ListeBigI[m];
        for (int i = 0; i < m; i++)
            t[i] = new ListeBigI();
    }

    /**
     * Retourne la "hauteur" de la liste de hachage
     */
    private int h(BigInteger u) {
        final BigInteger m = BigInteger.valueOf(t.length);
        return u.remainder(m).intValue();
    }

    public HTNaive(ListeBigI l, int m) {
        this(m);
        this.ajoutListe(l);
    }


    public HTNaive(ListeBigI l, double f) {
        this((int) (tempH(l) * f));
    }


    /*
     * Retourne la longeur de l si tous les éléments de l sont distinct sinon retourne 0
     */
    private static int tempH(ListeBigI l) {
        int m = l.longueur();
        Maillon curseur1 = l.getTete();
        Maillon curseur2 = l.getTete();
        while (curseur1 != null) {
            while (curseur2 != null) {
                if (curseur1.getVal().equals(curseur2.getVal()) && curseur1.getSuiv() != curseur2.getSuiv()) {
                    m--;
                }
                curseur2 = curseur2.getSuiv();
            }
            curseur1 = curseur1.getSuiv();
        }
        return m;
    }

    /**
     * Retourne vrai si la table de hachage contient l'élement u, sinon faux
     */
    public boolean contient(BigInteger u) {
        return this.t[this.h(u)].contient(u);
    }

    /**
     * Action - ajoute u dans la table de hachage
     */
    public boolean ajout(BigInteger u) {
        if (!contient(u)) {
            this.t[h(u)].ajoutTete(u);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Pré-requis : L est non null
     * Action : ajoute à la table les éléments de L qui n'y sont pas déjà. Attention, L ne doit pas être modifié
     */
    public void ajoutListe(ListeBigI L) {
        final ListeBigI copyL = new ListeBigI(L);
        Maillon curseur = copyL.getTete();
        while (curseur != null) {
            ajout(curseur.getVal());
            curseur = curseur.getSuiv();
        }
    }

    /**
     * Retourne le nombre d'élements de la table de hachage
     */
    public int getCardinal() {
        return getElements().longueur();
    }

    /**
     * Retourne la liste ayant le plus d'élements
     */
    public int getMaxSize() {
        int max = t[0].longueur();
        for (int i = 1; i < t.length; i++)
            if (t[i].longueur() > max)
                max = t[i].longueur();
        return max;
    }

    /**
     * Retourne une Liste retournant tous les éléments de la table.
     */
    public ListeBigI getElements() {
        ListeBigI listeTousElt = new ListeBigI();
        ListeBigI curListe;
        Maillon teteListe;
        for (ListeBigI listeBigI : t) {
            curListe = listeBigI;
            teteListe = curListe.getTete();
            while (teteListe != null) {
                listeTousElt.ajoutTete(teteListe.getVal());
                teteListe = teteListe.getSuiv();
            }
        }
        return listeTousElt;
    }

    /**
     * Retourne le nombre de listes (vides ou non) de la table
     */
    public int getNbListes() {
        int i = 0;
        for (int k = 0; k < t.length; k++) {
            if (t[i].longueur() != 0) {
                i++;
            }
        }
        return i;
    }

    /**
     * Retourne une chaine de la forme:
     * [
     * 0 - (...)
     * 1 - (...)
     * .
     * .
     * ]
     */
    @Override
    public String toString() {
        StringBuilder ch = new StringBuilder();

        ch.append("[").append("\n");
        for (int i = 0; i < t.length; i++)
            ch.append("\t").append(i).append(" - ").append(t[i]).append("\n");
        ch.append("]");

        return ch.toString();
    }

    /**
     * Retourne la table sous la forme :
     * t[3] : *****
     * t[7] : *******
     * t[10] : ***
     * Dans le cas où t[3] a une longueur de 5, t[7] a une longueur de 7 et t[10] a une longueur de 3
     */
    public String toStringV2() {
        StringBuilder ch = new StringBuilder();

        ch.append("[").append("\n");
        for (int i = 0; i < t.length; i++) {
            ch.append("\t").append(i).append(" - ").append("*".repeat(t[i].longueur())).append("\n");
        }
        ch.append("]");

        return ch.toString();
    }
}