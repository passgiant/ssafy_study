import java.util.*;
import java.io.*;

class ValidateCalendar {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(br.readLine());
		int[] dayOfMonth = {-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		for (int test_case = 1; test_case <= T; test_case++) {
			String info = br.readLine();
			String month = "";
			String day = "";
			String answer = "-1";
			String temp = "";
			
			boolean isRightMonth = true;
			boolean isRightDay = true;
			
			for (int i = 0; i < 4; i++) {
				temp += info.charAt(i);
			}
			temp += "/";
			for (int i = 4; i < 6; i++) {
				month += info.charAt(i);
				temp += info.charAt(i);
			}
			temp += "/";
			for (int i = 6; i < 8; i++) {
				day += info.charAt(i);
				temp += info.charAt(i);
			}
			int monthNum = Integer.parseInt(month);
			isRightMonth = monthNum <= 12 && monthNum > 0;
			
			if (isRightMonth) {
				int maxDay = dayOfMonth[monthNum];
				int dayNum = Integer.parseInt(day);
				
				isRightDay = dayNum <= maxDay && dayNum > 0;
			}
			
			if (isRightMonth && isRightDay) {
				answer = temp;
			}
			
			bw.write("#" + test_case + " " + answer + "\n");
		}

		bw.close();
		br.close();
	}
}