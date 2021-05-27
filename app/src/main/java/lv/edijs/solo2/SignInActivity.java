package lv.edijs.solo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignInActivity extends AppCompatActivity {

    DatabaseReference firebaseDatabase;
    String pass="", login="";
    EditText username, password;
    RelativeLayout btn_login;
    RelativeLayout progress_circular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        username = findViewById(R.id.usernames);
        password = findViewById(R.id.passwords);
        btn_login = findViewById(R.id.btn_login);
        progress_circular = findViewById(R.id.progress_circular);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progress_circular.setVisibility(View.VISIBLE);
                checkPassword();

            }
        });
        firebaseDatabase = FirebaseDatabase.getInstance().getReference();
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot snapshot) {
                login = snapshot.child("account").child("login").getValue(String.class);
                pass = snapshot.child("account").child("password").getValue(String.class);
                Log.d("TAGus", "onDataChange: "+login+password);
                progress_circular.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled( DatabaseError error) {
                progress_circular.setVisibility(View.GONE);
                Log.d("TAGus", "onDataChange: "+login+password+error);
            }
        };
        firebaseDatabase.addValueEventListener(valueEventListener);

    }

    public void checkPassword(){
        if(login.equals(username.getText().toString())&&pass.equals(password.getText().toString())){
            Intent intent = new Intent(SignInActivity.this, NotMainActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(), "Incorrect email/password", Toast.LENGTH_SHORT).show();
            progress_circular.setVisibility(View.GONE);
        }

    }
}