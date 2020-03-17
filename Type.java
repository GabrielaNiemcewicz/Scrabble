package Jabba;

enum Type {
		NORMAL(1, 1, "  "),
		DOUBLE_WORD(1, 2, "2W"),
		TRIPLE_WORD(1, 3, "3W"),
		DOUBLE_LETTER(2, 1, "2L"),
		TRIPPLE_LETTER(3, 1, "3L");
		
		private final int WordMultiplier;
		private final int LetterMultiplier;
		private final String identifier;
		
		Type(int LetterMultiplier, int WordMultiplier, String identifier){
			this.LetterMultiplier = LetterMultiplier;
			this.WordMultiplier = WordMultiplier;
			this.identifier = identifier;
		}
		
		public int getWordMultiplier() {
			return WordMultiplier;
		}
		
		public int getLetterMultiplier() {
			return LetterMultiplier;
		}
		
		public String toString() {
			return identifier;
		}
	}