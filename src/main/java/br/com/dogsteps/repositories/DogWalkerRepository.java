package br.com.dogsteps.repositories;

import br.com.dogsteps.dao.Dao;
import br.com.dogsteps.interfaces.IFilterLogin;
import br.com.dogsteps.interfaces.IRepositoryDao;
import br.com.dogsteps.models.User;
import br.com.dogsteps.models.dto.DogWalkerDto;
import br.com.dogsteps.excecoes.*;
import br.com.dogsteps.interfaces.IDao;
import br.com.dogsteps.models.DogWalker;
import br.com.dogsteps.models.dto.UserDto;
import br.com.dogsteps.utils.Login;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class DogWalkerRepository implements IRepositoryDao<DogWalker, String, DogWalkerDto> {

    private static final String FILE_NAME = "database/dogwalker.bin";
    private final IDao<DogWalker, String> DOGWALKER_DAO = inicializarDao();
    private static final IFilterLogin filterLogin = new Login();

    public User filtrarDogWalker(UserDto userDto)
    {
        return filterLogin.filtrarUsuario(userDto);
    }

    public Dao inicializarDao() {
        try {
            return new Dao(FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<DogWalker> getList() {
        return DOGWALKER_DAO.getAll();
    }

    public DogWalker find(String id) {
        return (DogWalker) DOGWALKER_DAO.get(id);
    }

    public Response add(DogWalker dogWalker) {
        try {
            validarRequisicao(dogWalker);
            if (DOGWALKER_DAO.add(dogWalker))
                return Response.status(Status.OK).build();
            else
                return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        } catch (ValorNegativoException | StringVaziaException | MenorIdadeException |
                AgendaNullException | EmailInvalidoException e) {
            return Response.status(Status.BAD_REQUEST).build();
        }

    }

    public Response update(DogWalker dogWalker) {
        try {
            validarRequisicao(dogWalker);
            if (DOGWALKER_DAO.update(dogWalker))
                return Response.status(Status.OK).build();
            else
                return Response.status(Status.NOT_FOUND).build();
        } catch (ValorNegativoException | StringVaziaException
                | MenorIdadeException | AgendaNullException | EmailInvalidoException |
                NullPointerException e) {
            return Response.status(Status.BAD_REQUEST).build();
        }
    }

    public Response remove(String id) {
        if (id != null) {
            if (!(id.isEmpty())) {
                if (DOGWALKER_DAO.remove(id))
                    return Response.status(Status.OK).build();
                else
                    return Response.status(Status.NOT_FOUND).build();
            }
        }
        return Response.status(Status.BAD_REQUEST).build();

    }

    @Override
    public List<DogWalker> getListByFilter(DogWalkerDto dogWalkerDTO ) {
        if (dogWalkerDTO.getPorte() == null && dogWalkerDTO.getEndereco() == null)
            return getList();

        if (dogWalkerDTO.getPorte() == null && dogWalkerDTO.getEndereco() == null){
            return getList();
        }
        if(dogWalkerDTO.getCoordenadas() != null){
            return getList().stream()
                    .filter( dogWalker ->
                                    dogWalker.estaDentroDoPoligono(dogWalkerDTO.getCoordenadas())
                    ).collect(toList());

        }

//        if (dogWalkerDTO.getPorte() != null && !dogWalkerDTO.getEndereco().isEmpty() &&
//                dogWalkerDTO.getAgenda().getHorario() != null && dogWalkerDTO.getAgenda().getDias() != null && dogWalkerDTO.getCoordenadas() != null)
//            return getList().stream()
//                    .filter( dogWalker ->
//                            dogWalker.getPreferencias().getPorte().equals(dogWalkerDTO.getPorte()) &&
//                            dogWalker.getEndereco().getRua().equals(dogWalkerDTO.getEndereco()) &&
//                            dogWalker.getAgenda().getDias().equals(dogWalkerDTO.getAgenda().getDias()) &&
//                            dogWalker.getAgenda().getHorario().equals(dogWalkerDTO.getAgenda().getHorario()) &&
//                            dogWalker.estaDentroDoPoligono(dogWalkerDTO.getCoordenadas())
//                    ).collect(toList());

        return getList().stream().
                filter( dogWalker ->
                        dogWalker.getEndereco().getRua().equals(dogWalkerDTO.getEndereco()) ||
                                dogWalker.getPreferencias().getPorte().equals(dogWalkerDTO.getPorte())
                ).collect(toList());
    }

    public void validarRequisicao(DogWalker dogWalker)
            throws ValorNegativoException, StringVaziaException,
            MenorIdadeException, EmailInvalidoException {

        System.out.println(dogWalker);

        if ( dogWalker.getIdade() <= 0 )
			throw new ValorNegativoException();

        if (dogWalker.getIdade() < 18)
            throw new MenorIdadeException();

        if (dogWalker.getCpf().isEmpty() || dogWalker.getNome().isEmpty()
                || dogWalker.getSenha().isEmpty() || dogWalker.getEmail().isEmpty() )
            throw new StringVaziaException();

        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

        if (! (dogWalker.getEmail().matches(regex) ))
            throw new EmailInvalidoException();
    }
}
