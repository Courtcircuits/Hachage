import java.math.BigInteger;

public class Dictionnaire {

    private HTNaive dico;

    public Dictionnaire(int m) {
        this.dico = new HTNaive(m);
    }

    public Dictionnaire(String fileName, int m) {
        this(m);
        this.dico.ajoutListe(calculeListeInt(fileName));
    }

    private static BigInteger stringToBigInteger(String s) {
        BigInteger res = BigInteger.ZERO;
        for (int i = s.length() - 1; i >= 0; i--) {
            long result = (long) (s.charAt(i) * Math.pow(255, s.length() - i - 1));
            res = res.add(BigInteger.valueOf(result));
        }
        return res;
    }

    public boolean ajout(String s) {
        final BigInteger valeur = Dictionnaire.stringToBigInteger(s);
        if (this.dico.contient(valeur)){
            return false;
        } else {
            this.dico.ajout(valeur);
            return true;
        }
    }
    public boolean contient(String s){
        return this.dico.contient(Dictionnaire.stringToBigInteger(s));
    }
}
