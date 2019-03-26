package br.edu.fapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder viewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.viewHolder.editValue = findViewById(R.id.edit_value);
        this.viewHolder.textDolar = findViewById(R.id.text_dolar);
        this.viewHolder.textEuro = findViewById(R.id.text_euro);
        this.viewHolder.buttonCalculate = findViewById(R.id.button_calculate);

        this.viewHolder.buttonCalculate.setOnClickListener(this);

        this.clearValues();

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.button_calculate){
            Double value = Double.valueOf(this.viewHolder.editValue.getText().toString());
            this.viewHolder.textDolar.setText(String.format("%.2f" ,value / 3.9));
            this.viewHolder.textEuro.setText(String.format("%.2f" ,value / 4.4));
        }
    }

    private void clearValues(){
        this.viewHolder.textEuro.setText("");
        this.viewHolder.textDolar.setText("");
    }


    private static class ViewHolder{

        EditText editValue;
        TextView textDolar;
        TextView textEuro;
        Button buttonCalculate;

    }


}
