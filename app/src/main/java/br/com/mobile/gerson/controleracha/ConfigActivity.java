package br.com.mobile.gerson.controleracha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import br.com.mobile.gerson.controleracha.model.Config;
import br.com.mobile.gerson.controleracha.persistence.RachaContract;

public class ConfigActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        Config config = new Config(this.getApplicationContext());
        config.find(1);

        EditText edtTeamSize = (EditText) this.findViewById(R.id.edtTeamSize);
        edtTeamSize.setText(config.getTeamSize().toString());
    }

    @Override
    protected void onStop() {
        super.onStop();

        EditText edtTeamSize = (EditText) this.findViewById(R.id.edtTeamSize);
        String teamSize = edtTeamSize.getText().toString();
        Config config = new Config(this.getApplicationContext());
        boolean exist = config.find(1);
        config.setTeamSize(Integer.parseInt(teamSize));
        if (exist)
            config.update();
        else
            config.save();
    }
}
