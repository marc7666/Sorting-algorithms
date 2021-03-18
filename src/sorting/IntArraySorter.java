package sorting;

/**
 * @author jmgimeno
 *
 * * Autoria dels algoritmes d'ordenació: Marc Cervera Rosell
 */

public class IntArraySorter {

    private final int[] array;

    public IntArraySorter(int[] array) {
        this.array = array;
    }

    public boolean isSorted() {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public void swap(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public void insertionSort() {
        // Invariant: The prefix [0, end) is a sorted array
        for (int end = 1; end < array.length; end++) {
            // We insert element at end into this prefix

            // Invariant: arrays sorted in the ranges [0, insert)
            // and [insert, end] and element at insert less than
            // all elements in [insert+1, end].

            for (int insert = end; insert >= 1; insert--) {
                if (array[insert - 1] > array[insert]) {
                    swap(insert - 1, insert);
                } else {
                    break;
                }
            }
        }
    }

    public void bubbleSort() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) { /*array.length - i - 1 => A partir d'aquí ja està ordenat*/
                if (array[j] > array[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
    }

    public void selectionSort() {
        for (int i = 0; i < array.length; i++) {
            int min = i; /*Busquem el menor element de l'array desordenat*/
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (i < min) {
                swap(i, min);
            }
        }
    }

    public void quickSort() {
       recursiveQuickSort(this.getArray(), 0, this.array.length);
    }

    public void recursiveQuickSort(int[] array, int lowest, int highest) {
        if (lowest < highest) {
            int pos = partition(array, lowest, highest);
            recursiveQuickSort(array, lowest, pos);
            recursiveQuickSort(array, pos + 1, highest);
        }
    }

    public int partition(int[] array, int lowest, int highest) {
        int pivot = array[lowest]; //Posicionem el pivot
        int low = lowest;
        int high = highest;
        while (low < high) {
            do {
                low++;
            } while (array.length > low && array[low] <= pivot); //Saltem els elements menors el pivot
            //No podem arribar al final de l'array. Tampoc es possible que l'element al qual apunta el punter low sigui <= al pivot (indica que hauriam de parar)
            do {
                high--;
            } while (array[high] > pivot && high > 0); //Saltem els elements majors al pivot
            //No podem arribar al principi de l'array. Tampoc es possible que l'element al que apunta el punter high sigui > al pivot (indica que hauriam de parar)
            if (high > low) {
                swap(low, high);
            }
        }
        swap(lowest, high); //Situació dels elements al costat que els hi pertoca
        return high;
    }

    public int[] getArray() {
        return array;
    }
}
