package br.com.mobile.gerson.controleracha;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.mobile.gerson.controleracha.model.Player;

public class AddPlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button add = (Button) this.findViewById(R.id.bnt_add_player);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText) findViewById(R.id.edt_add_name);
                EditText phone = (EditText) findViewById(R.id.edt_add_phone);

                Player player = new Player(v.getContext());
                player.setName(name.getText().toString());
                player.setTelefone(phone.getText().toString());
                player.save();

                name.getText().clear();
                phone.getText().clear();
                name.requestFocus();

                Toast.makeText(v.getContext(), "Player Added", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
