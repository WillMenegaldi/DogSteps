package br.com.dogsteps.dao;

import br.com.dogsteps.interfaces.DAO;
import br.com.dogsteps.models.Tour;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TourDAO implements DAO<Tour, Integer> {

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
        tours.remove(id);
        return saveInFile();
    }

    @Override
    public boolean update(Tour tour, Integer id) {
        tours.add(id, tour);
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
            return null;
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
            System.out.println("ERRO ao gravar produto no disco!");
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
