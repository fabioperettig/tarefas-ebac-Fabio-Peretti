public class Police extends Worker{

    @Override
    protected void wearUniform() {
        super.wearUniform();
        System.out.println("Security equipment equiped");
    }

    @Override
    protected void work() {
        System.out.println("Working at SAPD");
    }
}
