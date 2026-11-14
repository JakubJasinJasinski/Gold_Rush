import edu.io.Board;
import edu.io.Token;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoardTest {
    final String EMPTY_TOKEN_LABEL = "・";
    final String PLAYER_TOKEN_LABEL = "웃";
    final String GOLD_TOKEN_LABEL = "💰︎";

    Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    void new_board_is_clean() {
        Assertions.assertTrue(_is_board_clean());
    }

    @Test
    void can_place_token() {
        Token t = new Token(PLAYER_TOKEN_LABEL);
        board.placeToken(1, 2, t);
        Assertions.assertEquals(t, board.peekToken(1, 2));
    }

    @Test
    void clean_method_works() {
        board.placeToken(1, 2, new Token(GOLD_TOKEN_LABEL));
        board.placeToken(board.size-1, board.size-1, new Token(GOLD_TOKEN_LABEL));
        board.clean();
        Assertions.assertTrue(_is_board_clean());
    }

    @Test
    void display_method_exists() {
        try {
            Board.class.getMethod("display");
        }
        catch (Exception e) {
            Assertions.fail();
        }
    }

    // -- utils
    boolean _is_board_clean() {
        int size = board.size;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (!board.peekToken(col, row).label.equals(EMPTY_TOKEN_LABEL)) {
                    return false;
                }
            }
        }
        return true;
    }
}
