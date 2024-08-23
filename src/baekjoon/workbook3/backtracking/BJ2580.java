package baekjoon.workbook3.backtracking;

import java.io.*;
import java.util.StringTokenizer;

/**
 * backtracking 알고리즘 사용
 *
 */
public class BJ2580 {

    static int[][] sudoku = new int[9][9];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/baekjoon/workbook3/backtracking/input2580.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        for(int i=0;i<9;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0,0);
    }

    public static void backtracking(int row, int col) {
        if(col == 9) {
            // 해당 행의 마지막 열까지 완료
            backtracking(row+1, 0);
        }

        if(row == 9) {
            for(int i=0;i<9;i++) {
                System.out.println();
                for(int j=0;j<9;j++) {
                    System.out.printf("%d ", sudoku[i][j]);
                }
            }
            System.exit(0);
        }

        // 해당 행열에 0이 있을 경우 가능한 숫자 체크
        if(sudoku[row][col] == 0) {
            for(int i=1;i<=9;i++) {
                if(check(row, col, i)) {
                    sudoku[row][col] = i;
                    backtracking(row, col+1);   // 숫자를 넣어놓고 해당 행의 다른 숫자를 조회
                }
            }
            sudoku[row][col] = 0;   // 현재 위치 0에 들어갈 숫자가 i가 아닌 것이므로 원복
            return;
        }

        backtracking(row, col+1);

    }

    public static boolean check(int row, int col, int num) {
        for(int i=0;i<9;i++){
            // 해당 행에 같은 숫자가 있을 경우
            if(sudoku[row][i] == num) return false;
        }

        for(int i=0;i<9;i++){
            // 해당 열에 같은 숫자가 있을 경우
            if(sudoku[i][col] == num) return false;
        }

        for(int i=3*(row/3);i<3*(row/3)+3;i++){
            for(int j=3*(col/3);j<3*(col/3)+3;j++){
                // 3*3 영역에 같은 숫자가 있을 경우
                if(sudoku[i][j] == num) return false;
            }
        }

        return true;
    }
}
