package receipt.model;

public class ReceiptList {
	private int no;
	private String memberid;
	private String date;

	public ReceiptList(int no, String memberid, String date) {
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ReceiptList [no=" + no + ", memberid=" + memberid + ", date=" + date + "]";
	}


}
