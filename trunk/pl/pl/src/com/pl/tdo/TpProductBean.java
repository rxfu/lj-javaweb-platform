package com.pl.tdo;

import java.io.File;

public class TpProductBean {

    private String productId;
    private String productNameSimple;
    private String productName;
    private File imagfile;
    private String imagfileFileName;
    private String imagfileContentType;
    private String unit;
    private Float unitWeight;
    private Float priceCost;
    private Float priceSellP;
    private Float priceSellE;
    private Float priceMarket;
    private Integer inventory;
    private String brand;
    private String productIntroduction;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductNameSimple() {
		return productNameSimple;
	}
	public void setProductNameSimple(String productNameSimple) {
		this.productNameSimple = productNameSimple;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getImagfileFileName() {
		return imagfileFileName;
	}
	public void setImagfileFileName(String imagfileFileName) {
		this.imagfileFileName = imagfileFileName;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Float getUnitWeight() {
		return unitWeight;
	}
	public void setUnitWeight(Float unitWeight) {
		this.unitWeight = unitWeight;
	}
	public Float getPriceCost() {
		return priceCost;
	}
	public void setPriceCost(Float priceCost) {
		this.priceCost = priceCost;
	}
	public Float getPriceSellP() {
		return priceSellP;
	}
	public void setPriceSellP(Float priceSellP) {
		this.priceSellP = priceSellP;
	}
	public Float getPriceSellE() {
		return priceSellE;
	}
	public void setPriceSellE(Float priceSellE) {
		this.priceSellE = priceSellE;
	}
	public Float getPriceMarket() {
		return priceMarket;
	}
	public void setPriceMarket(Float priceMarket) {
		this.priceMarket = priceMarket;
	}
	public Integer getInventory() {
		return inventory;
	}
	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getProductIntroduction() {
		return productIntroduction;
	}
	public void setProductIntroduction(String productIntroduction) {
		this.productIntroduction = productIntroduction;
	}
	public File getImagfile() {
		return imagfile;
	}
	public void setImagfile(File imagfile) {
		this.imagfile = imagfile;
	}
	public String getImagfileContentType() {
		return imagfileContentType;
	}
	public void setImagfileContentType(String imagfileContentType) {
		this.imagfileContentType = imagfileContentType;
	}

}