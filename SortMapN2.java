package sortMap;

import java.util.*;

public class SortMapN2 {

    public <K,V extends Comparable<V>> Map<K, V> sortMap(Map<K,V> map){

        ArrayList<K> keys;
        ArrayList<V> values;

        keys = extractKeys(map);

        values = extractValues(map);

        sortValues(values);

        Map<K,V> sortedMap = new LinkedHashMap<>();

        for (int i=0; i<values.size(); i++){
            for (int j=0; j<keys.size(); j++){
                if(values.get(i)==map.get(keys.get(j))){
                    sortedMap.put(keys.get(j), values.get(i));
                    keys.remove(j);
                    break;
                }
            }
        }


        return sortedMap;
    }

    private <K, V extends Comparable<V>> ArrayList<V> extractValues(Map<K,V> map) {
        return new ArrayList<>(map.values());
    }

    private <K, V extends Comparable<V>> ArrayList<K> extractKeys(Map<K,V> map) {
        return new ArrayList<>(map.keySet());
    }

    private <V extends Comparable<V>> void sortValues(ArrayList<V> values) {
        Collections.sort(values);
    }

    public static void main(String[] args) {
        SortMapN2 sortMap = new SortMapN2();

        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(1,"veneet");
        hm.put(2,"ankush");
        hm.put(3,"qwerty");
        hm.put(4,"christopher");
        hm.put(5,"quentin");
        hm.put(6,"david");

        System.out.println(hm);

        System.out.println(sortMap.sortMap(hm));
    }

}
