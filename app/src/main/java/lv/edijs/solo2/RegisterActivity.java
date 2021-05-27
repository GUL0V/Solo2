package lv.edijs.solo2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterActivity extends AppCompatActivity {

    DatabaseReference firebaseDatabase;
    EditText name, surname, username, password, password2;
    RelativeLayout btn_login;
    RelativeLayout progress_circular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = findViewById(R.id.names);
        surname = findViewById(R.id.surnames);
        username = findViewById(R.id.usernames);
        password = findViewById(R.id.passwords);
        password2 = findViewById(R.id.passwords2);
        btn_login = findViewById(R.id.btn_login);

        progress_circular = findViewById(R.id.progress_circular);

        firebaseDatabase = FirebaseDatabase.getInstance().getReference();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(password2.getText().toString().equals(password.getText().toString())){

                    firebaseDatabase.child("account").child("name").setValue(name.getText().toString());
                    firebaseDatabase.child("account").child("surname").setValue(surname.getText().toString());
                    firebaseDatabase.child("account").child("login").setValue(username.getText().toString());
                    firebaseDatabase.child("account").child("password").setValue(password.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        RegisterActivity.this.finish();
                                        Toast.makeText(getApplicationContext(), "Успешно зарегистрирован!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(getApplicationContext(), "Ошибка регистрации!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                }
                else{
                    Toast.makeText(getApplicationContext(), "Пароли не совпадают", Toast.LENGTH_SHORT).show();
                    progress_circular.setVisibility(View.GONE);
                }
            }
        });


    }

}