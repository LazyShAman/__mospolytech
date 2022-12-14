import java.awt.*;

public class HardBrick extends Brick {
    /*
     * @_hitCount - количество допустимых ударов шайбой
     *              кирпич разрушается, как только
     *              атрибут будет равен нулю
     * @_woundImg - зображение поврежденного крипича
     *              заменяет исходное изображение при первом
     *              ударе шайбы
     */
    private int _hitCount = 1;
    private Image _woundImg;

    public HardBrick(PlayField pf,
                     BrickPile bp,
                     Rectangle p,
                     Image img,
                     Image woundImg) {
        super(pf, bp, img, p);
        _woundImg = woundImg;
    }

    /* Обработка соударения с шайбой. Как только
     * значение _hitCount становится равным нулю
     * и будет удален с игрового поля
     */

    @Override
    public void hitBy(Puck p) {
        if (_hitCount > 0) {
            _img = _woundImg;
            _hitCount--;
        } else {
            _isDead = true;
            if (_bp.unbrokenCount() == 0) {
                _pf.getMatch().win();
            }
        }

        p.getVelocity().reverseY();
    }
}
