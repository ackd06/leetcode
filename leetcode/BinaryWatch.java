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
		
		
		401。二进制手表
			二进制手表有4个发光二极管上代表小时（0-11），在底部的6个发光二极管代表分钟（到59）。
			每个LED代表一零或一个，至少有显着的位上的权利。
			例如，上面写着“3:25“二进制手表。
			给定一个非负整数N代表当前正在进行的LED的数量，返回所有可能的时间，手表可以代表。
			例子:
			输入：n = 1
			返回：[“一点”、“两点”、“4”、“点”、“0”、“0:02”、“0:04”、“0:08”、“0时16分”、“零时32”]
			注：
			输出的顺序无所谓。
			小时必须不包含前导零，例如“01:00”是无效的，它应该是“一点”。
			当必须由两位可能包含前导零，例如“十”是无效的，应该是“分”。
 * @author zhangsz
 *
 */
public class BinaryWatch {

	
//
//	/**
//	 * 这里有一个很关键的点，你找到后就不能再用了
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

		for (int i = 0; i <= num; i++) {//小于等于输入的数
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
			sum += hour[i];//取出 i位置  对应的数值
			backTrackHours(totayNum, i + 1, alreadyUsed + 1, hours, sum);
			sum -= hour[i];// 取出 i 对应的数值
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
