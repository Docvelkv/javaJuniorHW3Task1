package saveAndLoad;

import java.io.*;

public class Externalisation {
    public static void saving(Object obj, String fileName){
        try(FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(obj);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static Object loading(String fileName){
        Object obj = null;
        try(FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis)){
            obj = ois.readObject();
        }catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        return obj;
    }
}
