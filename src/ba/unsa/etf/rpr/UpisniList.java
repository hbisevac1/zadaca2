package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UpisniList {
    private Semestar semestar;
    private Student student;
    private List<Predmet> izborni;
    private int bodoviECTS;

    public UpisniList(Student student, Semestar semestar) {
        this.student=student;
        this.semestar = semestar;
        this.izborni=new ArrayList<>();
        bodoviECTS=0;
        for(int i=0; i<semestar.getObavezniPredmeti().size(); i++){
            bodoviECTS+=semestar.getObavezniPredmeti().get(i).getBrojBodova();
        }
    }

    public Student getStudent() {
        return student;
    }

    public ArrayList<Predmet> dajPredmete(){
        ArrayList<Predmet> predmeti=new ArrayList<>();
        semestar.getObavezniPredmeti().stream().collect(Collectors.toCollection(()->predmeti));
        izborni.stream().collect(Collectors.toCollection(()->predmeti));
        return predmeti;
    }

    public void upisiIzborniPredmet(Predmet predmet){
        List<Predmet> provjera=semestar.getIzborniPredmeti();
        if(!provjera.contains(predmet)) throw new IllegalArgumentException("Ovaj predmet nije ponudjen kao izborni");
        izborni.add(predmet);
    }

    public List<Predmet> getIzborni() {
        return izborni;
    }

    public int getBodoviECTS(){
        for (int i = 0; i < izborni.size(); i++){
            bodoviECTS+=izborni.get(i).getBrojBodova();
        }
        return bodoviECTS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpisniList that = (UpisniList) o;
        return Objects.equals(semestar, that.semestar) && Objects.equals(student, that.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(semestar, student);
    }
}
