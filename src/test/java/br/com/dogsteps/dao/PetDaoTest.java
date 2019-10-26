package br.com.dogsteps.dao;

import br.com.dogsteps.enums.EPort;
import br.com.dogsteps.enums.ESex;
import br.com.dogsteps.models.Avaliacao;
import br.com.dogsteps.models.Pet;
import br.com.dogsteps.models.Tutor;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PetDaoTest {

    Dao<Pet> pets;

    @Before
    public void setUp() throws Exception {
        pets = new Dao<Pet>("pets.bin");
    }

    @Test
    public void add() {
        Pet pet = new Pet("Billy", 4, "", "YorkShire", ESex.MALE, EPort.MINI,
                new ArrayList<Avaliacao>(), 0, new Tutor());

        String id = pet.getId();

        pets.add(pet);

        assertEquals(pet , pets.get(id));
        
    }

    @Test
    public void remove() {
    }

    @Test
    public void update() {
    }
}