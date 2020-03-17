package com.example.demo.medal;

import java.util.ArrayList;

/**
 * @ClassName MedalBaseEnum
 * @Author WangChen
 * @Date 2019/12/6 16:43
 */
public class MedalBaseEnum {

    public enum Habit implements MedalDetail{

         time_type_10(10,HabitSpecificDetail.every_habit_type),

         time_type_15(15,HabitSpecificDetail.every_habit_type),

         time_type_30(30,HabitSpecificDetail.every_habit_type),

         time_type_50(50,HabitSpecificDetail.every_habit_type),

         time_type_120(120,HabitSpecificDetail.every_habit_type),

         time_type_180(180,HabitSpecificDetail.every_habit_type),

         time_type_240(240,HabitSpecificDetail.every_habit_type),

         time_type_365(365,HabitSpecificDetail.every_habit_type);

        private final int days;
        private final HabitSpecificDetail habitSpecificDetail;

        Habit(int days, HabitSpecificDetail habitSpecificDetail) {
            this.days = days;
            this.habitSpecificDetail = habitSpecificDetail;
        }

        public int getDays() {
            return days;
        }

        public String getHabitSpecificDetail() {
            return habitSpecificDetail.name();
        }

        @Override
        public MedalEntity findSpecificMedal() {
            return null;
        }
    }

    private enum HabitSpecificDetail{

        //任意打卡类型
        every_habit_type,

        //21天安抚打卡
        propitiatory_habit_type,

    }

    public enum Pdp {

        time_type_1(1,PdpSpecificDetail.every_pdp_type);

        private final int time;
        private final PdpSpecificDetail pdpSpecificDetail;

        Pdp(int time, PdpSpecificDetail pdpSpecificDetail) {
            this.time = time;
            this.pdpSpecificDetail = pdpSpecificDetail;
        }

        public int getTime() {
            return time;
        }
        public String getPdpSpecificDetail(){return pdpSpecificDetail.name();}
    }

    private enum PdpSpecificDetail{

        every_pdp_type,

        Tiger_pdp_type,

        Peacock_pdp_type,

        Koala_pdp_type,

        Owl_pdp_type,

        Chameleon_pdp_type,



    }

     enum Pac {

         time_type_1(1);

        private final int number;

        Pac(int number) {
            this.number = number;
        }

        public int get() {
            return number;
        }
    }

     enum LifeTree {

         time_type_1(1);

        private final int number;

        LifeTree(int number) {
            this.number = number;
        }

        public int get() {
            return number;
        }
    }

     enum Stick {

        yes(1),

        no(0);

        private final int isTop;

        public int value() {
            return isTop;
        }

        Stick(int isTop) {
            this.isTop = isTop;
        }
    }

}
