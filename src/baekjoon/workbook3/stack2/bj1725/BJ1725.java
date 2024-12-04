package baekjoon.workbook3.stack2.bj1725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 참고 : https://st-lab.tistory.com/255
 * << 핵심 >>
 *     top이 가리키는 index의 value(막대높이)보다 현재 index의 값보다 작을 경우
 *     현재 막대의 높이보다 크거나 같은 원소는 모두 삭제(pop)하고 현재 index를 삽입(push) 한다.
 */
public class BJ1725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] histogram = new int[n];
        for(int i=0;i<n;i++)
            histogram[i] = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i=0;i<n;i++) {

            while(!stack.isEmpty() && histogram[stack.peek()] >= histogram[i]) {
                int height = histogram[stack.pop()];

                int width = stack.isEmpty() ? i : i - 1 - stack.peek();

                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        System.out.println(stack);
        System.out.println(maxArea);
    }
}
