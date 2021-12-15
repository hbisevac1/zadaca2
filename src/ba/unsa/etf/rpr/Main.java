package ba.unsa.etf.rpr;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        {
            Fakultet etf = new Fakultet();
            Osoba p1 = new Profesor("Severus", "Snape", "1");
            Osoba p2 = new Profesor("Minerva", "McGonagal", "2");
            Osoba p3 = new Profesor("Filius", "Flitwick", "3");
            Osoba p4 = new Profesor("Poppy", "Pomfrey", "4");
            Osoba p5 = new Profesor("Horace", "Slughorn", "5");
            Osoba p6 = new Profesor("Sybill", "Trelawney", "6");
            Osoba p7 = new Profesor("Pomona", "Sprout", "7");
            Osoba p8 = new Profesor("Quirinus", "Quirrell", "8");
            Osoba p9 = new Profesor("Gilderoy", "Lockhart", "9");
            Osoba p10 = new Profesor("Remus", "Lupin", "10");

            Predmet matematika1 = new Predmet("Inzinjerska matematika 1", 7, (Profesor) p1, 75);
            Predmet fizika1 = new Predmet("Inzinjerska fizika 1", 5, (Profesor) p2, 60);
            Predmet oe = new Predmet("Osnove elektrotehnike", 7, (Profesor) p3, 80);
            Predmet lag = new Predmet("Liearne algebra", 5, (Profesor) p4, 60);
            Predmet uup = new Predmet("Uvod u programiranje", 6, (Profesor) p5, 70);
            Predmet matematika2 = new Predmet("Inzinjerska matematik 2", 7, (Profesor) p1, 80);
            Predmet tp = new Predmet("Tehnike programiranja", 6, (Profesor) p10, 70);
            Predmet mlti = new Predmet("Matematicka Logika i Teorija", 7, (Profesor) p6, 70);
            Predmet vis = new Predmet("Vjerovatnoca i statistika", 5, (Profesor) p7, 60);
            Predmet os = new Predmet("Operativni sistemi", 5, (Profesor) p8, 60);

            etf.dodajPredmet(matematika1); etf.dodajPredmet(fizika1); etf.dodajPredmet(oe);
            etf.dodajPredmet(lag); etf.dodajPredmet(uup); etf.dodajPredmet(matematika2);
            etf.dodajPredmet(tp); etf.dodajPredmet(mlti); etf.dodajPredmet(vis); etf.dodajPredmet(os);

            etf.dodajProfesora((Profesor) p1);
            etf.dodajProfesora((Profesor) p2);
            etf.dodajProfesora((Profesor) p3);
            etf.dodajProfesora((Profesor) p4);
            etf.dodajProfesora((Profesor) p5);
            etf.dodajProfesora((Profesor) p6);
            etf.dodajProfesora((Profesor) p7);
            etf.dodajProfesora((Profesor) p8);
            etf.dodajProfesora((Profesor) p9);
            etf.dodajProfesora((Profesor) p10);

            Ciklus prvaGodina = new Ciklus(1);

            Semestar prvi = new Semestar("Prvi");
            prvi.dodajObavezniPredmet(matematika1);
            prvi.dodajObavezniPredmet(fizika1);
            prvi.dodajObavezniPredmet(uup);
            prvi.dodajObavezniPredmet(lag);
            prvi.dodajObavezniPredmet(oe);

            Semestar drugi = new Semestar("Drugi");
            drugi.dodajObavezniPredmet(matematika2);
            drugi.dodajObavezniPredmet(mlti);
            drugi.dodajObavezniPredmet(tp);
            drugi.dodajObavezniPredmet(vis);
            drugi.dodajObavezniPredmet(os);

            prvaGodina.dodajSemestar(prvi);
            prvaGodina.dodajSemestar(drugi);

            Predmet asp = new Predmet("Algoritmi i strukture podataka", 5, (Profesor) p8, 38);
            Predmet ld = new Predmet("Logicki dizajn", 5, (Profesor) p7, 38);
            Predmet rpr = new Predmet("Razvoj programski rjesenja", 5, (Profesor) p4, 38);
            Predmet obp = new Predmet("Osnove baza podataka", 5, (Profesor) p3, 38);
            Predmet dm = new Predmet("Diskretna matematika", 5, (Profesor) p1, 39);
            Predmet sp = new Predmet("Sistemsko programiranje", 5, (Profesor) p2, 36);
            Predmet na = new Predmet("Numericki algoritmi", 5, (Profesor) p1, 35);

            Predmet ra = new Predmet("Racunarska arhitektura", 5, (Profesor) p7, 40);
            Predmet orm = new Predmet("Osnove racunarskih mreza", 5, (Profesor) p5, 40);
            Predmet ooad = new Predmet("Objektno orijentisana analiza i dizajn", 5, (Profesor) p9, 38);
            Predmet afj = new Predmet("Automati i formalni jezici", 5, (Profesor) p10, 38);
            Predmet rma = new Predmet("Razvoj mobilnih aplikacija", 5, (Profesor) p9, 35);
            Predmet cad = new Predmet("CAD-CAM inzinjering", 5, (Profesor) p4, 35);
            Predmet us = new Predmet("Ugradbeni sistemi", 5, (Profesor) p8, 28);
            Predmet dps = new Predmet("Digitalno procesiranje signala", 5, (Profesor) p7, 28);

            etf.dodajPredmet(asp);
            etf.dodajPredmet(ld);
            etf.dodajPredmet(rpr);
            etf.dodajPredmet(obp);
            etf.dodajPredmet(dm);
            etf.dodajPredmet(sp);
            etf.dodajPredmet(na);
            etf.dodajPredmet(ra);
            etf.dodajPredmet(orm);
            etf.dodajPredmet(ooad);
            etf.dodajPredmet(afj);
            etf.dodajPredmet(rma);
            etf.dodajPredmet(cad);
            etf.dodajPredmet(us);
            etf.dodajPredmet(dps);


            Semestar treci = new Semestar("Treci");
            treci.dodajObavezniPredmet(asp);
            treci.dodajObavezniPredmet(ld);
            treci.dodajObavezniPredmet(obp);
            treci.dodajObavezniPredmet(dm);
            treci.dodajObavezniPredmet(rpr);
            treci.dodajIzborniPredmet(sp);
            treci.dodajIzborniPredmet(na);

            Semestar cetvrti = new Semestar("Cetvrti");
            cetvrti.dodajObavezniPredmet(ra);
            cetvrti.dodajObavezniPredmet(orm);
            cetvrti.dodajObavezniPredmet(ooad);
            cetvrti.dodajObavezniPredmet(afj);
            cetvrti.dodajIzborniPredmet(rma);
            cetvrti.dodajIzborniPredmet(cad);
            cetvrti.dodajIzborniPredmet(us);
            cetvrti.dodajIzborniPredmet(dps);

            prvaGodina.dodajSemestar(treci);
            prvaGodina.dodajSemestar(cetvrti);

            Predmet wt = new Predmet("Web tehnologije", 5, (Profesor) p2, 40);
            Predmet rg = new Predmet("Racunarska grafika", 5, (Profesor) p3, 22);
            Predmet ois = new Predmet("Osnove informacionih sistema", 5, (Profesor) p4, 40);
            Predmet ooi = new Predmet("Osnove operacionih istrazivanja", 5, (Profesor) p5, 40);
            Predmet vvs = new Predmet("Verifikacija i validacija softvera", 5, (Profesor) p6, 30);
            Predmet pws = new Predmet("Poslovni web sistemi", 5, (Profesor) p7, 35);
            Predmet pjp = new Predmet("Programski jezici i prevodioci", 5, (Profesor) p8, 36);
            Predmet rms = new Predmet("Racunarsko modeliranje i simulacije", 5, (Profesor) p9, 35);

            Predmet si = new Predmet("Softver inzinjering", 5, (Profesor) p10, 35);
            Predmet pis = new Predmet("Projektovanje informacionih sistema", 5, (Profesor) p9, 38);
            Predmet vi = new Predmet("Vjestacka inteligencija", 5, (Profesor) p8, 35);
            Predmet osp = new Predmet("Organizacija sofverskog projekta", 5, (Profesor) p5, 30);
            Predmet arm = new Predmet("Administracija računarskih mreža", 5, (Profesor) p4, 35);
            Predmet dass = new Predmet("Dizajn i arhitektura softverskih sistema", 5, (Profesor) p1, 30);
            Predmet psds = new Predmet("Projektovanje i sinteza digitalnih sistema", 5, (Profesor) p2, 30);

            etf.dodajPredmet(wt);
            etf.dodajPredmet(rg);
            etf.dodajPredmet(ois);
            etf.dodajPredmet(ooi);
            etf.dodajPredmet(vvs);
            etf.dodajPredmet(pws);
            etf.dodajPredmet(pjp);
            etf.dodajPredmet(rms);
            etf.dodajPredmet(si);
            etf.dodajPredmet(pis);
            etf.dodajPredmet(vi);
            etf.dodajPredmet(osp);
            etf.dodajPredmet(arm);
            etf.dodajPredmet(dass);
            etf.dodajPredmet(psds);

            Semestar peti = new Semestar("Peti");
            peti.dodajObavezniPredmet(wt);
            peti.dodajObavezniPredmet(rg);
            peti.dodajObavezniPredmet(ois);
            peti.dodajObavezniPredmet(ooi);
            peti.dodajIzborniPredmet(vvs);
            peti.dodajIzborniPredmet(pws);
            peti.dodajIzborniPredmet(pjp);
            peti.dodajIzborniPredmet(rms);

            Semestar sesti = new Semestar("Sesti");
            sesti.dodajObavezniPredmet(si);
            sesti.dodajObavezniPredmet(pis);
            sesti.dodajObavezniPredmet(vi);
            sesti.dodajIzborniPredmet(osp);
            sesti.dodajIzborniPredmet(arm);
            sesti.dodajIzborniPredmet(dass);
            sesti.dodajIzborniPredmet(psds);

            prvaGodina.dodajSemestar(peti);
            prvaGodina.dodajSemestar(sesti);



            etf.dodajCiklus(prvaGodina);
            for (; ; ) {
                System.out.println("Dobrodosli na pocetnu stranicu fakulteta!\nOdaberite neku od opcija:\n" +
                        "1. Upisi studenta\n" +
                        "2. Prikazi predmete za semestar\n" +
                        "3. Prikazi plan studija za ciklus\n" +
                        "4. Prikaze profesore na fakultetu\n" +
                        "5. Prikazi studente\n" +
                        "6. Unesi ocjenu\n" +
                        "7. Ispisi ocjene za studenta\n" +
                        "8. Prikazi norme proferosa\n" +
                        "9. Prikazi broj studenata po predmetima\n" +
                        "10. Prikazi broj studenata koji slusjau predmete kod profesora\n" +
                        "11. Izlaz\n");
                int broj;
                Scanner ulaz = new Scanner(System.in);
                broj = ulaz.nextInt();
                if(broj==11) break;
                switch (broj) {
                    case 1: {
                        Scanner ulaz1 = new Scanner(System.in);
                        System.out.println("Unesite ime studenta: ");
                        String ime;
                        ime = ulaz1.nextLine();
                        System.out.println("Unesite prezime studenta: ");
                        String prezime = ulaz1.nextLine();
                        System.out.println("Unesite broj indeksa: ");
                        String indeks = ulaz1.nextLine();
                        System.out.println("Unesite redni broj semestra koji upisujete: ");
                        int semestar;
                        Student novi = new Student(ime, prezime, indeks);
                        semestar = ulaz1.nextInt();
                        switch (semestar) {
                            case 1: {
                                UpisniList list = new UpisniList(novi, prvi);
                                etf.upisiStudenta(list);
                                break;
                            }
                            case 2: {
                                UpisniList list = new UpisniList(novi, drugi);
                                etf.upisiStudenta(list);
                                break;
                            }
                            case 3: {
                                Scanner ulaz2=new Scanner(System.in);
                                UpisniList list = new UpisniList(novi, treci);
                                System.out.println("Izaberite izborni predmet: ");
                                System.out.println(treci.toString());
                                String izbor = ulaz2.nextLine();
                                switch (izbor) {
                                    case "Sistemsko programiranje":
                                        list.upisiIzborniPredmet(sp);
                                    case "Numericki algoritmi":
                                        list.upisiIzborniPredmet(na);
                                }
                                etf.upisiStudenta(list);
                                break;
                            }
                            case 4: {
                                Scanner ulaz2=new Scanner(System.in);
                                UpisniList list = new UpisniList(novi, cetvrti);
                                System.out.println("Izaberite dva izborna predmeta: ");
                                System.out.println(cetvrti.toString());
                                String izbor1 = ulaz2.nextLine();
                                String izbor2 = ulaz2.nextLine();
                                switch (izbor1) {
                                    case "Razvoj mobilnih aplikacija":
                                        list.upisiIzborniPredmet(rma);
                                        break;
                                    case "CAD-CAM inzinjering":
                                        list.upisiIzborniPredmet(cad);
                                        break;
                                    case "Ugradbeni sistemi":
                                        list.upisiIzborniPredmet(us);
                                        break;
                                    case "Digitalno procesiranje signala":
                                        list.upisiIzborniPredmet(dps);
                                        break;
                                }
                                switch (izbor2) {
                                    case "Razvoj mobilnih aplikacija":
                                        list.upisiIzborniPredmet(rma);
                                        break;
                                    case "CAD-CAM inzinjering":
                                        list.upisiIzborniPredmet(cad);
                                        break;
                                    case "Ugradbeni sistemi":
                                        list.upisiIzborniPredmet(us);
                                        break;
                                    case "Digitalno procesiranje signala":
                                        list.upisiIzborniPredmet(dps);
                                        break;
                                }
                                etf.upisiStudenta(list);
                                break;
                            }
                            case 5: {
                                Scanner ulaz2=new Scanner(System.in);
                                UpisniList list = new UpisniList(novi, peti);
                                System.out.println("Izaberite dva izborna predmeta: ");
                                System.out.println(peti.toString());
                                String izbor1 = ulaz2.nextLine();
                                String izbor2 = ulaz2.nextLine();
                                switch (izbor1) {
                                    case "Verifikacija i validacija softvera":
                                        list.upisiIzborniPredmet(vvs);
                                        break;
                                    case "Poslovni web sistemi":
                                        list.upisiIzborniPredmet(pws);
                                        break;
                                    case "Programski jezici i prevodioci":
                                        list.upisiIzborniPredmet(pjp);
                                        break;
                                    case "Računarsko modeliranje i simulacije":
                                        list.upisiIzborniPredmet(rms);
                                        break;
                                }
                                switch (izbor2) {
                                    case "Verifikacija i validacija softvera":
                                        list.upisiIzborniPredmet(vvs);
                                        break;
                                    case "Poslovni web sistemi":
                                        list.upisiIzborniPredmet(pws);
                                        break;
                                    case "Programski jezici i prevodioci":
                                        list.upisiIzborniPredmet(pjp);
                                        break;
                                    case "Računarsko modeliranje i simulacije":
                                        list.upisiIzborniPredmet(rms);
                                        break;
                                }
                                etf.upisiStudenta(list);
                                break;
                            }
                            case 6: {
                                Scanner ulaz2=new Scanner(System.in);
                                UpisniList list = new UpisniList(novi, sesti);
                                System.out.println("Izaberite dva izborna predmeta: ");
                                String izbor1 = ulaz2.nextLine();
                                String izbor2 = ulaz2.nextLine();
                                switch (izbor1) {
                                    case "Organizacija softverskog projekta":
                                        list.upisiIzborniPredmet(osp);
                                        break;
                                    case "Administracija računarskih mreža":
                                        list.upisiIzborniPredmet(arm);
                                        break;
                                    case "Dizajn i arhitektura softverskih sistema":
                                        list.upisiIzborniPredmet(dass);
                                        break;
                                    case "Projektovanje i sinteza digitalnih sistema":
                                        list.upisiIzborniPredmet(psds);
                                        break;
                                }
                                switch (izbor2) {
                                    case "Organizacija softverskog projekta":
                                        list.upisiIzborniPredmet(osp);
                                        break;
                                    case "Administracija računarskih mreža":
                                        list.upisiIzborniPredmet(arm);
                                        break;
                                    case "Dizajn i arhitektura softverskih sistema":
                                        list.upisiIzborniPredmet(dass);
                                        break;
                                    case "Projektovanje i sinteza digitalnih sistema":
                                        list.upisiIzborniPredmet(psds);
                                        break;
                                }
                                etf.upisiStudenta(list);
                                break;
                            }
                        }
                        break;
                    }
                    case 2: {
                        Scanner ulaz2=new Scanner(System.in);
                        System.out.println("Unesite semestar: ");
                        int br = ulaz2.nextInt();
                        switch (br) {
                            case 1: {
                                System.out.println(prvi.toString());
                                break;
                            }
                            case 2: {
                                System.out.println(drugi.toString());
                                break;
                            }
                            case 3: {
                                System.out.println(treci.toString());
                                break;
                            }
                            case 4: {
                                System.out.println(cetvrti.toString());
                                break;
                            }
                            case 5: {
                                System.out.println(peti.toString());
                                break;
                            }
                            case 6: {
                                System.out.println(sesti.toString());
                                break;
                            }
                        }
                        break;
                    }
                    case 3: {
                        System.out.println(prvaGodina.toString());
                        break;
                    }
                    case 4: {
                        ArrayList<Profesor> p = (ArrayList<Profesor>) etf.getProfesori();
                        for (int i = 0; i < p.size(); i++) {
                            System.out.println(p.get(i).toString());
                        }
                        break;
                    }
                    case 5: {
                        ArrayList<Student> s = (ArrayList<Student>) etf.getStudenti();
                        for (int i = 0; i < s.size(); i++) {
                            System.out.println(s.get(i).toString());
                        }
                        break;
                    }
                    case 6: {
                        Scanner ulaz2=new Scanner(System.in);
                        System.out.println("Unesite ime predmeta: ");
                        String predmet = ulaz2.nextLine();
                        ArrayList<Predmet> p = (ArrayList<Predmet>) etf.getPredmeti();
                        for (int i = 0; i < p.size(); i++) {
                            if (p.get(i).getImePredmeta().equals(predmet)) {
                                System.out.println("Unesite broj indeksa studenta: ");
                                String indeks = ulaz.nextLine();
                                System.out.println("Unesite ocjenu: ");
                                Integer ocjena = ulaz.nextInt();
                                etf.upisiOcjenu(indeks, p.get(i), ocjena);
                                break;
                            }
                        }
                        break;
                    }
                    case 7: {
                        Scanner ulaz2=new Scanner(System.in);
                        System.out.println("Unesite studenta za kojeg zelite ispisane ocjene: ");
                        String ime, prezime, indeks;
                        System.out.println("Ime: ");
                        ime = ulaz.nextLine();
                        System.out.println("Prezime: ");
                        prezime = ulaz.nextLine();
                        System.out.println("Indeks: ");
                        indeks = ulaz2.nextLine();
                        Student novi = new Student(ime, prezime, indeks);
                        etf.dajPrepisOcjena(novi);
                        break;
                    }
                    case 8: {
                        Map<Profesor, Integer> norme = etf.dajNormu();
                        for (Map.Entry<Profesor, Integer> p : norme.entrySet()) {
                            if (p.getValue() < 130)
                                System.out.println(p.getKey().toString() + "\nNorma: " + p.getValue() + "\nNorma nije ispunjena\n");
                            else
                                System.out.println(p.getKey().toString() + "\nNorma: " + p.getValue() + "\nNorma je ispunjena\n");
                        }
                        break;
                    }
                    case 9: {
                        Map<Predmet, List<Student>> p = etf.getRasporedStudenataPoPredmetima();
                        for (Map.Entry<Predmet, List<Student>> s : p.entrySet()) {
                            System.out.println(s.getKey().toString() + "Studenti na predmetu: ");
                            for (int i = 0; i < s.getValue().size(); i++) {
                                System.out.println(s.getValue().get(i).toString());
                            }
                        }

                        break;
                    }
                    case 10: {
                        System.out.println("Profesori i broj studenata koji slisaju njihove predmete:\n");
                        Map<Profesor, Integer> p = etf.profesoriIStudentiPoPredmetu();
                        for (Map.Entry<Profesor, Integer> s : p.entrySet()) {
                            System.out.println(s.getKey().toString() + " Broj studenata: " + s.getValue() + "\n");
                        }
                        break;
                    }
                    case 11:
                        break;
                }

            }
        }
