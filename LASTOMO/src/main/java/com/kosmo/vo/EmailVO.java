package com.kosmo.vo;

public class EmailVO {
	private String subject;
	private String contents;
	private String sender;
	private String receiver;
	private int mseq;
	private String mmail;

	public String getMmail() {
		return mmail;
	}

	public void setMmail(String mmail) {
		this.mmail = mmail;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public int getMseq() {
		return mseq;
	}

	public void setMseq(int mseq) {
		this.mseq = mseq;
	}

}