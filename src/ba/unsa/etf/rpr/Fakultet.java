package ba.unsa.etf.rpr;

import java.util.*;
import java.util.stream.Collectors;

public class Fakultet {
    private List<UpisniList> upisniListovi;
    private List<Ciklus> ciklusi;
    private List<Student> studenti;
    private List<Profesor> profesori;
    private List<Predmet> predmeti;
    private Map<String, Map<Predmet, Integer>> ocjene;
    private Map<Predmet, List<Student>> rasporedStudenataPoPredmetima;

    private boolean daLiStudentSlusaPredmet(Predmet p, ArrayList<Predmet> p1){
        return p1.contains(p);
    }

    private HashMap<Profesor, List<Predmet>> listaProfesoraIPredmeta(){
        HashMap<Profesor, List<Predmet>> lista=new HashMap<>();
        for(int i=0; i<profesori.size(); i++){
            List<Predmet> pom=new ArrayList<>();
            for(int j=0; j<predmeti.size(); j++){
                if(predmeti.get(j).getProfesor().equals(profesori.get(i))) pom.add(predmeti.get(j));
            }
            lista.put(profesori.get(i), pom);
        }
        return lista;
    }

    private int brojStudenataNaPredmetu(Predmet predmet){
        List<Student> s = getRasporedStudenataPoPredmetima().get(predmet);
        if(s==null) return 0;
        return s.size();
    }


    Fakultet(){
        upisniListovi=new ArrayList<>();
        studenti = new ArrayList<>();
        ocjene = new HashMap<>();
        profesori = new ArrayList<>();
        predmeti=new ArrayList<>();
        rasporedStudenataPoPredmetima = new HashMap<>();
        ciklusi=new ArrayList<>();
    }

    public List<UpisniList> getUpisniListovi() {
        return upisniListovi;
    }

    public List<Student> getStudenti() {
        return studenti;
    }

    public List<Profesor> getProfesori() {
        return profesori;
    }

    public List<Predmet> getPredmeti() {
        return predmeti;
    }

    public void dodajPredmet(Predmet predmet) throws IllegalArgumentException{
        if(predmeti.contains(predmet)) throw new IllegalArgumentException("Ovaj predmet vec postoji");
            predmeti.add(predmet);
    }

    public void upisiStudenta(UpisniList upisniList) throws IllegalArgumentException{
        if(upisniListovi.contains(upisniList)) throw new IllegalArgumentException("Student je vec upisan");
        upisniListovi.add(upisniList);
        if(!studenti.contains(upisniList.getStudent())) studenti.add(upisniList.getStudent());
    }

    public Map<Predmet, Integer> dajPrepisOcjena(Student student) throws IllegalArgumentException{
        Map<Predmet, Integer> lista= new HashMap<>();
        if(ocjene.containsKey(student.getIndex())){
            for(Map.Entry<String, Map<Predmet, Integer>> p : ocjene.entrySet()){
                if(p.getKey().equals(student.getIndex())){
                    Map<Predmet, Integer> pom=p.getValue();
                    for(Map.Entry<Predmet, Integer> o : pom.entrySet()){
                        lista.put(o.getKey(), o.getValue());
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
            if(!pom.isEmpty()) rasporedStudenataPoPredmetima.put(predmeti.get(i), pom);
        }

    }

    public Map<Predmet, List<Student>> getRasporedStudenataPoPredmetima() {
        this.rasporedSudenata();
        return rasporedStudenataPoPredmetima;
    }

    public  Map<Profesor, Integer> dajNormu(){
        HashMap<Profesor, Integer> norme=new HashMap<>();
        for (int i = 0; i < profesori.size(); i++){
            Profesor pom=profesori.get(i);
            Integer broj=0;
            for (int j=0; j<predmeti.size(); j++){
                if(predmeti.get(j).getProfesor().equals(pom)) {
                    if(getRasporedStudenataPoPredmetima().containsKey(predmeti.get(j))) {
                        broj += predmeti.get(j).getBrojPredavanja();
                    }
                }
            }
            norme.put(pom, broj);
        }
        LinkedHashMap<Profesor, Integer> nova = new LinkedHashMap<>();
        norme.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(x->nova.put(x.getKey(), x.getValue()));
        return nova;
    }

    public Map<Profesor, Integer> profesoriIStudentiPoPredmetu(){
        Map<Profesor, Integer> lista=new HashMap<>();
        HashMap<Profesor, List<Predmet>> profesor=listaProfesoraIPredmeta();
        for(Map.Entry<Profesor, List<Predmet>> p : profesor.entrySet()){
            Integer broj=0;
            for(int i=0; i<p.getValue().size(); i++){
                broj+=brojStudenataNaPredmetu(p.getValue().get(i));
            }
            lista.put(p.getKey(), broj);
        }
        LinkedHashMap<Profesor, Integer> novi=new LinkedHashMap<>();
        lista.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(x->novi.put(x.getKey(), x.getValue()));
        return novi;
    }

    public void dodajCiklus(Ciklus prvaGodina) throws IllegalArgumentException{
        if(ciklusi.contains(prvaGodina)) throw new IllegalArgumentException("Ciklus je vec upisan");
        ciklusi.add(prvaGodina);
    }

    public List<Ciklus> getCiklusi() {
        return ciklusi;
    }
}
