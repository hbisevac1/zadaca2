package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fakultet {
    private List<UpisniList> upisniListovi;
    private List<Student> studenti;
    private List<PlanStudija> planoviStudija;
    private Map<String, Map<Predmet, Integer>> ocjene;
    private Map<Profesor, List<Predmet>> profesori;


    Fakultet(){
        upisniListovi=new ArrayList<>();
        studenti = new ArrayList<>();
        planoviStudija = new ArrayList<>();
        ocjene = new HashMap<>();
        profesori = new HashMap<>();
    }
    public void dodajPlanStudija(PlanStudija planStudija){
        planoviStudija.add(planStudija);
    }

    public void upisiOcjenu(String indeks, Predmet predmet, Integer ocjena) throws IllegalArgumentException{
        if(ocjene.containsKey(indeks)){
            Map<Predmet, Integer> pom = ocjene.get(indeks);
            if(pom.containsKey(predmet)) throw new IllegalArgumentException("Ocjena je vec upisana");
            pom.put(predmet, ocjena);
        }
        else{
            Map<Predmet, Integer> p=new HashMap<>();
            p.put(predmet, ocjena);
            ocjene.put(indeks, p);
        }
    }

    public void upisiStudenta(Student student) throws IllegalArgumentException{
        if(studenti.contains(student)) throw new IllegalArgumentException("Student je vec upisan");
        studenti.add(student);
    }



    public ArrayList<Integer> dajPrepisOcjena(Student student) throws IllegalArgumentException{
        ArrayList<Integer> lista= new ArrayList<>();
        if(ocjene.containsKey(student.getIndex())){
            for(Map.Entry<String, Map<Predmet, Integer>> p : ocjene.entrySet()){
                if(p.getKey().equals(student.getIndex())){
                    Map<Predmet, Integer> pom=p.getValue();
                    for(Map.Entry<Predmet, Integer> o : pom.entrySet()){
                        lista.add(o.getValue());
                    }
                    break;
                }
            }
        }
        else throw new IllegalArgumentException("Student ne postoji");
        return lista;
    }


}
