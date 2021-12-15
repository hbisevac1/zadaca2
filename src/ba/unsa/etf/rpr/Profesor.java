package ba.unsa.etf.rpr;

import java.util.Objects;

public class Profesor extends Osoba{
    private String idProfesora;

    public Profesor(String ime, String prezime, String idProfesora) {
        super(ime, prezime);
        this.idProfesora = idProfesora;
    }

    public String getIdProfesora() {
        return idProfesora;
    }

    public void setIdProfesora(String idProfesora) {
        this.idProfesora = idProfesora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profesor profesor = (Profesor) o;
        return Objects.equals(idProfesora, profesor.idProfesora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProfesora);
    }

    @Override
    public String toString() {
        return "Profesor: " + getIme()+ " "+getPrezime()+
                "\nidProfesora='" + idProfesora + '\'';
    }
}
