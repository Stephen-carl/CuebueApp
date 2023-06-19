package com.project.cuebue.dtb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBConnector extends SQLiteOpenHelper {

    //signup
    public static final String Database_Name = "CueBue.db";
    public static final String User_Table = "Customer_Table";
    public static final String User_BVN = "BVN";
    public static final String User_BVN_Phone_no = "Phone_Number";
    public static final String User_name = "Name";
    public static final String User_Password = "Password";

    //profile
    public static final String Profile_Table = "Profile_Table";
    public static final String Profile_ID = "Profile_ID";
    public static final String Profile_BVN = User_BVN;
    public static final String Profile_Nickname = "NickName";
    public static final String Profile_Pin = "Profile_Pin";
    public static final String Profile_AcctNo = "Account_Number";
    public static final String Profile_AcctPhoneNumber = "Account_Phone_Number";
    public static final String Profile_AcctName = "Account_Name";

    //transaction_Type
    public static final String TransactionType_Table = "TransactionType";
    public static final String TransactionType_ID = "TransactionType_ID";
    public static final String Transaction_Type = "Transaction_Type";

    //transaction
    public static final String Transaction_Table = "Transaction_Table";
    public static final String Transaction_ID = "Transaction_ID";
    public static final String Transaction_BVN = User_BVN;
    public static final String Transaction_Type_id = TransactionType_ID;
    public static final String Transaction_ProfileID = Profile_ID;
    public static final String Transaction_Amount = "Amount";

    //transfer
    public static final String Transfer_Table = "Transfer_Table";
    public static final String Transfer_ID = "Transfer_ID";
    public static final String Trans_Transaction_ID = Transaction_ID;
    public static final String Transfer_BVN = User_BVN;
    public static final String TransProfile_ID = Profile_ID;
    public static final String Transfer_Amount = "Amount";
    public static final String Receiver_bank = "Receiver_bank";
    public static final String Receiver_name = "Receiver_name";

    //topUp
    public static final String TopUp_Table = "TopUp_Table";
    public static final String TopUp_ID = "TopUp_ID";
    public static final String TopUp_Transaction_ID = Transaction_ID;
    public static final String TopUp_BVN = User_BVN;
    public static final String TopUp_ProfileID = Profile_ID;
    public static final String TopUp_Amount = "Amount";
    public static final String TopUp_PhoneNumber = "Receiver_Phone_Number";


    public DBConnector(Context context) {
        super(context, Database_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(" CREATE TABLE "
                + User_Table + " ("
                + User_name + " VARCHAR, "
                + User_Password + " VARCHAR "
                + " );"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    private void createProfileStatement(SQLiteDatabase db) {
        db.execSQL(
                " CREATE TABLE "
                        + Profile_Table + " ("
                        + Profile_ID + " INT PRIMARY KEY AUTOINCREMENT, "
                        + Profile_BVN + " VARCHAR," //" FOREIGN KEY (" + Profile_BVN + ") REFERENCES " + User_Table + "(" + User_BVN + "),"
                        + Profile_Nickname + " TEXT, "
                        + Profile_Pin + " VARCHAR,"
                        + Profile_AcctNo + " VARCHAR, "
                        + Profile_AcctPhoneNumber + " VARCHAR, "
                        + Profile_AcctName + " VARCHAR, "
                        + " FOREIGN KEY (" + Profile_BVN + ") REFERENCES " + User_Table + "(" + User_BVN + ")"
                        + " );"
        );
    }

    private void createTransactionTypeStatement(SQLiteDatabase db) {
        db.execSQL(
                " CREATE TABLE "
                        + TransactionType_Table + " ("
                        + TransactionType_ID + " INT PRIMARY KEY AUTOINCREMENT, "
                        + Transaction_Type + " TEXT "
                        + " );"
        );
    }

    private void createTransactionStatement(SQLiteDatabase db) {
        db.execSQL(
                " CREATE TABLE "
                        + Transaction_Table + " ("
                        + Transaction_ID + " INT PRIMARY KEY, "
                        + Transaction_Type_id + " INT, "
                        + Transaction_BVN + " VARCHAR, "
                        + Transaction_ProfileID + " INT, "
                        + Transaction_Amount + " MONEY, "
                        + " FOREIGN KEY (" + Transaction_Type_id + ") REFERENCES " + TransactionType_Table + "(" + TransactionType_ID + "), "
                        + " FOREIGN KEY (" + Transaction_BVN + ") REFERENCES " + User_Table + "(" + User_BVN + "), "
                        + " FOREIGN KEY (" + Transaction_ProfileID + ") REFERENCES " + Profile_Table + "(" + Profile_ID + ") "
                        + " );"
        );
    }

    private void createTransferStatement(SQLiteDatabase db) {
        db.execSQL(
                " CREATE TABLE "
                        + Transfer_Table + " ("
                        + Transfer_ID + " INT PRIMARY KEY, "
                        + Trans_Transaction_ID + " INT, "
                        + Transfer_BVN + " VARCHAR,"
                        + TransProfile_ID + " INT, "
                        + Transfer_Amount + " MONEY, "
                        + Receiver_bank + " VARCHAR, "
                        + Receiver_name + " VARCHAR, "
                        + " FOREIGN KEY (" + Trans_Transaction_ID + ") REFERENCES " + Transaction_Table + "(" + Transaction_ID + "), "
                        + " FOREIGN KEY (" + Transfer_BVN + ") REFERENCES " + User_Table + "(" + User_BVN + "), "
                        + " FOREIGN KEY (" + TransProfile_ID + ") REFERENCES " + Profile_Table + "(" + Profile_ID + ") "
                        + " );"
        );
    }

    private void createTopUpStatement(SQLiteDatabase db) {
        db.execSQL(
                " CREATE TABLE "
                        + TopUp_Table + " ("
                        + TopUp_ID + " INT PRIMARY KEY, "
                        + TopUp_Transaction_ID + " INT, "
                        + TopUp_BVN + " VARCHAR,"
                        + TopUp_ProfileID + " INT, "
                        + TopUp_Amount + " MONEY, "
                        + TopUp_PhoneNumber + " VARCHAR, "
                        + " FOREIGN KEY (" + TopUp_Transaction_ID + ") REFERENCES " + Transaction_Table + "(" + Transaction_ID + "), "
                        + " FOREIGN KEY (" + TopUp_BVN + ") REFERENCES " + User_Table + "(" + User_BVN + "), "
                        + " FOREIGN KEY (" + TopUp_ProfileID + ") REFERENCES " + Profile_Table + "(" + Profile_ID + ") "
                        + " );"
        );
    }
}
