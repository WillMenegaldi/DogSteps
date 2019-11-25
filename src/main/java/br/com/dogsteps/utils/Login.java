package br.com.dogsteps.utils;

import br.com.dogsteps.interfaces.IFilterLogin;
import br.com.dogsteps.interfaces.IRepositoryDao;
import br.com.dogsteps.models.DogWalker;
import br.com.dogsteps.models.Tutor;
import br.com.dogsteps.models.User;
import br.com.dogsteps.models.dto.DogWalkerDto;
import br.com.dogsteps.models.dto.TutorDto;
import br.com.dogsteps.models.dto.UserDto;
import br.com.dogsteps.repositories.DogWalkerRepository;
import br.com.dogsteps.repositories.TutorRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Login implements IFilterLogin<User, UserDto> {
    private static IRepositoryDao<DogWalker, String, DogWalkerDto> dogWalkerRepository = new DogWalkerRepository();
    private static IRepositoryDao<Tutor, String, TutorDto> tutorRepository = new TutorRepository();

    @Override
    public User filtrarUsuario(UserDto userDto) {
        List<DogWalker> listaDeDogWalkers = dogWalkerRepository.getList();
        List<Tutor> listaDeTutores = tutorRepository.getList();
        User usuarioLogado = null;


        if (listaDeDogWalkers.size() > 0) {
            usuarioLogado = listaDeDogWalkers.stream()
                    .filter(dogWalker ->
                            dogWalker.getEmail().equals(userDto.getEmail()) &&
                                    dogWalker.getSenha().equals(userDto.getSenha())
                    ).collect(Collectors.toList()).get(0);
        }

        if (listaDeTutores.size() > 0) {
            usuarioLogado = listaDeTutores.stream()
                    .filter(tutor ->
                            tutor.getEmail().equals(userDto.getEmail()) &&
                                    tutor.getSenha().equals(userDto.getSenha())
                    ).collect(Collectors.toList()).get(0);
        }

        return usuarioLogado;
    }
}
