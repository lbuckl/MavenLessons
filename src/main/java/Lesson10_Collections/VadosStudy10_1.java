package Lesson10_Collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class VadosStudy10_1 {
    public static void main(String[] args) {

        String words[] = {"one","two","one","three","four","four","five","eight","six","one",
                "one","three","eight","six","one",};//15
        for (String e:words) {
            System.out.print(e+" ");
        }
        System.out.println();

        //Собираем уникальные коллекции
        Set<String> uniqueHash = new HashSet<>();
        Set<String> uniqueTree = new TreeSet<>();
        System.out.println("Уникальные слова: ");
        for (String e:words) {
            uniqueHash.add(e);
            uniqueTree.add(e);
        }
        System.out.println(uniqueHash);
        System.out.println(uniqueTree);
        System.out.println();

        //Не дадими зря пропасть коллекции выше.
        //По ней и будем считать сколько раз в массиве встречается каждое слово

        Iterator<String> iter = uniqueTree.iterator();
        while (iter.hasNext()){
            int count = 0;
            String str = iter.next();

            for (String e:words) {
                if (str.equals(e)){
                    count++;
                }
            }
            System.out.println(str + " встречается " + count + " раз(а)");
        }
    }
}
