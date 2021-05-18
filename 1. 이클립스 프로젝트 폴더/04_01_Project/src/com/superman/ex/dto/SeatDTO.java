package com.superman.ex.dto;

public class SeatDTO {
	private long seat_id;
	private long time_id;
	private String member_id;
	private int row;
	private int column;
	private int area;
	private int type;
	
	public long getSeat_id() {
		return seat_id;
	}
	public void setSeat_id(long seat_id) {
		this.seat_id = seat_id;
	}
	public long getTime_id() {
		return time_id;
	}
	public void setTime_id(long time_id) {
		this.time_id = time_id;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
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
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}
