package lv.edijs.solo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;


public class ChooseAuthClass extends AppCompatActivity {

    RelativeLayout btn_login1;
    RelativeLayout btn_login2;
    RelativeLayout btn_login3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_auth);

        btn_login1 = findViewById(R.id.btn_login);
        btn_login2 = findViewById(R.id.btn_login2);
        btn_login3 = findViewById(R.id.btn_login3);
        btn_login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseAuthClass.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btn_login2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseAuthClass.this, SignInActivity.class);
                startActivity(intent);
            }
        });

        btn_login3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseAuthClass.this, AnonymusActivity.class);
                startActivity(intent);
            }
        });

    }
}