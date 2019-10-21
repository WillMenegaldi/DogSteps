package br.com.dogsteps.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.dogsteps.interfaces.IDAO;
import br.com.dogsteps.models.Tour;

public class TourDAO implements IDAO<Tour, Integer> {

    private static List<Tour> tours = new ArrayList<>();
    private File file;
    private FileOutputStream fileOutputStream;
    private FileInputStream fileInputStream;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream inputFile;

    public TourDAO(String filename) throws IOException {
        file = new File(filename);
        tours = readFromFile();
    }

    @Override
    public List<Tour> getAll() {
        return readFromFile();
    }

    @Override
    public Tour get(Integer id) {
        return tours.get(id);
    }

    @Override
    public boolean add(Tour tour) {
        tours.add(tour);
        return saveInFile();
    }

    @Override
    public boolean remove(Integer id) {
        Iterator<Tour> iterator = tours.iterator();
        while(iterator.hasNext()){
            if(iterator.next().getId().equals(id)){
                tours.remove(id);
            }
        }
        return saveInFile();
    }

    @Override
    public boolean update(Tour tour) {
        Iterator<Tour> iterator = tours.iterator();
        while(iterator.hasNext()){
            if(iterator.next().getId().equals(tour.getId())){
                tours.add(tours.indexOf(iterator.next()), tour);
            }
        }
        return saveInFile();
    }

    private List<Tour> readFromFile() {
        tours = new ArrayList<>();
        try {
            fileInputStream = new FileInputStream(file);
            inputFile = new ObjectInputStream(fileInputStream);
            while (fileInputStream.available() > 0) {
                Tour tour = (Tour) inputFile.readObject();
                tours.add(tour);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tours;
    }

    private boolean saveInFile() {
        try {
            close();
            fileOutputStream = new FileOutputStream(file, false);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for (Tour tour : tours) {
                objectOutputStream.writeObject(tour);
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
