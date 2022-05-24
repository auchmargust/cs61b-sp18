public class NBody {

    public static double readRadius(String path) {
        In in = new In(path);
        int number_of_planets = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String path) {
        In in = new In(path);
        int number_of_planets = in.readInt();
        double radius = in.readDouble();
        Planet[] planet_list = new Planet[number_of_planets];
        int i = 0;
        while (i < number_of_planets) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double vX = in.readDouble();
            double vY = in.readDouble();
            double ma = in.readDouble();
            String pic = in.readString();
            planet_list[i] = new Planet(xP, yP, vX, vY, ma, pic);
            i++;
        }
        return planet_list;
    }


    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] planet_list = readPlanets(filename);
        double radius = readRadius(filename);

        String imageToDraw = "images/starfield.jpg";
        StdDraw.setCanvasSize(512, 512);
        StdDraw.setScale(-radius, radius);

        StdDraw.enableDoubleBuffering();

        double time = 0;

        while (time < T) {
            double[] xForces = new double[planet_list.length];
            double[] yForces = new double[planet_list.length];
            for (int i = 0; i < planet_list.length; i++) {
                xForces[i] = planet_list[i].calcNetForceExertedByX(planet_list);
                yForces[i] = planet_list[i].calcNetForceExertedByY(planet_list);
            }
            for (int i = 0; i < planet_list.length; i++) {
                planet_list[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, imageToDraw);
            for (int i = 0; i < planet_list.length; i++) {
                planet_list[i].draw();
            }

            StdDraw.show();
            StdDraw.pause(10);

            time = time + dt;

        }
        StdOut.printf("%d\n", planet_list.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planet_list.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planet_list[i].xxPos, planet_list[i].yyPos, planet_list[i].xxVel,
                    planet_list[i].yyVel, planet_list[i].mass, planet_list[i].imgFileName);
        }

    }
}


