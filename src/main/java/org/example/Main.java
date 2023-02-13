package org.example;
import java.io.File;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
        public static void main(String[] args) throws Exception {
            Logger l = Logger.getLogger("kitty");
            String f = "C:\\frquency\\textfile.txt";
            Scanner sc = new Scanner(new File(f));
            String data = sc.nextLine();
            String[] arr = data.split(" ");
            static final HashMap<String, Integer> hMap = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                if (hMap.containsKey(arr[i])) {
                    int count = hMap.get(arr[i]);
                    hMap.put(arr[i], count + 1);
                } else {
                    hMap.put(arr[i], 1);
                }
            }
            l.log(Level.INFO,() ->" "+hMap);
            PriorityQueue<HashMap.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> {
                return b.getValue() - a.getValue();
            });

                for (Map.Entry<String, Integer> e : hMap.entrySet()) {
                    queue.add(e);
                }
                while (!queue.isEmpty()) {
                    l.log(Level.INFO,() ->"\n" + queue.poll());
                }
        }
    }
