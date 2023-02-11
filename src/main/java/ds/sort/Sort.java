package ds.sort;

import com.quickcode.builder.Builder;
import com.quickcode.print.Console;

public class Sort {

    public static void main(String[] args) {
        int[] ints = Builder.buildInt(49, 38, 65, 97, 76, 13, 27, 49, 53, 4, 8, 329);
        // insertSort(ints);
        // bubbleSort(ints);
        // selectSort(ints);
        // heapSort(ints);
        mergeSort(ints);
        Console.log(ints);
    }

    // 插入排序 第一个元素已经有序 不用排
    // 从第二个元素开始 和前面的元素比较 如果构成逆序 则前面元素后移 直到找到元素不逆序的元素 将本轮排序值放到该元素的后面
    public static void insertSort(int[] A) {
        int temp, j;
        for (int i = 1; i < A.length; i++) {
            // 如果前面元素比后面的大 说明需要将前面的元素后移
            if (A[i - 1] > A[i]) {
                temp = A[i];
                for (j = i - 1; j >= 0 && temp < A[j]; j--) {
                    // 后面的位置放前面的值
                    A[j + 1] = A[j];
                }
                // 最后
                A[j + 1] = temp;
            }
        }
    }


    // 冒泡排序 非递减排序 先确定后面最大的元素
    // 每一趟冒泡 从前往后 把最大的元素放到最后的位置
    public static void bubbleSort(int[] array) {
        // 核心 遍历
        boolean flag;
        for (int i = array.length - 1; i > 0; i--) {
            flag = false;
            // 确定最后一个元素
            // 即找一个最大值放到最后一个位置
            // 从前向后找
            for (int j = 0; j < i; j++) {
                // 如果逆序
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {
                return;
            }
        }
    }

    private static void swap(int[] array, int j, int i) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    private static void partition(int[] array, int start, int end) {
        if (start >= end) return;
        int pivot = array[start];// 枢轴元素
        int low = start, high = end;
        while (low < high) {
            // 如果比枢轴元素大 则不操作 继续循环
            while (low < high && pivot <= array[high]) {
                high--;
            }
            // 直到遇到比枢轴小的元素 将其移动到i的位置
            array[low] = array[high];
            // 如果比枢轴元素小 则不操作
            while (low < high && pivot >= array[low]) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = pivot;
        partition(array, start, low - 1);
        partition(array, low + 1, end);
    }

    private static void partition2(int[] array, int start, int end) {
        if (start >= end) return;
        int pivot = array[start];// 枢轴元素
        int low = start, high = end;
        while (low < high) {
            // 如果比枢轴元素大 则不操作 继续循环
            while (low < high && pivot <= array[high]) {
                high--;
            }

            // 直到遇到比枢轴小的元素 将其移动到i的位置
            // 若low = high ，则不用移动位置
            if (low < high) {
                array[low++] = array[high];
                // low的位置已经比枢轴小了 所以low可以前进一位
            }

            // 如果比枢轴元素小 则不操作
            while (low < high && pivot >= array[low]) {
                low++;
            }

            if (low < high) {
                array[high--] = array[low];
            }
        }
        array[low] = pivot;
        partition2(array, start, low - 1);
        partition2(array, low + 1, end);
    }

    // 此方法为错误代码
    // 规避一种特殊情况 如果low high 相遇了 跳出了内层1或2处循环
    // array[low++] = array[high]; 此时low==high 但是还执行了low 导致了low>high
    // 然后最下面的枢轴取值array[low]就不准确了
    // 所以 要么如partition3，加判断及low，high进行操作
    // 要么如partition，什么都不加
    private static void partition3(int[] array, int start, int end) {
        if (start >= end) return;
        int pivot = array[start];// 枢轴元素
        int low = start, high = end;
        while (low < high) {
            // 1
            // 如果比枢轴元素大 则不操作 继续循环
            while (low < high && pivot <= array[high]) {
                high--;
            }

            // 直到遇到比枢轴小的元素 将其移动到i的位置
            // 若low = high ，则不用移动位置
            array[low++] = array[high];
            // low的位置已经比枢轴小了 所以low可以前进一位

            // 2
            // 如果比枢轴元素小 则不操作
            while (low < high && pivot >= array[low]) {
                low++;
            }
            array[high--] = array[low];

        }
        array[low] = pivot;
        partition3(array, start, low - 1);
        partition3(array, low + 1, end);
    }


    private static void quickSort(int[] array) {
        partition2(array, 0, array.length - 1);
    }

    private static void selectSort(int[] array) {
        int min;
        for (int i = 0; i < array.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                // 从后面找最小的
                if (array[min] > array[j]) min = j;
            }
            // 如果有必要交换
            if (i < min) {
                swap(array, i, min);
            }
        }
    }

    // 假设待排序元素是从数组下标 1 ~ len
    private static void heapSort(int[] array) {
        // 堆排序 从小到大 则建立大根堆
        int high = array.length;
        // 这样建立完全二叉树的时候取值方便
        int[] heap = new int[high + 1];
        for (int i = 1; i < heap.length; i++) {
            heap[i] = array[i - 1];
        }

        // 从len/2处开始至0调整大根堆节点
        for (int i = high / 2; i >= 1; i--) {
            buildHeap(heap, i, high);
        }
        // 将堆顶元素放入最后位置，然后继续调整堆
        for (int i = high; i > 0; i--) {
            // 把堆顶最大的元素 与 堆尾元素交换
            swap(heap, 1, i);
            // 交换完成之后 堆只剩 （1~i-1）
            buildHeap(heap, 1, i - 1);
        }
        Console.log(heap);
    }

    // 建立大根堆
    // 对low位置上的节点进行调整

    /**
     * low 节点进行下坠
     *
     * @param low  代表要对以low为根的子树进行调整
     * @param high 代表堆的边界
     */
    private static void buildHeap(int[] array, int low, int high) {
        array[0] = array[low];
        // 循环要
        for (int i = 2 * low; i <= high; i *= 2) {
            // 要判断是否有右孩子，若有则进行比较左右孩子
            if (i + 1 < high && array[i] < array[i + 1]) {
                i++;
            }
            // 如果孩子更大
            if (array[i] > array[0]) {
                // 将大孩子放到父节点
                array[low] = array[i];
                // 下移：要以大孩子的地址进行构建堆
                low = i;
            } else {
                break;
            }
        }
        array[low] = array[0];
    }

    private static void buildSmallHeap(int[] array, int low, int high) {
        array[0] = array[low];
        // 循环要
        for (int i = 2 * low; i <= high; i *= 2) {
            // 要判断是否有右孩子，若有则进行比较左右孩子
            if (i + 1 < high && array[i] > array[i + 1]) {
                i++;
            }
            // 如果孩子更小
            if (array[i] < array[0]) {
                // 将大孩子放到父节点
                array[low] = array[i];
                // 下移：要以大孩子的地址进行构建堆
                low = i;
            } else {
                break;
            }
        }
        array[low] = array[0];
    }

    // 利用堆排序实现从一千个数中选出前10个最大值
    private static void getTopK(int[] array) {
        if (array == null || array.length <= 10) {
            Console.log(array);
            return;
        }
        int len = 11;
        // heap 从 [1,11] 是大根堆 调整为大根堆后 堆顶元素和堆尾元素交换位置 堆顶元素 最后返回[1,10] 即是最大的前十个
        // heap[0] 空出
        int[] heap = new int[len];
        // 换在堆上
        for (int i = 1; i < heap.length; i++) {
            heap[i] = array[i - 1];
        }
        for (int i = len / 2; i >= 1; i--) {
            // 构建小顶堆
            buildSmallHeap(heap, i, len);
        }
        for (int i = 10; i < array.length; i++) {
            // 堆顶元素是目前已经遍历过的序列中 最大的是个元素
            // 如果有元素过来，比最小的堆顶元素还要小，则不可以
            if (heap[1] < array[i]) {
                heap[1] = array[i];
                buildSmallHeap(heap, 1, len - 1);
            }
        }
        // heap[0] 不算
        Console.log(heap);
    }

    private static void mergeSort(int[] array) {
        // 合并排序时的辅助数组，只声明一次
        int[] supportArray = new int[array.length];
        mergeSort(array, supportArray, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] supportArray, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            // 递归完成了之后进行合并
            mergeSort(array, supportArray, low, mid);
            mergeSort(array, supportArray, mid + 1, high);
            merge(array, supportArray, low, mid, high);
        }
    }

    private static void merge(int[] array, int[] supportArray, int low, int mid, int high) {
        // k为指向已经排序元素的下一个 所以k应该操作array
        int k = low;
        for (int i = low; i <= high; i++) {
            supportArray[i] = array[i];
        }
        int i = low, j = mid + 1;
        for (; i <= mid && j <= high; k++) {
            if (supportArray[i] <= supportArray[j]) {
                // 说明i要更小 或者相等 那么为了保证稳定性 此时需要取i所指的位置
                array[k] = supportArray[i++];
            } else {
                // 否则，就时j指向的元素更小
                array[k] = supportArray[j++];
            }
        }
        // 此时 i 或者 j 可能存在有一个还没有移动到最终的位置
        while (i <= mid) {
            array[k] = supportArray[i++];
            k++;
        }
        while (j <= high) {
            array[k] = supportArray[j++];
            k++;
        }
    }

}
