package ba.unsa.etf.rpr;

import java.util.Objects;

public class Predmet {
    private String imePredmeta;
    private int brojBodova;
    private Profesor profesor;
    private int brojPredavanja;

    Predmet(String imePredmeta, int brojBodova, Profesor profesor, int brojPredavanja){
        this.imePredmeta=imePredmeta;
        this.brojBodova=brojBodova;
        this.profesor=profesor;
        this.brojPredavanja=brojPredavanja;
    }

    public String getImePredmeta() {
        return imePredmeta;
    }

    public void setImePredmeta(String imePredmeta) {
        this.imePredmeta = imePredmeta;
    }

    public int getBrojBodova() {
        return brojBodova;
    }

    public void setBrojBodova(int brojBodova) {
        this.brojBodova = brojBodova;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public int getBrojPredavanja() {
        return brojPredavanja;
    }

    public void setBrojPredavanja(int brojPredavanja) {
        this.brojPredavanja = brojPredavanja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Predmet predmet = (Predmet) o;
        return Objects.equals(imePredmeta, predmet.imePredmeta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imePredmeta);
    }

    @Override
    public String toString() {
        return "Ime predmeta: '" + imePredmeta + '\'' + " Broj ETCS bodova: "+brojBodova+
                "\n";
    }
}
