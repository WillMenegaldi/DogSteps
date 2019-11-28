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
        Map<String, Integer> response = new HashMap<String, Integer>();
        for(ETourStatus status : ETourStatus.values()){
            response.put(status.getDescription(), (int) repositoryPasseio.getList().stream()
                    .filter( passeio ->
                            passeio.getStatus().equals(status)
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
        Double media = (totalPets/totalTutores);

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
        for(EDuracao duracao : EDuracao.values()){
            response.put(duracao.getDescricao(), (double) repositoryPasseio.getList().stream()
                    .filter( passeio ->
                             passeio.getDuracao().equals(duracao)
                    ).collect(Collectors.toList())
                    .size()
            );
        }
        Gson json = new Gson();
        return json.toJson(response);
    }
}
