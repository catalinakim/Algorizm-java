import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Ch1_Ch2_beforeSosu_p71 {
    static int max3(int a, int b, int c) {
        int max = a;
        if (max < b) {
            max = b;
        }
        if (max < c) {
            max = c;
        }
        return max;
    }

    static int mid(int a, int b, int c) {
        //int max = a;
        int mid = 0;
        if (a < b) {
            if (a > c) {
                mid = a;
            } else if (b < c) {
                mid = b;
            } else {
                mid = c;
            }
        } else if (b > c) {
            mid = b;
        } else if (a < c) {
            mid = a;
        } else {
            mid = c;
        }
        return mid;
    }

    static String positiveNumber(int a) {
        //String result = "";
        if (a > 0) {
            return "양수입니다";
        } else if (a < 0) {
            return "음수입니다.";
        } else {
            return "0입니다";
        }
    }

    static int sumN(int a) {
        int sum = 0;
//        for (int i = 0; i <= a; i++) {
//            sum += i;
//        }
//        return sum;

//        int i = 0;
//        while (i <= a) {
//            sum += i;
//            i++;
//            System.out.println("i  = " + i + ", sum = " + sum);
//        }
        //가우스의 덧셈
        double sumDouble = (1 + a) * a/2;
        System.out.println("sumDouble = " + sumDouble);
        sum = (int) sumDouble;
        return sum;
    }

    static int sumof(int a, int b) {
        int sum = 0;
        if (a > b) {
            int t = b;
            b = a;
            a = t;
        }
        for (int i = a; i <= b; i++) {
            sum += i;
        }
        return sum;
    }

    static void subtract() {
        Scanner sc = new Scanner(System.in);
        System.out.print("a값:");
        int a = sc.nextInt();
        System.out.print("b값:");
        int b = sc.nextInt();
        do {
            System.out.println("a보다 큰 숫자 입력");
            System.out.print("b값:");
            b = sc.nextInt();
        } while (a >= b);
        System.out.println(b-a);
    }

    static void numPosition(int a) {
        int div = a;
//        int i;
//        for (i = 0; div > 0; i++) {
//            div = div/10;
//        }
//        System.out.println(i + "자리수입니다");
        //while사용
        int pos = 0;
        while (div > 0) {
            div = div/10;
            pos ++;
        }
        System.out.println(pos + "자리수입니다");
    }

    static void pos2num() {
        Scanner sc = new Scanner(System.in);
        System.out.println("2자리 양수 입력");
        int a;
        int length;
        do {
            System.out.print("입력: ");
            a = sc.nextInt();
            //자리수2
            //log10(1) = 0   log10(10) = 1   log10(100) = 2
            //length = (int)(Math.log10(a) + 1);
            //String strNum = Integer.toString(a); //자리수3. 문자로 변환해서 길이
            //length = strNum.length();
            //자리수4
            int[] arrNum = Stream.of(String.valueOf(a).split(""))
                    .mapToInt(Integer::parseInt) //요소들을 Int Stream타입으로
                    .toArray();
            System.out.println("arrNum = " + Arrays.toString(arrNum));
            length = arrNum.length;
            System.out.println("입력한 숫자의 자리수는 = " + length);
        } while ( a <= 0 || length != 2);
        System.out.println("변수 a = " + a + "는 2자리수");

    }

    static void multiple() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                //System.out.print(i * j + " ");
                System.out.printf("%3d", i*j);
            }
            System.out.println();
        }
    }

    static void multiple2() {
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                if (i == 0 && j == 0) {
                    System.out.printf("%3s", new String("|"));
                }else if (i == 0) {
                    System.out.printf("%3d", j);
                } else if (j == 0) {
                    System.out.printf("%d |", i);
                } else {
                    System.out.printf("%3d", i*j);
                }
            }
            System.out.println();
            if (i == 0) {
                System.out.println("-".repeat(3) + "+" + "-".repeat(26));
            }
        }
    }

    static void square() {
        Scanner sc = new Scanner(System.in);
        System.out.print("단 수: ");
        int a = sc.nextInt();
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= a; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void triangle() {
        Scanner sc = new Scanner(System.in);
        System.out.print("단 수: ");
        int a = sc.nextInt();
        for (int i = 1; i <= a; i++) {
            System.out.print("*".repeat(i));
            System.out.println();
        }
    }

//    static void test() { //메소드 내 선언한 지역변수는 초기화되지 않음
//        int a;
//        System.out.println("a = " + a);
//    }

    static void reverse(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = temp;
        }
    }

    static boolean arrEqual(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }
        for(int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    static void copy(int[] a, int[] b) {
        //a = new int[b.length];
        for (int i=0; i<b.length; i++){
            a[i]= b[i];
        }
    }

    static void rcopy(int[] a, int[] b){
        int num = a.length <= b.length ? a.length : b.length;
        for (int i=0; i<num; i++){
            a[i] = b[num-i-1];
        }
    }

    static char[] convert(int n, int r, char[] arr){
        int pos = 0;
        while(n>0){
            pos++;
            int left = n%r;
            n = n/r;
            arr[arr.length -pos] = (char) (left + '0');
            //System.out.println("pos: " + pos +", left = " + left);
        }
        char[] newArr = new char[pos];
        for (int i = 0; i < pos; i++) {
            newArr[i] = arr[arr.length - pos + i];
        }
        return newArr;
    }

    static String convert36(int n, int r, char[] arr){
        String str = "";
        String charList = "";
        for (int i = 0; i < 10; i++) {
            charList += String.valueOf(i);
        }
        //System.out.println("charList = " + charList);
        for (int i = 65; i<=90; i++){
            char c = (char) i;
            charList += String.valueOf(c);
        }
        //System.out.println("charList = " + charList);
        int pos = 0;
        while(n>0){
            pos++;
            int left = n%r;
            n = n/r;
            if (left < 10) {
                arr[arr.length - pos] = (char) (left + '0');
            } else {
                arr[arr.length - pos] = charList.charAt(left);
            }
            //System.out.println("pos: " + pos +", left = " + left);
        }
//        char[] newArr = new char[pos];
        for (int i = 0; i < pos; i++) {
            str += arr[arr.length - pos + i];
        }
        return str;
    }

    static String convert36v2(int n, int r){
        String str = "";
        String charList = "";
        char[] arr = new char[10];
        for (int i = 0; i < 10; i++) {
            charList += String.valueOf(i);
        }
        for (int i = 65; i<=90; i++){
            char c = (char) i;
            charList += String.valueOf(c);
        }

        int pos = 0;
        while(n>0){
            pos++;
            int left = n%r;
            n = n/r;
            if (left < 10) {
                arr[arr.length - pos] = (char) (left + '0');
            } else {
                arr[arr.length - pos] = charList.charAt(left);
            }
            //System.out.println("pos: " + pos +", left = " + left);
        }
        for (int i = 0; i < pos; i++) {
            str += arr[arr.length - pos + i];
        }
        return str;
    }

    static int[] testArr(int[] aa){
        aa[1] = 99;
        return aa;
    }

    public void mainCh1Ch2(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("a: ");
//        int a = sc.nextInt();
//        System.out.println(positiveNumber(a));
//        System.out.println(sumof(3, 5));
//        subtract();
//        square();
//        triangle();

//        int[] a = new int[]{3, 4, 1, 5, 10};
//        int max = a[0];
//        for(int i = 1; i<a.length; i++){
//            if (max < a[i]) {
//                max = a[i];
//            }
//        }
//        System.out.println("max = " + max);

        //역순
//        int[] a = {4, 3, 5, 1, 2};
//        int[] a2 = {4, 3, 5, 1, 2};
//        int[] a3 = {4, 3, 5, 9, 2};
//        int[] b = {1, 3, 2, 4};
//        reverse(a);
//        reverse(b);
//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(b));
//        System.out.println(arrEqual(a, b));
//        System.out.println(arrEqual(a, a3));
//        System.out.println(arrEqual(a, a2));
//        int[] c = new int[a.length];
//        copy(c, a);
//        System.out.println("c: "+ Arrays.toString(c));
//        rcopy(c, a);
//        System.out.println("c: "+ Arrays.toString(c));

        char[] arr = new char[10];
        char[] arr2 = new char[]{'0','0','0','0','0','0','0','0','0','0'};
        char[] arr3 = new char[]{'0','0','0','0','0','0','0','0','0','0'};
//        char[] newArr1 = convert(12, 8, arr);
//        char[] newArr2 = convert(16, 2, arr2);
//        convert(16, 2, arr3);
//        System.out.println("arr = " + String.valueOf(arr));
//        System.out.println("arr = " + Arrays.toString(arr));
//        System.out.println("newArr1 = " + String.valueOf(newArr1));
//        System.out.println("arr2 = " + Arrays.toString(newArr2));
//        System.out.println("arr3 = " + String.valueOf(arr3));
//        System.out.println((char) 65);
//        char c = (char)(5 + '0');
//        System.out.println(c);
//        System.out.println((char)(5 + '0'));
//        char[] charArr = {65};
//        System.out.println(charArr); //A

//        int[] aa = {2, 5, 1, 4};
//        testArr(aa);
//        System.out.println("aa = " + Arrays.toString(aa));  //[2, 99, 1, 4]

//        System.out.println("convert36(15, 16, arr2) = " + convert36(28, 16, arr2));
//        System.out.println("convert36(15, 16, arr2) = " + convert36(511, 8, arr2));
//        System.out.println("convert36(15, 16, arr2) = " + convert36(15, 16, arr2));
//        System.out.println("arr2 = " + String.valueOf(arr2));
//        System.out.println("convert36v2(15, 16) = " + convert36v2(15, 16));
//        System.out.println("convert36v2(15, 16) = " + convert36v2(16, 16));
//        System.out.println("convert36v2(15, 16) = " + convert36v2(28, 16));

    }
}
