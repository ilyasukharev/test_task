package task2;

import java.io.*;

public class Main {
    private static float[] getCoordinatesFromString (String line) {
        float[] coords = new float[2];
        try {
            coords[0] = Float.parseFloat(line.split(" ")[0]);
            coords[1] = Float.parseFloat(line.split(" ")[1]);
        } catch (Exception e) { throw new RuntimeException(e.getMessage()); }

        return coords;
    }
    private static int findPlaceOfPoint(float[] pointCoords, int radius, float[] centerCoords) {
        float distanceBetweenPoint = (float) Math.sqrt(
                Math.pow(centerCoords[0] - pointCoords[0], 2) + Math.pow(centerCoords[1] - pointCoords[1], 2)
        );
        if (distanceBetweenPoint < radius)      return 1;
        else if (distanceBetweenPoint > radius) return 2;
        else                                    return 0;
    }
    public static void main(String[] args) {
        if (args.length < 2)
            throw new IllegalArgumentException("Some or all arguments are null");

        File file1 = new File(args[0]);
        File file2 = new File(args[1]);

        if (!file1.exists() || !file2.exists())
            throw new IllegalArgumentException("One or both of arguments paths don`t reference to exists files");

        try (BufferedReader file1Reader = new BufferedReader(new FileReader(file1));
             BufferedReader file2Reader = new BufferedReader(new FileReader(file2))) {

            float[] centerCoords = getCoordinatesFromString(file1Reader.readLine());
            int radius = Integer.parseInt(file1Reader.readLine());

            String line;
            while(true) {
                line = file2Reader.readLine();
                if (line == null) break;
                float[] pointCoords = getCoordinatesFromString(line);
                System.out.println(
                        findPlaceOfPoint(
                                pointCoords, radius, centerCoords
                        )
                );
            }

        } catch (Exception e) { throw new RuntimeException(e.getMessage()); }
    }
}
