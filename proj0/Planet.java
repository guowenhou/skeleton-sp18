

public class Planet {
    public static final double G = 6.67E-11f;

    public double xxPos; //Its current x position
    public double yyPos;//Its current y position
    public double xxVel;  // Its current velocity in the x direction
    public double yyVel;  // Its current velocity in the y direction
    public double mass;   //Its mass
    //The name of the file that corresponds to the image that depicts the planet
    // (for example, jupiter.gif)
    public String imgFileName;

    public Planet(double xxPos, double yyPos, double xxVel, double yyVel, double mass, String imgFileName) {
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

    public double calcDistance(Planet p) {

        double distance;
        distance = Math.sqrt((this.xxPos - p.xxPos) * (this.xxPos - p.xxPos) +
                (this.yyPos - p.yyPos) * (this.yyPos - p.yyPos));
        return distance;
    }

    public double calcForceExertedBy(Planet p) {
        double force;
        force = p.mass * this.mass * G
                / (calcDistance(p) * calcDistance(p));
        return force;
    }

    public double calcForceExertedByX(Planet p) {
        double force;
        double res;
        force = calcForceExertedBy(p);
        res = (p.xxPos - this.xxPos) / calcDistance(p) * force;
        return res;
    }

    public double calcForceExertedByY(Planet p) {
        double force;
        double res;
        force = calcForceExertedBy(p);
        res = (p.yyPos - this.yyPos) / calcDistance(p) * force;
        return res;
    }

    public double calcNetForceExertedByX(Planet[] arr) {
        double res = 0.0;
        for (Planet planet : arr) {
            if (!(this.equals(planet))) {
                res += calcForceExertedByX(planet);
            }
        }
        return res;
    }

    public double calcNetForceExertedByY(Planet[] arr) {
        double res = 0.0;
        for (Planet planet : arr) {
            if (!(this.equals(planet))) {
                res += calcForceExertedByY(planet);
            }
        }
        return res;
    }

    public void update(double dt, double fx, double fy) {
        double ax = fx / this.mass;
        double ay = fy / this.mass;
        this.xxVel += ax * dt;
        this.yyVel += ay * dt;
        this.xxPos += xxVel * dt;
        this.yyPos += yyVel * dt;
    }

    public void draw(){


        /* Stamps one copy of images/starfield.jpg in a triangular pattern. */
        StdDraw.picture(this.xxPos, this.yyPos,"images/" + imgFileName);
    }

}
