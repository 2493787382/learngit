package com.example.test3;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Account implements Parcelable {
    private String username;
    private String gendnt;
    private int age;

    public Account(String name,String gender,int age){
        this.username = name;
        this.gendnt = gender;
        this.age = age;
    }

    @NonNull
    @Override
    public String toString() {
        return "Account[username="+username+",gendnt="+gendnt+",age="+age+"]";
    }

    @Override
    public int describeContents() {
        return 0;
    }
    public Account(Parcel in){
        username = in.readString();
        gendnt = in.readString();
        age = in.readInt();
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {//把当前类中的成员封装打包到
        dest.writeString(username);//与public Account里面的顺序相同
        dest.writeString(gendnt);
        dest.writeInt(age);
    }


    public static Parcelable.Creator<Account> CREATOR = new Parcelable.Creator<Account>(){
        @Override
        public Account createFromParcel(Parcel source) {//数据打包时，通过source给当前类赋值
            return new Account(source);
        }

        @Override
        public Account[] newArray(int size) {//创建数组
            return new Account[size];
        }
    };
}
