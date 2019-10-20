package br.com.dogsteps;

import br.com.dogsteps.enums.EFisicStatus;
import br.com.dogsteps.enums.EMood;
import br.com.dogsteps.enums.EPort;
import br.com.dogsteps.enums.ESex;
import br.com.dogsteps.exceptions.NegativeValueException;
import br.com.dogsteps.models.*;

import org.junit.Assert;
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
    void testSetFeatures() {
        EPort portExpected = EPort.BIG;
        EMood moodExpected = EMood.AGRESSIVE;
        EFisicStatus fisicExpected = EFisicStatus.EXCEPTIONAL;

        pet.setFeature(new Feature(EPort.BIG,EMood.AGRESSIVE,EFisicStatus.EXCEPTIONAL));

        Assert.assertEquals("changing dog port", portExpected, pet.getFeature().getPort());
        Assert.assertEquals("changing dog mood", moodExpected, pet.getFeature().getMood());
        Assert.assertEquals("changing dog fisic status", fisicExpected, pet.getFeature().getFisicStatus());

    }

    @Test
    void testAddRating() {
        Rating score = new Rating( -4, "good");

        Assert.assertTrue("default rating is empty", pet.getRatings().isEmpty());

        try {
            pet.addRating(null);
            pet.addRating(score);
        }
        catch (NegativeValueException e){/*testing a negative value*/}
        catch (IllegalArgumentException e){/*testing a null reference*/}

        pet.addRating(new Rating(4,""));
        Assert.assertEquals("adding new score", 4, pet.getRatings().get(0).getAvaliation());

        pet.clearRating();
    }

    @Test
    void testSetMedianScore() {
        Rating score = new Rating( 4, "good");
        Rating score2 = new Rating(2, "fair");
        Rating score3 = new Rating(5, "");

        pet.addRating(score);

        pet.addRating(score2);

        Assert.assertEquals(3, pet.getMedianScore(), 0.1);

        pet.addRating(score3);

        Assert.assertEquals(3.6, pet.getMedianScore(), 0.1);
    }

    @Test
    void testSetTutor() {
        Tutor tutorExpected = new Tutor("64540987","blah.test",new Adress("Stest","12",
        "dist", "32332-231", "test"),"323233","Test", "https://google.com",
                23, "I like dogs!");

        pet.setTutor(tutorExpected);

        Assert.assertEquals("changing a tutor ", tutorExpected, pet.getTutor());
    }

}
