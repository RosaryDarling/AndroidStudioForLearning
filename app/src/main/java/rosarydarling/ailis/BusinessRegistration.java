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

public class BusinessRegistration extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase sqLiteDatabase;
    Button register, login;
    EditText bname, blastname, bemail, bphone, baddress, bweb, bbname, bpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        openHelper = new DatabaseHelper(this);
        setContentView(R.layout.activity_business_registration);
        register = (Button) findViewById(R.id.btn_br_register);
        login = (Button) findViewById(R.id.btn_br_login);
        bname = (EditText) findViewById(R.id.txt_br_Name);
        blastname = (EditText) findViewById(R.id.txt_br_lname);
        bemail = (EditText) findViewById(R.id.txt_br_email);
        bphone = (EditText) findViewById(R.id.txt_br_phonen);
        baddress = (EditText) findViewById(R.id.txt_br_address);
        bweb = (EditText) findViewById(R.id.txt_br_website);
        bbname = (EditText) findViewById(R.id.txt_br_bname);
        bpassword = (EditText) findViewById(R.id.txt_br_password);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqLiteDatabase = openHelper.getWritableDatabase();
                String brname = bname.getText().toString();
                String brlastname = blastname.getText().toString();
                String bremail = bemail.getText().toString();
                String brphone = bphone.getText().toString();
                String braddress = baddress.getText().toString();
                String brweb = bweb.getText().toString();
                String brbname = bbname.getText().toString();
                String brpassword = bpassword.getText().toString();

                insertBData(brname, brlastname, bremail, brphone, braddress, brweb, brbname, brpassword);
                Toast.makeText(getApplicationContext(), "Registration is Done!", Toast.LENGTH_LONG).show();

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BusinessRegistration.this, LoginMain.class);
                startActivity(intent);
            }
        });

    }


    public void insertBData (String brname, String brlastname, String bremail, String brphone, String braddress,  String brweb, String brbname, String brpassword){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_8, brname);
        contentValues.put(DatabaseHelper.COL_9, brlastname);
        contentValues.put(DatabaseHelper.COL_2, bremail);
        contentValues.put(DatabaseHelper.COL_4, brphone);
        contentValues.put(DatabaseHelper.COL_5, braddress);
        contentValues.put(DatabaseHelper.COL_6, brweb);
        contentValues.put(DatabaseHelper.COL_7, brbname);
        contentValues.put(DatabaseHelper.COL_3, brpassword);

        long id = sqLiteDatabase.insert(DatabaseHelper.TABLE2_NAME, null, contentValues);
    }

}
