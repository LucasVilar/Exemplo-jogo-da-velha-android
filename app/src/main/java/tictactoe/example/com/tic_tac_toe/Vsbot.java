package tictactoe.example.com.tic_tac_toe;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Lucas on 30/09/2015.
 */
public class Vsbot extends Activity {

    public int jogadas=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
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

        final Button botoes[] = {b1,b2,b3,b4,b5,b6,b7,b8,b9};

        final JogoVelha jogo = new JogoVelha();

        for(int i=0; i <9; i++){
            final int atual = i;
            botoes[atual].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (jogadas < 10) {

                        if (botoes[atual].getText().equals("")) {
                            jogadas++;

                            int i=0;
                            for (int l = 0; l < 3; l++) {
                                for (int c = 0; c < 3; c++) {
                                    if (atual == i) {
                                        jogo.NovaJogada(l, c, 0);
                                    }
                                    i++;
                                }
                            }

                            botoes[atual].setTextColor(Color.parseColor("#ff0000"));
                            botoes[atual].setText("X");

                            if(t2.getText().equals("")) {
                                t2.setText(jogo.Vitoria());
                            }

                            if (t2.getText().length() > 0) {
                                jogadas = 10;
                            }
                            if (jogo.Velha() == 0 && t2.getText().equals("")) {
                                t2.setText("Deu velha!");
                            }

                            if (jogadas <= 4) {

                                int vazio = 0;

                                for (int b = 0; b < 9; b++) {

                                    if (botoes[b].getText().equals("")) {
                                        vazio++;
                                    }
                                }
                                String bot = jogo.BotTurno(vazio);
                                switch (bot) {
                                    case "0,0":
                                        botoes[0].setTextColor(Color.parseColor("#1702e4"));
                                        botoes[0].setText("O");
                                        break;
                                    case "0,1":
                                        botoes[1].setTextColor(Color.parseColor("#1702e4"));
                                        botoes[1].setText("O");
                                        break;
                                    case "0,2":
                                        botoes[2].setTextColor(Color.parseColor("#1702e4"));
                                        botoes[2].setText("O");
                                        break;
                                    case "1,0":
                                        botoes[3].setTextColor(Color.parseColor("#1702e4"));
                                        botoes[3].setText("O");
                                        break;
                                    case "1,1":
                                        botoes[4].setTextColor(Color.parseColor("#1702e4"));
                                        botoes[4].setText("O");
                                        break;
                                    case "1,2":
                                        botoes[5].setTextColor(Color.parseColor("#1702e4"));
                                        botoes[5].setText("O");
                                        break;
                                    case "2,0":
                                        botoes[6].setTextColor(Color.parseColor("#1702e4"));
                                        botoes[6].setText("O");
                                        break;
                                    case "2,1":
                                        botoes[7].setTextColor(Color.parseColor("#1702e4"));
                                        botoes[7].setText("O");
                                        break;
                                    case "2,2":
                                        botoes[8].setTextColor(Color.parseColor("#1702e4"));
                                        botoes[8].setText("O");
                                        break;
                                }

                                if(t2.getText().equals("")) {
                                    t2.setText(jogo.Vitoria());
                                }

                                if (t2.getText().length() > 0)
                                    jogadas = 10;

                            }
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

    @Override
    public void onBackPressed() {

    }
}


class JogoVelha{

    String Campo[][] = {{"1","1","1"}, {"1","1","1"},{"1","1","1"}};
    TextView t;
    private String campotexto="";
    int njogadas;

    //Ação para mostrar o campo com um toast (será retirado dps)
/*    public String Mostra(){

        for (int l = 0; l < 3; l++){

            for (int c = 0; c < 3; c++){

                campotexto = campotexto + Campo[l][c];
            }
            campotexto = campotexto + "\n";
        }
        Toast.makeText(context, campotexto, Toast.LENGTH_LONG).show();
        return null;

    }*/

    //Ação para colocar a ação do jogador no campo
    public String NovaJogada(Integer l, Integer c, Integer player){

        campotexto="";
        if(player==0)
            Campo[l][c] = "X";
        else Campo[l][c] = "O";
        njogadas++;

        return null;
    }

    //Ação do bot
    public String BotTurno(int vazio){

        String validos[]= new String[vazio];
        int i=0;
        campotexto="";

        for (int l = 0; l < 3; l++){

            for (int c = 0; c < 3; c++) {

                if (Campo[l][c].equals("1")) {

                    validos[i] =  l+","+c;
                    i++;
                }

            }
        }

        Random r = new Random();
        int escolha = r.nextInt(validos.length);
        String campol = Character.toString(validos[escolha].charAt(0));
        String campoc = Character.toString(validos[escolha].charAt(2));

        Campo[Integer.parseInt(campol)][Integer.parseInt(campoc)] = "O";

        String retorno=campol+","+campoc;
        return retorno;
    }

    String  Vitoria(){

        String[] condicaoVitoria = {Campo[0][0]+Campo[0][1]+Campo[0][2], Campo[1][0]+Campo[1][1]+Campo[1][2], Campo[2][0]+Campo[2][1]+Campo[2][2], Campo[0][0]+Campo[1][0]+Campo[2][0], Campo[0][1]+Campo[1][1]+Campo[2][1], Campo[0][2]+Campo[1][2]+Campo[2][2], Campo[0][0]+Campo[1][1]+Campo[2][2], Campo[0][2]+Campo[1][1]+Campo[2][0]};
        String retorno="";

        for(int i=0; i<8; i++ ){
            if(condicaoVitoria[i].equals("XXX")){
                retorno = retorno+"Jogador 1 ganhou!";
            } else
            if(condicaoVitoria[i].equals("OOO")){
                retorno= retorno+"Jogador 2 ganhou!";
            }  else retorno= retorno+"";
        }

        return retorno;

    }

    int Velha(){

        int velha=0;
        for(int l=0; l<3;l++){
            for(int c =0; c<3;c++){

                if(Campo[l][c].equals("1")){
                    velha = velha+1;
                } else velha = velha+0;
            }
        }

        return velha;
    }

    Void reset(){

        for (int l = 0; l < 3; l++){

            for (int c = 0; c < 3; c++) {

                Campo[l][c]="1";

            }
        }
        return null;
    };
}