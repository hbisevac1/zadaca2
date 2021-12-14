package ba.unsa.etf.rpr;

import java.util.Objects;

public class Student extends Osoba{
    private String index;

    public Student(String ime, String prezime, String index) {
        super(ime, prezime);
        this.index = index;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(index, student.index);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}
