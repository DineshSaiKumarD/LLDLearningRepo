package Cricbuzz.entities;

public class MatchEvent {

    private EventType eventType;
    private int value;


    public MatchEvent(EventType eventType, int value) {
        this.eventType = eventType;
        this.value = value;
    }

    public EventType getEventType() {
        return eventType;
    }

    public int getValue() {
        return value;
    }
}
