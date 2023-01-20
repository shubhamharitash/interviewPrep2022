package algorithms.recursion.theory;

public class Q8_kthGrammer {
    public int kthGrammar(int n, int k) {
        if (n == 1)
            return 0;
        int mid = (1<<(n-1))/2;
        if (k <= mid)
            return kthGrammar(n - 1, k);
        else
            return kthGrammar(n - 1, k - mid) == 0 ? 1:0;
    }

    public static void main(String[] args) {
        System.out.println(kthGrammar(4,4));
    }
}
