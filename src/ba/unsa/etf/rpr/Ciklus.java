package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class Ciklus {
    private  int brojCiklusa;
    private List<Semestar> semestri;

    public Ciklus(int broj) {
        this.brojCiklusa=broj;
        semestri=new ArrayList<>();
    }

    public void dodajSemestar(Semestar semestar) throws IllegalArgumentException{
        if(semestri.contains(semestar)){
            throw new IllegalArgumentException("Semestar vec postoji");
        }
        semestri.add(semestar);
    }

    public int getBrojCiklusa() {
        return brojCiklusa;
    }

    public void setBrojCiklusa(int brojCiklusa) {
        this.brojCiklusa = brojCiklusa;
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
        return "Ciklus: " + getBrojCiklusa() + '\n'+ rez;
    }
}
