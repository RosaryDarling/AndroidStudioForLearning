package rosarydarling.ailis;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="Registration.db";

    private static final int DATABASE_VERSION = 1;

    public static final String TABLE1_NAME = "Regular_Registration";
    public static final String TABLE2_NAME = "Business_Registration";

    public  static final String COLUMN_1 = "ID";
    public  static final String COLUMN_2 = "email";
    public  static final String COLUMN_3 = "password";
    public  static final String COLUMN_4 = "phone";
    public  static final String COLUMN_5 = "firstName";
    public  static final String COLUMN_6 = "lastName";


    public  static final String COL_1 = "ID";
    public  static final String COL_2 = "email";
    public  static final String COL_3 = "password";
    public  static final String COL_4 = "phone";
    public  static final String COL_5 = "address";
    public  static final String COL_6 = "web";
    public  static final String COL_7 = "businessName";
    public  static final String COL_8 = "firstName";
    public  static final String COL_9 = "lastName";

    private static final String tableBusinessRegistration = "CREATE TABLE IF NOT EXISTS " + TABLE2_NAME + " (" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_2 + " TEXT, " + COL_3 + " TEXT, " +  COL_4 + " TEXT, " + COL_5 + " TEXT, " + COL_6 + " TEXT, " + COL_7 + " TEXT, " + COL_8 + " TEXT" + ")";

    private static final String tableRegularRegistration = "CREATE TABLE IF NOT EXISTS " + TABLE1_NAME + "(" + COLUMN_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +  COLUMN_2 + " TEXT, " + COLUMN_3 + " TEXT, " + COLUMN_4 + " TEXT, " + COLUMN_5 + " TEXT, " + COLUMN_6 + " TEXT" + ")";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(tableBusinessRegistration);
        sqLiteDatabase.execSQL(tableRegularRegistration);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " +TABLE2_NAME); //drop older table if exists
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " +TABLE1_NAME);
        onCreate(sqLiteDatabase);


    }
}

