public abstract class Observer {
    protected ConcreteSubject subject;

    public Observer(ConcreteSubject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    public abstract void update();
}
