package com.superman.ex.dto;

public class ReservationDataDTO {
	String title;
	int room;
	String time;
	int row;
	int column;
	String id;
	long seat_id;
	
	public long getSeat_id() {
		return seat_id;
	}
	public void setSeat_id(long seat_id) {
		this.seat_id = seat_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
