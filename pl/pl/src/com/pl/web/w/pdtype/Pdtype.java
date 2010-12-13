package com.pl.web.w.pdtype;

import java.util.List;

public class Pdtype {
    private Short seq;
    private String pdtypeName1;
    private String pdtypeName2;
    private String pdtypeName3;
    private String level;
    private List<Pdtype> childrens;
	public Short getSeq() {
		return seq;
	}
	public void setSeq(Short seq) {
		this.seq = seq;
	}
	public String getPdtypeName1() {
		return pdtypeName1;
	}
	public void setPdtypeName1(String pdtypeName1) {
		this.pdtypeName1 = pdtypeName1;
	}
	public String getPdtypeName2() {
		return pdtypeName2;
	}
	public void setPdtypeName2(String pdtypeName2) {
		this.pdtypeName2 = pdtypeName2;
	}
	public String getPdtypeName3() {
		return pdtypeName3;
	}
	public void setPdtypeName3(String pdtypeName3) {
		this.pdtypeName3 = pdtypeName3;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public List<Pdtype> getChildrens() {
		return childrens;
	}
	public void setChildrens(List<Pdtype> childrens) {
		this.childrens = childrens;
	}
}