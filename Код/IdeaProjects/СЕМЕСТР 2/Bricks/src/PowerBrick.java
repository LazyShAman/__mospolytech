import java.awt.*;

class PowerBrick extends Brick {

    public PowerBrick(PlayField pf,
                      BrickPile bp,
                      Rectangle p,
                      Image img) {
        super(pf, bp, img, p);
    }

    @Override
    public void hitBy(Puck p) {
        _isDead = true;
        p.getVelocity().reverseY();
        p.getVelocity().speedy(2);
        p.getVelocity().setDirection(p.getDirection());
        p.getVelocity().reverseY();
        //p = new Puck();

        if (_bp.unbrokenCount() == 0) {
            _pf.getMatch().win();
        }
    }
}