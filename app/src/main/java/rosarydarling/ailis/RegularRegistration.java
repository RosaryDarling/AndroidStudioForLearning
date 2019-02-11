package rosarydarling.ailis;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import rosarydarling.ailis.R;

public class RegularRegistration extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase sqLiteDatabase;
    Button register, login;
    EditText email, name, lastName, password, phonenum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        openHelper = new DatabaseHelper(this);
        setContentView(R.layout.regular_registration);
        register = (Button)findViewById (R.id.btnRegister);
        login = (Button)findViewById (R.id.btnLogin);
        email = (EditText)findViewById(R.id.txtEmail);
        name = (EditText)findViewById(R.id.txtName);
        lastName = (EditText)findViewById(R.id.txtLName);
        password = (EditText)findViewById(R.id.txtPassword);
        phonenum = (EditText)findViewById(R.id.txtPhoneN);



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLiteDatabase = openHelper.getWritableDatabase();
                String rremail = email.getText().toString();
                String rrname = name.getText().toString();
                String rrlname = lastName.getText().toString();
                String rrpassword = password.getText().toString();
                String rrphonenum = phonenum.getText().toString();

                insertData(rremail, rrname, rrlname, rrpassword, rrphonenum);
                Toast.makeText(getApplicationContext(), "Registration is Done!", Toast.LENGTH_LONG).show();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegularRegistration.this, LoginMain.class);
                startActivity(intent);
            }
        });
    }


    public void insertData (String rremail, String rrname, String rrlname, String rrpassword, String rrphonenum){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COLUMN_2, rremail);
        contentValues.put(DatabaseHelper.COLUMN_5, rrname);
        contentValues.put(DatabaseHelper.COLUMN_6, rrlname);
        contentValues.put(DatabaseHelper.COLUMN_3, rrpassword);
        contentValues.put(DatabaseHelper.COLUMN_4, rrphonenum);

        long id = sqLiteDatabase.insert(DatabaseHelper.TABLE1_NAME, null, contentValues);

    }



}
