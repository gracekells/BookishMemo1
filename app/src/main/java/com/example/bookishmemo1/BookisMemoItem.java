package com.example.bookishmemo1;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class BookisMemoItem implements Parcelable {
	@SerializedName("success")
	private int success;

	@SerializedName("message")
	private String message;

	private String sipnosis;
	private String namaBuku;
	private String author;
	private String genre;
	private String linkGambar;
	private String id;
	private String tahunTerbit;

	protected BookisMemoItem(Parcel in) {
		sipnosis = in.readString();
		namaBuku = in.readString();
		author = in.readString();
		genre = in.readString();
		linkGambar = in.readString();
		id = in.readString();
		tahunTerbit = in.readString();
	}

	public static final Creator<BookisMemoItem> CREATOR = new Creator<BookisMemoItem>() {
		@Override
		public BookisMemoItem createFromParcel(Parcel in) {
			return new BookisMemoItem(in);
		}

		@Override
		public BookisMemoItem[] newArray(int size) {
			return new BookisMemoItem[size];
		}
	};

	public void setSipnosis(String sipnosis){
		this.sipnosis = sipnosis;
	}

	public String getSipnosis(){
		return sipnosis;
	}

	public void setNamaBuku(String namaBuku){
		this.namaBuku = namaBuku;
	}

	public String getNamaBuku(){
		return namaBuku;
	}

	public void setAuthor(String author){
		this.author = author;
	}

	public String getAuthor(){
		return author;
	}

	public void setGenre(String genre){
		this.genre = genre;
	}

	public String getGenre(){
		return genre;
	}

	public void setLinkGambar(String linkGambar){
		this.linkGambar = linkGambar;
	}

	public String getLinkGambar(){
		return linkGambar;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setTahunTerbit(String tahunTerbit){
		this.tahunTerbit = tahunTerbit;
	}

	public String getTahunTerbit(){
		return tahunTerbit;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(@NonNull Parcel dest, int flags) {
		dest.writeString(sipnosis);
		dest.writeString(namaBuku);
		dest.writeString(author);
		dest.writeString(genre);
		dest.writeString(linkGambar);
		dest.writeString(id);
		dest.writeString(tahunTerbit);
	}

	public int getSuccess() { return success;}

	public String getMessage() {
		return message;
	}

}
