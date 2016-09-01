package zsz.develop;

/**
 * 292. Nim Game QuestionEditorial Solution My Submissions Total Accepted: 94312
 * Total Submissions: 174462 Difficulty: Easy You are playing the following Nim
 * Game with your friend: There is a heap of stones on the table, each time one
 * of you take turns to remove 1 to 3 stones. The one who removes the last stone
 * will be the winner. You will take the first turn to remove the stones.
 * 
 * Both of you are very clever and have optimal strategies for the game. Write a
 * function to determine whether you can win the game given the number of stones
 * in the heap.
 * 
 * For example, if there are 4 stones in the heap, then you will never win the
 * game: no matter 1, 2, or 3 stones you remove, the last stone will always be
 * removed by your friend.
 * 
 * Hint:
 * 
 * If there are 5 stones in the heap, could you figure out a way to remove the
 * stones such that you will always be the winner? Credits: Special thanks
 * to @jianchao.li.fighter for adding this problem and creating all test cases.
 * 
 * Subscribe to see which companies asked this question
 * 
 * �����������������NIM��Ϸ�������ϵ�һ��ʯͷ��ÿһ��������ȡ��1��3��ʯͷ���Ƴ����һ��ʯͷ���˽���Ӯ�ҡ��㽫��ȡ��һ��ת�䣬������ʯͷ��
 * �����������ܴ���������ѵ���Ϸ���ԡ���дһ��������ȷ�����Ƿ����Ӯ����Ϸ�и�����һЩʯͷ���е�������
 * ���磬�����4��ʯͷ����ô����Զ����Ӯ����Ϸ��������1��2����3��ʯͷ��ɾ�������һ��ʯͷ����Զ���������ɾ���� ��ʾ��
 * ���������5��ʯͷ���������һ��������ȥ��ʯͷ����������Զ��Ӯ���� ����:
 * �ر��л@jianchao.li.fighter������һ���⣬�������еĲ��������� ���Ŀ��ļҹ�˾���������
 * 
 * @author zhangsz
 *
 */
public class NimGameSolution {

	/**
	 * ����˼·�� ����Ӯ�Ļ��������Ҫ�����õ�ʣ�µ��Ŀ�ʯͷ,
	 * 
	 * ��������Ϊ5 ȡ1 6>2 7-->3
	 * 
	 * ������ô���ò������Ŀ�ʯͷ ���ִ���8���λ��
	 * 
	 * @param n
	 * @return
	 */
	public static boolean canWinNimMyOne(int n) {

		if (n < 4 || n % 4 != 0) {
			return true;
		}

		return false;

	}

	/**
	 * ����
	 * 
	 * @param n
	 * @return
	 */
	public static boolean canWinNimOtherOne(int n) {

		return !(n % 4 == 0);

	}

}
