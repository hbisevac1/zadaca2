package ba.unsa.etf.rpr;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	Student novi=new Student("Hana", "Bisevac", "18628");
    Fakultet etf = new Fakultet();
    etf.upisiStudenta(novi);
    Osoba p1=new Profesor("Naida", "Mujic", "12");
    Predmet im1=new Predmet("Inzinjerska matematika 1", 7, (Profesor) p1, 75);
    etf.upisiOcjenu("18628", im1, 8);
    ArrayList<Integer> ocjene1=etf.dajPrepisOcjena(novi);
    ocjene1.stream().forEach(System.out::println);
    }
}
