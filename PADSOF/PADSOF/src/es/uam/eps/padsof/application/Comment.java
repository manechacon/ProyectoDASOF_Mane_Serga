package es.uam.eps.padsof.application;
public abstract class Comment extends Commentable {
	private User user;
	public Comment(User u) {
		super();
		this.user = u;
	}
	public User getUser() {
		return user;
	}
	
}
