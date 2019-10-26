package br.com.dogsteps.repositories;

import br.com.dogsteps.enums.EPort;
import br.com.dogsteps.enums.ESex;
import br.com.dogsteps.models.Avaliacao;
import br.com.dogsteps.models.Pet;
import br.com.dogsteps.models.Tutor;
import br.com.dogsteps.repositories.PetRepository;

import org.junit.Before;
import org.junit.Test;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Random;
import static org.junit.Assert.assertEquals;

public class PetDaoTest {

    private static PetRepository pets;

    @Before
    public void setUp() {
        pets = new PetRepository();
    }

    @Test
    public void add() {
        Pet pet = new Pet("Billy", 4, "fotos", "YorkShire", ESex.MALE, EPort.MINI,
                new ArrayList<Avaliacao>(), 0, new Tutor());
        pets.add(pet);
        String id = pet.getId();
        Pet petAdicionado = pets.find(id);
        assertEquals("se for inserido na lista o id deve ser o mesmo", id, petAdicionado.getId());
    }

    @Test
    public void remove() {
        String id = populaDao(20);
        String respostaEsperada = Response.status((Response.Status.OK)).build().toString();
        assertEquals(respostaEsperada, pets.remove(id).toString());
    }

    @Test
    public void update() {
        String idPetAleatorio = populaDao(20);
        String novoNome = "Bob";
        String respostaEsperada = Response.status((Response.Status.OK)).build().toString();
        Pet petASerAlterado = pets.find(idPetAleatorio);

        petASerAlterado.setName(novoNome);
        assertEquals(respostaEsperada, pets.update(petASerAlterado).toString());
        assertEquals(novoNome, pets.find(idPetAleatorio).getName());
    }

    private String populaDao(int elementosACriar) {
        Random random = new Random();
        String idAleatorioLista = "";
        int indiceGerado = random.nextInt(elementosACriar);

        for (int i = 0; i < elementosACriar; i++) {
            Pet pet = petAleatorio();
            pets.add(pet);
            if (indiceGerado == i)
                idAleatorioLista = pet.getId();
        }

        return idAleatorioLista;
    }

    private Pet petAleatorio() {
        Random random = new Random();
        String[] nomes = {"Billy", "Lindinha", "Sofia", "Fafa", "Bethoven", "Pretinha", "Scooby", "Toto",
                "Pepe", "Bradock"};
        String[] racas = {"Bulldog", "Yorkshire", "Dalmata", "SRD", "New Hampshire", "Beagle", "Chihuahua",
                "Poodle", "Labrador", "Golden Retriever"};

        int indice = random.nextInt(10) % 10;
        int idade = (random.nextInt(12) + 1);

        return new Pet(nomes[indice], idade, "fotos",
                racas[indice], ESex.MALE, EPort.MINI,
                new ArrayList<Avaliacao>(), 0, new Tutor());
    }

}