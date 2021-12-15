package ba.unsa.etf.rpr;

import javax.swing.text.StyleContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	/*Student novi=new Student("Hana", "Bisevac", "18628");
    Fakultet etf = new Fakultet();
    etf.upisiStudenta(novi);
    Osoba p1=new Profesor("Naida", "Mujic", "12");
    Predmet im1=new Predmet("Inzinjerska matematika 1", 7, (Profesor) p1, 75);
    etf.upisiOcjenu("18628", im1, 8);
    ArrayList<Integer> ocjene1=etf.dajPrepisOcjena(novi);
    ocjene1.stream().forEach(System.out::println);*/

        {
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



            Fakultet etf = new Fakultet();
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
            UpisniList u1 = new UpisniList(new Student("Hana", "Bisevac", "18628"), prvi);
            UpisniList u2 = new UpisniList(new Student("Hana", "Bisevac","18628"), drugi);
            u2.upisiIzborniPredmet(m14);
            etf.upisiStudenta(u1);
            etf.upisiStudenta(u2);
            HashMap<Profesor, Integer> norma=etf.racunanjeNorme();
            for(Map.Entry<Profesor, Integer> n : norma.entrySet()){
                System.out.println(n.getKey().getIme()+" "+n.getKey().getPrezime()+"\nNorma: "+n.getValue()+"\n");
            }

        }

    }
}
