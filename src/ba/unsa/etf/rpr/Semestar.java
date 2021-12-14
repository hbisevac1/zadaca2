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
    public void dodajIzborniPredmet(Predmet predmet){
        if(izborniPredmeti.contains(predmet)){
            throw new IllegalArgumentException("Predmet vec postoji");
        }
        izborniPredmeti.add(predmet);
    }
    public void dodajObavezniPredmet(Predmet predmet){
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
}
