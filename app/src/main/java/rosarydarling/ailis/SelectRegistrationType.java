package rosarydarling.ailis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectRegistrationType extends AppCompatActivity {

    Button rregistration, brregistration, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_registration_type);

        rregistration = (Button) findViewById(R.id.btn_rregistration);
        brregistration = (Button) findViewById(R.id.btn_brregistration);
        login = (Button)findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(SelectRegistrationType.this, LoginMain.class);
                startActivity(intent3);
            }
        });

        rregistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(SelectRegistrationType.this, RegularRegistration.class);
                startActivity(intent4);
            }
        });

        brregistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(SelectRegistrationType.this, BusinessRegistration.class);
                startActivity(intent5);
            }
        });


    }
}
