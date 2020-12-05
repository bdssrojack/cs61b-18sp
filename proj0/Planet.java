public class Planet {
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;
	private final double G = 6.67e-11;
	
	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		this.xxPos = xP;
		this.yyPos = yP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.mass = m;
		this.imgFileName = img;
	}
	
	public Planet(Planet p) {
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}
	
	//calculates the distance between two Planets
	public double calcDistance(Planet p) {
		double xdis = this.xxPos - p.xxPos;
		double ydis = this.yyPos - p.yyPos;
		double dis = Math.sqrt(xdis * xdis + ydis * ydis);
		return dis;
	}
	
	//describing the force exerted on this planet
	public double calcForceExertedBy(Planet p) {
		double r = this.calcDistance(p);
		return (G * this.mass * p.mass) / (r * r);
	}
	
	public double calcForceExertedByX(Planet p) {
		double F = this.calcForceExertedBy(p);
		double r = this.calcDistance(p);
		double dx = p.xxPos - this.xxPos;
		double Fx = (F * dx) / r;
		return Fx;
	}
	
	public double calcForceExertedByY(Planet p) {
		double F = this.calcForceExertedBy(p);
		double r = this.calcDistance(p);
		double dy = p.yyPos - this.yyPos;
		double Fy = (F * dy) / r;
		return Fy;
	}
	
	public double calcNetForceExertedByX(Planet[] allPlanets) {
		double Fx = 0;
		for (Planet p : allPlanets) {
			if (this.equals(p)) {
				continue;
			}
			Fx += this.calcForceExertedByX(p);
			
		}
		return Fx;
	}
	
	public double calcNetForceExertedByY(Planet[] allPlanets) {
		double Fy = 0;
		for (Planet p : allPlanets) {
			if (this.equals(p)) {
				continue;
			}
			Fy += this.calcForceExertedByY(p);
		}
		return Fy;
	}
	
	public void update(double dt, double Fx, double Fy) {
		double ax = Fx / this.mass;
		double ay = Fy / this.mass;
		this.xxVel += dt * ax;
		this.yyVel += dt * ay;
		this.xxPos += dt * xxVel;
		this.yyPos += dt * yyVel;
	}
	
	public void draw() {
		StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
		StdDraw.show();
	}
}
