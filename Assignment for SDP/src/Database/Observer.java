package Database;

import decorator.IHouse;

public interface Observer {
    void handleEvent(IHouse iHouse);
}
