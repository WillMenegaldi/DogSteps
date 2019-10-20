package br.com.dogsteps;

import br.com.dogsteps.enums.EFisicStatus;
import br.com.dogsteps.enums.EMood;
import br.com.dogsteps.enums.EPort;
import br.com.dogsteps.enums.ESex;
import br.com.dogsteps.models.Adress;
import br.com.dogsteps.models.Feature;
import br.com.dogsteps.models.Pet;
import br.com.dogsteps.models.Tutor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class PetTest{

    public static Pet pet;
    public static Tutor tutor;

    @BeforeEach
    void setUp() {
        tutor = new Tutor("12345678901", "test@test.com", new Adress("a", "12","test",
                "12323-32","test"), "123676", "test",
                "https://test.com", 30, "no description");
        pet = new Pet(tutor,new Feature(EPort.SMALLER, EMood.CALM, EFisicStatus.GOOD), "dog",
                "https://test.com","very Smart", 4, ESex.MALE);
    }

    @Test
    void testGetSex() {

    }

    void testGetFeatures() {
    }

    void testSetFeatures() {
    }

    void testGetRatings() {
    }

    void testAddRating() {
    }

    void testGetMedianScore() {
    }

    void testSetMedianScore() {
    }

    void testGetTutor() {
    }

    void testSetTutor() {
    }

    void testGetFeature() {
    }

    void testSetFeature() {
    }

    void testGetPort() {
    }
}
