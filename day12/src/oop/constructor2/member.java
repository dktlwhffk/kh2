package oop.constructor2;

public class member {
private String id,password,nick,authority;
private int point;

void setId(String id) {
	this.id=id;
}
String getId() {
	return this.id;
}


void setPassword(String password) {
	this.password=password;
}
String getPassword() {
	return this.password;
}


void setNick(String nick) {
	this.nick=nick;
}
String getNick() {
	return this.nick;
}


void setAuthority(String authority) {
//	if(authority=="") {
//		this.authority="일반";
//	} 
//	else {
//		this.authority=authority;		
//	}
	this.authority=authority;
}
String getAuthoirty() {
	return this.authority;
}


void setPoint(int point) {
	this.point=point;
}
int getPoint() {
	return this.point;
}

void set(String id, String password, String nick, String authority, int point) {
	this.setId(id);
	this.setPassword(password);
	this.setNick(nick);
	this.setAuthority(authority);
	this.setPoint(point);
}
void print() {
	System.out.println(id);
	System.out.println(password);
	if(nick.length()>=2&&nick.length()<=7) {
		System.out.println(nick);		
	} else {
		System.out.println("2~7자 사이로 입력하세요.");
	}
	switch(authority) {
	case "x": 
		System.out.println("일반");
		break;
	default :
		System.out.println(authority);
		break;
	}
	
//	else {
//		System.out.println(authority);
//	}
//	System.out.println(authority);
	System.out.println(point);
}
}