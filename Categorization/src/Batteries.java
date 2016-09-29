//
//import java.util.Arrays;
//import java.util.List;
//import java.util.regex.Pattern;
//
///**
// * Created by R00715649 on 27-Sep-16.
// */
//public class Batteries {
//    String productCategory = "BATTERIES";
//
//    //I create the patterns
//    Pattern battery0 = Pattern.compile("baterias?", Pattern.CASE_INSENSITIVE);
//
//    //then put them on a list
//    List<Pattern> patternList = Arrays.asList(battery0);
//
//
//    //then test the list with a string
//    boolean matchTest (String line){
//        for (Pattern p:patternList){
//            if (p.matcher(line).find()){
//                return true;
//            }
//        }
//        return false;
//    }
//
//}
//
//class Test{
//    public static void main(String[] args) {
//        Batteries b = new Batteries();
//
//        if (b.matchTest("esto es un monobloque de energia")) {
//            System.out.println(b.productCategory);
//        }else{
//            System.out.println("No se encontro ni verga");
//        }
//
//    }
//}