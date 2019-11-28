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


public class EstatisticasRepository implements IEstatistica<Number> {
    private IBaseRepository<Pet> repositoryPet       = new PetRepository();
    private IBaseRepository<Passeio> repositoryPasseio   = new PasseioRepository();
    private IBaseRepository<Tutor> repositoryTutor     = new TutorRepository();
    private IBaseRepository<DogWalker> repositoryDogWalker = new DogWalkerRepository();

    private String toJSON(Map mapa){
        return new Gson().toJson(mapa);
    }

    @Override
    public String getAllEstatisticas() {
        Map<String, Map> mapa = new HashMap<>();
        mapa.put("passeios",getPasseiosEstatistica());
        mapa.put("total_de_cadastros", getTotalCadastroDogWalker());
        mapa.put("pets_por_tutor", getMediaPetsPorTutor());
        mapa.put("media_idade_passeadores", getMediaIdadePasseadores());
        mapa.put("media_duracao_passeio", getMediaHorarioPasseio());
        return toJSON(mapa);
    }

    @Override
    public Map<String, Integer> getPasseiosEstatistica() {
        Map<String, Integer> response = new HashMap<String, Integer>();
        for(ETourStatus status : ETourStatus.values()){
            response.put(status.name(), (int) repositoryPasseio.getList().stream()
                    .filter( passeio ->
                            passeio.getStatus().equals(status)
                    ).collect(Collectors.toList())
                    .size()
            );
        }
        return response;
    }

    @Override
    public Map<String, Integer> getTotalCadastroDogWalker() {
        Integer total = repositoryDogWalker.getList().size();
        Map<String, Integer> response = new HashMap<String , Integer>();
        response.put("cadastros", total);
        return response;
    }

    @Override
    public Map<String, Double> getMediaPetsPorTutor() {
        Double totalTutores = (double) repositoryTutor.getList().size();
        Double totalPets    = (double) repositoryPet.getList().size();
        Map map = new HashMap<String, Double>();
        if(totalTutores == 0){
            map.put("media", 0D);
            return map;
        }
        Double media = (totalPets/totalTutores);
        map.put("media", media);
        return map;
    }

    @Override
    public Map<String, Double> getMediaIdadePasseadores() {
        Double media =  repositoryDogWalker.getList().stream()
                .mapToDouble(DogWalker::getIdade)
                .average().getAsDouble();
        Map mapa = new HashMap<String, Double>();
        mapa.put("media_idade_passeador", media);
        return mapa;
    }

    @Override
    public Map<String, Double> getMediaHorarioPasseio() {
        Map<String, Double> response = new HashMap<String, Double>();
        for(EDuracao duracao : EDuracao.values()){
            response.put(duracao.name(), (double) repositoryPasseio.getList().stream()
                    .filter( passeio ->
                             passeio.getDuracao().equals(duracao)
                    ).collect(Collectors.toList())
                    .size()
            );
        }
        return response;
    }
}
