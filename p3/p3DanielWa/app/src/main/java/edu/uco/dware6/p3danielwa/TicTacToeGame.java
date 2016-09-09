package edu.uco.dware6.p3danielwa;


public class TicTacToeGame {

    private boolean mXTurn;
    //we can't click a button more than 9 times and no one wins before click 5
    private int mButtonsPressed;
    private TicType[] mTicTiles;
    private boolean mHaveWinner;
    private TicType mWinnerType;


    public TicTacToeGame()
    {
        mTicTiles = new TicType[9];
        mWinnerType = TicType.Unticked;
        for(int i = 0; i < mTicTiles.length; i++){
            mTicTiles[i] = TicType.Unticked;
        }
        mButtonsPressed = 0;
        mXTurn = false;
        mHaveWinner = false;
    }

    public boolean CheckForWinner()
    {
        if(mButtonsPressed < 5)
            return false;

        TicType ticType = TicType.Unticked;
        for(int i = 1; i < TicType.values().length; i++){
            ticType = TicType.values()[i];
            //0 1 2
            if(mTicTiles[0] == ticType){
                if(mTicTiles[1] == ticType){
                    if(mTicTiles[2] == ticType){
                        mHaveWinner = true;
                    }
                }
                //0 3 6
                if(mTicTiles[3] == ticType){
                    if(mTicTiles[6] == ticType){
                        mHaveWinner = true;
                    }
                }
                //0 4 8
                if(mTicTiles[4] == ticType){
                    if(mTicTiles[8] == ticType){
                        mHaveWinner = true;
                    }
                }
            }
            //1 4 7
            if(mTicTiles[1] == ticType){
                if(mTicTiles[4] == ticType){
                    if(mTicTiles[7] == ticType){
                        mHaveWinner = true;
                    }
                }
            }
            //2 5 8
            if(mTicTiles[2] == ticType){
                if(mTicTiles[5] == ticType){
                    if(mTicTiles[8] == ticType){
                        mHaveWinner = true;
                    }
                }
                //2 4 6
                if(mTicTiles[4] == ticType){
                    if(mTicTiles[6] == ticType){
                        mHaveWinner = true;
                    }
                }
            }
            //3 4 5
            if(mTicTiles[3] == ticType){
                if(mTicTiles[4] == ticType){
                    if(mTicTiles[5] == ticType){
                        mHaveWinner = true;
                    }
                }
            }
            //6 7 8
            if(mTicTiles[6] == ticType){
                if(mTicTiles[7] == ticType){
                    if(mTicTiles[8] == ticType){
                        mHaveWinner = true;
                    }
                }
            }

            if(mHaveWinner)
                break;
        }

        if(mHaveWinner)
        {
            mWinnerType = ticType;
        }
        if(!mHaveWinner && mButtonsPressed == 9){
            mWinnerType = TicType.Unticked;
            mHaveWinner = true;
        }
        return mHaveWinner;
    }

    public void AddTic(int index)
    {
        //check that we sent a value inside the length
        if(index > mTicTiles.length - 1)
        {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds(0-8)");
        }
        //check that we aren't overwriting an existing tic
        if(mTicTiles[index] != TicType.Unticked)
        {
            return;
        }

        if(mXTurn)
        {
            mTicTiles[index] = TicType.X;
        }
        else
        {
            mTicTiles[index] = TicType.O;
        }

        mButtonsPressed++;

        //switch turns
        mXTurn = !mXTurn;

    }

    public boolean GetXTurn()
    {
        return mXTurn;
    }

    public TicType GetWinnerType()
    {
        return mWinnerType;
    }

}
