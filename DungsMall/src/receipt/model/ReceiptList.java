package receipt.model;

import java.sql.Date;
import java.time.LocalDate;

public class ReceiptList {
	private int no;
	private String memberid;
	private LocalDate date;

	public ReceiptList(int no, String memberid, LocalDate date) {
		super();
		this.no = no;
		this.memberid = memberid;
		this.date = date;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ReceiptList [no=" + no + ", memberid=" + memberid + ", date=" + date + "]";
	}


}
