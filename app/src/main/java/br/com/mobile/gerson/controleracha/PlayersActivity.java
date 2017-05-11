package br.com.mobile.gerson.controleracha;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import br.com.mobile.gerson.controleracha.model.Player;

public class PlayersActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton actionButton = (FloatingActionButton) this.findViewById(R.id.fab_add_player);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), AddPlayerActivity.class);
                startActivity(i);
            }
        });

        setPlayerList();
    }

    private void setPlayerList() {
        Player player = new Player(this);

        ListView playersList = (ListView) this.findViewById(R.id.players_list);
        ArrayAdapter<Player> adapter = new ArrayAdapter<Player>(this, android.R.layout.simple_list_item_1,
                android.R.id.text1, player.getAll());
        playersList.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setPlayerList();
    }
}
