package rosarydarling.ailis;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import rosarydarling.ailis.R;

public class LoginMain extends AppCompatActivity {
    SQLiteDatabase sqLiteDatabase;
    SQLiteOpenHelper openHelper;
    Button btnRLogin; Button btnRegister; Button btnBLogin;
    EditText logEmail; EditText logPassword;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
        openHelper = new DatabaseHelper(this);
        sqLiteDatabase = openHelper.getReadableDatabase();
        btnRLogin = (Button)findViewById(R.id.btn_rrLogin);
        btnBLogin = (Button)findViewById(R.id.btn_brLogin);
        btnRegister = (Button)findViewById(R.id.btnRegister) ;
        logEmail = (EditText)findViewById(R.id.txtLogEmail);
        logPassword = (EditText)findViewById(R.id.txtLogPassword);

        btnRLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = logEmail.getText().toString();
                String password = logPassword.getText().toString();
                cursor = sqLiteDatabase.rawQuery(" SELECT * FROM "+ DatabaseHelper.TABLE1_NAME + " WHERE " + DatabaseHelper.COLUMN_2 + " =? AND " + DatabaseHelper.COLUMN_3 + " =? ", new String[]{email, password});
                if(cursor != null){
                    if(cursor.getCount()> 0){
                        cursor.moveToNext();
                        Toast.makeText(getApplicationContext(), "You logged in, yay!", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Oops, please try again", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

        btnBLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = logEmail.getText().toString();
                String password = logPassword.getText().toString();
                cursor = sqLiteDatabase.rawQuery(" SELECT * FROM "+ DatabaseHelper.TABLE2_NAME + " WHERE " + DatabaseHelper.COL_2 + " =? AND " + DatabaseHelper.COL_3 + " =? ", new String[]{email, password});
                if(cursor != null){
                    if(cursor.getCount()> 0){
                        cursor.moveToNext();
                        Toast.makeText(getApplicationContext(), "You logged in, yay!", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Oops, please try again", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginMain.this, SelectRegistrationType.class);
                startActivity(intent);
            }
        });
    }
}
