class Solution {
    public void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public int partition(int[] arr, int lowIndex, int highIndex, int pivot) {

        //here high index value is actually have pivot value
        //that's why we are not taking that index in the window on which the operation will take place

        int leftPointer = lowIndex;
        int rightPointer = highIndex - 1;

        while (leftPointer <= rightPointer) {
            while (leftPointer <= rightPointer && arr[leftPointer] <= pivot) {
                leftPointer++;
            }

            while (leftPointer <= rightPointer && arr[rightPointer] >= pivot) {
                rightPointer--;
            }

            if (leftPointer < rightPointer) {
                swap(arr, leftPointer, rightPointer);
            }
        }

        swap(arr, leftPointer, highIndex); 
        //now the pivot value has find its right place in the array at leftpointer
        return leftPointer;
    }

    private void quicksort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex >highIndex) {
            return;
        }

        int pivotIndex = new Random().nextInt(highIndex - lowIndex + 1) + lowIndex;
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, highIndex); // Move pivot to the end

        int pivotFinalIndex = partition(array, lowIndex, highIndex, pivot);

        quicksort(array, lowIndex, pivotFinalIndex - 1);
        quicksort(array, pivotFinalIndex + 1, highIndex);
    }

    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }
}
