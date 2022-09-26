package com.Tasbeh.Activity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;


import com.example.sebhaa.R;
import com.github.barteksc.pdfviewer.PDFView;


public class MainActivity extends AppCompatActivity {

    private TextView T_V_Counter,new_ZeKer_Setter;
    private Animation Anim;
    static int Counter;
    final int My_Req_Code = 1 ;
    private PDFView pdfView;

//    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pdfView=findViewById(R.id.pdfView);
        T_V_Counter=findViewById(R.id.Counter);
        new_ZeKer_Setter=findViewById(R.id.Set_New_ZeKer);
        Anim= AnimationUtils.loadAnimation(this,R.anim.animation);

    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    public void Count_Clicker(View view) {

        switch (view.getId()){

            case R.id.Start_Button:
                T_V_Counter.setText(++Counter+"");
                break;

            case R.id.Reset_Button:
                Counter=0;
                T_V_Counter.setText(Counter+"");
                break;

            case R.id.Set_New_ZeKer:
                startActivityForResult(new Intent(this, ZeKer_page.class),My_Req_Code);
                break;

            case R.id.Quran:
                pdfView.setVisibility(View.VISIBLE);
                pdfView.fromAsset("Quran.pdf").load();
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode , int resultCode , @Nullable Intent data) {
        super.onActivityResult(requestCode , resultCode , data);

        if (requestCode==My_Req_Code){

            if (resultCode==RESULT_OK){
              new_ZeKer_Setter.setText(data.getStringExtra("ZeKer_that_choice"));
              new_ZeKer_Setter.setAnimation(Anim);

                if (Anim.hasStarted()){
                 Anim.start();
                }

            }else {
                Toast.makeText(this," لم يتم اختيار ذكر",Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (pdfView.getVisibility()==View.VISIBLE){
            pdfView.setVisibility(View.GONE);
        }else {
            super.onBackPressed();
        }
    }

}
