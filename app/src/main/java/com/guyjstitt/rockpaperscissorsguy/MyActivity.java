package com.guyjstitt.rockpaperscissorsguy;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;

import junit.framework.Test;

import org.w3c.dom.Text;

import java.util.Random;


public class MyActivity extends Activity {
    private TextView resultText;
    private TextView bodyText;
    private TextView choiceText;
    private TextView win;
    private TextView lost;
    private TextView draw;
    private ImageButton rock, paper, scissors;
    private ImageView compRock, compPaper, compScissors;
    private Button reset;
    Random rand = new Random();
    int compChoice = 0;
    int wonCount = 0;
    int lostCount = 0;
    int drawCount = 0;
    String cChoice = "";
    String pChoice = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        Initialize();
    }

    private void Initialize() {
        choiceText = (TextView) findViewById(R.id.textView);
        resultText = (TextView) findViewById(R.id.textView3);
        bodyText = (TextView) findViewById(R.id.textView2);
        rock = (ImageButton) findViewById(R.id.rockImage);
        paper = (ImageButton) findViewById(R.id.paperImage);
        scissors = (ImageButton) findViewById(R.id.scissorImage);
        win = (TextView) findViewById(R.id.win);
        lost = (TextView) findViewById(R.id.lost);
        draw = (TextView) findViewById(R.id.draw);

        reset = (Button) findViewById(R.id.reset);

        reset.setOnClickListener(new OnClickListener(){
            public void onClick(View arg0){
                choiceText.setText("Which pokemon will you choose?");
                bodyText.setText("");
                resultText.setText("");
                win.setText(String.valueOf(0));
                lost.setText(String.valueOf(0));
                draw.setText(String.valueOf(0));
                wonCount = 0;
                lostCount = 0;
                drawCount = 0;
            }
        });

        scissors.setOnClickListener(new OnClickListener(){
            public void onClick(View arg0){
                pChoice = "S";
                choiceText.setText("You chose scissors!");
                compChoice();
            }
        });

        paper.setOnClickListener(new OnClickListener(){
            public void onClick(View arg0){
                pChoice = "P";
                choiceText.setText("You chose paper!");
                compChoice();
            }
        });

        rock.setOnClickListener(new OnClickListener(){
            public void onClick(View arg0){
                pChoice = "R";
                choiceText.setText("You chose rock!");
                compChoice();
            }
        });



    }

    //This method will track the computers move and compare to the players move
    public void compChoice() {
        compChoice = rand.nextInt(3);

        if(compChoice == 0) {
            cChoice = "R";
            bodyText.setText("Gary chose Rock!");
        }
        else if (compChoice == 1) {
            cChoice = "P";
            bodyText.setText("Gary chose Paper");
        }
        else if (compChoice == 2){
            cChoice ="S";
            bodyText.setText("Gary chose Scissors");
        }

        compare();

    }

    public void compare() {
        if(pChoice == "R") {
            if(cChoice == "R") {
                resultText.setText("Draw");
                draw.setText(String.valueOf(++drawCount));
            }
            else if(cChoice == "P") {
                resultText.setText("You Lose");
                lost.setText(String.valueOf(++lostCount));

            }
            else if(cChoice == "S") {
                resultText.setText("You Win");
               win.setText(String.valueOf(++wonCount));
            }
        }
        else if(pChoice == "P") {
            if(cChoice == "R") {
                resultText.setText("You win");
                win.setText(String.valueOf(++wonCount));
            }
            else if(cChoice == "P") {
                resultText.setText("Draw");
                draw.setText(String.valueOf(++drawCount));
            }
            else if(cChoice == "S") {
                resultText.setText("You Lose");
                lost.setText(String.valueOf(++lostCount));
            }
        }
        else if(pChoice == "S") {
            if(cChoice == "R") {
                resultText.setText("You Lose");
                lost.setText(String.valueOf(++lostCount));

            }

            else if(cChoice == "P") {
                resultText.setText("You Win");
                win.setText(String.valueOf(++wonCount));

            }

            else if(cChoice == "S") {
                resultText.setText("Draw");
                draw.setText(String.valueOf(++drawCount));

            }

        }

        //gameOver();
    }



    public void gameOver()
    {
        scissors.setEnabled(false);
        rock.setEnabled(false);
        paper.setEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
