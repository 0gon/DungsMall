package receipt.model;

import java.util.ArrayList;
import java.util.List;

public class ReceiptList {
	private int no;
	private String memberid;
	private String date;
	private List<ReceiptDetail> detail;

	public ReceiptList(int no, String memberid, String date) {
		super();
		this.no = no;
		this.memberid = memberid;
		this.date = date;
		this.detail = new ArrayList<>();
	}

	public List<ReceiptDetail> getDetail() {
		return detail;
	}

	public void setDetail(List<ReceiptDetail> list) {
		this.detail = list;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ReceiptList [no=" + no + ", memberid=" + memberid + ", date=" + date + "]" + detail; 
	}


}
