package interface_class;

import objects.Board;

public interface Cards {
    
    abstract Board action(Board board);

    abstract Board setMoney(Board board, int aux);
    
}
