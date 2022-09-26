package com.Tasbeh.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sebhaa.R;

public class Write_ZeKer extends AppCompatActivity {
    //we defined All Variables here
EditText E_TX_ZeKer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_zeker);
        E_TX_ZeKer=findViewById(R.id.Write_Zeker);
    }
//Take data from EditText when clicked on Button
    public void Write_zeKer(View view) {
        String write_zeKer=E_TX_ZeKer.getText().toString().trim();
        if (write_zeKer.equals("")){
            Toast.makeText(this,"لا يوجد شىء لعرضه",Toast.LENGTH_LONG).show();
        }else {
            setResult(RESULT_OK,new Intent().putExtra("New input",write_zeKer));
            Write_ZeKer.this.finish();
        }
    }

}
