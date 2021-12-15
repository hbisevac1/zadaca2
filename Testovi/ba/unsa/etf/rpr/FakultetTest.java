package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FakultetTest {

    @Test
    void dodajPredmet() {
        Fakultet etf=new Fakultet();
        Predmet matematika=new Predmet("Inzinjerska matematika", 7, new Profesor("Severus", "Snape", "12"), 40);
        Predmet fizika=new Predmet("Inzinjerska fizika", 6, new Profesor("Albus", "Dumbldore", "21"), 70);
        ArrayList<Predmet> probni=new ArrayList<>();
        probni.add(matematika); probni.add(fizika);
        etf.dodajPredmet(matematika);
        etf.dodajPredmet(fizika);
        assertEquals(probni, etf.getPredmeti());
    }

    @Test
    void upisiStudenta() {
        Semestar s=new Semestar("Prvi");
        Fakultet etf=new Fakultet();
        UpisniList list1=new UpisniList(new Student("Hana", "Bisevac", "18628"), s);
        UpisniList list2= new UpisniList(new Student("Nezla", "Bisevac", "17877"), s);
        List<UpisniList> lista=new ArrayList<>();
        lista.add(list1); lista.add(list2);
        etf.upisiStudenta(list1); etf.upisiStudenta(list2);
        assertEquals(lista, etf.getUpisniListovi());
    }

    @Test
    void dajPrepisOcjena() {
        Semestar s=new Semestar("Prvi");
        Fakultet etf=new Fakultet();
        s.dodajObavezniPredmet(new Predmet("InzinjerskaMatematika", 7, new Profesor("Severus", "Snape", "12"), 40));
        s.dodajIzborniPredmet(new Predmet("Inzinjerska Fizika", 6, new Profesor("Poppy", "Pomfrey", "13"), 40));
        UpisniList list1=new UpisniList(new Student("Hana", "Bisevac", "18628"), s);
        etf.upisiStudenta(list1);
        etf.upisiOcjenu("18628", new Predmet("InzinjerskaMatematika", 7, new Profesor("Severus", "Snape", "12"), 40), 8);
        etf.upisiOcjenu("18628", new Predmet("Inzinjerska Fizika", 6, new Profesor("Poppy", "Pomfrey", "13"), 40), 7);
        ArrayList<Integer> probni=new ArrayList<>();
        probni.add(7); probni.add(8);
        assertEquals(probni, etf.dajPrepisOcjena(new Student("Hana", "Bisevac", "18628")));
    }

    @Test
    void dodajProfesora() {
        Osoba p1 = new Profesor("Severus", "Snape", "1");
        Osoba p2 = new Profesor("Minerva", "McGonagal", "2");
        Osoba p3 = new Profesor("Filius", "Flitwick", "3");
        Osoba p4 = new Profesor("Poppy", "Pomfrey", "4");
        Osoba p5 = new Profesor("Horace", "Slughorn", "5");
        ArrayList<Profesor> profe=new ArrayList<>();
        profe.add((Profesor) p1);
        profe.add((Profesor) p2);
        profe.add((Profesor) p3);
        profe.add((Profesor) p4);
        profe.add((Profesor) p5);
        Fakultet etf=new Fakultet();
        etf.dodajProfesora((Profesor) p1);
        etf.dodajProfesora((Profesor) p2);etf.dodajProfesora((Profesor) p3);
        etf.dodajProfesora((Profesor) p4);
        etf.dodajProfesora((Profesor) p5);
        assertEquals(profe, etf.getProfesori());

    }

    @Test
    void getRasporedPoPredmetima() {
        Student s1=new Student("Hana", "Bisevac", "18628");
        Student s2=new Student("Harry", "Potter", "19891");
        Student s3=new Student("Draco", "Malfoy", "66666");
        Student s4=new Student("Fred", "Weasly", "171717");
        Student s5=new Student("Tom", "Riddle", "666661");
        Fakultet etf=new Fakultet();
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
        prvi.dodajObavezniPredmet(m1); prvi.dodajObavezniPredmet(m2);
        prvi.dodajObavezniPredmet(m3); prvi.dodajObavezniPredmet(m4);
        prvi.dodajObavezniPredmet(m5);

        Semestar drugi = new Semestar("Drugi");
        drugi.dodajObavezniPredmet(m11); drugi.dodajObavezniPredmet(m12);
        drugi.dodajObavezniPredmet(m13); drugi.dodajIzborniPredmet(m14);
        drugi.dodajIzborniPredmet(m15);

        etf.dodajProfesora((Profesor) p1);
        etf.dodajProfesora((Profesor) p2);
        etf.dodajProfesora((Profesor) p3);
        etf.dodajProfesora((Profesor) p4);
        etf.dodajProfesora((Profesor) p5);
        etf.dodajPredmet(m1);
        etf.dodajPredmet(m2);
        etf.dodajPredmet(m3);
        etf.dodajPredmet(m4);
        etf.dodajPredmet(m5);
        etf.dodajPredmet(m11);
        etf.dodajPredmet(m12);
        etf.dodajPredmet(m13);
        etf.dodajPredmet(m14);
        etf.dodajPredmet(m15);
        UpisniList u1=new UpisniList(s1, prvi);
        UpisniList u2=new UpisniList(s2, prvi);
        UpisniList u3=new UpisniList(s3, prvi);
        UpisniList u4=new UpisniList(s4, prvi);
        UpisniList u5=new UpisniList(s5, prvi);
        UpisniList u11=new UpisniList(s1, drugi);
        UpisniList u21=new UpisniList(s2, drugi);
        UpisniList u31=new UpisniList(s3, drugi);
        UpisniList u41=new UpisniList(s4, drugi);
        UpisniList u51=new UpisniList(s5, drugi);

        u11.upisiIzborniPredmet(m14);
        u21.upisiIzborniPredmet(m15);
        u31.upisiIzborniPredmet(m14);
        u41.upisiIzborniPredmet(m14);
        u51.upisiIzborniPredmet(m14);

        etf.upisiStudenta(u1); etf.upisiStudenta(u2);
        etf.upisiStudenta(u3); etf.upisiStudenta(u4);
        etf.upisiStudenta(u5);
        etf.upisiStudenta(u11);
        etf.upisiStudenta(u21);
        etf.upisiStudenta(u31); etf.upisiStudenta(u41); etf.upisiStudenta(u51);
        HashMap<Predmet, List<Student>> mapa=new HashMap<>();
        ArrayList<Student> prvo=new ArrayList<>();
        prvo.add(s1); prvo.add(s2);
        prvo.add(s3); prvo.add(s4);
        prvo.add(s5);
        mapa.put(m1, prvo);
        mapa.put(m2, prvo);
        mapa.put(m3, prvo);
        mapa.put(m4, prvo);
        mapa.put(m5, prvo);
        ArrayList<Student> drugo=new ArrayList<>();
        ArrayList<Student> trece=new ArrayList<>();
        trece.add(s2);
        drugo.add(s1); drugo.add(s3); drugo.add(s4); drugo.add(s5);
        mapa.put(m11, prvo);
        mapa.put(m12, prvo);
        mapa.put(m13, prvo);
        mapa.put(m14, drugo);
        mapa.put(m15, trece);
        assertEquals(mapa, etf.getRasporedStudenataPoPredmetima());

    }

    @Test
    void dajNormu() {
        Student s1=new Student("Hana", "Bisevac", "18628");
        Student s2=new Student("Harry", "Potter", "19891");
        Student s3=new Student("Draco", "Malfoy", "66666");
        Student s4=new Student("Fred", "Weasly", "171717");
        Student s5=new Student("Tom", "Riddle", "666661");
        Fakultet etf=new Fakultet();
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
        prvi.dodajObavezniPredmet(m1); prvi.dodajObavezniPredmet(m2);
        prvi.dodajObavezniPredmet(m3); prvi.dodajObavezniPredmet(m4);
        prvi.dodajObavezniPredmet(m5);

        Semestar drugi = new Semestar("Drugi");
        drugi.dodajObavezniPredmet(m11); drugi.dodajObavezniPredmet(m12);
        drugi.dodajObavezniPredmet(m13); drugi.dodajIzborniPredmet(m14);
        drugi.dodajIzborniPredmet(m15);

        etf.dodajProfesora((Profesor) p1);
        etf.dodajProfesora((Profesor) p2);
        etf.dodajProfesora((Profesor) p3);
        etf.dodajProfesora((Profesor) p4);
        etf.dodajProfesora((Profesor) p5);
        etf.dodajPredmet(m1);
        etf.dodajPredmet(m2);
        etf.dodajPredmet(m3);
        etf.dodajPredmet(m4);
        etf.dodajPredmet(m5);
        etf.dodajPredmet(m11);
        etf.dodajPredmet(m12);
        etf.dodajPredmet(m13);
        etf.dodajPredmet(m14);
        etf.dodajPredmet(m15);
        UpisniList u1=new UpisniList(s1, prvi);
        UpisniList u2=new UpisniList(s2, prvi);
        UpisniList u3=new UpisniList(s3, prvi);
        UpisniList u4=new UpisniList(s4, prvi);
        UpisniList u5=new UpisniList(s5, prvi);
        UpisniList u11=new UpisniList(s1, drugi);
        UpisniList u21=new UpisniList(s2, drugi);
        UpisniList u31=new UpisniList(s3, drugi);
        UpisniList u41=new UpisniList(s4, drugi);
        UpisniList u51=new UpisniList(s5, drugi);

        u11.upisiIzborniPredmet(m14);
        u21.upisiIzborniPredmet(m14);
        u31.upisiIzborniPredmet(m14);
        u41.upisiIzborniPredmet(m14);
        u51.upisiIzborniPredmet(m14);

        etf.upisiStudenta(u1); etf.upisiStudenta(u2);
        etf.upisiStudenta(u3); etf.upisiStudenta(u4);
        etf.upisiStudenta(u5);
        etf.upisiStudenta(u11);
        etf.upisiStudenta(u21);
        etf.upisiStudenta(u31); etf.upisiStudenta(u41); etf.upisiStudenta(u51);

        HashMap<Profesor, Integer> norme=new HashMap<>();
        norme.put((Profesor) p1, 155);
        norme.put((Profesor) p2, 130);
        norme.put((Profesor) p3, 150);
        norme.put((Profesor) p4, 120);
        norme.put((Profesor) p5, 70);
        assertEquals(norme, etf.dajNormu());
    }

    @Test
    void profesoriIStudentiPoPredmetu() {
    }
}