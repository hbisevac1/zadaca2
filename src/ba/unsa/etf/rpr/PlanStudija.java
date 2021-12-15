package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class PlanStudija {
    private  String nazivStudija;
    private List<Semestar> semestri;

    public PlanStudija(String nazivStudija) {
        this.nazivStudija = nazivStudija;
        semestri=new ArrayList<>();
    }

    public void dodajSemestar(Semestar semestar) throws IllegalArgumentException{
        if(semestri.contains(semestar)){
            throw new IllegalArgumentException("Semestar vec postoji");
        }
        semestri.add(semestar);
    }

    public String getNazivStudija() {
        return nazivStudija;
    }

    public void setNazivStudija(String nazivStudija) {
        this.nazivStudija = nazivStudija;
    }

    public List<Semestar> getSemestri() {
        return semestri;
    }

    @Override
    public String toString() {
        String rez="";
        for(int i = 0; i < semestri.size(); i++){
            rez+=semestri.get(i).toString();
        }
        return "Plan studija: " + nazivStudija + '\n'+ rez;
    }
}
