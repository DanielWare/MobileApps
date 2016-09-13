package edu.uco.dware6.p3danielwa;


import org.junit.Assert;
import org.junit.Test;

public class TicTacToeGameTest {

    ///add a tic out of bounds and catch exception
    @Test(expected = IndexOutOfBoundsException.class)
    public void addTicOutOfBoundsTest() throws Exception{
        TicTacToeGame game = new TicTacToeGame();
        game.AddTic(9);
    }

    /// add tic test
    @Test
    public void addTicTest(){
        TicTacToeGame game = new TicTacToeGame();
        game.AddTic(0);
    }

    ///012 TicType.O wins
    @Test
    public void topRowOWinnerTest(){
        TicTacToeGame game = new TicTacToeGame();
        game.AddTic(0);
        game.AddTic(3);
        game.AddTic(1);
        game.AddTic(4);
        game.AddTic(2);
        Assert.assertTrue(game.CheckForWinner());
        Assert.assertEquals(TicType.O,game.GetWinnerType());
    }

    ///012 TicType.O wins
    @Test
    public void topRowXWinnerTest(){
        TicTacToeGame game = new TicTacToeGame();
        //starts with TicType.O
        game.AddTic(6);//o
        game.AddTic(0);//x
        game.AddTic(3);//o
        game.AddTic(1);//x
        game.AddTic(4);//o
        game.AddTic(2);//x
        Assert.assertTrue(game.CheckForWinner());
        Assert.assertEquals(TicType.X,game.GetWinnerType());
    }

    ///345 TicType.O wins
    @Test
    public void middleRowOWinnerTest(){
        TicTacToeGame game = new TicTacToeGame();
        game.AddTic(3);//o
        game.AddTic(6);//x
        game.AddTic(4);//o
        game.AddTic(7);//x
        game.AddTic(5);//o
        Assert.assertTrue(game.CheckForWinner());
        Assert.assertEquals(TicType.O,game.GetWinnerType());
    }

    ///345 TicType.X wins
    @Test
    public void middleRowXWinnerTest(){
        TicTacToeGame game = new TicTacToeGame();
        //starts with TicType.O
        game.AddTic(0);//o
        game.AddTic(3);//x
        game.AddTic(1);//o
        game.AddTic(4);//x
        game.AddTic(7);//o
        game.AddTic(5);//x
        Assert.assertTrue(game.CheckForWinner());
        Assert.assertEquals(TicType.X,game.GetWinnerType());
    }

    ///678 TicType.O wins
    @Test
    public void bottomRowOWinnerTest(){
        TicTacToeGame game = new TicTacToeGame();
        game.AddTic(6);//o
        game.AddTic(0);//x
        game.AddTic(7);//o
        game.AddTic(1);//x
        game.AddTic(8);//o
        Assert.assertTrue(game.CheckForWinner());
        Assert.assertEquals(TicType.O,game.GetWinnerType());
    }

    ///678 TicType.X wins
    @Test
    public void bottomRowXWinnerTest(){
        TicTacToeGame game = new TicTacToeGame();
        //starts with TicType.O
        game.AddTic(0);//o
        game.AddTic(6);//x
        game.AddTic(1);//o
        game.AddTic(7);//x
        game.AddTic(5);//o
        game.AddTic(8);//x
        Assert.assertTrue(game.CheckForWinner());
        Assert.assertEquals(TicType.X,game.GetWinnerType());
    }

    

}