/*
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
            UpisniList s1 = new UpisniList(new Student("Nezla", "Bisevac", "17782"), prvi);
            UpisniList s2 = new UpisniList(new Student("Nezla", "Bisevac", "17782"), drugi);
            u2.upisiIzborniPredmet(m14);
            s2.upisiIzborniPredmet(m15);
            etf.upisiStudenta(u1);
            etf.upisiStudenta(u2);
            etf.upisiStudenta(s1);
            etf.upisiStudenta(s2);
            try{
                UpisniList u3 = new UpisniList(new Student("Hana", "Bisevac", "18628"), prvi);
                etf.upisiStudenta(u3);

            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
            Map<Profesor, Integer> norma=etf.dajNormu();
            for(Map.Entry<Profesor, Integer> n : norma.entrySet()){
                System.out.println(n.getKey().getIme()+" "+n.getKey().getPrezime()+"\nNorma: "+n.getValue()+"\n");
            }
            Map<Profesor, Integer> mapa=etf.profesoriIStudentiPoPredmetu();
            for(Map.Entry<Profesor, Integer> n : mapa.entrySet()){
                System.out.println(n.getKey().getIme()+" "+n.getKey().getPrezime()+"\nBroj studenata: "+n.getValue()+"\n");
            }

        }
*/
    }
}
