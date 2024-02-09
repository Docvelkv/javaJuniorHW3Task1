import objects.Magister;
import objects.Student;
import saveAndLoad.Externalisation;
import saveAndLoad.JacksonAPI;
import saveAndLoad.RegularSerialization;

public class Main {
    public static void main(String[] args) {
        Student std1 = new Student("Иван", 21, 4.6);
        Magister mgs1 = new Magister("Пётр", 23, 4.4);

        RegularSerialization.saving(std1, "src/main/resources/reg_ser.txt");
        Externalisation.saving(mgs1, "src/main/resources/ext_ser.txt");
        JacksonAPI.saving(std1, "src/main/resources/stdJackson_ser.json");
        JacksonAPI.saving(mgs1, "src/main/resources/mgsJackson_ser.json");
        JacksonAPI.saving(mgs1, "src/main/resources/mgsJackson_ser.xml");
        JacksonAPI.saving(mgs1, "src/main/resources/mgsJackson_ser.yaml");

        System.out.println(std1);
        System.out.println("*****Standard*****");
        System.out.print(RegularSerialization.loading("src/main/resources/reg_ser.txt"));
        System.out.println(" - стандартная десериализация");
        System.out.println(mgs1);
        System.out.println("*****Externalise*****");
        System.out.print(Externalisation.loading("src/main/resources/ext_ser.txt"));
        System.out.println(" - пользовательская стандартная десериализация");
        System.out.println("*****JacksonAPI*****");
        System.out.print(JacksonAPI.loading("src/main/resources/stdJackson_ser.json", Student.class));
        System.out.println(" - десериализация с помощью JacksonAPI из json");
        System.out.print(JacksonAPI.loading("src/main/resources/mgsJackson_ser.json", Magister.class));
        System.out.println(" - десериализация с помощью JacksonAPI из json");
        System.out.print(JacksonAPI.loading("src/main/resources/mgsJackson_ser.xml", Magister.class));
        System.out.println(" - десериализация с помощью JacksonAPI из xml");
        System.out.print(JacksonAPI.loading("src/main/resources/mgsJackson_ser.yaml", Magister.class));
        System.out.println(" - десериализация с помощью JacksonAPI из yaml");
    }
}
