package tictactoe.example.com.tic_tac_toe;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class TicMenu extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Button bot = (Button) findViewById(R.id.button);
        Button player = (Button)findViewById(R.id.button2);

        bot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TicMenu.this, Vsbot.class);
                startActivity(i);
            }
        });

        player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent player = new Intent(TicMenu.this, Vsplayer.class);
                startActivity(player);
            }
        });

    }
}
