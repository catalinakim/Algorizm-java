import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class ChangeCoin {

    static int changeCoin(int money, int numOfCoins, int[][] coins) {

        int[][] numCase = new int[numOfCoins][money+1];
        String[][][] caseStr = new String[numOfCoins][money + 1][];

        int minCoin = coins[0][0];  //가장 작은 동전
        int minCoinCnt = coins[0][1];

        for (int i = 0; i < numOfCoins; i++) { //동전 종류 수 numOfCoins

            numCase[i][0] = 1;
            caseStr[i][0] = new String[1];
            caseStr[i][0][0] = "";

            int coin = coins[i][0];  //얼마짜리 동전
            int cnt = coins[i][1];   //그 동전 갯수
            for (int j = 1; j < money + 1; j++) {  //금액
                for (int k = 0; k <= cnt && j - coin * k >= 0; k++) { //동전이 0개일때 부터
                    //System.out.println("i = " + i + ", 지폐 " + j + "원, " + coin + "원짜리 동전 " + k + "개");

                    if (i == 0) {
                        caseStr[i][j] = new String[1];
                        if (coin * k == j) {
                            numCase[i][j] = 1;
                            caseStr[i][j][0] = (j == 0) ? "" : coin + "x" + k;
                        } else {
                            caseStr[i][j][0] = "";
                        }
                    } else {

                        int add = numCase[i-1][j - coin * k];
                        numCase[i][j] += numCase[i-1][j - coin * k];

                        if (k == 0) {
                            if (numCase[i][j] > 0) {
                                caseStr[i][j] = new String[numCase[i][j]];
                                caseStr[i][j] = caseStr[i - 1][j - coin * k];
                            } else {
                                caseStr[i][j] = new String[1];
                                caseStr[i][j][0] = "";
                            }
                        } else {
                            String[] newCaseStr = (numCase[i][j]==0) ? new String[1] : new String[numCase[i][j]];
                            int preLength = caseStr[i][j].length;
                            //System.out.println("preLength = " + preLength);
                            System.arraycopy(caseStr[i][j], 0, newCaseStr, 0, caseStr[i][j].length);
                            caseStr[i][j] = newCaseStr;
                            //System.out.println("Arrays.toString(caseStr[i][j]) = " + Arrays.toString(caseStr[i][j]));

                            if (caseStr[i - 1][j - coin * k][0].equals("")) {  //[1][5] = [0][5] + [0][0]에서 [0][0]처럼 동전조합 알수없어서 비어있을 때
                                for (int l = preLength; l < numCase[i][j]; l++) {
                                    caseStr[i][j][l] = coin + "x" + k;
                                }
                            } else if (caseStr[i][j][0].equals("")){ //[1][6] = [0][6] + [0][1]에서 [0][1]경우(5원*1개) - [0][6]이 [""]일때
                                for (int l = 0; l < numCase[i][j]; l++) {
                                    caseStr[i][j][l] = caseStr[i-1][j - coin * k][0] + " + " + coin + "x" + k;
                                }
                            } else if (add > 1){  //[2][15] = [1][15] + [1][5]에서 [1][5]경우(10원*1개)
                                for (int l = 0; l < add; l++) {
                                    caseStr[i][j][l+preLength] = caseStr[i-1][j - coin * k][l] + " + " + coin + "x" + k;
                                }
                            } else {
                                for (int l = preLength; l < numCase[i][j]; l++) {
                                    caseStr[i][j][l] = caseStr[i-1][j - coin * k][0] + " + " + coin + "x" + k;
                                }
                            }
                        }
                    }

                }
            }
        }
        for (String[][] str : caseStr) {
            System.out.println(Arrays.deepToString(str));
        }

        for (int[] row : numCase) {
            System.out.println(Arrays.toString(row));
        }

        return numCase[numOfCoins-1][money];
    }


    public static void main(String[] args) {

        int money = 20;
        int numOfCoins = 3;
        int[][] coins = {{10, 2}, {1, 5}, {5, 3}};  //작은 동전순으로 정렬

        Arrays.sort(coins, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0]; //양수이면 swap되어 오름차순 정렬됨
            }
        });
        //System.out.println("coins = " + Arrays.deepToString(coins));

        System.out.println("총 경우의 수: " + changeCoin(money, numOfCoins, coins));
    }
}
