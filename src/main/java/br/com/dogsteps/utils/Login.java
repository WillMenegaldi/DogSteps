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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Login implements IFilterLogin
{
    private static IRepositoryDao<DogWalker, String, DogWalkerDto> dogWalkerRepository = new DogWalkerRepository();
    private static IRepositoryDao<Tutor, String, TutorDto> tutorRepository = new TutorRepository();
    private static User user;

    @Override
    public User filtrarUsuario(UserDto userDto)
    {
        user = (DogWalker) dogWalkerRepository.getList().stream()
            .filter( dogWalker ->
                userDto.getEmail().equals(dogWalker.getEmail()) &&
                userDto.getEmail().equals(dogWalker.getSenha())
        ).collect(toList());

        if(user == null)
        {
            user = (Tutor) tutorRepository.getList().stream()
                .filter( tutor ->
                        userDto.getEmail().equals(tutor.getEmail()) &&
                                userDto.getEmail().equals(tutor.getSenha())
            ).collect(toList());
        }

        return user;
    }
}
