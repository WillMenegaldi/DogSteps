package br.com.dogsteps.repositories;

import br.com.dogsteps.enums.EDuracao;
import br.com.dogsteps.enums.ETourStatus;
import br.com.dogsteps.interfaces.IBaseRepository;
import br.com.dogsteps.interfaces.IEstatistica;
import br.com.dogsteps.models.DogWalker;
import br.com.dogsteps.models.Passeio;
import br.com.dogsteps.models.Pet;
import br.com.dogsteps.models.Tutor;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import com.google.gson.Gson;


public class EstatisticasRepository implements IEstatistica<String, String> {
    private IBaseRepository<Pet> repositoryPet       = new PetRepository();
    private IBaseRepository<Passeio> repositoryPasseio   = new PasseioRepository();
    private IBaseRepository<Tutor> repositoryTutor     = new TutorRepository();
    private IBaseRepository<DogWalker> repositoryDogWalker = new DogWalkerRepository();

    @Override
    public String getPasseiosEstatistica() {
        Map<String, Double> response = new HashMap<String, Double>();
        for(ETourStatus status : ETourStatus.values()){
            response.put(status.getDescription(), (double) repositoryPasseio.getList().stream()
                    .filter( passeio ->
                            passeio.equals(status)
                    ).collect(Collectors.toList())
                    .size()
            );
        }
        Gson json = new Gson();
        return json.toJson(response);
    }

    @Override
    public String getTotalCadastroDogWalker() {
        Integer total = repositoryDogWalker.getList().size();
        return total.toString();
    }

    @Override
    public String getMediaPetsPorTutor() {
        Double totalTutores = (double) repositoryTutor.getList().size();
        Double totalPets    = (double) repositoryPet.getList().size();

        if(totalTutores == 0){
            return "";
        }
        Double media = (totalTutores/totalPets);

        return media.toString();
    }

    @Override
    public String getMediaIdadePasseadores() {
        Double media =  repositoryDogWalker.getList().stream()
                .mapToDouble(DogWalker::getIdade)
                .average().getAsDouble();
        return media.toString();
    }

    @Override
    public String getMediaHorarioPasseio() {
        Map<String, Double> response = new HashMap<String, Double>();
        for(EDuracao status : EDuracao.values()){
            response.put(status.getDescricao(), (double) repositoryPasseio.getList().stream()
                    .filter( duracao ->
                            duracao.equals(status)
                    ).collect(Collectors.toList())
                    .size()
            );
        }
        Gson json = new Gson();
        return json.toJson(response);
    }
}
