package Mastermind;

import Mastermind.controllers.BoardController;
import Mastermind.models.Board;
import Mastermind.models.IBoard;
import Mastermind.views.BoardView;
import Mastermind.views.ConfigMenu;
import Mastermind.views.Home;
import Mastermind.views.MainWindow;


public class App {
    public static void main(String[] args) {
        IBoard board = new Board();

        BoardController boardController = new BoardController(board);

        Home home = new Home();

        // create menus
        BoardView boardView = new BoardView(board, boardController, home);
        board.addObserver(boardView);
        ConfigMenu configMenu = new ConfigMenu(boardController, home);

        new MainWindow(home, boardView, configMenu);
    }
}
