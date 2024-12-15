import java.util.*;

class segmented_Sieve {
    public static int N = 1000000;
    public static boolean[] seive = new boolean[N + 1];

    // Function to create the sieve for numbers up to N
    public static void createSeive() {
        for (int i = 2; i <= N; i++) {
            seive[i] = true;
        }

        for (int i = 2; i * i <= N; i++) {
            if (seive[i]) {
                for (int j = i * i; j <= N; j += i) {
                    seive[j] = false;
                }
            }
        }
    }

    // Function to generate prime numbers up to N
    public static List<Integer> generatePrime(int limit) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (seive[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        createSeive();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            t--;
            int l = sc.nextInt();
            int r = sc.nextInt();

            // Generate primes up to sqrt(r)
            List<Integer> primes = generatePrime((int) Math.sqrt(r));

            // Create a dummy array to mark primes in range [l, r]
            int dummy[] = new int[r - l + 1];
            Arrays.fill(dummy, 1); // Mark all numbers as prime initially

            // Mark non-primes using the small primes we found
            for (int pr : primes) {
                // Find the first multiple of pr in the range [l, r]
                int firstMultiple = Math.max(pr * pr, (l + pr - 1) / pr * pr);
                
                // Mark all multiples of pr as non-prime in range [l, r]
                for (int j = firstMultiple; j <= r; j += pr) {
                    dummy[j - l] = 0; // Mark non-prime
                }
            }

            // Print all primes in range [l, r]
            for (int i = l; i <= r; i++) {
                if (dummy[i - l] == 1 && i != 1) {
                    System.out.println(i);
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
