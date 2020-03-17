package com.example.demo.medal;

/**
 * @ClassName MedalEntity
 * @Author WangChen
 * @Date 2019/12/6 10:36
 */
public interface MedalEntity {

    long getMedalId();
    void setMedalId(long medalId);
    int getMedalType();
    void setMedalType(int medalType);

    enum MedalTypeStatus{

        pdp(0),

        pac(1),

        habit(2),

        lifeTree(3);

        private int type;

        public int value() {
            return type;
        }

        MedalTypeStatus(int type) {
            this.type = type;
        }

    }

}
