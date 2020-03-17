package com.example.demo.medal;

/**
 * @ClassName MedalBase
 * @Author WangChen
 * @Date 2019/12/6 10:42
 */
public abstract class AbstractMedalEntity implements MedalEntity{

    private long medalId;

    private int medalType;

    @Override
    public long getMedalId() { return medalId; }

    @Override
    public void setMedalId(long medalId) {
        this.medalId = medalId;
    }

    @Override
    public int getMedalType() {
        return medalType;
    }

    @Override
    public void setMedalType(int medalType) {
        this.medalType = medalType;
    }


}
