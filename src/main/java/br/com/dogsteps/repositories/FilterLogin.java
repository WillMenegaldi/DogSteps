package br.com.dogsteps.repositories;

import br.com.dogsteps.interfaces.IFilterLogin;
import br.com.dogsteps.interfaces.IRepository;
import br.com.dogsteps.models.DogWalker;
import br.com.dogsteps.models.Tutor;
import br.com.dogsteps.models.User;
import br.com.dogsteps.models.dto.DogWalkerDTO;
import br.com.dogsteps.models.dto.TutorDTO;
import br.com.dogsteps.models.dto.UserDto;

import java.util.List;

public class FilterLogin implements IFilterLogin<User, String, UserDto>
{
    private static IRepository<DogWalker, String, DogWalkerDTO> dogWalkerRepository = new DogWalkerRepository();
    private static IRepository<Tutor, String, TutorDTO> tutorRepository = new TutorRepository();

    @Override
    public List getListByFilter(Object o) {
        return null;
    }
}
