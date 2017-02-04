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
 * 你和你的朋友玩下面的NIM游戏：在桌上的一堆石头，每一次你轮流取出1到3块石头。移除最后一块石头的人将是赢家。你将采取第一个转弯，以消除石头。
 * 你们两个都很聪明，有最佳的游戏策略。编写一个函数，确定你是否可以赢得游戏中给定的一些石头堆中的数量。
 * 例如，如果有4块石头，那么你永远不会赢得游戏：无论是1，2，或3个石头你删除，最后一块石头将永远被你的朋友删除。 提示：
 * 如果堆里有5块石头，你能想出一个方法来去除石头，这样你永远是赢家吗？ 信用:
 * 特别感谢@jianchao.li.fighter增加这一问题，创建所有的测试用例。 订阅看哪家公司问这个问题
 * 
 * @author zhangsz
 *
 */
public class NimGameSolution {

	/**
	 * 解题思路： 你想赢的话，你必须要抢先拿到剩下第四块石头,
	 * 
	 * 在你手上为5 取1 6>2 7-->3
	 * 
	 * 对手怎么都拿不到第四块石头 对手处于8这个位置
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
	 * 极简
	 * 
	 * @param n
	 * @return
	 */
	public static boolean canWinNimOtherOne(int n) {

		return !(n % 4 == 0);

	}

}
