package zsz.develop.one;

import java.util.ArrayList;
import java.util.List;
/**
 * 401. Binary Watch  
		A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
		
		Each LED represents a zero or one, with the least significant bit on the right.
		
		
		For example, the above binary watch reads "3:25".
		
		Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.
		
		Example:
		
		Input: n = 1
		Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
		Note:
		The order of output does not matter.
		The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
		The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
		
		
		401���������ֱ�
			�������ֱ���4������������ϴ���Сʱ��0-11�����ڵײ���6����������ܴ�����ӣ���59����
			ÿ��LED����һ���һ�������������ŵ�λ�ϵ�Ȩ����
			���磬����д�š�3:25���������ֱ�
			����һ���Ǹ�����N����ǰ���ڽ��е�LED���������������п��ܵ�ʱ�䣬�ֱ���Դ���
			����:
			���룺n = 1
			���أ�[��һ�㡱�������㡱����4�������㡱����0������0:02������0:04������0:08������0ʱ16�֡�������ʱ32��]
			ע��
			�����˳������ν��
			Сʱ���벻����ǰ���㣬���硰01:00������Ч�ģ���Ӧ���ǡ�һ�㡱��
			����������λ���ܰ���ǰ���㣬���硰ʮ������Ч�ģ�Ӧ���ǡ��֡���
 * @author zhangsz
 *
 */
public class BinaryWatch {

	
//
//	/**
//	 * ������һ���ܹؼ��ĵ㣬���ҵ���Ͳ���������
//	 * 
//	 * @param num
//	 * @return
//	 */
//	public List<String> readBinaryWatch(int num) {
//		if (num == 0) {
//			return new ArrayList<>();
//		}
//		int j = num;
//		for (int i = 0; i < num; i++) {
//
//		}
//
//		return null;
//	}

	private int[] hour = new int[] { 1, 2, 4, 8 };
	private int[] min = new int[] { 1, 2, 4, 8, 16, 32 };

	public  List<String> readBinaryWatch(int num) {
		List<String> res = new ArrayList<>();

		for (int i = 0; i <= num; i++) {//С�ڵ����������
			if (i <= 4 && num - i <= 6) {
				List<String> hours = new ArrayList<>();
				List<String> mins = new ArrayList<>();
				backTrackHours(i, 0, 0, hours, 0);
				backTrackMins(num - i, 0, 0, mins, 0);
				for (String h : hours) {
					for (String m : mins) {
						if (!res.contains(h + ":" + m)) {
							res.add(h + ":" + m);
						}
					}
				}
			}
		}
		return res;
	}

	/**
	 * 
	 * @param totayNum
	 * @param start
	 * @param alreadyUsed
	 * @param hours
	 * @param sum
	 */
	private void backTrackHours(int totayNum, int start, int alreadyUsed, List<String> hours, int sum) {
		if (totayNum == 0) {
			hours.add("0");
			return;
		}
		if (alreadyUsed == totayNum && sum < 12) {
			hours.add(Integer.toString(sum));
			return;
		}
		for (int i = start; i < hour.length; i++) {
			sum += hour[i];//ȡ�� iλ��  ��Ӧ����ֵ
			backTrackHours(totayNum, i + 1, alreadyUsed + 1, hours, sum);
			sum -= hour[i];// ȡ�� i ��Ӧ����ֵ
		}
	}

	private void backTrackMins(int totayNum, int start, int alreadyUsed, List<String> mins, int sum) {
		if (totayNum == 0) {
			mins.add("00");
			return;
		}
		if (alreadyUsed == totayNum && sum < 60) {
			if (sum < 10) {
				mins.add("0" + Integer.toString(sum));
			} else {
				mins.add(Integer.toString(sum));
			}
			return;
		}
		for (int i = start; i < min.length; i++) {
			sum += min[i];
			backTrackMins(totayNum, i + 1, alreadyUsed + 1, mins, sum);
			sum -= min[i];
		}
	}

}
