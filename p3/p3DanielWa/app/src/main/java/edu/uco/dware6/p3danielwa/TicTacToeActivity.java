package edu.uco.dware6.p3danielwa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class TicTacToeActivity extends Activity {

    private TicTacToeGame mGame;
    private TextView mDisplay;

    private Button mButton0;
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;
    private Button mButton6;
    private Button mButton7;
    private Button mButton8;

    private int[] mWins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);

        //mWins = AddWinnerToWins(mWins, TicType.Unticked);
        //mWins = AddWinnerToWins(mWins, TicType.O);
        //mWins = AddWinnerToWins(mWins, TicType.X);

        mGame = new TicTacToeGame();

        mDisplay = (TextView)findViewById(R.id.display);
        mButton0 = (Button)findViewById(R.id.button0);
        mButton1 = (Button)findViewById(R.id.button1);
        mButton2 = (Button)findViewById(R.id.button2);
        mButton3 = (Button)findViewById(R.id.button3);
        mButton4 = (Button)findViewById(R.id.button4);
        mButton5 = (Button)findViewById(R.id.button5);
        mButton6 = (Button)findViewById(R.id.button6);
        mButton7 = (Button)findViewById(R.id.button7);
        mButton8 = (Button)findViewById(R.id.button8);

        Button newGameBtn = (Button)findViewById(R.id.new_game);
        Button logBtn = (Button)findViewById(R.id.log_btn);

        //region set onclicklisteners

        mButton0.setOnClickListener(v->{
            mGame.AddTic(0);
            if(mGame.GetXTurn()){
                mButton0.setText("O");
            }else{
                mButton0.setText("X");
            }
            UpdateView();
            mButton0.setEnabled(false);
        });
        mButton1.setOnClickListener(v->{
            mGame.AddTic(1);
            if(mGame.GetXTurn()){
                mButton1.setText("O");
            }else{
                mButton1.setText("X");
            }
            UpdateView();
            mButton1.setEnabled(false);
        });
        mButton2.setOnClickListener(v->{
            mGame.AddTic(2);
            if(mGame.GetXTurn()){
                mButton2.setText("O");
            }else{
                mButton2.setText("X");
            }
            UpdateView();
            mButton2.setEnabled(false);
        });
        mButton3.setOnClickListener(v->{
            mGame.AddTic(3);
            if(mGame.GetXTurn()){
                mButton3.setText("O");
            }else{
                mButton3.setText("X");
            }
            UpdateView();
            mButton3.setEnabled(false);
        });
        mButton4.setOnClickListener(v->{
            mGame.AddTic(4);
            if(mGame.GetXTurn()){
                mButton4.setText("O");
            }else{
                mButton4.setText("X");
            }
            UpdateView();
            mButton4.setEnabled(false);
        });
        mButton5.setOnClickListener(v->{
            mGame.AddTic(5);
            if(mGame.GetXTurn()){
                mButton5.setText("O");
            }else{
                mButton5.setText("X");
            }
            UpdateView();
            mButton5.setEnabled(false);
        });
        mButton6.setOnClickListener(v->{
            mGame.AddTic(6);
            if(mGame.GetXTurn()){
                mButton6.setText("O");
            }else{
                mButton6.setText("X");
            }
            UpdateView();
            mButton6.setEnabled(false);
        });
        mButton7.setOnClickListener(v->{
            mGame.AddTic(7);
            if(mGame.GetXTurn()){
                mButton7.setText("O");
            }else{
                mButton7.setText("X");
            }
            UpdateView();
            mButton7.setEnabled(false);
        });
        mButton8.setOnClickListener(v->{
            mGame.AddTic(8);
            if(mGame.GetXTurn()){
                mButton8.setText("O");
            }else{
                mButton8.setText("X");
            }
            UpdateView();
            mButton8.setEnabled(false);
        });

        //endregion

        newGameBtn.setOnClickListener(v->{
            //reset game
            mGame = new TicTacToeGame();
            EnableAndClearAllButtons();
        });
        logBtn.setOnClickListener(v->{
            //go to log intent
            Intent logIntent = new Intent(TicTacToeActivity.this, LogActivity.class);
            logIntent.putExtra(getString(R.string.WINSLIST), mWins);
            startActivity(logIntent);
        });



    }


    private void UpdateView(){
        if(mGame.CheckForWinner()){
            DisableAllButtons();
            switch(mGame.GetWinnerType()){
                case X:
                    mDisplay.setText(R.string.X_winner);
                    mWins = AddWinnerToWins(mWins, TicType.X);
                    break;
                case O:
                    mDisplay.setText(R.string.O_winner);
                    mWins = AddWinnerToWins(mWins, TicType.O);
                    break;
                case Unticked:
                    //game is a draw
                    mDisplay.setText(R.string.draw);
                    mWins = AddWinnerToWins(mWins, TicType.Unticked);
                    break;
            }
        }
        else
        {
            if(mGame.GetXTurn())
            {
                //set text to x turn
                mDisplay.setText(R.string.x_turn);
            }
            else
            {
                //set text to o turn
                mDisplay.setText(R.string.o_turn);
            }
        }

    }

    private void DisableAllButtons() {
        mButton0.setEnabled(false);
        mButton1.setEnabled(false);
        mButton2.setEnabled(false);
        mButton3.setEnabled(false);
        mButton4.setEnabled(false);
        mButton5.setEnabled(false);
        mButton6.setEnabled(false);
        mButton7.setEnabled(false);
        mButton8.setEnabled(false);
    }

    private void EnableAndClearAllButtons(){
        mButton0.setEnabled(true);
        mButton1.setEnabled(true);
        mButton2.setEnabled(true);
        mButton3.setEnabled(true);
        mButton4.setEnabled(true);
        mButton5.setEnabled(true);
        mButton6.setEnabled(true);
        mButton7.setEnabled(true);
        mButton8.setEnabled(true);

        mButton0.setText("");
        mButton1.setText("");
        mButton2.setText("");
        mButton3.setText("");
        mButton4.setText("");
        mButton5.setText("");
        mButton6.setText("");
        mButton7.setText("");
        mButton8.setText("");

        UpdateView();
    }

    // 1 means x wins, 2 means o wins, 0 means draw
    private int[] AddWinnerToWins(int[] wins, TicType t)
    {
        int[] updatedWins;
        if(wins == null){
            updatedWins = new int[1];
        }
        else{
            //create new array 1 larger than prev array
            updatedWins = new int[wins.length + 1];
            //populate old values
            for(int i = 0; i < wins.length; i++){
                updatedWins[i] = wins[i];
            }
        }

        //interpret new values
        int ticToInt = -1;
        switch (t){
            case X:
                ticToInt = 1;
                break;
            case O:
                ticToInt = 2;
                break;
            case Unticked:
                ticToInt = 0;
                break;
        }
        //add new win
        updatedWins[updatedWins.length-1] = ticToInt;
        return updatedWins;
    }


}
