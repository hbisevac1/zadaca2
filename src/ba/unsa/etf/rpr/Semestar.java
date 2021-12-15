package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class Semestar {
    private String idSemestra;
    private List<Predmet> izborniPredmeti;
    private List<Predmet> obavezniPredmeti;

    public Semestar(String idSemestra) {
        this.idSemestra = idSemestra;
        this.izborniPredmeti = new ArrayList<>();
        this.obavezniPredmeti = new ArrayList<>();
    }

    public void dodajIzborniPredmet(Predmet predmet)throws IllegalArgumentException{
        if(izborniPredmeti.contains(predmet)){
            throw new IllegalArgumentException("Predmet vec postoji");
        }
        izborniPredmeti.add(predmet);
    }

    public void dodajObavezniPredmet(Predmet predmet)throws IllegalArgumentException{
        if(obavezniPredmeti.contains(predmet)){
            throw new IllegalArgumentException("Predmet vec postoji");
        }
        obavezniPredmeti.add(predmet);
    }

    public String getIdSemestra() {
        return idSemestra;
    }

    public List<Predmet> getIzborniPredmeti() {
        return izborniPredmeti;
    }

    public List<Predmet> getObavezniPredmeti() {
        return obavezniPredmeti;
    }

    @Override
    public String toString() {
        String rez="";
        rez="Semestar: "+getIdSemestra()+"\nObavezni predmeti:\n";
        for(int i=0; i<obavezniPredmeti.size(); i++){
            int broj=i+1;
            rez+=broj+". "+obavezniPredmeti.get(i).getImePredmeta()+"\n";
        }
        if(izborniPredmeti.size()!=0){
            rez+="Izborni predmeti:\n";
            for (int i = 0; i<izborniPredmeti.size(); i++){
                int broj=i+1;
                rez+=broj+". "+izborniPredmeti.get(i).getImePredmeta()+"\n";
            }
        }
        else rez+="Nema izbornih predmeta za ovaj semestar.\n";
        return rez;
    }
}
