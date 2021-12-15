package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SemestarTest {
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
    void dodajIzborniPredmet() {
        drugi.dodajObavezniPredmet(m11); drugi.dodajObavezniPredmet(m12);
        drugi.dodajObavezniPredmet(m13); drugi.dodajIzborniPredmet(m14);
        drugi.dodajIzborniPredmet(m15);
        ArrayList<Predmet> probni=new ArrayList<>();
        probni.add(m14); probni.add(m15);
        assertEquals(probni, drugi.getIzborniPredmeti());
    }

    @Test
    void dodajIzborniPredmetIzuzetak(){
        drugi.dodajObavezniPredmet(m11); drugi.dodajObavezniPredmet(m12);
        drugi.dodajObavezniPredmet(m13); drugi.dodajIzborniPredmet(m14);
        drugi.dodajIzborniPredmet(m15);
        Exception exception=assertThrows(IllegalArgumentException.class,
                ()->drugi.dodajIzborniPredmet(m15)
                );
        assertEquals("Predmet vec postoji", exception.getMessage());

    }


    @Test
    void dodajObavezniPredmet() {
        drugi.dodajObavezniPredmet(m11); drugi.dodajObavezniPredmet(m12);
        drugi.dodajObavezniPredmet(m13); drugi.dodajIzborniPredmet(m14);
        drugi.dodajIzborniPredmet(m15);
        ArrayList<Predmet> probni=new ArrayList<>();
        probni.add(m11); probni.add(m12); probni.add(m13);
        assertEquals(probni, drugi.getObavezniPredmeti());
    }


    @Test
    void dodajObavezniPredmetIzuzetak() {
        drugi.dodajObavezniPredmet(m11); drugi.dodajObavezniPredmet(m12);
        drugi.dodajObavezniPredmet(m13); drugi.dodajIzborniPredmet(m14);
        drugi.dodajIzborniPredmet(m15);
        Exception exception=assertThrows(IllegalArgumentException.class,
                ()->drugi.dodajObavezniPredmet(m11)
        );
        assertEquals("Predmet vec postoji", exception.getMessage());

    }
}