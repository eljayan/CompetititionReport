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
        Pattern license3 = Pattern.compile("(software|licencia)", Pattern.CASE_INSENSITIVE);
        List<Pattern>patternsLicense = Arrays.asList(license0, license1,license2, license3);

        //cameras
        Pattern camera0 = Pattern.compile("852580\\d+", Pattern.CASE_INSENSITIVE);
        Pattern camera1 = Pattern.compile("vigilancia\\w+", Pattern.CASE_INSENSITIVE);
        Pattern camera2 = Pattern.compile("c\\wmara\\w*[^(celular)]*]", Pattern.CASE_INSENSITIVE);
        Pattern camera3 = Pattern.compile("videoconf", Pattern.CASE_INSENSITIVE);
        List<Pattern>patternsCamera = Arrays.asList(camera0, camera1, camera2, camera3);

        //decoders
        Pattern decoder0 = Pattern.compile("852871\\d+", Pattern.CASE_INSENSITIVE);
        List<Pattern>patternsDecoder = Arrays.asList(decoder0);

        //cabinets
        Pattern cabinet0 = Pattern.compile("8537\\d+", Pattern.CASE_INSENSITIVE);
        Pattern cabinet1 = Pattern.compile("8538\\d+", Pattern.CASE_INSENSITIVE);
        Pattern cabinet2 = Pattern.compile("940320\\d+", Pattern.CASE_INSENSITIVE);
        Pattern cabinet3 = Pattern.compile("gabinete\\s[de, para]", Pattern.CASE_INSENSITIVE);
        Pattern cabinet4 = Pattern.compile("chasis\\s[de, para]", Pattern.CASE_INSENSITIVE);
        Pattern cabinet5 = Pattern.compile("rack\\s+[de, para, equipo]*", Pattern.CASE_INSENSITIVE);
        Pattern cabinet6 = Pattern.compile("rack\\s+[de, para, equipo]*", Pattern.CASE_INSENSITIVE);
        List<Pattern>patternsCabinet = Arrays.asList(cabinet0, cabinet1, cabinet2, cabinet3,
                cabinet4, cabinet5, cabinet6);


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
        //Pattern cable6 = Pattern.compile("[^optic]*\\s*cable.*[^optic]*", Pattern.CASE_INSENSITIVE);
        List<Pattern>patternsCable = Arrays.asList(cable0, cable1, cable2, cable3, cable4, cable5);

        //mobile phone
        Pattern cell0 = Pattern.compile("851712\\d+", Pattern.CASE_INSENSITIVE);
        List<Pattern>patternsCell = Arrays.asList(cell0);

        //tablet
        Pattern tablet0 = Pattern.compile("tablet\\w*", Pattern.CASE_INSENSITIVE);
        List<Pattern>patternsTablet = Arrays.asList(tablet0);

        //sistemas de poder
        Pattern power0 = Pattern.compile("850440\\d+", Pattern.CASE_INSENSITIVE);
        Pattern power1 = Pattern.compile("sistema\\w*.+poder", Pattern.CASE_INSENSITIVE);
        Pattern power2 = Pattern.compile("rectificador", Pattern.CASE_INSENSITIVE);
        Pattern power3 = Pattern.compile("modulo\\s+.poder", Pattern.CASE_INSENSITIVE);
        Pattern power4 = Pattern.compile("energ\\wa", Pattern.CASE_INSENSITIVE);
        Pattern power5 = Pattern.compile("el\\wctrico", Pattern.CASE_INSENSITIVE);
        Pattern power6 = Pattern.compile("generador", Pattern.CASE_INSENSITIVE);
        Pattern power7 = Pattern.compile("electrogeno", Pattern.CASE_INSENSITIVE);
        Pattern power8 = Pattern.compile("8502\\d+", Pattern.CASE_INSENSITIVE);
        List<Pattern>patternsPower = Arrays.asList(power0, power1, power2, power3, power4,
                power5, power6, power7, power8);

        //estacion base
        Pattern baseStation0 = Pattern.compile("851761\\d+", Pattern.CASE_INSENSITIVE);
        Pattern baseStation1 = Pattern.compile("estacion\\w*\\sbase", Pattern.CASE_INSENSITIVE);
        Pattern baseStation2 = Pattern.compile("(BBU|RRU)", Pattern.CASE_INSENSITIVE);
        Pattern baseStation3 = Pattern.compile("banda\\s\\w*base", Pattern.CASE_INSENSITIVE);
        Pattern baseStation4 = Pattern.compile("radio\\s\\w*remota", Pattern.CASE_INSENSITIVE);
        Pattern baseStation5 = Pattern.compile("radio\\sbase", Pattern.CASE_INSENSITIVE);
        List<Pattern>patternsDBS = Arrays.asList(baseStation0, baseStation1, baseStation2,
                baseStation3, baseStation4, baseStation5);

        //servidores
        Pattern server0 = Pattern.compile("servidor\\w*", Pattern.CASE_INSENSITIVE);
        Pattern server1 = Pattern.compile("server", Pattern.CASE_INSENSITIVE);
        Pattern server2 = Pattern.compile("storage", Pattern.CASE_INSENSITIVE);
        Pattern server3 = Pattern.compile("disco\\sduro", Pattern.CASE_INSENSITIVE);
        Pattern server4 = Pattern.compile("colector de datos", Pattern.CASE_INSENSITIVE);
        Pattern server5 = Pattern.compile("almacenamiento", Pattern.CASE_INSENSITIVE);
        Pattern server6 = Pattern.compile("8471500000", Pattern.CASE_INSENSITIVE);
        List<Pattern>patternsServers = Arrays.asList(server0, server1, server2, server3, server4,
                server5, server6);

        //Microondas
        Pattern micro0 = Pattern.compile("microonda", Pattern.CASE_INSENSITIVE);
        Pattern micro1 = Pattern.compile("microwave", Pattern.CASE_INSENSITIVE);
        Pattern micro2 = Pattern.compile("anten?na", Pattern.CASE_INSENSITIVE);
        Pattern micro3 = Pattern.compile("\\bodu\\b", Pattern.CASE_INSENSITIVE);
        Pattern micro4 = Pattern.compile("parabol", Pattern.CASE_INSENSITIVE);
        List<Pattern>patternsMicrowave = Arrays.asList(micro0, micro1, micro2, micro3, micro4);

        //switch and router
        Pattern router0 = Pattern.compile("equipo", Pattern.CASE_INSENSITIVE);
        Pattern router1 = Pattern.compile("tarjeta.*[^(celular)]", Pattern.CASE_INSENSITIVE);
        Pattern router2 = Pattern.compile("board", Pattern.CASE_INSENSITIVE);
        Pattern router3 = Pattern.compile("interf\\w+", Pattern.CASE_INSENSITIVE);
        Pattern router4 = Pattern.compile("transmisi\\w+", Pattern.CASE_INSENSITIVE);
        Pattern router5 = Pattern.compile("ruteador", Pattern.CASE_INSENSITIVE);
        Pattern router6 = Pattern.compile("conmut\\w+", Pattern.CASE_INSENSITIVE);
        Pattern router7 = Pattern.compile("electr\\wnic\\w+", Pattern.CASE_INSENSITIVE);
        Pattern router8 = Pattern.compile("s\\w+t\\w?ch", Pattern.CASE_INSENSITIVE);
        Pattern router9 = Pattern.compile("unidad\\s\\w+\\s+'*proces\\w+", Pattern.CASE_INSENSITIVE);
        Pattern router10 = Pattern.compile("sistema\\sde", Pattern.CASE_INSENSITIVE);
        Pattern router11 = Pattern.compile("modem", Pattern.CASE_INSENSITIVE);
        Pattern router12 = Pattern.compile("telec\\w+on", Pattern.CASE_INSENSITIVE);
        Pattern router13 = Pattern.compile("tr\\w+ns\\w+e\\w+r", Pattern.CASE_INSENSITIVE);
        Pattern router14 = Pattern.compile("multiplex", Pattern.CASE_INSENSITIVE);
        Pattern router15 = Pattern.compile("procesa", Pattern.CASE_INSENSITIVE);
        Pattern router16 = Pattern.compile("\\bLTE\\b", Pattern.CASE_INSENSITIVE);
        Pattern router17 = Pattern.compile("s\\wste\\w+\\sintegrado", Pattern.CASE_INSENSITIVE);
        Pattern router18 = Pattern.compile("router", Pattern.CASE_INSENSITIVE);
        Pattern router19 = Pattern.compile("modulo", Pattern.CASE_INSENSITIVE);
        Pattern router20 = Pattern.compile("aparato", Pattern.CASE_INSENSITIVE);
        Pattern router21 = Pattern.compile("unidad de", Pattern.CASE_INSENSITIVE);
        Pattern router22 = Pattern.compile("plexor", Pattern.CASE_INSENSITIVE);
        Pattern router23 = Pattern.compile("8517700000.*partes|kit", Pattern.CASE_INSENSITIVE);
        Pattern router24 = Pattern.compile("transmisor\\s", Pattern.CASE_INSENSITIVE);
        Pattern router25 = Pattern.compile("IMM\\s", Pattern.CASE_INSENSITIVE);
        Pattern router26 = Pattern.compile("enrutador", Pattern.CASE_INSENSITIVE);
        Pattern router27 = Pattern.compile("rf module", Pattern.CASE_INSENSITIVE);
        Pattern router28 = Pattern.compile("LNB DUAL", Pattern.CASE_INSENSITIVE);
        Pattern router29 = Pattern.compile("LNB DUAL", Pattern.CASE_INSENSITIVE);
        Pattern router30 = Pattern.compile("punto de enlace", Pattern.CASE_INSENSITIVE);
        Pattern router31 = Pattern.compile("controlador", Pattern.CASE_INSENSITIVE);
        Pattern router32 = Pattern.compile("cisco.+asr", Pattern.CASE_INSENSITIVE);

        List<Pattern>patternsRouter = Arrays.asList(router0, router1,router2, router3,
                router4, router5, router6, router7, router8, router9, router10, router11,
                router12, router13, router14, router15, router16, router17, router18,
                router19, router20, router21, router22, router23, router24, router25, router26,
                router27, router28, router29, router30, router31, router32);

        //crear diccionario de categorias y regexes
        categories.put("BATTERIES", patternsBatery);
        categories.put("LICENSE", patternsLicense);
        categories.put("CAMERA", patternsCamera);
        categories.put("DECODER", patternsDecoder);
        categories.put("CABINET", patternsCabinet);
        categories.put("CABLE OPTICAL", patternsCableOptical);
        categories.put("CABLE OTHER", patternsCable);
        categories.put("MOBILE PHONE", patternsCell);
        categories.put("TABLET", patternsTablet);
        categories.put("POWER SYSTEM", patternsPower);
        categories.put("BASE STATION", patternsDBS);
        categories.put("SERVERS", patternsServers);
        categories.put("MICROWAVE", patternsMicrowave);
        categories.put("SWITCHING AND ROUTING", patternsRouter);

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
//
//class testing{
//    public static void main(String[] args) {
//        CategorySetter categorySetter = new CategorySetter();
//        System.out.println(categorySetter.findCategory("servidores"));
//    }
//}