package br.com.dogsteps.repositories;

import br.com.dogsteps.models.Agenda;
import br.com.dogsteps.models.Avaliacao;
import br.com.dogsteps.models.DogWalker;
import br.com.dogsteps.models.Endereco;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

public class DogWalkerDaoTest {

    private static DogWalkerRepository dogWalkers;

    @Before
    public void setUp(){
        dogWalkers = new DogWalkerRepository();
    }

    @Test
    public void add() {
        DogWalker dogWalker = dogwalkerAleatorio();
        String respostaEsperada = Response.status(Response.Status.OK).build().toString();

        assertEquals(respostaEsperada, dogWalkers.add(dogWalker).toString());

        String id = dogWalker.getId();
        assertEquals(id, dogWalkers.find(id).getId());

    }

    @Test
    public void update() {
        String idAleatorio = populaRepositorio(20);
        int novaIdade = -20;
        DogWalker dogWalkerASerAlterado = dogWalkers.find(idAleatorio);
        dogWalkerASerAlterado.setIdade(novaIdade);

        String respostaEsperada = Response.status(Response.Status.BAD_REQUEST).build().toString();

        assertEquals("não deverá alterar pois idade não é negativa",
                respostaEsperada, dogWalkers.update(dogWalkerASerAlterado).toString());


    }

    @Test
    public void remove() {
    }

    private String populaRepositorio(int elementosACriar){

        Random random = new Random();
        String idAleatorioLista = "";
        int indiceGerado = random.nextInt(elementosACriar);

        for(int i = 0 ; i < elementosACriar; i++){
            DogWalker dogWalker = dogwalkerAleatorio();
            dogWalkers.add(dogWalker);
            if(indiceGerado == i)
                idAleatorioLista = dogWalker.getId();
        }

        return idAleatorioLista;
    }

    private DogWalker dogwalkerAleatorio(){
        Random random = new Random();

        String[] nomes = {"Pedro", "Carla", "Maria", "Mercedes", "Tatiana", "Cintia", "Gustavo", "Flávia",
                            "Juliana", "Mateus"};

        int indiceGerado = random.nextInt(nomes.length);
        int idade = 18 + random.nextInt(100);

        return new DogWalker(nomes[indiceGerado], "photo", idade,
                "12345678910", "email@email.com", "asd123456", new Endereco()
                , new Agenda(), new ArrayList<Avaliacao>(), 0, "Gosto de cães");
    }
}