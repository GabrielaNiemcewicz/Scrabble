
import java.util.*;

public class Board {
	private int BOARD_SIZE = 15;
	public static final int BOARD_CENTRE = 7;
	private Square[][] board = new Square [15][15];
	boolean isFirstRound;
	public static final int WORD_INCORRECT_FIRST_PLAY = 0;
	public static final int WORD_OUT_OF_BOUNDS = 1;
	public static final int WORD_LETTER_NOT_IN_FRAME = 2;
	public static final int WORD_LETTER_CLASH = 3;
	public static final int WORD_NO_LETTER_PLACED = 4;
	public static final int WORD_NO_CONNECTION = 5;
	private int checkCode;
	private int numPlays;



	public Board() {
		Pattern pattern = new Pattern(board);
		pattern.drawScrabble(board);
		this.isFirstRound = true;
	}

	public Square[][] getBoard(){
		return board;
	}



		public void display() {
			for(int i=0; i<this.BOARD_SIZE;i++) {
				System.out.printf("            -------------------------------------------------------------\n        %-4d", i);
				for(int j=0; j<this.BOARD_SIZE; j++) {
					System.out.print("| " + board[i][j]);
				}
				System.out.println("|");
			}
			System.out.println("            -------------------------------------------------------------");
			System.out.println("              0   1   2   3   4   5   6   7   8   9   10  11  12  13  14");
		}

	public void reset() {
		for (Square [] rows:board)
			for (Square squares:rows)
				squares.removeTile();
	}


	public boolean isLegal(Frame frame, Word word) {
		boolean isLegal = true;
		//check for invalid first play
		if (numPlays == 0 &&
				((word.isHorizontal() && (word.getRow()!=BOARD_CENTRE || word.getFirstColumn()>BOARD_CENTRE ||
						word.getLastColumn()<BOARD_CENTRE)) ||
						(word.isVertical() && (word.getColumn()!=BOARD_CENTRE || word.getFirstRow()>BOARD_CENTRE ||
								word.getLastRow()<BOARD_CENTRE)))) {
			isLegal = false;
			checkCode = WORD_INCORRECT_FIRST_PLAY;
		}
		// check for word out of bounds
		if (isLegal && ((word.isHorizontal() && word.getLastColumn()>= BOARD_SIZE) ||
				(word.isVertical() && word.getLastRow()>= BOARD_SIZE))) {
			isLegal = false;
			checkCode = WORD_OUT_OF_BOUNDS;
		}
		// check that letters in the word do not clash with those on the board
		String lettersPlaced = "";
		if (isLegal) {
			int r = word.getFirstRow();
			int c = word.getFirstColumn();
			for (int i = 0; i < word.getLength() && isLegal; i++) {
				if (!board[r][c].isEmpty() && board[r][c].getTile().getLetter() != word.getLetter(i)) {
					isLegal = false;
					checkCode = WORD_LETTER_CLASH;
				} else if (board[r][c].isEmpty()) {
					lettersPlaced = lettersPlaced + word.getLetter(i);
				}
				if (word.isHorizontal()) {
					c++;
				} else {
					r++;
				}
			}
		}
		// check that more than one letter is placed
		if (isLegal && lettersPlaced.length() == 0) {
			isLegal = false;
			checkCode = WORD_NO_LETTER_PLACED;
		}
		// check that the letters placed are in the frame
		if (isLegal && !frame.isStringIn(lettersPlaced)) {
			isLegal = false;
			checkCode = WORD_LETTER_NOT_IN_FRAME;
		}
		// check that the letters placed connect with the letters on the board
		if (isLegal && numPlays!=0) {
			int boxTop = Math.max(word.getFirstRow()-1,0);
			int boxBottom = Math.min(word.getLastRow()+1, BOARD_SIZE-1);
			int boxLeft = Math.max(word.getFirstColumn()-1,0);
			int boxRight = Math.min(word.getLastColumn()+1, BOARD_SIZE-1);
			boolean foundConnection = false;
			for (int r=boxTop; r<=boxBottom && !foundConnection; r++) {
				for (int c=boxLeft; c<=boxRight && !foundConnection; c++) {
					if (!board[r][c].isEmpty()) {
						foundConnection = true;
					}
				}
			}
			if (!foundConnection) {
				isLegal = false;
				checkCode = WORD_NO_CONNECTION;
			}
		}
		return isLegal;
	}

	// getCheckCode precondition: isLegal is false
	public int getCheckCode() {
		return checkCode;
	};

	// place precondition: isLegal is true
	public void place(Frame frame, Word word) {
		int r = word.getFirstRow();
		int c = word.getFirstColumn();
		for (int i=0; i<word.getLength(); i++) {
			if (board[r][c].isEmpty()) {
				char letter = word.getLetter(i);
				Tile tile = frame.getTilesByWord(word.getLetters()).get(i);
				board[r][c].placeTile(tile);
				frame.removeTile(tile);
			}
			if (word.isHorizontal()) {
				c++;
			} else {
				r++;
			}
		}
		numPlays++;
	}


	public void set_IsFirstRoundToFalse ()
	{ this.isFirstRound= false; }


	public boolean isFirstWord() {
		if (this.isFirstRound==true)
			for (int i=0; i<this.BOARD_SIZE; i++)
				for (int j=0; j<this.BOARD_SIZE; j++)
					if (!this.board[i][j].isEmpty())
						this.set_IsFirstRoundToFalse();
		return this.isFirstRound;
	}




	public boolean inTheMiddle(int firstPositionFixed, int firstPositionMobile, String temporaryWord)
	{
		if(firstPositionFixed!=7)
			return false;
		else if (firstPositionMobile<=7 && temporaryWord.length()+firstPositionMobile>=7)
			return true;
	return true;
	}

}
