package ba.unsa.etf.rpr;

import java.util.ArrayList;

public class UpisniList {
    private Student student;
    private Predmet predmet;
    private String idSemestra;
    private PlanStudija planStudija;

    public UpisniList(Student student, Predmet predmet, String idSemestra, PlanStudija planStudija) {
        this.student = student;
        this.predmet = predmet;
        this.idSemestra = idSemestra;
        this.planStudija = planStudija;
    }

}
