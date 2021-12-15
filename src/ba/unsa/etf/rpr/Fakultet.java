package ba.unsa.etf.rpr;

import java.util.*;
import java.util.stream.Collectors;

public class Fakultet {
    private List<UpisniList> upisniListovi;
    private List<Student> studenti;
    private List<Profesor> profesori;
    private List<Predmet> predmeti;
    private Map<String, Map<Predmet, Integer>> ocjene;
    private Map<Predmet, List<Student>> rasporedPoPredmetima;
    private boolean daLiStudentSlusaPredmet(Predmet p, ArrayList<Predmet> p1){
        return p1.contains(p);
    }

    Fakultet(){
        upisniListovi=new ArrayList<>();
        studenti = new ArrayList<>();
        ocjene = new HashMap<>();
        profesori = new ArrayList<>();
        predmeti=new ArrayList<>();
        rasporedPoPredmetima = new HashMap<>();
    }

    public void dodajPredmet(Predmet predmet){
            predmeti.add(predmet);
    }

    public List<Predmet> getPredmeti() {
        return predmeti;
    }

    public void dodajStudenta(Student student) throws IllegalArgumentException{
        if(studenti.contains(student)) throw new IllegalArgumentException("Student je vec upisan");
        studenti.add(student);
    }

    public void upisiStudenta(UpisniList upisniList) throws IllegalArgumentException{
        if(upisniListovi.contains(upisniList)) throw new IllegalArgumentException("Student je vec upisan");
        upisniListovi.add(upisniList);
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

    public void dodajProfesora(Profesor profesor) throws IllegalArgumentException{
        if(profesori.contains(profesor)) throw new IllegalArgumentException("Profesor vec radi na ovom fakultetu");
        profesori.add(profesor);
    }

    private void rasporedSudenata(){
        for( int i = 0; i < predmeti.size(); i++){
            List<Student> pom = new ArrayList<>();
            for(int j = 0; j < upisniListovi.size(); j++){
                if(daLiStudentSlusaPredmet(predmeti.get(i), upisniListovi.get(j).dajPredmete())) {
                    pom.add(upisniListovi.get(j).getStudent());
                }
            }
            if(!pom.isEmpty()) rasporedPoPredmetima.put(predmeti.get(i), pom);
        }

    }

    public Map<Predmet, List<Student>> getRasporedPoPredmetima() {
        this.rasporedSudenata();
        return rasporedPoPredmetima;
    }

    public  HashMap<Profesor, Integer> racunanjeNorme(){
        HashMap<Profesor, Integer> norme=new HashMap<>();
        for (int i = 0; i < profesori.size(); i++){
            Profesor pom=profesori.get(i);
            Integer broj=0;
            for (int j=0; j<predmeti.size(); j++){
                if(predmeti.get(j).getProfesor().equals(pom)) {
                    if(getRasporedPoPredmetima().containsKey(predmeti.get(j))) {
                        broj += predmeti.get(j).getBrojPredavanja();
                    }
                }
            }
            norme.put(pom, broj);
        }
        return norme;
    }
}
