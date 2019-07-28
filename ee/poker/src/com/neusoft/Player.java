package com.neusoft;

import java.util.ArrayList;

public class Player {
private int score;
private String Nickname;
private ArrayList<String> pokers;
public int getScore() {
	return score;
}
public void setScore(int score) {
	this.score = score;
}
public String getNickname() {
	return Nickname;
}
public void setNickname(String Nickname) {
	this.Nickname = Nickname;
}
public ArrayList<String> getPokers() {
	return pokers;
}
public void setPokers(ArrayList<String> player) {
	this.pokers = player;
}

public Player() {
	// TODO Auto-generated constructor stub
}
public Player(int score,String Nickname) {
	this.Nickname = Nickname;
	this.score=score;
}




}
