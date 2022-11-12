import java.util.Scanner;

public class Ch2DayOfYear {
    static int monthDay[][] = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, //평년
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}  //윤년
    };
    
    static int isYun(int year) {
        int yun = 0;  //0: 평년, 1: 윤년

        if (year % 4 == 0){
            if (year % 100 == 0 && year % 400 != 0) {
                yun = 0;
            } else {
                yun = 1;
            }
        }
        return yun;
    }
    
    static int daysOfYear(int year, int month, int day) {
        int days = 0;
        for (int m = 0; m < month-1; m++) {
            days += monthDay[isYun(year)][m];
        }
        return days + day;
    }

    static int daysOfYear2(int year, int month, int day) { //days 없이
        for (int m = 0; m < month-1; m++) {
            day += monthDay[isYun(year)][m];
        }
        return day;
    }

    static int daysOfYear3(int year, int month, int day) { //days 없이, while사용
        int m = 0;
        while(m < month-1){
            day += monthDay[isYun(year)][m];
            m ++;
        }
        return day;
    }

    static int daysOfYear4(int year, int month, int day) { //m변수 없이, days 없이, while사용
        //while(month - 1 != 0){
        //    day += monthDay[isYun(year)][month - 1];
        //    month--;
        //}
        //return day;

        //책
        while(--month != 0){
            day += monthDay[isYun(year)][month - 1];
        }
        return day;
    }

    static int leftDaysOfYear(int year, int month, int day) {
        int days = monthDay[isYun(year)][month-1] - day;
        for( int i = month; i != 12; i++){
            days += monthDay[isYun(year)][i];
        }
        return days;
    }

    static int leftDaysOfYear2(int year, int month, int day) {
        int days = monthDay[isYun(year)][month-1] - day;
        while( month != 12){
            days += monthDay[isYun(year)][month];
            month++;
        }
        return days;
    }

    static int leftDayOfYearBook(int y, int m, int d) {
        int days = d; // 일수

        for (int i = 1; i < m; i++) // 1월~(m-1)월의 일 수를 더함
            days += monthDay[isYun(y)][i - 1];
        return 365 + isYun(y) - days;
    }

    public static void main(String[] args) {

        //Scanner sc = new Scanner(System.in);
        //System.out.print("연도 입력:");
        //int year = sc.nextInt();
        //System.out.print("월 입력:");
        //int month = sc.nextInt();
        //System.out.print("일 입력:");
        //int day = sc.nextInt();

        //int pySum = 0;
        //for (int i = 0; i < monthDay[0].length; i++) {
        //    pySum += monthDay[0][i];
        //}
        //System.out.println("pySum = " + pySum);
        //
        //int yySum = 0;
        //for (int i = 0; i < monthDay[0].length; i++) {
        //    yySum += monthDay[1][i];
        //}
        //System.out.println("yySum = " + yySum);

        //System.out.println("daysOfYear() " + daysOfYear(year, month, day) + "번째 날입니다.");
        //System.out.println("daysOfYear2() " + daysOfYear2(year, month, day) + "번째 날입니다.");
        //System.out.println("daysOfYear3() " + daysOfYear3(year, month, day) + "번째 날입니다.");
        //System.out.println("daysOfYear4() " + daysOfYear4(year, month, day) + "번째 날입니다.");
        System.out.println("leftDaysOfYear2 of 2022.12.30 : " + leftDaysOfYear2(2022, 12, 30) + "일 남았습니다.");
        System.out.println("leftDaysOfYear2 of 2022.12.31 : " + leftDaysOfYear2(2022, 12, 31) + "일 남았습니다.");
        System.out.println("leftDaysOfYear2 of 2022.11.29 : " + leftDaysOfYear2(2022, 11, 29) + "일 남았습니다.");
        System.out.println("leftDaysOfYear of 2022.10.30 : " + leftDaysOfYear(2022, 10, 30) + "일 남았습니다.");
        System.out.println("leftDaysOfYear2 of 2022.10.30 : " + leftDaysOfYear2(2022, 10, 30) + "일 남았습니다.");
        //System.out.println("leftDayOfYearBook of 2022.10.30 : " + leftDayOfYearBook(2022, 10, 30) + "일 남았습니다.");

    }

}
