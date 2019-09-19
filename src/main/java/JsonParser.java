
import org.json.*;

import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class JsonParser {
    public static void main(String[] args) throws FileNotFoundException {
        getListOfAtoms();
    }

    public static List<Atom> getListOfAtoms() throws FileNotFoundException {

        InputStream is = new FileInputStream("C:\\Users\\Zstudent\\Temp\\codeKata1709\\src\\main\\resources\\PeriodicTableJSON.json");

        JSONTokener tokener = new JSONTokener(is);
        JSONObject root = new JSONObject(tokener);

        List<Atom> result = new ArrayList<>();
        Object o = root.get("elements");
        JSONArray j = (JSONArray) o ;
        JSONObject jo = (JSONObject) j.get(0);



        Stream.of(j)
                .flatMap(a -> a.getDouble("atomic_mass"))
                .

        System.out.println(jo.getDouble("atomic_mass"));
        System.out.println(root.get("elements"));


        return null;
    }
}
