package es.uam.eps.padsof.application;

public class TextComment extends Comment{
	private String message;
	public TextComment(User u, String s) {
		super(u);
		this.message = s;
	}
	public String getMessage() {
		return message;
	}
	
}
