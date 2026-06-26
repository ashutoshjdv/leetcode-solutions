// Last updated: 6/26/2026, 8:54:20 AM
class Solution {
    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }

    public int[] selectionSort(int[] nums, int first, int last) {
        for(int i=0; i < last; i++) {
            int position = i;
            for(int j=i+1;j<=last; j++) {
                if(nums[position] > nums[j]) {
                    position =j;
                }
            }
            int temp = nums[position];
            nums[position] = nums[i];
            nums[i] = temp;
        }

        return nums;
    }

    public int[] bubbleSort(int[] nums, int first,int last) {
        boolean swapped;
        for(int i=0; i< last; i++){
            swapped = false;
            for(int j=0; j < last - i; j++) {
                if(nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;

                    swapped = true;
                }
            }

            if(!swapped) break;
        }

        return nums;
    }

    public int[] mergeSort(int[] nums, int first, int last) {
        if(first == last) return nums;

        int mid = (first + last) / 2;

        mergeSort(nums, first, mid);
        mergeSort(nums, mid+1, last);
        merge(nums, first, mid, last);

        return nums;
    }

    public void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right-left+1];
        int pointer1 = left;
        int pointer2 = mid+1;
        int tempPointer = 0;

        while(pointer1 <= mid && pointer2 <= right) {

            if(nums[pointer1] < nums[pointer2]) {
                temp[tempPointer] = nums[pointer1];
                tempPointer++;
                pointer1++;
            }

            else {
                temp[tempPointer] = nums[pointer2];
                tempPointer++;
                pointer2++;
            }
        }

        while(pointer1 <= mid) {
            temp[tempPointer] = nums[pointer1];
                tempPointer++;
                pointer1++;
        }

        while(pointer2 <= right) {
            temp[tempPointer] = nums[pointer2];
                tempPointer++;
                pointer2++;
        }

        for(int i = left; i<= right; i++){
            nums[i] = temp[i-left];
        }
    }
}