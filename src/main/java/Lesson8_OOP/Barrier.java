package Lesson8_OOP;

interface Barrier {
    double GetVal();
    String GetBarrierName();
}

class RunWay implements Barrier{
    public final String name = "Дорожка";
    double value;

    public RunWay(int value) {
        if (value < 1) this.value = 1;
        else this.value = value;
    }

    @Override
    public double GetVal() {
        return value;
    }

    @Override
    public String GetBarrierName() {
        return name;
    }
}

class Wal implements Barrier{
    public final String name = "Стена";
    double value;

    public Wal (double value) {
        if (value < 0.1) this.value = 0.1;
        else if (value > 3) this.value = 3;
        else this.value = value;
    }

    @Override
    public double GetVal() {
        return value;
    }

    @Override
    public String GetBarrierName() {
        return name;
    }
}
