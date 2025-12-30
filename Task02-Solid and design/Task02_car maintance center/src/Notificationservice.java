public interface Notificationservice {
    void send (String message);
}
class SMSNotification implements Notificationservice {
    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}
class NotificationDecorator implements Notificationservice {
    protected Notificationservice wrap;

    public NotificationDecorator(Notificationservice wrap) {
        this.wrap = wrap;
    }

    public void send(String message) {
        wrap.send(message);
    }
}
class TimestampNotification extends NotificationDecorator {
    public TimestampNotification(Notificationservice wrap) {
        super(wrap);
    }

    @Override
    public void send(String message) {
        super.send("[" + System.currentTimeMillis() + "] " + message);
    }
}

class OldEmailSystem {
    public void oldSendEmail(String text) {
        System.out.println("Old Email System " + text);
    }
}
class EmailAdapter implements Notificationservice {
    private OldEmailSystem oldSystem;

    public EmailAdapter(OldEmailSystem oldSystem) {
        this.oldSystem = oldSystem;
    }

    @Override
    public void send(String message) {
        oldSystem.oldSendEmail(message); // adapting old method
    }
}
