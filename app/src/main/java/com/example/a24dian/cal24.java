package com.example.a24dian;

import static java.lang.Math.abs;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class cal24 {
    static final int TARGET = 24;
    static final double EPSILON = 1e-6;
    static final int add = 0, mul = 1, sub = 2, div = 3;
    private List<String> equations = new ArrayList<String>();

    public List<String> getPoint24Equ(int[] cards) {
        equations.clear();

        List<Double> list = new ArrayList<Double>();  // 存储操作数
        List<String> numStr = new ArrayList<String>();  // 存储表达式

        for (int num : cards) {
            list.add((double) num);
            numStr.add(Integer.toString(num));
        }

        dfs(list, numStr);

        equations = new ArrayList<String>(new LinkedHashSet<String>(equations));
        return equations;
    }


    private void dfs(List<Double> list, List<String> numStr) {
        if (list.size() == 0) {
            return;
        }

        if (list.size() == 1) {
            if (abs(list.get(0) - TARGET) < EPSILON) {
                String equ = numStr.get(0);
                equations.add(equ.substring(1, equ.length() - 1)+"=24");

            }
            return;
        }

        // 两个数字
        int n = list.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    // 递归数组
                    List<Double> list2 = new ArrayList<Double>();
                    List<String> numStr2 = new ArrayList<String>();

                    for (int z = 0; z < n; z++) {
                        if (z != i && z != j) {
                            list2.add(list.get(z));
                            numStr2.add(numStr.get(z));
                        }
                    }
                    // 四个操作符
                    for (int k = 0; k <= 3; k++) {
                        if (i < j && k <= 1) continue;

                        if (k == add) {
                            list2.add(list.get(i) + list.get(j));
                            numStr2.add("(" + numStr.get(i) + "+" + numStr.get(j) + ")");

                        } else if (k == mul) {
                            list2.add(list.get(i) * list.get(j));
                            numStr2.add("(" + numStr.get(i) + "*" + numStr.get(j) + ")");

                        } else if (k == sub) {
                            list2.add(list.get(i) - list.get(j));
                            numStr2.add("(" + numStr.get(i) + "-" + numStr.get(j) + ")");

                        } else if (k == div) {
                            // 判断除数是否为零
                            if (abs(list.get(j)) < EPSILON) continue;
                            else {
                                list2.add(list.get(i) / list.get(j));
                                numStr2.add("(" + numStr.get(i) + "/" + numStr.get(j) + ")");
                            }
                        }

                        // 递归计算
                        dfs(list2, numStr2);

                        list2.remove(list2.size() - 1);
                        numStr2.remove(numStr2.size() - 1);
                    }
                }
            }
        }
    }
}


