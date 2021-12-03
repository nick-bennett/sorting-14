package edu.cnm.deepdive;

public class MergeSort {

  public static void sort(int[] data) {
    sort(data, 0, data.length);
  }

  public static void sort(int[] data, int start, int end) {
    if (end > start + 1) {
      // Divide
      int midpoint = (start + end) / 2;
      sort(data, start, midpoint); // Sort the left side.
      sort(data, midpoint, end); // Sort the right side.
      // Conquer (merge)
      int[] merged = new int[end - start];
      int leftIndex = start;
      int rightIndex = midpoint;
      int mergedIndex = 0;
      while (leftIndex < midpoint && rightIndex < end) {
        int leftValue = data[leftIndex];
        int rightValue = data[rightIndex];
        if (leftValue <= rightValue) {
          merged[mergedIndex++] = leftValue;
          leftIndex++;
        } else {
          merged[mergedIndex++] = rightValue;
          rightIndex++;
        }
      }
      if (leftIndex < midpoint) { // We know there are items remaining in the left-hand side.
        System.arraycopy(data, leftIndex, merged, mergedIndex, midpoint - leftIndex);
      } else { // We now know that items remain in right-hand side; that is,  rightIndex < end.
        System.arraycopy(data, rightIndex, merged, mergedIndex, end - rightIndex);
      }
      System.arraycopy(merged, 0, data, start, merged.length);
    }
  }

}
