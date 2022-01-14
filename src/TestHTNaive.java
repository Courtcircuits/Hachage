import java.util.concurrent.ThreadLocalRandom;

public class TestHTNaive {
    public static void main(String args[]) {
        Dictionnaire d = new Dictionnaire("/home/ann1/radulescut/Hachage/src/randomWords.txt", 2000);
        System.out.println("maxSize : " + d.getMaxSize());
        System.out.println("cardinal : " + d.getCardinal());
        System.out.println("nbListes : " + d.getNbListes());
        int nbRecherches = 100000;
        final ThreadLocalRandom random = ThreadLocalRandom.current();
        long debut = System.currentTimeMillis();
        for (int i = 0; i < nbRecherches; i++) {
            int tailleMot = random.nextInt(15) + 2;
            char[] mot = new char[tailleMot];
            for (int j = 0; j < mot.length; j++)
                mot[j] = (char) ('a' + random.nextInt(26));
            String motS = new String(mot);
            d.contient(motS);
        }
        long fin = System.currentTimeMillis();
        System.out.println("temps total : " + (fin - debut));
    }

}
