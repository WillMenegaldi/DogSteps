package br.com.dogsteps.repositories;

import br.com.dogsteps.enums.ETourStatus;
import br.com.dogsteps.models.DogWalker;
import br.com.dogsteps.models.Passeio;
import br.com.dogsteps.models.Pet;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;


import static org.junit.Assert.assertEquals;

public class PasseioDaoTest {

    PasseioRepository passeios;
    static String statusBADREQUEST = Response.status(Response.Status.BAD_REQUEST).build().toString();
    static String statusOK = Response.status(Response.Status.OK).build().toString();
    static String statusNOTFOUND = Response.status(Response.Status.NOT_FOUND).build().toString();

    @Before
    public void setUp() {
        passeios = new PasseioRepository();
    }

    @Test
    public void find() {
        String id = populaPasseio(32);
        assertEquals("passeio não encontrado deve ser null",
                null, passeios.find("32313233"));
        assertEquals("esse passeio deve ser encontrado",
                id, passeios.find(id).getId());
    }

    @Test
    public void add() {
        Passeio passeio = geraPasseio(0);
        assertEquals("deve ser negada referencia nula", statusBADREQUEST,
                passeios.add(null).toString());

        passeio.setDuracao(-3232);
        assertEquals("deve ser negado passeio com duracao negativa", statusBADREQUEST,
                passeios.add(passeio).toString());

        passeio = geraPasseio(0);
        LocalDate anteontem = LocalDate.now().minusDays(2);
        passeio.setData(anteontem);

        assertEquals("deve ser negada alteração de data antes da data atual",
                statusBADREQUEST, passeios.add(passeio).toString());

        passeio = geraPasseio(1);
        assertEquals("adicionando passeio válido", statusOK,
                passeios.add(passeio).toString());
    }

    @Test
    public void update() {
        String id = populaPasseio(30);
        Passeio passeio = passeios.find(id);

        passeio.setData(LocalDate.now().plusDays(3));

        assertEquals("Alterando a data do passeio", statusOK,
                passeios.update(passeio).toString());
        passeio.setStatus(ETourStatus.ONGOING);
        assertEquals("alterando a status ", statusOK,
                passeios.update(passeio).toString());
    }

    @Test
    public void remove() {
    }

    private String populaPasseio(int tamanho) {
        Random random = new Random();
        int indiceGerado = random.nextInt(tamanho);
        String idAleatorio = "";

        for (int i = 0; i < tamanho; i++) {
            Passeio passeio = geraPasseio(random.nextInt(50));
            passeios.add(passeio);
            if (i == indiceGerado) {
                idAleatorio = passeio.getId();
            }
        }

        return idAleatorio;
    }

    private Passeio geraPasseio(int diaAFrente) {
        return new Passeio(LocalDate.now().plusDays(diaAFrente), ETourStatus.PENDING, 1,
                new ArrayList<Pet>(), new DogWalker());
    }
}