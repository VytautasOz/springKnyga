package lt.codeacademy.springKnyga.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.springKnyga.entity.Knyga;
import lt.codeacademy.springKnyga.repository.KnygaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KnygaService {
    private final KnygaRepository knygaRepository;


    public void addKnyga(Knyga knyga) {
        knygaRepository.saveAndFlush(knyga);
    }

    public void removeKnyga(int id){
        knygaRepository.deleteById(id);
    }

    public void updateVieta(int id, String vieta){
        Knyga knyga = knygaRepository.findById(id);
        knyga.setVieta(vieta);
        knygaRepository.saveAndFlush(knyga);
    }

    public List<Knyga> getByZanras(String zanras) {
        return knygaRepository.findByZanras(zanras);
    }

    public void printKnygosByZanras(String zanras) {
        List<Knyga> knygos = knygaRepository.findByZanras(zanras);
        knygos.forEach(System.out::println);
    }

    public void printAllGenresWithBooks() {
        List<String> zanrai = knygaRepository.findDistinctGenres();

        for (String zanras : zanrai) {
            System.out.println("Žanras: " + zanras);
            List<Knyga> knygos = knygaRepository.findByZanras(zanras);
            knygos.forEach(knyga -> System.out.println("  - " + knyga.getPavadinimas() + " (" + knyga.getAutorius() + ")"));
        }
    }

    public void printKnygaById(int id) {
        Knyga knyga = knygaRepository.findById(id);
        if (knyga != null) {
            System.out.println(knyga);
        }
    }



    public void addTestKnyga() {
        Knyga knyga1 = new Knyga();
        knyga1.setPavadinimas("Pjuklas");
        knyga1.setAutorius("VV");
        knyga1.setMetai("2021");
        knyga1.setZanras("Siaubo");
        knyga1.setVieta("Biblioteka");
        addKnyga(knyga1);

        Knyga knyga2 = new Knyga();
        knyga2.setPavadinimas("Ziedu Valdovas");
        knyga2.setAutorius("LL");
        knyga2.setMetai("2018");
        knyga2.setZanras("Fantastika");
        knyga2.setVieta("Sandelys");
        addKnyga(knyga2);

        Knyga knyga3 = new Knyga();
        knyga3.setPavadinimas("Twilight");
        knyga3.setAutorius("MM");
        knyga3.setMetai("2020");
        knyga3.setZanras("Drama");
        knyga3.setVieta("Kambarys");
        addKnyga(knyga3);

        Knyga knyga4 = new Knyga();
        knyga4.setPavadinimas("Haris poteris");
        knyga4.setAutorius("NN");
        knyga4.setMetai("2022");
        knyga4.setZanras("Fantastika");
        knyga4.setVieta("Virtuve");
        addKnyga(knyga4);

        Knyga knyga5 = new Knyga();
        knyga5.setPavadinimas("Isgyvenimo vadovas");
        knyga5.setAutorius("OO");
        knyga5.setMetai("2019");
        knyga5.setZanras("Knyga apie gamta");
        knyga5.setVieta("Skaitykla");
        addKnyga(knyga5);
    }
}
