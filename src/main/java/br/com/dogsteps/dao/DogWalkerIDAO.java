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
import br.com.dogsteps.models.DogWalker;

public class DogWalkerIDAO implements IDAO<DogWalker, Integer> {

	private static List<DogWalker> dogWalkers = new ArrayList<DogWalker>();
	private File file;
	private FileOutputStream fileOutputStream;
	private FileInputStream fileInputStream;
	private ObjectOutputStream objectOutputStream;
	private ObjectInputStream inputFile;

	public DogWalkerIDAO(String filename) {
		file = new File(filename);
		dogWalkers = readFromFile();
	}

	public DogWalker get(Integer id) {
		return dogWalkers.get(id);
	}

	
	public boolean add(DogWalker dogwalker) {
		dogWalkers.add(dogwalker);
		return saveInFile();
	}

	
	public boolean remove(String cpf) {
	      Iterator<DogWalker> iterator = dogWalkers.iterator();
	        while(iterator.hasNext()){
	            if(iterator.next().getCpf().equals(cpf)){
	                dogWalkers.remove(cpf);
	            }
	        }
	        return saveInFile();
	}

	
	public boolean update(DogWalker dogWalker) {
		 Iterator<DogWalker> iterator = dogWalkers.iterator();
	        while(iterator.hasNext()){
	            if(iterator.next().getCpf().equals(dogWalker.getCpf())){
	                dogWalkers.add(dogWalkers.indexOf(iterator.next()), dogWalker);
	            }
	        }
	        return saveInFile();
	}

	
	public List<DogWalker> getAll() {
		return readFromFile();
	}

	// File Functions

	private List<DogWalker> readFromFile() {
		dogWalkers = new ArrayList<DogWalker>();
		try {
			fileInputStream = new FileInputStream(file);
			inputFile = new ObjectInputStream(fileInputStream);
			while (fileInputStream.available() > 0) {
				DogWalker dogWalker = (DogWalker) inputFile.readObject();
				dogWalkers.add(dogWalker);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dogWalkers;
	}
	
	private boolean saveInFile() {
        try {
            close();
            fileOutputStream = new FileOutputStream(file, false);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for (DogWalker dogWalker : dogWalkers) {
                objectOutputStream.writeObject(dogWalker);
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

	public boolean remove(Integer k) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
