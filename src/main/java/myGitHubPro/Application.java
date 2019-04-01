package myGitHubPro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liweiqiang
 */

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("myGitHubPro.mapper")
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

//        int[] array = {3, 3, 1, 5, 7, 2, 4, 9, 6, 8, 3};
//        int len[] = insertSort(array);
//        int len[] = bubbleSort(array)
//        quickSort(array, 0, array.length - 1);
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + ",");
//        }
//        int array[] = {1, 3, 5, 8, 9, 11, 15, 36, 84, 96, 785, 4253, 1234};
//        int i = binarySearch(array, 33);
//        int i = biSearch(array, 0, array.length, 36);
//        System.out.println(i);
        int array[] = {1, 5, 6, 8, 7, 4, 5, 2, 1, 22, 45, 33, 12, 0, 56, 87, 12};
        int arr[] = solution(array);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

    /**
     * 直接插入排序
     */
    public static int[] insertSort(int[] s) {
        int insertNum;
        int length = s.length;
        for (int i = 1; i < length; i++) {
            insertNum = s[i];
            int j = i - 1;
            while (j >= 0 && s[j] > insertNum) {
                s[j + 1] = s[j];
                j--;
            }
            s[j + 1] = insertNum;
        }
        return s;
    }

    /**
     * 冒泡排序
     */
    public static int[] bubbleSort(int[] s) {
        int length = s.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (s[j] > s[j + 1]) {
                    int temp = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = temp;
                }
            }
        }
        return s;
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] a, int left, int right) {
        if (left > right) {
            return;
        }
        int midNum = a[left];
        int i = left;
        int j = right;
        int temp;
        while (i < j) {
            while (midNum <= a[j] && i < j) {
                j--;
            }
            while (midNum >= a[i] && i < j) {
                i++;
            }
            if (i < j) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        midNum = a[i];
        a[i] = a[left];
        a[left] = midNum;
        quickSort(a, left, i - 1);
        quickSort(a, i + 1, right);
    }

    /**
     * 二分查找(非递归)
     */
    public static int binarySearch(int[] a, int number) {
        int low = 0;
        int hight = a.length;
        int mid;
        while (low <= hight) {
            mid = (low + hight) / 2;
            if (a[mid] > number) {
                hight = mid - 1;
            } else if (a[mid] < number) {
                low = mid + 1;
            } else {
                return mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找(递归)
     */
    public static int biSearch(int a[], int low, int hight, int number) {
        if (low <= hight) {
            int mid = (low + hight) / 2;
            if (a[mid] < number) {
                return biSearch(a, mid + 1, hight, number);
            } else if (a[mid] > number) {
                return biSearch(a, low, mid - 1, number);
            } else {
                return mid + 1;
            }
        }
        return -1;
    }

    /**
     * 将数组中的奇偶数分离
     */
    public static int[] solution(int a[]) {
        int start = 0;
        int end = a.length - 1;
        int temp;
        while (start < end) {
            while (start < end && a[end] % 2 == 1) {
                end--;
            }
            while (start < end && a[start] % 2 == 0) {
                start++;
            }
            temp = a[end];
            a[end] = a[start];
            a[start] = temp;
        }
        return a;
    }
    /**
     * String转double
     */
    public static void num(){

        String ss = "3.141592653";
        double value = Double.valueOf(ss.toString());
    }
}
