package Task4.zad1;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public
    interface MousePressListener
    extends MouseListener {

    void myMouseAction(MouseEvent e);

    @Override
    default void mouseClicked(MouseEvent e) {
        myMouseAction(e);
    }

    @Override
    default void mousePressed(MouseEvent e) {}

    @Override
    default void mouseReleased(MouseEvent e) {}

    @Override
    default void mouseEntered(MouseEvent e) {
        myMouseAction(e);
    }

    @Override
    default void mouseExited(MouseEvent e) {
        myMouseAction(e);
    }
}
