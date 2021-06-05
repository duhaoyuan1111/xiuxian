package com.example.xiuxian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

public class GlobalApplication extends AppCompatActivity {

    private static double exp = 0;
    private static int index = 0;
    private static double expSpeed = 1.0;
    private static String[] level = {"筑基初阶", "筑基二阶", "筑基三阶", "筑基四阶", "筑基五阶", "筑基六阶", "筑基七阶", "筑基八阶","筑基九阶", "筑基巅峰",
            "培元初阶", "培元二阶", "培元三阶", "培元四阶", "培元五阶", "培元六阶", "培元七阶", "培元八阶","培元九阶", "培元巅峰",
            "辟谷初阶", "辟谷二阶", "辟谷三阶", "辟谷四阶", "辟谷五阶", "辟谷六阶", "辟谷七阶", "辟谷八阶","辟谷九阶", "辟谷巅峰",
            "金丹初阶", "金丹二阶", "金丹三阶", "金丹四阶", "金丹五阶", "金丹六阶", "金丹七阶", "金丹八阶","金丹九阶", "金丹巅峰",
            "元婴初阶", "元婴二阶", "元婴三阶", "元婴四阶", "元婴五阶", "元婴六阶", "元婴七阶", "元婴八阶","元婴九阶", "元婴巅峰",
            "出窍初阶", "出窍二阶", "出窍三阶", "出窍四阶", "出窍五阶", "出窍六阶", "出窍七阶", "出窍八阶","出窍九阶", "出窍巅峰",
            "分神初阶", "分神二阶", "分神三阶", "分神四阶", "分神五阶", "分神六阶", "分神七阶", "分神八阶","分神九阶", "分神巅峰",
            "合体初阶", "合体二阶", "合体三阶", "合体四阶", "合体五阶", "合体六阶", "合体七阶", "合体八阶","合体九阶", "合体巅峰",
            "渡劫初阶", "渡劫二阶", "渡劫三阶", "渡劫四阶", "渡劫五阶", "渡劫六阶", "渡劫七阶", "渡劫八阶","渡劫九阶", "渡劫巅峰",
            "大乘初阶", "大乘二阶", "大乘三阶", "大乘四阶", "大乘五阶", "大乘六阶", "大乘七阶", "大乘八阶","大乘九阶", "大乘巅峰", "散仙初阶"};
    private static double[] expRequire = {10, 30, 60, 60, 120, 140, 150, 170, 180, 240,
            270, 300, 330, 350, 370, 390, 410, 450, 470, 500,
            530, 560, 590, 650, 700, 770, 820, 870, 940, 1000,
            1300, 1600, 1800, 2100, 2400, 2400, 2400, 2700, 3000, 3000,
            4200, 4200, 4200, 4200, 4400, 4750, 4750, 4750, 4950, 4950,
            5300, 5600, 5900, 6000, 6300, 6600, 6900, 7400, 7600, 7800,
            8000, 8200, 8400, 8600, 8800, 9000, 9000, 9000, 9300, 9500,
            10000, 10400, 10800, 11200, 11600, 12000, 12500, 13000, 13500, 13500,
            13500, 13500, 13900, 14200, 14500, 14800, 14800, 14900, 15000, 15200,
            15300, 15600, 15900, 16200, 16500, 16800, 17100, 17600, 19000, 20000, 50000};
    private static long frozenPeriod = System.currentTimeMillis();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global_application);

    }

    public static void setExp(double newExp) {
        exp = newExp;
    }
    public static double getExp() {
        return exp;
    }

    public static void setIndex(int newIndex) {
        if (newIndex >= 100) {
            index = 100;
        } else {
            index = newIndex;
        }
    }

    public static int getIndex() {
        return index;
    }

    public static double getExpRequire(int index) {
        return expRequire[index];
    }

    public static double getExpSpeed() {
        return expSpeed;
    }

    public static String getLevel(int index) {
        return level[index];
    }

    public static long getFrozenPeriod() {
        return frozenPeriod;
    }

    public static void setFrozenPeriod(long time) {
        frozenPeriod = time;
    }
}