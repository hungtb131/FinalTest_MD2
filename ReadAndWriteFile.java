package Data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile<E> {
    
    public void writeFile(String PATH, List<E> list) {
        
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(PATH);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public List<E> readFile(String PATH) {
        List<E> list = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream("contact.csv");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            list = (List<E>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
