public class R3Vector {
    private double _x, _y, _z;

    public R3Vector(double x, double y, double z) {
        _x = x;
        _y = y;
        _z = z;
    }

    public double getX() {
        return _x;
    }

    public double getY() {
        return _y;
    }

    public double getZ() {
        return _z;
    }

    public void scale(double k) {
        _x *= k;
        _y *= k;
        _z *= k;
    }

    public void scale(double kx, double ky, double kz) {
        _x *= kx;
        _y *= ky;
        _z *= kz;
    }

    public void translate(double dx, double dy, double dz) {
        _x += dx;
        _y += dy;
        _z += dz;
    }

    private void rotateZ(double u) {
//        u *= Math.PI/180;
        u = Math.toRadians(u);
        double tx = _x * Math.cos(u) - _y * Math.sin(u);
        _y = _x * Math.sin(u) + _y * Math.cos(u);
        _x = tx;
    }

    private void rotateX(double u) {
//        u *= Math.PI/180;
        u = Math.toRadians(u);
        double ty = _y * Math.cos(u) - _z * Math.sin(u);
        _z = _y * Math.sin(u) + _z * Math.cos(u);
        _y = ty;
    }

    private void rotateY(double u) {
//        u *= Math.PI/180;
        u = Math.toRadians(u);
        double tx = _x * Math.cos(u) - _z * Math.sin(u);
        _z = _x * Math.sin(u) + _z * Math.cos(u);
        _x = tx;
    }

    public void rotate(double ux, double uy, double uz) {
        this.rotateX(ux);
        this.rotateY(uy);
        this.rotateZ(uz);
    }

    public static R3Vector toR3Vector(R3Vector begin, R3Vector end) {
        return new R3Vector(end._x - begin._x,
                            end._y - begin._y,
                            end._z - begin._z);
    }

    public static R3Vector vect(R3Vector a, R3Vector b) {
        return new R3Vector(a._y * b._z - a._z * b._y,
                            a._z * b._x - a._x * b._z,
                            a._x * b._y - a._y * b._x);
    }

    public static double dot(R3Vector a, R3Vector b) {
        return a._x * b._x + a._y * b._y + a._z * b._z;
    }


}
