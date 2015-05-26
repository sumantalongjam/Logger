package in.blogspot.longjamcode.logger;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.Iterator;

/**
 * Created by sumanta on 27/5/15.
 */
public class DataHandler {
    public static void insertError (Context context, String error) {
        SQLiteDatabase db = LoggerSqLiteHelper.getWritableDatabase(context);
        try {
            ContentValues values = new ContentValues();
            values.put("error", error);
            db.insertWithOnConflict(LoggerSqLiteHelper.LOGGER_TABLE, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getAllError (Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        String selectQuery = "SELECT  * FROM " + LoggerSqLiteHelper.LOGGER_TABLE;
        SQLiteDatabase db = LoggerSqLiteHelper.getWritableDatabase(context);
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                stringBuilder.append(cursor.getString(0) + "\n\n\n\n");
            } while (cursor.moveToNext());
        }
        cursor.close();
        return stringBuilder.toString();
    }
    public static void clearAll (Context context) {
        SQLiteDatabase db = LoggerSqLiteHelper.getWritableDatabase(context);
        db.execSQL("delete from " + LoggerSqLiteHelper.LOGGER_TABLE);
    }
}
