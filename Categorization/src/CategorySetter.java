import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by R00715649 on 28-Sep-16.
 * Esta clase tiene tiene un metodo que recibe un string devuelve el nombre de una categoria
 * Todos los regex deben ir aqui mismo
 */
public class CategorySetter {

    Map<String, List<Pattern>> categories = new HashMap<>();

    public CategorySetter(){
        //Crear los regexes y matchers y guardarlos en un diccionario de categorias

        //regexes para baterias
        Pattern battery0 = Pattern.compile("8507\\d+", Pattern.CASE_INSENSITIVE);
        Pattern battery1 =  Pattern.compile("baterias?", Pattern.CASE_INSENSITIVE);
        List<Pattern>patternsBatery = Arrays.asList(battery0, battery1);

        //licencias
        Pattern license0 = Pattern.compile("490700\\d+", Pattern.CASE_INSENSITIVE);
        Pattern license1 = Pattern.compile("852349\\d+", Pattern.CASE_INSENSITIVE);
        Pattern license2 = Pattern.compile("852351\\d+", Pattern.CASE_INSENSITIVE);
        List<Pattern>patternsLicense = Arrays.asList(license0, license1,license2);

        //cameras
        Pattern camera0 = Pattern.compile("852349\\d+", Pattern.CASE_INSENSITIVE);
        List<Pattern>patternsCamera = Arrays.asList(camera0);

        //decoders
        Pattern decoder0 = Pattern.compile("852871\\d+", Pattern.CASE_INSENSITIVE);
        List<Pattern>patternsDecoder = Arrays.asList(decoder0);

        //cabinets
        Pattern cabinet0 = Pattern.compile("8537\\d+", Pattern.CASE_INSENSITIVE);
        Pattern cabinet1 = Pattern.compile("8538\\d+", Pattern.CASE_INSENSITIVE);
        Pattern cabinet2 = Pattern.compile("940320\\d+", Pattern.CASE_INSENSITIVE);
        Pattern cabinet3 = Pattern.compile("gabinete\\s[de, para]", Pattern.CASE_INSENSITIVE);
        Pattern cabinet4 = Pattern.compile("rack\\s+[de, para, equipo]*", Pattern.CASE_INSENSITIVE);
        Pattern cabinet5 = Pattern.compile("rack\\s+[de, para, equipo]*", Pattern.CASE_INSENSITIVE);
        List<Pattern>patternsCabinet = Arrays.asList(cabinet0, cabinet1, cabinet2, cabinet3,
                cabinet4, cabinet5);


        //cable optical
        Pattern cableOpt0 = Pattern.compile("854470\\d+", Pattern.CASE_INSENSITIVE);
        List<Pattern>patternsCableOptical = Arrays.asList(cableOpt0);

        //cable other
        Pattern cable0 = Pattern.compile("854411\\d+", Pattern.CASE_INSENSITIVE);
        Pattern cable1 = Pattern.compile("854419\\d+", Pattern.CASE_INSENSITIVE);
        Pattern cable2 = Pattern.compile("854420\\d+", Pattern.CASE_INSENSITIVE);
        Pattern cable3 = Pattern.compile("854442\\d+", Pattern.CASE_INSENSITIVE);
        Pattern cable4 = Pattern.compile("854449\\d+", Pattern.CASE_INSENSITIVE);
        Pattern cable5 = Pattern.compile("854460\\d+", Pattern.CASE_INSENSITIVE);
        Pattern cable6 = Pattern.compile("cable", Pattern.CASE_INSENSITIVE);
        List<Pattern>patternsCable = Arrays.asList(cable0, cable1, cable2, cable3, cable4, cable5, cable6);

        //mobile phone
        Pattern cell0 = Pattern.compile("851712\\d+", Pattern.CASE_INSENSITIVE);
        List<Pattern>patternsCell = Arrays.asList(cell0);

        //sistemas de poder
        Pattern power0 = Pattern.compile("850440\\d+", Pattern.CASE_INSENSITIVE);
        Pattern power1 = Pattern.compile("sistema\\s+.+poder", Pattern.CASE_INSENSITIVE);
        Pattern power2 = Pattern.compile("rectificador", Pattern.CASE_INSENSITIVE);
        Pattern power3 = Pattern.compile("modulo\\s+.poder", Pattern.CASE_INSENSITIVE);
        List<Pattern>patternsPower = Arrays.asList(power0, power1, power2, power3);

        //estacion base
        Pattern baseStation0 = Pattern.compile("851761\\d+", Pattern.CASE_INSENSITIVE);
        Pattern baseStation1 = Pattern.compile("estacion\\w*\\sbase", Pattern.CASE_INSENSITIVE);
        Pattern baseStation2 = Pattern.compile("(BBU|RRU)", Pattern.CASE_INSENSITIVE);
        Pattern baseStation3 = Pattern.compile("banda\\s\\w*base", Pattern.CASE_INSENSITIVE);
        Pattern baseStation4 = Pattern.compile("radio\\s\\w*remota", Pattern.CASE_INSENSITIVE);
        List<Pattern>patternsDBS = Arrays.asList(baseStation0, baseStation1, baseStation2, baseStation3, baseStation4);

        //servidores
        Pattern server0 = Pattern.compile("servidor\\w*", Pattern.CASE_INSENSITIVE);
        Pattern server1 = Pattern.compile("server", Pattern.CASE_INSENSITIVE);
        Pattern server2 = Pattern.compile("storage", Pattern.CASE_INSENSITIVE);
        List<Pattern>patternsServers = Arrays.asList(server0, server1, server2);

        //Microondas
        Pattern micro0 = Pattern.compile("microonda", Pattern.CASE_INSENSITIVE);
        Pattern micro1 = Pattern.compile("microwave", Pattern.CASE_INSENSITIVE);
        Pattern micro2 = Pattern.compile("antenna", Pattern.CASE_INSENSITIVE);
        List<Pattern>patternsMicrowave = Arrays.asList(micro0, micro1, micro2);


        //crear diccionario de categorias y regexes
        categories.put("BATTERIES", patternsBatery);
        categories.put("LICENSE", patternsLicense);
        categories.put("CAMERA", patternsCamera);
        categories.put("DECODER", patternsDecoder);
        categories.put("CABINET", patternsCabinet);
        categories.put("CABLE OPTICAL", patternsCableOptical);
        categories.put("CABLE OTHER", patternsCable);
        categories.put("MOBILE PHONE", patternsCell);
        categories.put("POWER SYSTEM", patternsPower);
        categories.put("BASE STATION", patternsDBS);
        categories.put("SERVERS", patternsServers);
        categories.put("MICROWAVE", patternsMicrowave);

    }


    /*crear metodo para encontrar categoria que devuelva string
    la funcion debe recibir unn string con la description o partida arancelaria*/
    public String findCategory(String description){
        //por cada diccionario
        for (String k:categories.keySet()){
            //toma la lista de patrones respectiva
            List<Pattern> catList = categories.get(k);

            //por cada pattern en la lista, hace el test
            for (Pattern p:catList){
                Matcher m = p.matcher(description);
                if (m.find()){
                    return k;
                }
            }
        }
        return "OTHER PRODUCTS";
    }
}
