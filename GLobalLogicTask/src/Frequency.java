import java.util.*;
import java.util.stream.Collectors;
public class Frequency {


    public static void count(String toCountIn, String toBeCounted){
        Map<Map<Integer, Set<Character>>, Integer> map = new LinkedHashMap<>();
        Map<Map<Integer, Set<Character>>, Integer> map2 = new LinkedHashMap<>();
        List<Map<Integer, Set<Character>>> list = new ArrayList<>();
        String[] words = toCountIn.trim().split("\\s+");

        int totalLetters = 0;
        for (char a : toCountIn.toLowerCase(Locale.ROOT).toCharArray()) {
            if (a >= 'a' && a <= 'z')
                totalLetters++;
        }

        Set<Character> charset = new LinkedHashSet<>();
        for (char c : toBeCounted.toLowerCase(Locale.ROOT).toCharArray()) {
            charset.add(c);
        }

        int counterWord;
        int counterAll = 0;


        for (String word : words){
            Set<Character> foundChars = new LinkedHashSet<>();
            char[] charsInWord = word.toLowerCase(Locale.ROOT).toCharArray();
            counterWord = 0;
            for (char c : charset){
                for (char d : charsInWord){
                    if (d >= 'a' && d <= 'z'){
                        if(c==d){
                            foundChars.add(c);
                            counterAll++;
                            counterWord++;
                        }
                    }
                }
            }


            Map<Integer, Set<Character>> helperMap = new HashMap<>();
            helperMap.put(word.length(), foundChars);
            if (map.containsKey(helperMap)){
                counterWord = map.get(helperMap) + counterWord;
            }
            map.put(helperMap, counterWord);
            list.add(helperMap);

            list.sort((o1, o2) -> {
                if (o1.keySet() == o2.keySet()) {
                    if (o1.get(o1.keySet()).size() < o2.get(o2.keySet()).size()) {
                        return 1;
                    } else return -1;
                }
                if ((Integer) o1.keySet().toArray()[0] >
                        (Integer) (o2.keySet().toArray()[0]))
                    return 1;
                else return -1;
            });





        }
        for (Map<Integer, Set<Character>> m : list){
            map2.put(m, map.get(m));
        }

        for (Map key : map2.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new))
                .keySet()){

            System.out.print("{(");
            boolean first = false;
            float freq;
            for (char c : (Set<Character>) key.get(key.keySet().toArray()[0])) {
                if (first){
                System.out.print(" ,");
                }
                first = true;
                System.out.print(c);
            }
            freq = (float) map2.get(key) / counterAll;
            System.out.print("), " + key.keySet().toArray()[0] + "} = ");
            System.out.printf("%.2f ", freq);
            System.out.println("(" + map2.get(key) + "/" + counterAll + ")");
        }
        float totFreqency = (float) counterAll / totalLetters;
        System.out.print("TOTAL Frequency: ");
        System.out.printf("%.2f ", totFreqency);
        System.out.print("(" + counterAll + "/" + totalLetters + ")");


    }
}
