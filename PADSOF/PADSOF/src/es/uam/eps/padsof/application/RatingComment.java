package es.uam.eps.padsof.application;

public class RatingComment extends Comment{
	private int score;
	
	public RatingComment (User u) {
		super(u);
		this.score = 0;
	}
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
