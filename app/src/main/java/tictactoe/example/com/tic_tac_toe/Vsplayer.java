package tictactoe.example.com.tic_tac_toe;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Lucas on 30/09/2015.
 */
public class Vsplayer extends Activity{

    int jogadas=0;
    int player=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.field);

        setContentView(R.layout.field);

        final TextView t2 = (TextView)findViewById(R.id.textView2);
        final Button b1 = (Button)findViewById(R.id.button1);
        final Button b2 = (Button)findViewById(R.id.button2);
        final Button b3 = (Button)findViewById(R.id.button3);
        final Button b4 = (Button)findViewById(R.id.button4);
        final Button b5 = (Button)findViewById(R.id.button5);
        final Button b6 = (Button)findViewById(R.id.button6);
        final Button b7 = (Button)findViewById(R.id.button7);
        final Button b8 = (Button)findViewById(R.id.button8);
        final Button b9 = (Button)findViewById(R.id.button9);
        final Button b10 = (Button)findViewById(R.id.b10);
        final Button b11 = (Button)findViewById(R.id.b11);

        final Button botoes[] ={b1,b2,b3,b4,b5,b6,b7,b8,b9};

        final JogoVelha jogo = new JogoVelha();

        for(int i=0; i<9; i++){
            final int atual=i;
            botoes[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (botoes[atual].getText().equals("") && jogadas < 9) {

                        jogadas++;

                        int i=0;
                            for (int l = 0; l < 3; l++) {
                                for (int c = 0; c < 3; c++) {
                                    if (atual == i) {
                                        jogo.NovaJogada(l, c, player);
                                    }
                                    i++;
                                }
                            }


                        if (t2.getText().equals("")) {
                            t2.setText(jogo.Vitoria());
                        }
                        if (t2.getText().length() > 0) {
                            jogadas = 11;
                        }

                        if (player == 0) {
                            botoes[atual].setText("X");
                            botoes[atual].setTextColor(Color.parseColor("#ff0000"));
                            player = 1;
                        } else {
                            botoes[atual].setTextColor(Color.parseColor("#1702e4"));
                            botoes[atual].setText("O");
                            player = 0;
                        }

                    }

                    if (jogadas >= 9) {
                        if (jogo.Velha() == 0 && t2.getText().equals("")) {
                            t2.setText("Deu velha!");
                        }
                    }
                }
            });
        }

        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i=0; i<9;i++){

                    botoes[i].setText("");
                }
                jogadas = 0;
                jogo.reset();
                t2.setText("");
            }
        });

        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}