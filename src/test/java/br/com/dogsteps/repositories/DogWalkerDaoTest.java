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
    static String statusBADREQUEST = Response.status(Response.Status.BAD_REQUEST).build().toString();
    static String statusOK = Response.status(Response.Status.OK).build().toString();
    static String statusNOTFOUND = Response.status(Response.Status.NOT_FOUND).build().toString();

    @Before
    public void setUp(){
        dogWalkers = new DogWalkerRepository();
    }

    @Test
    public void add() {
        DogWalker dogWalker = dogwalkerAleatorio();

        assertEquals(statusOK, dogWalkers.add(dogWalker).toString());
        String id = dogWalker.getId();
        assertEquals(id, dogWalkers.find(id).getId());

    }

    @Test
    public void update() {
        String idAleatorio = populaRepositorio(20);

        DogWalker dogWalkerASerAlterado = dogWalkers.find(idAleatorio);

        dogWalkerASerAlterado.setNome("");
        testHelper(dogWalkerASerAlterado,"qualquer string vazia deve ser responder com BAD_REQUEST",
                statusBADREQUEST, dogWalkers.update(dogWalkerASerAlterado));

        dogWalkerASerAlterado.setIdade(-20);
        testHelper(dogWalkerASerAlterado,"idade negativa deve ser responder com BAD_REQUEST",
                statusBADREQUEST, dogWalkers.update(dogWalkerASerAlterado));

        dogWalkerASerAlterado.setAgenda(null);
        testHelper(dogWalkerASerAlterado,"referencia null deve ser rejeitada com BAD_REQUEST ",
                statusBADREQUEST, dogWalkers.update(dogWalkerASerAlterado));

        dogWalkerASerAlterado.setIdade(17);
        testHelper(dogWalkerASerAlterado,"dogwalkers menores de idade são rejeitados com BAD_REQUEST ",
                statusBADREQUEST, dogWalkers.update(dogWalkerASerAlterado));

        //Teste com Valor válido
        dogWalkerASerAlterado.setEmail("asdweqweew");
        assertEquals(statusOK, dogWalkers.update(dogWalkerASerAlterado).toString());
    }

    @Test
    public void remove() {

        String id = populaRepositorio(20);
        assertEquals("dogwalker não encontrado recebe NOTFOUND",
                statusNOTFOUND, dogWalkers.remove("3232323dsad").toString());

        assertEquals("dogwalker encontrado recebe OK",
                statusOK,dogWalkers.remove(id).toString());

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

    private void dogwalkerDefault(DogWalker dogWalker){
        dogWalker.setNome("Bob");
        dogWalker.setIdade(26);
        dogWalker.setAgenda(new Agenda());
    }

    private void testHelper(DogWalker dogWalker, String mensagem, String esperado, Response response){
        assertEquals(mensagem, esperado,response.toString());
        dogwalkerDefault(dogWalker);
    }
}