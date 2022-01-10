import java.math.BigInteger;

public class HTNaive{
    private static ListeBigI[] t;

    public HTNaive(int m){
        t = new ListeBigI[m];
    }

    public ListeBigI getListe(int i){
        return t[i];
    }

    private static int h(BigInteger u){
        BigInteger m = BigInteger.valueOf(t.length);
        return u.remainder(m).intValue();
    }

    public boolean contient(BigInteger u){
        return t[h(u)].contient(u);
    }

    public boolean ajout(BigInteger u){
        if(contient(u)){
            t[h(u)].ajoutTete(u);
            return true;
        }else{
            return false;
        }
    }

    public void ajoutListe(ListeBigI L){
        ListeBigI copyL = new ListeBigI(L);
        for(int i=0; i<copyL.longueur();i++){
            if()
        }
    }
}