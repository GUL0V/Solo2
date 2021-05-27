package lv.edijs.solo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class AnonymusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anonymus);
        Intent intent = new Intent(AnonymusActivity.this, NotMainActivity.class);
        intent.putExtra("type", "Lite");
        startActivity(intent);
    }
}