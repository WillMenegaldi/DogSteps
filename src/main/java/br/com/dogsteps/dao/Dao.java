package br.com.dogsteps.dao;

import br.com.dogsteps.interfaces.IDao;
import br.com.dogsteps.models.Tutor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Dao<T> implements IDao<T, String> {

    private static List<Tutor> tutores = new ArrayList<>();
    private File arquivo;
    private FileOutputStream fileOutputStream;
    private FileInputStream fileInputStream;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream inputFile;

    public Dao(String nomeArquivo) throws IOException {
        arquivo = new File(nomeArquivo);
        tutores = readFromFile();
    }

    @Override
    public List<T> getAll() {
        return readFromFile();
    }

    @Override
    public T get(String id) {
        return tutores.get(id);
    }

    @Override
    public boolean add(Tutor tutor) {
        tutores.add(tutor);
        return saveInFile();
    }

    @Override
    public boolean remove(String id) {
        Iterator<Tutor> iterator = tutores.iterator();
        while(iterator.hasNext()){
            if(iterator.next().getId().equals(id)){
                tutores.remove(id);
            }
        }
        return saveInFile();
    }

    @Override
    public boolean update(Tutor tutor) {
        Iterator<Tutor> iterator = tutores.iterator();
        while(iterator.hasNext()){
            if(iterator.next().getId().equals(tutor.getId())){
                tutores.add(tutores.indexOf(iterator.next()), tutor);
            }
        }
        return saveInFile();
    }

    private List<Tutor> readFromFile() {
        tutores = new ArrayList<>();
        try {
            fileInputStream = new FileInputStream(arquivo);
            inputFile = new ObjectInputStream(fileInputStream);
            while (fileInputStream.available() > 0) {
                Tutor tutor = (Tutor) inputFile.readObject();
                tutores.add(tutor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tutores;
    }

    private boolean saveInFile() {
        try {
            close();
            fileOutputStream = new FileOutputStream(arquivo, false);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for (Tutor tutor : tutores) {
                objectOutputStream.writeObject(tutor);
            }
            objectOutputStream.flush();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao salvar no arquivo!");
            e.printStackTrace();
        }
        return false;
    }

    private void close() throws IOException {
        if (objectOutputStream != null) {
            objectOutputStream.close();
            fileOutputStream.close();
            objectOutputStream = null;
            fileOutputStream = null;
        }
    }
}
