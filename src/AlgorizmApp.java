import java.util.ArrayList;

public class AlgorizmApp {

    //소수 구하기
    static void noDivNo(int n) {
        ArrayList<Integer> sosuList = new ArrayList<>();
        int divCount = 0;

        for (int i=2; i <= n; i++){
            boolean isSosu = true;
            for (int j=2; j<i; j++){
                //System.out.println("i = " + i + ", j = " + j);
                divCount++;

                if (i % j == 0) {
                    isSosu = false;
                    break;
                }
            }
            if (isSosu == true) {
                //여기까지 왔으면 소수
                sosuList.add(i);
                //System.out.println(i);
            }
        }
        //1000 이하 소수 계산시, 나누기 연산 횟수
        System.out.println("divCount v1 = " + divCount);
    }

    static void noDivNo2(int n) {
        ArrayList<Integer> sosuList = new ArrayList<>();
        int divCount = 0;

        sosuList.add(2);

        //for (int i=2; i <= n; i++){
        for (int i=3; i <= n; i+=2){  //책(대상은 홀수만)
            boolean isSosu = true;
            //for (int j=0; j<sosuList.size(); j++){
            for (int j=1; j<sosuList.size(); j++){  //책(홀수만 대상이라 2로 나눌필요x)
                //System.out.println("i = " + i + ", sosuList.get(j) = " + sosuList.get(j));
                divCount++;

                if (i % sosuList.get(j) == 0) {
                    isSosu = false;
                    break;
                }
            }
            if (isSosu == true) {
                //여기까지 왔으면 소수
                sosuList.add(i);
            }
        }

        //for (Integer sosu : sosuList) {
        //    System.out.println(sosu);
        //}

        //System.out.println("sosuList.size() = " + sosuList.size());  //총 소수 168개

        System.out.println("divCount v2 = " + divCount);
    }

    static void noDivNo3(int n) {
        ArrayList<Integer> sosuList = new ArrayList<>();
        int calCount = 0;

        sosuList.add(2);
        sosuList.add(3);

        //for (int i=2; i <= n; i++){
        for (int i=5; i <= n; i+=2){  //책(대상은 홀수만)
            boolean isSosu = true;
            //for (int j=0; j<sosuList.size(); j++){
            //for (int j=1; j<sosuList.size(); j++){  //책(홀수만 대상이라 2로 나눌필요x)
            for (int j=1; sosuList.get(j) * sosuList.get(j) <= i; j++){  //V3
                System.out.println("i = " + i + ", sosuList.get(j) = " + sosuList.get(j));
                calCount += 2;
                System.out.println("카운트 2번");

                if (i % sosuList.get(j) == 0) {
                    isSosu = false;
                    break;
                }
            }
            //calCount++;  //2번째 for문의 제어식이 만족하지 않을 때의 계산건을 횟수에 추가하는건데, 여기서 카운트하면, 위에 if문에서 어느 소수로 나눠져서, break로 for문 끝낸거까지 계산됨

            if (isSosu == true) {
                calCount++;
                //여기까지 왔으면 소수
                sosuList.add(i);
                System.out.println("소수 i = " + i);
            }
        }

        //for (Integer sosu : sosuList) {
        //    System.out.println(sosu);
        //}

        System.out.println("calCount v3 = " + calCount);
    }

    public static void main(String[] args) {

        //1000 이하 소수 계산시, 나누기 연산 횟수
        //divCount v1 = 78022
        //divCount v2 = 15621
        //divCount v2-2(책: 대상은 홀수만) = 15121
        //divCount v2-3(책: 홀수대상이라 2로 나눌필요X, 인텍스 1부터) = 14622
        //calCount v3 = 3774

        //noDivNo(1000);
        //noDivNo2(1000);
        noDivNo3(20);

    }
}
