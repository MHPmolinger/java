package com.neusoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * 编程实现 买新扑克牌（按顺序 大小王 然后 大小王 四个A 四个 2 …… 四个 K ） 洗牌 ：将新买的牌打乱顺序 发牌
 * 分发给三个人17张牌后剩余三张底牌 码牌 将每个人手中的 牌（以及三张底牌） 按照游戏规则排序54 张 两个 大小王 一种 花色 13张 四种 花色
 * 13*4=52 三个人 玩 斗地主 无序 洗牌 后 发牌 1、买牌 ： 新的牌 大小王 四个A 四个 2 …… 四个 K (方法 返回值
 * ArrayList<String>) buyNewPoker 红桃三 2、洗牌 ：全部 打乱 其顺序 3、发牌 ：发牌 17张牌 剩下 三张底牌
 * 4、要牌（玩家名字） 三颗底牌给这名玩家 5、帮我们 码牌 从左 往右，从大到小 排序
 */

public class Poker {
	public ArrayList<String> buyNewPoker() {
		ArrayList<String> buyPoker = new ArrayList<String>();
		buyPoker.add("大王");
		buyPoker.add("小王");
		String[] s1 = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		String[] s2 = { "♣", "♦", "♥", "♠" };
		for (int i = 0; i < s1.length; i++)
			for (int j = 0; j < s2.length; j++) {
				buyPoker.add(s2[j] + s1[i]);
			}
		return buyPoker;
	}

	public void printPoker(ArrayList<String> poker) {
		for (String x : poker)
			System.out.print(x + "\t");
		System.out.println();
	}

	public ArrayList<String> washPoker(ArrayList<String> buyPoker) {
		ArrayList<String> newPoker = new ArrayList<String>();
		Random random = new Random();
		int i;
		while (buyPoker.size() > 0) {
			i = random.nextInt(buyPoker.size());
			newPoker.add(buyPoker.remove(i));
		}
		return newPoker;
	}

	public void yaoPoker(ArrayList<String> diCard, Player[] players, String name) {
		for (int i = 0; i < players.length; i++) {
			if (players[i].getNickname().equals(name)) {
				players[i].getPokers().addAll(diCard);
				break;
			}
		}
	}

	public ArrayList<String> orderPoker(ArrayList<String> oldPoker) {
		ArrayList<String> orderPoker = new ArrayList<>();
		String[] rule = { "大王", "小王", "2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3" };
		for (int i = 0; i < rule.length; i++) {
			for (int j = 0; j < oldPoker.size(); j++) {
				if (oldPoker.get(j).contains(rule[i])) {
					orderPoker.add(oldPoker.remove(j));
					j--;
				}
			}
		}
		return orderPoker;
	}

	public Object[] sendPoker(ArrayList<String> washedCard) {
		ArrayList<String> player1 = new ArrayList<>();
		ArrayList<String> player2 = new ArrayList<>();
		ArrayList<String> player3 = new ArrayList<>();
		for (int i = 0; i < washedCard.size() - 3; i += 3) {
			player1.add(washedCard.get(i));
			player2.add(washedCard.get(i + 1));
			player3.add(washedCard.get(i + 2));
		}
		ArrayList<String> diCard = new ArrayList<>();
		diCard.addAll(washedCard.subList(washedCard.size() - 3, washedCard.size()));

		Object[] objs = { player1, player2, player3, diCard };
		return objs;
	}

	public void playPoker(Player[] player) {
		Player temp = new Player();
		for (int i = 0; i < player.length; i++) {
			if (player[i].getPokers().size() == 20) {
				temp = player[0];
				player[0] = player[i];
				player[i] = temp; // 地主为player[0],
			}
		}
		int i = 0;
		HashMap<String, Object> last = new HashMap<>();
		last.put("dizhu", 1);// 地主走牌
		// size 玩家手中剩余的牌
		// "cishu记录连续要不起的次数
		// "last玩家走的是什么牌
		// "nums玩家走了几张牌
		// "name赢家姓名

		while (true) {
			if ((Integer) last.get("dizhu") == 1) {// 刚开始地主出牌
				last.put("dizhu", 0);
				last = chuPoker(player[i]);
				i++;
				continue;
			}

			// 如果size=0,表示牌已打完
			if ((Integer) last.get("size") == 0) {
				System.out.println(last.get("name") + "获胜！");
				break;
			}
			// 如果cishu=2,表示无人要牌
			if ((Integer) last.get("cishu") == 2) {
				last.put("cishu", 0);
				last = chuPoker(player[i]);
				i++;
				if (i == 3) {
					i = i - 3;
				}
				continue;
			} else {
				last = guanPoker(last, player[i]);
				i++;
				if (i == 3) {
					i = i - 3;
					continue;
				}
			}
		}
	}

