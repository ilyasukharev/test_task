package task1;


public class Main {
    public static void main(String[] args) {
        if (args.length == 0) throw new IllegalArgumentException();
        int n,m;
        try {
            n = Integer.parseInt(args[0]);
            m = Integer.parseInt(args[1]);

            if (m == 1) throw  new IllegalArgumentException("Infinity cycle");
        } catch (NumberFormatException e) { throw new IllegalArgumentException(e.getMessage()); }

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        StringBuilder builder = new StringBuilder();
        int ind = 0;
        int counts = 0;
        builder.append(arr[0]);

        while(true) {
            if (ind + 1 == n) ind = 0;
            else              ind++;

            if (++counts == m - 1) {
                if (arr[ind] == arr[0]) break;

                builder.append(arr[ind]);
                counts = 0;
            }
        }

        System.out.println(builder);
    }
}
