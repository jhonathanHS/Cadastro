package com.example.cadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cadastro.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    private Formulario formulario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        activityMainBinding.salvarBt.setOnClickListener(view -> {
            formulario = new Formulario(
                    activityMainBinding.nomeEt.getText().toString(),
                    activityMainBinding.telefoneEt.getText().toString(),
                    activityMainBinding.emailEt.getText().toString(),
                    activityMainBinding.femininoRb.isChecked() ? getString(R.string.feminino) : getString(R.string.masculino),
                    activityMainBinding.cidadeEt.getText().toString(),
                    activityMainBinding.unidadeFederalSp.getSelectedItem().toString()
            );
            Toast.makeText(this, formulario.toString(), Toast.LENGTH_SHORT).show();
        });

        activityMainBinding.limparBt.setOnClickListener(view -> {
            activityMainBinding.nomeEt.setText("");
            activityMainBinding.telefoneEt.setText("");
            activityMainBinding.emailEt.setText("");
            activityMainBinding.femininoRb.setChecked(true);
            activityMainBinding.cidadeEt.setText("");
            activityMainBinding.unidadeFederalSp.setSelection(0);

            formulario = null;

        });

    }
}