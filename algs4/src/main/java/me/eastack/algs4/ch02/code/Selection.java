package me.eastack.algs4.ch02.code;

@SuppressWarnings("rawtypes")
public class Selection implements Sorter {
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        new Selection().sort();
    }
}
