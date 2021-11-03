

public class NBody {
    private static String imageToDraw = "images/starfield.jpg";
    /*Given a file name, it should return a double corresponding
    to the radius of the universe in that file,
    e.g. readRadius("./data/planets.txt") should return 2.50e+11.*/
    public static double readRadius(String fileName) {
        In in = new In(fileName);
        int numberItemInFile = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    /*Given a file name, it should return an array of Planets
    corresponding to the planets in the file,
     e.g. readPlanets("./data/planets.txt") should return an array of five planets*/
    public static Planet[] readPlanets(String fileName) {
        In in = new In(fileName);
        int numberItemInFile = in.readInt();
        double radius = in.readDouble();
        Planet[] planets = new Planet[numberItemInFile];
        // Planet temp = new Planet(0.0,0.0,0.0,0.0,100,"test.gif");
        for (int i = 0; i < numberItemInFile; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
        }

        return planets;
    }


    public static void main(String[] args) {

        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet [] planets = readPlanets(filename);
        int length = planets.length;


        /** Sets up the universe so it goes from
         * -100, -100 up to radius, radius */
        StdDraw.setScale(-radius, radius);
        /* Clears the drawing window. */
        StdDraw.clear();
        /* Stamps one copy of images/startled.jpg in a triangular pattern. */
        StdDraw.picture(0, 0, imageToDraw);
       // StdDraw.pause(2000);

        for (Planet planet : planets) {
            planet.draw();
        }
        StdDraw.enableDoubleBuffering();
        double timeVariable = 0;
        while(timeVariable < T){
            double [] xForces = new double[length];
            double [] yForces = new double[length];
            /*get xForces  and  yForces */
            for (int i = 0; i < length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            /*update plants information after get the entire xForces  and  yForces */
            for (int i = 0; i < length; i++) {

                planets[i].update(dt, xForces[i], yForces[i]);
            }
            /*draw the background*/
            StdDraw.setScale(-radius, radius);
            StdDraw.picture(0, 0, imageToDraw);

            /*draw every planet*/
            for (Planet planet : planets) {
                planet.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            timeVariable +=dt;
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
