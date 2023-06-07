package task4;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) throw new IllegalArgumentException("Path was not found");
        File file = new File(args[0]);
        if (!file.exists()) throw new IllegalArgumentException("File was not found");

        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            ArrayList<Integer> list = new ArrayList<>();

            while(line != null) {
                list.add(Integer.parseInt(line));
                line = reader.readLine();
            }

            list.sort(Integer::compareTo);
            int middle = list.get(list.size() / 2);
            int res = 0;
            for (Integer num : list) {
                int x = num - middle;
                res += x < 0 ? -x : x;
            }
            System.out.println(res);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
