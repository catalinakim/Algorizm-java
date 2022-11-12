import java.util.Scanner;

public class ChangeCoinGumi {

    private static void solve(Scanner sc) {
        int m = sc.nextInt();
        int n = sc.nextInt();
        //int m = 20;
        //int n = 3;
        Coin[] coins = new Coin[10001];
        int[][] dp = new int[10001][101];

        // dp[n][k] = n원일 때 동전 k개까지 사용했을 때의 경우의 수
        // dp[n][k] = dp[n][k] + dp[n - v * c][k - 1]

        for (int i = 1; i <= n; i++) {
            int v = sc.nextInt();
            int c = sc.nextInt();

            coins[i] = new Coin(v, c);
        }

        for (int i = 1; i <= n; i++) {
            int v = coins[i].value;
            int c = coins[i].count;
            dp[0][i - 1] = 1;

            for (int j = 1; j <= c; j++) {

                for (int k = v * j; k <= m; k++) {
                    dp[k][i] += dp[k - (v * j)][i - 1];
                }

            }

            for (int j = 1; j <= m; j++) {
                dp[j][i] += dp[j][i - 1];
            }
        }
        System.out.println(dp[m][n]);
    }

    static class Coin {

        int value = 0;
        int count = 0;

        Coin(int value, int count) {
            this.value = value;
            this.count = count;
        }

    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        solve(sc);

    }
}

