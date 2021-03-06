package com.infinitybiz.triviaapp.Data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.infinitybiz.triviaapp.Model.User

val DATABASENAME = "MY DATABASE"
val TABLENAME = "Users"
val COL_NAME = "name"
val COL_VALUE = "value"
val COL_LIST = "list"
val COL_TIME= "time"

val COL_ID = "id"
class DataBaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASENAME, null,
    1) {
    override fun onCreate(db: SQLiteDatabase?) {
        //Create Table
        val createTable = "CREATE TABLE " + TABLENAME + " (" + COL_ID + " INTEGER PRIMARY KEY " +
                "AUTOINCREMENT," + COL_NAME + " VARCHAR(256)," + COL_VALUE + " VARCHAR(256)," +
                COL_LIST + " VARCHAR(256)," + COL_TIME + " VARCHAR(256))"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
// Insert Data in table
    fun insertData(user: User) {

        val database = this.writableDatabase
        val contentValues = ContentValues() // create ContentValues
        contentValues.put(COL_NAME, user.name)
        contentValues.put(COL_VALUE, user.value)
        contentValues.put(COL_LIST, user.list)
        contentValues.put(COL_TIME, user.time)
        val result = database.insert(TABLENAME, null, contentValues)
        if (result == (0).toLong()) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
        }
    }

    // Read Data
    fun readData(): ArrayList<User> {
        val lists:ArrayList<User> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLENAME"
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            do {
                val user = User()
                user.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                user.name = result.getString(result.getColumnIndex(COL_NAME))
                user.value = result.getString(result.getColumnIndex(COL_VALUE))
                user.list = result.getString(result.getColumnIndex(COL_LIST))
                user.time = result.getString(result.getColumnIndex(COL_TIME))
                lists.add(user)
            }
            while (result.moveToNext())
        }
        return lists
    }
}