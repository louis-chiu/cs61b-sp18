import java.awt.*;

public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static double G = 6.67e-11;

    public Planet(double xxPos, double yyPos, double xxVel,
                  double yyVel, double mass, String imgFileName) {
        this.xxPos = xxPos;
        this.yyPos = yyPos;
        this.xxVel = xxVel;
        this.yyVel = yyVel;
        this.mass = mass;
        this.imgFileName = imgFileName;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet planet) {
        return Math.sqrt(Math.pow(this.xxPos - planet.xxPos, 2) + Math.pow(this.yyPos - planet.yyPos, 2));
    }

    public double calcForceExertedBy(Planet planet) {
        return G * this.mass * planet.mass / this.calcDistance(planet) / this.calcDistance(planet);
    }

    public double calcForceExertedByX(Planet planet) {
        return this.calcForceExertedBy(planet) * (planet.xxPos - this.xxPos) / this.calcDistance(planet);
    }

    public double calcNetForceExertedByX(Planet[] planets) {
        double result = 0;
        for (Planet planet : planets) {
            if (!this.equals(planet)) {
                result += this.calcForceExertedByX(planet);
            }
        }
        return result;
    }

    public double calcForceExertedByY(Planet planet) {
        return this.calcForceExertedBy(planet) * (planet.yyPos - this.yyPos) / this.calcDistance(planet);
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        double result = 0;
        for (Planet planet : planets) {
            if (!this.equals(planet)) {
                result += this.calcForceExertedByY(planet);
            }
        }
        return result;
    }

    public void update(double dt, double fx, double fy) {
        double ax = fx / this.mass;
        double ay = fy / this.mass;

        this.xxVel += ax * dt;
        this.yyVel += ay * dt;
        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "./images/" + this.imgFileName);
    }
}
