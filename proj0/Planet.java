import static java.lang.Math.sqrt;

public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private double G = 6.67e-11;

    public Planet(double xPos, double yPos, double xVel, double yVel, double m, String img) {
        xxPos = xPos;
        yyPos = yPos;
        xxVel = xVel;
        yyVel = yVel;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;

    }

    public double calcDistance(Planet p) {
        return sqrt((this.xxPos - p.xxPos) * (this.xxPos - p.xxPos) + (this.yyPos - p.yyPos) * (this.yyPos - p.yyPos));
    }

    public double calcForceExertedBy(Planet p) {
        double distance = calcDistance(p);
        double force = (G * p.mass * this.mass) / (distance * distance);
        return force;
    }

    public double calcForceExertedByX(Planet p) {
        double F = calcForceExertedBy(p);
        double radius = calcDistance(p);
        double F1X = F * (p.xxPos - this.xxPos) / radius;
        return F1X;
    }

    public double calcForceExertedByY(Planet p) {
        double F = calcForceExertedBy(p);
        double radius = calcDistance(p);
        double F1Y = F * (p.yyPos - this.yyPos) / radius;
        return F1Y;
    }

    public double calcNetForceExertedByX(Planet[] planet_list) {
        double Sum_of_F_net_x = 0;
        for (Planet p : planet_list) {
            if (p.equals(this)) {
                continue;
            } else {
                Sum_of_F_net_x = Sum_of_F_net_x + calcForceExertedByX(p);
            }
        }
        return Sum_of_F_net_x;
    }

    public double calcNetForceExertedByY(Planet[] planet_list) {
        double Sum_of_F_net_y = 0;
        for (Planet p : planet_list) {
            if (p.equals(this)) {
                continue;
            } else {
                Sum_of_F_net_y = Sum_of_F_net_y + calcForceExertedByY(p);
            }
        }
        return Sum_of_F_net_y;
    }

    public void update(double t, double Fx, double Fy) {
        double ax = Fx / this.mass;
        double ay = Fy / this.mass;
        this.xxVel = ax * t + this.xxVel;
        this.yyVel = ay * t + this.yyVel;
        this.xxPos = this.xxPos + this.xxVel * t;
        this.yyPos = this.yyPos + this.yyVel * t;
    }

    public void draw() {
        String planet_image = "images/" + this.imgFileName;
        StdDraw.picture(this.xxPos, this.yyPos, planet_image);
    }
}
