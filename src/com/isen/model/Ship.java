package com.isen.model;

public class Ship {

	public String userMessage=null;
	int length;
	//ArrayList<Boolean> health =new ArrayList<>();
//	boolean[] health =new boolean[length];
	int health;
	int posX;
	int posY;
	int direction;//1:nord/2:est/3:sud/4:ouest

	public Ship() {
		// TODO Auto-generated constructor stub
	}

	public Ship(int length,int posX,int posY,int direction) {
		// TODO Auto-generated constructor stub
	this.length=length;
	this.health=length;
	this.posX=posX;
	this.posY=posY;
	this.direction=direction;
	}

	public void hitted(){
		health=health-1;
		if(isSank()){
			System.out.println("Bateau d'une longueur de "+this.length+" vient de couler.");
			userMessage="Bateau d'une longueur de "+this.length+" vient de couler.";
		}
	}

	public boolean isSank(){
		if(health==0){
			return true;
		}
		else return false;
	}

}
