package com.project.cuebue.dtb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.widget.Toast;

import com.project.cuebue.ProfileDetails;

import java.util.ArrayList;

public class DBHelper implements BaseColumns {

    private Context con;
    private SQLiteDatabase db;

    public static final String Use_Table = "Customer_Table";
    public static final String Use_BVN = "BVN";
    public static final String Use_BVN_Phone_no = "Namer";
    public static final String Use_name = "Name";
    public static final String Use_Password = "Password";

    public  DBHelper(Context con) {this.con = con;}

    public DBHelper OpenDB() {
        DBConnector dbcon = new DBConnector(con);
        db = dbcon.getWritableDatabase();
        return this;
    }

    //mapping the values
    public boolean RegisterUser(UserDetails userDetails) {
        try {
            ContentValues cv = new ContentValues();
            cv.put(Use_name, userDetails.getNameUser());
            cv.put(Use_Password, userDetails.getPsword());
            //insert new row
            db.insert(Use_Table, null, cv);
            return true;
        } catch (Exception e) {
            Toast.makeText(con, e.getMessage(), Toast.LENGTH_LONG).show();
            return false;
        }
    }
}
