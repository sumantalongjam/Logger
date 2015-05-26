package in.blogspot.longjamcode.logger;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sumanta on 27/5/15.
 */
public class LoggerSqLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "logger.db";
    private static final int DATABASE_VERSION = 1;

    public static final String LOGGER_TABLE = "logger";
    private final String CREATE_TABLE_LOGGER = "CREATE TABLE " +LOGGER_TABLE+ " ( error  TEXT );";
    private static LoggerSqLiteHelper loggerSqLiteHelper;

    private LoggerSqLiteHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static LoggerSqLiteHelper getLoggerSqLiteHelper(Context context) {
        if(loggerSqLiteHelper == null) {
            loggerSqLiteHelper = new LoggerSqLiteHelper(context);
        }
        return loggerSqLiteHelper;
    }
    public static SQLiteDatabase getWritableDatabase(Context context) {
        return getLoggerSqLiteHelper(context).getWritableDatabase();
    }
    public static void closeDatabase(Context context) {
        getLoggerSqLiteHelper(context).close();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_LOGGER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }
}
