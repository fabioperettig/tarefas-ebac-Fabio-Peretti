
public abstract class Worker {

    public void execute() {
        initRotine();
        wearUniform();
        work();
        backHome();

    }

    protected void initRotine() {
        System.out.println("Starting routine");
    }

    protected void wearUniform() {
        System.out.println("Uniform worn");
    }

    protected abstract void work();

    protected void backHome() {
        System.out.println("Backing home\n");
    }

}