	// 出牌
	public HashMap<String, Object> chuPoker(Player player) {
		HashMap last = new HashMap<>();
		last.put("dizhu", 0);
		last.put("cishu", 0);
		last.put("size", 1);
		String[] mianzhi = { "大王", "小王", "2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3" };
		// 出对子
		System.out.println();
		for (int i = player.getPokers().size() - 1; i > 0; i--) {
			for (int j = mianzhi.length - 1; j > 0; j--) {
				if (player.getPokers().get(i).contains(mianzhi[j])
						&& player.getPokers().get(i - 1).contains(mianzhi[j])) {
					System.out.print(player.getNickname() + ":\t" + player.getPokers().get(i) + "\t"
							+ player.getPokers().get(i - 1));
					last.put("last", mianzhi[j]);
					last.put("nums", 2);
					player.getPokers().remove(i);
					player.getPokers().remove(i - 1);
					last.put("size", player.getPokers().size());
					System.out.println("(还剩 " + player.getPokers().size() + " 张)");
					if (player.getPokers().size() == 0) {
						last.put("name", player.getNickname());
						last.put("size", 0);
						return last;
					}
					return last;
				}
			}
		}
		// 出单牌
		for (int i = mianzhi.length - 1; i >= 0; i--) {
			if (player.getPokers().get(player.getPokers().size() - 1).contains(mianzhi[i])) {
				System.out.print(player.getNickname() + ":\t" + player.getPokers().get(player.getPokers().size() - 1));
				last.put("last", (mianzhi[i]));
				last.put("nums", 1);
				player.getPokers().remove(player.getPokers().size() - 1);
				last.put("size", player.getPokers().size());
				System.out.println("(还剩 " + player.getPokers().size() + " 张)");
				if (player.getPokers().size() == 0) {
					last.put("name", player.getNickname());
					return last;
				}
				return last;
			}
		}
		return last;
	}

	public HashMap<String, Object> guanPoker(HashMap last, Player player) {
		String[] mianzhi = { "大王", "小王", "2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3" };
		int temp = 0;
		for (int i = 0; i < mianzhi.length; i++) {
			if (last.get("last").equals(mianzhi[i])) {
				temp = i;
				break;
			}
		}
		if ((Integer) last.get("nums") == 2) {
			for (int i = temp - 1; i > 0; i--) {
				for (int j = player.getPokers().size() - 1; j > 0; j--) {
					if (player.getPokers().get(j).contains(mianzhi[i])
							&& player.getPokers().get(j - 1).contains(mianzhi[i])) {
						System.out.print(player.getNickname() + ":\t" + player.getPokers().get(j) + "\t"
								+ player.getPokers().get(j - 1));
						last.put("last", mianzhi[i]);
						last.put("cishu", 0);
						last.put("nums", 2);
						player.getPokers().remove(player.getPokers().get(j));
						player.getPokers().remove(player.getPokers().get(j - 1));
						last.put("size", player.getPokers().size());
						System.out.println("(还剩 " + player.getPokers().size() + " 张)");
						if (player.getPokers().size() == 0) {
							last.put("name", player.getNickname());
							return last;
						}
						return last;
					}
				}
			}
			last.put("cishu", (Integer) last.get("cishu") + 1);
			System.out.println(player.getNickname() + "：要不起。");
			return last;
		}
		if ((Integer) last.get("nums") == 1) {
			for (int i = temp - 1; i >= 0; i--) {
				for (int j = player.getPokers().size() - 1; j >= 0; j--) {
					if (player.getPokers().get(j).contains(mianzhi[i])) {
						System.out.print(player.getNickname() + ":\t" + player.getPokers().get(j));
						last.put("last", mianzhi[i]);
						last.put("nums", 1);
						last.put("cishu", 0);
						player.getPokers().remove(player.getPokers().get(j));
						last.put("size", player.getPokers().size());
						System.out.println("(还剩 " + player.getPokers().size() + " 张)");
						if (player.getPokers().size() == 0) {
							last.put("name", player.getNickname());
							return last;
						}
						return last;
					}
				}
			}
		}
		last.put("cishu", (Integer) last.get("cishu") + 1);
		System.out.println(player.getNickname() + "：要不起！");
		return last;
	}

	public static void main(String[] args) {
		Poker obj = new Poker();
		ArrayList<String> buyPoker = obj.buyNewPoker();// 新牌
		// System.out.println("新买的牌如下：");
		// obj.printPoker(buyPoker);
		ArrayList<String> washedPoker = obj.washPoker(buyPoker);// 洗过的牌
		// System.out.println("\n洗过的牌如下：");
		// obj.printPoker(washedPoker);
		Player p1 = new Player(0, "小兔兔");
		Player p2 = new Player(0, "小猫咪");
		Player p3 = new Player(0, "小乌龟");
		Player[] players = { p1, p2, p3 };
		Object[] a = obj.sendPoker(washedPoker);// a保存玩家与底牌4个元素
		p1.setPokers((ArrayList<String>) a[0]);
		p2.setPokers((ArrayList<String>) a[1]);
		p3.setPokers((ArrayList<String>) a[2]);
		ArrayList<String> diCard = (ArrayList<String>) a[3];
		// System.out.println("\n发到的牌如下：");
		// System.out.print(p1.getNickname() + "\t:");
		// obj.printPoker(p1.getPokers());
		// System.out.print(p2.getNickname() + "\t:");
		// obj.printPoker(p2.getPokers());
		// System.out.print(p3.getNickname() + "\t:");
		// obj.printPoker(p3.getPokers());
		// System.out.print("底牌\t:");
		// obj.printPoker(diCard);
		// System.out.println("\n小猫咪要牌");
		obj.yaoPoker(diCard, players, "小猫咪");
		p1.setPokers(obj.orderPoker(p1.getPokers()));
		p2.setPokers(obj.orderPoker(p2.getPokers()));
		p3.setPokers(obj.orderPoker(p3.getPokers()));
		// System.out.println("\n整理后的牌如下：");
		System.out.print(p1.getNickname() + "\t:");
		obj.printPoker(p1.getPokers());
		System.out.print(p2.getNickname() + "\t:");
		obj.printPoker(p2.getPokers());
		System.out.print(p3.getNickname() + "\t:");
		obj.printPoker(p3.getPokers());
		obj.playPoker(players);
	}

}
