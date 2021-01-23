// https://algoprog.ru/material/p1460

// https://hsecodes.com/index.php/tasksdecision/index/467
// https://www.geeksforgeeks.org/how-to-left-or-right-rotate-an-array-in-java/
// https://www.geeksforgeeks.org/print-left-rotation-array/
// https://leetcode.com/problems/rotate-array/
// https://www.techiedelight.com/left-rotate-array-c/?__cf_chl_captcha_tk__=6fc0e49e33865cfe3c0a302e12dc7a1c0694096a-1611390694-0-AZdPhR-_iuUvcoMxqPpmGeaQYdTFUrt0_PjLCtCSJwI65uAAUzt6P55xEdeLER8IZVnA2EroCH5c3XgrNTFykyMVLNvxzV2d1EMVYSl9_WQfIcZHz_GIsdFQeK6MomScaxF3INXQPGF0OJDguFXbD-7oZ04ZU2djfE5PCaYIZRcWQ7BPWGDy1IUqcl_VnVFfA1SxcwZJBdZZRh7dvmwv2uXm60cAzDA3VI84jUcA8UEIUrLi5iB8puWq4ifweAexlqxVz4Ci6drjCCdITuOo2tRM4Ton_nwG10uy8l1HjqWDk4CYks6p6OEeXAPINZUlv2cel8KFN1e2yw2_m4H4s68FRLszFbqSmTBwYcYkqmQJ-HRdoDdytq75ylb7UH_LVfQe9I2UXRYEmRXTXhBPIxY511oc6gib4iFL88SnXWhwb4LloOK85r1vkkSKItS1XIy-8sEU46h07BuOTlHiHkrmoEYtPCHC8FFVlsANgOv7eiy-Gb7xDNCms80F7YcF1OraUUPNStcdllTjeUB3DK1WYjGYyXeJXJQToeAH960Z

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1460 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] nn = new int[n];
        String[] t = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nn[i] = Integer.parseInt(t[i]);
        }
        int k = Integer.parseInt(reader.readLine());
        calc(n, nn, k);
    }

    static void calc(int n, int[] nn, int k) {
        if (k > 0) {
            rRotate(n, nn, k);
        } else {
            lRotate(n, nn, Math.abs(k));
        }
    }

    static void rRotate(int n, int[] nn, int k) {
        k %= nn.length;
        reverse(nn, 0, nn.length - 1);
        reverse(nn, 0, k - 1);
        reverse(nn, k, nn.length - 1);
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            buffer.append(nn[i]);
            buffer.append(" ");
        }
        System.out.println(buffer.toString());
    }

    static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    static void lRotate(int n, int[] nn, int k) {
        k %= nn.length;
        reverse(nn, 0, k - 1);
        reverse(nn, k, nn.length - 1);
        reverse(nn, 0, nn.length - 1);
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            buffer.append(nn[i]);
            buffer.append(" ");
        }
        System.out.println(buffer.toString());
    }
}
