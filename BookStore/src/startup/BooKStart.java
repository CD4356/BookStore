package startup;

import controller.BookController;
import view.Welcome;

public class BooKStart extends Welcome {
    @Override
    public void showBookAdmin() {
        new BookController().setVisible(true);
    }

    public static void main(String[] args) {
        new BooKStart().setVisible(true);
    }
}
