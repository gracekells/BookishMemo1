package com.example.bookishmemo1;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataBuku implements Parcelable {

	@SerializedName("bookisMemo")
	private List<BookisMemoItem> bookisMemo;
	private int success;
	private String message;

	protected DataBuku(Parcel in) {
		bookisMemo = in.createTypedArrayList(BookisMemoItem.CREATOR);
		success = in.readInt();
		message = in.readString();
	}

	public static final Creator<DataBuku> CREATOR = new Creator<DataBuku>() {
		@Override
		public DataBuku createFromParcel(Parcel in) {
			return new DataBuku(in);
		}

		@Override
		public DataBuku[] newArray(int size) {
			return new DataBuku[size];
		}
	};

	public void setBookisMemo(List<BookisMemoItem> bookisMemo){
		this.bookisMemo = bookisMemo;
	}

	public List<BookisMemoItem> getBookisMemo(){
		return bookisMemo;
	}

	public void setSuccess(int success){
		this.success = success;
	}

	public int getSuccess(){
		return success;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(@NonNull Parcel dest, int flags) {
		dest.writeTypedList(bookisMemo);
		dest.writeInt(success);
		dest.writeString(message);
	}
}