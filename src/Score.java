import java.io.Serializable;

public class Score implements Serializable {
	
	private int score;
	private int par;
	private int relPar;
	private String date;
	private boolean used;
	private boolean result;
	private boolean ha;
	private String course;

	static final long serialVersionUID = 421L;
	
	public Score(int par, int score, String date, String course, boolean used, boolean result, boolean ha) {
		this.score = score;
		this.par = par;
		relPar = score - par;
		this.date = date;
		this.used = used;
		this.course = course;
		this.result = result;
		this.ha = ha;
	}
	public boolean getHa() {
		return ha;
	}
	public void setHa(boolean ha) {
		this.ha = ha;
	}
	public Score(int par, int score, String date, boolean used) {
		this.score = score;
		this.par = par;
		relPar = score - par;
		this.date = date;
		this.used = used;
	}
	public Score(int par, int score, String date) {
		this.score = score;
		this.par = par;
		relPar = score - par;
		this.date = date;
	}
	public Score(int par, int score, String date, String course) {
		this.score = score;
		this.par = par;
		relPar = score - par;
		this.date = date;
		this.course = course;
	}
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public boolean getResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getPar() {
		return par;
	}

	public void setPar(int par) {
		this.par = par;
	}

	public int getRelPar() {
		return relPar;
	}

	public void setRelPar(int relPar) {
		this.relPar = relPar;
	}
	public String toString() {
		String relParFull;
		if(relPar < 0) {
			relParFull = String.format("%s", relPar);
		}
		else if(relPar > 0) {
			relParFull = String.format("+%s", relPar);
		}
		else {
			relParFull = "E";
		}
		return String.format("|%-5s |%-10s|%-18s|", score + "/" + relParFull, date, course);
	}
}
