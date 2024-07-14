public class NBody {

    public static Planet[] readPlanets(String planetsTxtPath) {
        In in = new In(planetsTxtPath);
        int numberOfPlanets = in.readInt();
        Planet[] planets = new Planet[numberOfPlanets];
        in.readDouble();
        for (int i = 0; i < numberOfPlanets; i++) {
            planets[i] = new Planet(
                    in.readDouble(),
                    in.readDouble(),
                    in.readDouble(),
                    in.readDouble(),
                    in.readDouble(),
                    in.readString()
            );
        }
        return planets;
    }

    public static double readRadius(String planetsTxtPath) {
        In in = new In(planetsTxtPath);
        in.readDouble();
        return in.readDouble();
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] planets = readPlanets(filename);
        double radius = readRadius(filename);

        StdDraw.enableDoubleBuffering();

        for (double t = 0; t <= T; t+=dt) {
            double [] xForces = new double[planets.length];
            double [] yForces = new double[planets.length];
            for (int i = 0; i < planets.length; i++) {
                Planet planet = planets[i];
                xForces[i] = planet.calcNetForceExertedByX(planets);
                yForces[i] = planet.calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < planets.length; i++) {
                Planet planet = planets[i];
                planet.update(dt, xForces[i], yForces[i]);
            }
            StdDraw.setScale(-(radius), (radius));
            StdDraw.clear();
            StdDraw.picture(0d, 0d, "images/starfield.jpg");
            for (Planet planet : planets) {
                planet.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
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
