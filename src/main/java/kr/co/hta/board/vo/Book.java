package kr.co.hta.board.vo;

import java.util.Date;

public class Book {

	private Integer no;
	private String title;
	private String author;
	private String publisher;
	private String mainCategory;
	private String subCategory;
	private Integer fixPrice;
	private Double discountRate;
	private String status;
	
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getMainCategory() {
		return mainCategory;
	}
	public void setMainCategory(String mainCategory) {
		this.mainCategory = mainCategory;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public Integer getFixPrice() {
		return fixPrice;
	}
	public void setFixPrice(Integer fixPrice) {
		this.fixPrice = fixPrice;
	}
	public Double getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(Double discountRate) {
		this.discountRate = discountRate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Book [no=" + no + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", mainCategory=" + mainCategory + ", subCategory=" + subCategory + ", fixPrice=" + fixPrice
				+ ", discountRate=" + discountRate + ", status=" + status + "]";
	}
}