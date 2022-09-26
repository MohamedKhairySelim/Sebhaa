package com.Tasbeh.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sebhaa.R;

import java.util.ArrayList;
public class ZeKer_page extends AppCompatActivity {

    private ArrayList<String>AzKar_Array;
    private ArrayAdapter<String>AzKar_Array_Adapter;
    final int My_Req_Code = 1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zeker_page);

        ListView azKar_List_View = findViewById(R.id.Zeker_List_View);

        AzKar_Array=new ArrayList<>();

        AzKar_Array.add("سُبْحَانَ اللَّهِ.");
        AzKar_Array.add("الْحَمْدُ للّهِ رَبِّ الْعَالَمِينَ.");
        AzKar_Array.add("الْلَّهُ أَكْبَرُ.");
        AzKar_Array.add("لَا إِلَهَ إِلَّا اللَّهُ.");
        AzKar_Array.add("لا حَوْلَ وَلا قُوَّةَ إِلا بِاللَّهِ.");
        AzKar_Array.add("سُبْحَانَ اللَّهِ وَبِحَمْدِهِ, سُبْحَانَ اللَّهِ الْعَظِيمِ. ");
        AzKar_Array.add("لَا إلَه إلّا اللهُ وَحْدَهُ لَا شَرِيكَ لَهُ, لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ وَهُوَ عَلَى كُلُّ شَيْءِ قَدِيرِ.");
        AzKar_Array.add("أستغفر الله");
        AzKar_Array.add("اللهم صل صلاة كاملة وسلم سلاما تاما علي سيدنا محمد الذى تنحل به العقد وتنفرج به الكرب وتقضى به الحوائج وتنال به الرغائب وحسن الخواتيم ويستسقى الغمام بنور وجهه الكريم وعلى اله فى كل لمحة ونفس بعدد كل معلوم لك يا الله ياحي ياقيوم");
        AzKar_Array.add("الله أكبر كبيرا,والحمد لله كثيرا,وسبحان الله بكرة وأصيلا");
        AzKar_Array.add("سُبْحَانَ الْلَّهِ, وَالْحَمْدُ لِلَّهِ, وَلَا إِلَهَ إِلَّا الْلَّهُ, وَالْلَّهُ أَكْبَرُ.");
        AzKar_Array.add("سُبْحَانَ اللَّهِ وَبِحَمْدِهِ.");
        AzKar_Array.add("سُبْحَانَ اللَّهِ وَالْحَمْدُ لِلَّهِ.");
        AzKar_Array.add("سُبْحَانَ اللهِ العَظِيمِ وَبِحَمْدِهِ.");
        AzKar_Array.add("الْلَّهُم صَلِّ وَسَلِم وَبَارِك عَلَى سَيِّدِنَا مُحَمَّد.");

        AzKar_Array_Adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,AzKar_Array);

    azKar_List_View.setAdapter(AzKar_Array_Adapter);

    azKar_List_View.setOnItemClickListener((parent, view, position, id) -> {

        String choice_ZeKer=parent.getItemAtPosition(position).toString();
        setResult(RESULT_OK,new Intent().putExtra("ZeKer_that_choice",choice_ZeKer));
        finish();

    });
    }


/***/
    public void gotoAdd_ZeKer_page(View view) {

    startActivityForResult(new Intent(this, Write_ZeKer.class),My_Req_Code);

    }
/***/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    if (requestCode==My_Req_Code){

            if (resultCode==RESULT_OK){

                if (!AzKar_Array.contains(data.getStringExtra("New input"))){

                    AzKar_Array_Adapter.add(data.getStringExtra("New input"));

                }else {

                    Toast.makeText(this, "هذا الذكر متواجد بالفعل ", Toast.LENGTH_LONG).show();

                }
            }
        }
    }
}
