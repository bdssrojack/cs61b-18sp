

public class NBody{
	
	//∂¡»°”Ó÷Ê∞Îæ∂
	public static double readRadius(String sourse){
		In in = new In(sourse);
		double num = in.readDouble();
		double radius = in.readDouble();
		return radius;
	}
	
	//∂¡»°–––«
	public static Planet[] readPlanets(String sourse){
		
		In in = new In(sourse);
		int num = in.readInt();
		double radius = in.readDouble();
		
		Planet[] p = new Planet[num];
		
		for(int i = 0; i<num; i++){
			double xPos = in.readDouble();
			double yPos = in.readDouble();
			double xVel = in.readDouble();
			double yVel = in.readDouble();
			double mass = in.readDouble();
			String img = in.readString();
			
			p[i] = new Planet(xPos, yPos, xVel, yVel, mass, img);
		}
		
		return p;
	}
	
	public static void main(String[] args){
		/*…Ë÷√√¸¡Ó––≤Œ ˝*/
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		
		/*∂¡»°∞Îæ∂∫Õ–––«*/
		double radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);
		
		/*ªÊ÷∆±≥æ∞*/
		StdDraw.setScale(-radius, radius);
		StdDraw.clear();
		StdDraw.picture(0, 0, "images/starfield.jpg");
		StdDraw.show();
		
		/*ªÊ÷∆–––«*/
		for(Planet p : planets){
			p.draw();
		}
		
		StdDraw.enableDoubleBuffering();//∑¿÷πª≠√Ê…¡À∏
		
		double time = 0;
		for(time = 0; time<T; time++){
			Double[] xForces = new Double[planets.length];
			Double[] yForces = new Double[planets.length];
			for(int i = 0; i<planets.length; i++){
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}
			for(int i = 0; i<planets.length; i++){
				planets[i].update(dt, xForces[i], yForces[i]);
			}
			StdDraw.setScale(-radius, radius);
			StdDraw.clear();
			StdDraw.picture(0, 0, "images/starfield.jpg");
			StdDraw.show();
			for(Planet p : planets){
				p.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
			time += dt;
		}
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
				planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
				planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}
	}
}