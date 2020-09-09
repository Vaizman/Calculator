package by.bstu.kvv.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean isMale=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] peopleActivity = {" Сидячий образ жизни", "занятия 1-3 раз в неделю", "занятия 3-5 раз в неделю", "занятия 6-7 раз в неделю", "Спортсмен"};

        Spinner spinner = (Spinner) findViewById(R.id.personActivity);
        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, peopleActivity);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinner.setAdapter(adapter);


        RadioButton male = findViewById(R.id.male);
        male.setChecked(true);
    }

    public void Result(View view) {

        int abmr=0;
        double bmr;
        double[] amr={1.2,1.375,1.55,1.725,1.9};
        EditText eta = findViewById(R.id.age);
        EditText etm = findViewById(R.id.massa);
        EditText etr = findViewById(R.id.Rost);
        Spinner spinner = (Spinner) findViewById(R.id.personActivity);

        RadioButton female = findViewById(R.id.female);
        if (female.isChecked())
        {
            isMale=false;
        }
        else{isMale=true;}

        if (eta.getText().toString().isEmpty()||etm.getText().toString().isEmpty()||etr.getText().toString().isEmpty())
        {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Заполните все поля!", Toast.LENGTH_SHORT);
            toast.show();
        }
        else
        {
            String age = eta.getText().toString();
            String massa = etm.getText().toString();
            String rost = etm.getText().toString();

            if(isMale)
            {
                bmr= (int) (66.473+(13.7516*Integer.parseInt(massa))+(5.0033*Integer.parseInt(rost))-(6.755*Integer.parseInt(age)));
                abmr=(int)(amr[spinner.getSelectedItemPosition()]*bmr);
            }
            else
            {
                bmr= (int) (66.0955+(9.5634*Integer.parseInt(massa))+(1.8496*Integer.parseInt(rost))-(4.6756*Integer.parseInt(age)));
                abmr=(int)(amr[spinner.getSelectedItemPosition()]*bmr);
            }

            TextView textResult = findViewById(R.id.textResult);
            textResult.setText(""+abmr);
        }


    }
}