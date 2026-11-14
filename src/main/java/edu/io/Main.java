package edu.io;

    public class Main {

        // Klasa Token
        static class Token {
            private String name;
            private String symbol;

            public Token(String name, String symbol) {
                this.name = name;
                this.symbol = symbol;
            }

            public String getName() {
                return name;
            }

            public String getSymbol() {
                return symbol;
            }
        }

        // Klasa Board
        static class Board {
            private Token[][] board;
            private int size;

            public Board(int size) {
                this.size = size;
                board = new Token[size][size];
            }

            // Czyszczenie planszy
            public void clean() {
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        board[i][j] = null;
                    }
                }
            }

            // Umieszczanie żetonu
            public boolean placeToken(Token token, int row, int col) {
                if (row < 0 || row >= size ||
                        col < 0 || col >= size) {
                    return false;
                }

                if (board[row][col] != null) {
                    return false;
                }

                board[row][col] = token;
                return true;
            }

            // Sprawdzanie zawartości pola
            public Token peekToken(int row, int col) {
                if (row < 0 || row >= size ||
                        col < 0 || col >= size) {
                    return null;
                }

                return board[row][col];
            }

            // Wyświetlanie planszy
            public void display() {
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {

                        if (board[i][j] == null) {
                            System.out.print("\u30FB ");
                        } else {
                            System.out.print(
                                    board[i][j].getSymbol() + " "
                            );
                        }
                    }

                    System.out.println();
                }
            }
        }

        public static void main(String[] args) {
            System.out.println("Gold Rush");

            System.setOut(new java.io.PrintStream(
                    System.out, true, java.nio.charset.StandardCharsets.UTF_8));

            Board board = new Board(8);

            // Tworzenie żetonu złota i pionka gracza
            Token gold = new Token("Gold", "\uD83D\uDCB0");
            Token player = new Token("Player", "\uC6C3");

            // Umieszczanie żetonów
            board.placeToken(player, 3, 2);
            board.placeToken(gold, 4, 5);

            // Wyświetlanie planszy
            System.out.println("Board:");
            board.display();

            // Test peekToken()
            System.out.println("\nChecking field:");

            Token found = board.peekToken(3, 2);

            if (found != null) {
                System.out.println("Found: " + found.getName());
            } else {
                System.out.println("Empty square");
            }

            /** Test clean()
            System.out.println("\nCleaning board:");
            board.clean();
            board.display(); **/
        }
    }


