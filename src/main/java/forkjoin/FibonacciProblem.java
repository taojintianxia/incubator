package forkjoin;

/**
 * @author Kane.Sun
 * @version Feb 28, 2014 3:54:51 PM
 */
public class FibonacciProblem {

    public int n;

    public FibonacciProblem(int n) {
        this.n = n;
    }

    public long solve() {
        return fibonacci(n);
    }

    private long fibonacci(int n) {
        System.out.println("Thread: " + Thread.currentThread().getName() + " calculates " + n);
        if (n <= 1)
            return n;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

}