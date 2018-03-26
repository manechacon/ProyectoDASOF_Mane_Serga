package es.uam.eps.padsof.application;
import java.util.*;

public abstract class Commentable {
	private ArrayList<Comment> comments;
	private double rating;
	private int nrating;
	
	public Commentable() {
		this.rating = 0;
		this.nrating = 0; 
		this.comments = new ArrayList<Comment>();
	}
	
	public ArrayList<Comment> getComments() {
		return comments;
	}
	public double getRating() {
		return rating;
	}
	private void setRating(double rating) {
		this.rating = rating;
	}
	private void calcRating (double rating) {
		double aux;
		aux = (this.rating * this.nrating + rating )/(this.nrating + 1);
		this.nrating = this.nrating +1;
		setRating(aux);
	}
	public void addComment(Comment c) {
		if (c instanceof RatingComment) {
			this.calcRating(((RatingComment)c).getScore());
		}
		this.comments.add(c);
	}
	
}
