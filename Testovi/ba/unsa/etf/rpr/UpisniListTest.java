package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UpisniListTest {
    Osoba p1 = new Profesor("Severus", "Snape", "1");
    Osoba p2 = new Profesor("Minerva", "McGonagal", "2");
    Osoba p3 = new Profesor("Filius", "Flitwick", "3");
    Osoba p4 = new Profesor("Poppy", "Pomfrey", "4");
    Osoba p5 = new Profesor("Horace", "Slughorn", "5");

    Predmet m1 = new Predmet("Inzinjerska matematika 1", 7, (Profesor) p1, 75);
    Predmet m2 = new Predmet("Inzinjerska fizika 1", 5, (Profesor) p2, 60);
    Predmet m3 = new Predmet("Osnove elektrotehnike", 7, (Profesor) p3, 80);
    Predmet m4 = new Predmet("Liearne algebra", 5, (Profesor) p4, 60);
    Predmet m5 = new Predmet("Uvod u programiranje", 6, (Profesor) p5, 70);

    Predmet m11 = new Predmet("Inzinjerska matematik 2",7, (Profesor) p1, 80);
    Predmet m12 = new Predmet("Tehnike programiranja", 6, (Profesor) p2, 70);
    Predmet m13 = new Predmet("Matematicka Logika i Teorija", 7, (Profesor) p3, 70);
    Predmet m14 = new Predmet("Vjerovatnoca i statistika", 5, (Profesor) p4, 60);
    Predmet m15 = new Predmet("Operativni sistemi", 5, (Profesor) p5, 60);
    Semestar prvi = new Semestar("Prvi");
    Semestar drugi = new Semestar("Drugi");

    @Test
    void getStudent() {
        prvi.dodajObavezniPredmet(m1); prvi.dodajObavezniPredmet(m2);
        prvi.dodajObavezniPredmet(m3); prvi.dodajObavezniPredmet(m4);
        prvi.dodajObavezniPredmet(m5);
        UpisniList l = new UpisniList(new Student("Hana", "Bisevac", "18628"), prvi);
        Student s = new Student("Hana", "Bisevac", "18628");
        assertEquals(s, l.getStudent());

    }

    @Test
    void dajPredmete() {
        prvi.dodajObavezniPredmet(m1); prvi.dodajObavezniPredmet(m2);
        prvi.dodajObavezniPredmet(m3); prvi.dodajObavezniPredmet(m4);
        prvi.dodajObavezniPredmet(m5);
        UpisniList l = new UpisniList(new Student("Hana", "Bisevac", "18628"), prvi);
        ArrayList<Predmet> probni=new ArrayList<>();
        probni.add(m1); probni.add(m2); probni.add(m3);
        probni.add(m4); probni.add(m5);
        assertEquals(probni, l.dajPredmete());
    }

    @Test
    void upisiIzborniPredmet() {
        drugi.dodajObavezniPredmet(m11); drugi.dodajObavezniPredmet(m12);
        drugi.dodajObavezniPredmet(m13); drugi.dodajIzborniPredmet(m14);
        drugi.dodajIzborniPredmet(m15);
        UpisniList l = new UpisniList(new Student("Hana", "Bisevac", "18628"), drugi);
        l.upisiIzborniPredmet(m15);
        ArrayList<Predmet> probni=new ArrayList<>();
        probni.add(m15);
        assertEquals(probni, l.getIzborni());
    }

    @Test
    void upisiIzborniPredmetIzuzetak(){
        drugi.dodajObavezniPredmet(m11); drugi.dodajObavezniPredmet(m12);
        drugi.dodajObavezniPredmet(m13); drugi.dodajIzborniPredmet(m14);
        drugi.dodajIzborniPredmet(m15);
        UpisniList l = new UpisniList(new Student("Hana", "Bisevac", "18628"), drugi);
        Exception exception=assertThrows(IllegalArgumentException.class, ()->l.upisiIzborniPredmet(m1));
        assertEquals("Ovaj predmet nije ponudjen kao izborni", exception.getMessage());

    }

    @Test
    void getBodoviECTS() {
        drugi.dodajObavezniPredmet(m11); drugi.dodajObavezniPredmet(m12);
        drugi.dodajObavezniPredmet(m13); drugi.dodajIzborniPredmet(m14);
        drugi.dodajIzborniPredmet(m15);
        UpisniList l = new UpisniList(new Student("Hana", "Bisevac", "18628"), drugi);
        l.upisiIzborniPredmet(m15);
        l.upisiIzborniPredmet(m14);
        assertEquals(30, l.getBodoviECTS());

    }

    @Test
    void testEquals() {
        prvi.dodajObavezniPredmet(m1); prvi.dodajObavezniPredmet(m2);
        prvi.dodajObavezniPredmet(m3); prvi.dodajObavezniPredmet(m4);
        prvi.dodajObavezniPredmet(m5);
        UpisniList l = new UpisniList(new Student("Hana", "Bisevac", "18628"), prvi);
        drugi.dodajObavezniPredmet(m11); drugi.dodajObavezniPredmet(m12);
        drugi.dodajObavezniPredmet(m13); drugi.dodajIzborniPredmet(m14);
        drugi.dodajIzborniPredmet(m15);
        UpisniList l2 = new UpisniList(new Student("Hana", "Bisevac", "18628"), drugi);
        UpisniList l3 = new UpisniList(new Student("Hana", "Bisevac", "18628"), drugi);
        assertAll(
                ()->assertFalse(l.equals(l2)),
                ()->assertTrue(l2.equals(l3))
        );
    }

}