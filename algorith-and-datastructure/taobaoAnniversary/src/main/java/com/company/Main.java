package com.company;

import com.company.bean.Combination;
import com.company.bean.Account;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        int[] xppCount = new int[] {2499,930,799,503,428,218,204,169,159,143,109,94,85,73,68,66,59,58,49,46,38,34,33,32,30,28,27,26,25,24,29,18,17,16,15,14,13,12,11,10,9,7,6,5,4,3,1};
        int[] zxyCount = new int[] {2,3,5,9,10,13,15,16,19,26,28,30,31,32,37,39,44,50,52,53,86,109,110,128,149,151,248,299,369,401};
        int[] lxhCount = new int[] {431,408,196,167,135,130,119,109,98,89,83,57,56,54,51,49,41,40,34,29,27,25,22,17,15,13,12,11,10,9,8,6,5,3};
        Account xpp = new Account(1, "<Panpan Xu", xppCount);
        Account zxy = new Account(2, "<Xiangyu Zeng", zxyCount);
        Account lxh = new Account(3, "<Xiaohong Lee", lxhCount);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please input your answer: ");
            int tarVal = scanner.nextInt();

            ArrayList<Combination> combinations = getRes(xpp, zxy, lxh, tarVal);
            int tolCon = combinations.size();
            if (tolCon != 0) {
                for (int count = 0; count < tolCon; count++) {
                    Combination combination = combinations.get(count);
                    int xppCountRes = combination.getXppCount();
                    int zxyCountRes = combination.getZxyCount();
                    int lxhCountRes = combination.getLxhCount();

                    StringBuilder msg = new StringBuilder();
                    msg.append("Combination ").append(count + 1).append(": ");
                    if (xppCountRes != 0) {
//                        msg.append(xpp.getName()).append(" input ").append(xppCountRes).append("; ");
                        msg.append(xpp.getName()).append(":").append(xppCountRes).append("> ");
                    }
                    if (zxyCountRes != 0) {
//                        msg.append(zxy.getName()).append(" input ").append(zxyCountRes).append("; ");
                        msg.append(zxy.getName()).append(":").append(zxyCountRes).append("> ");
                    }
                    if (lxhCountRes != 0) {
//                        msg.append(lxh.getName()).append(" input ").append(lxhCountRes).append("; ");
                        msg.append(lxh.getName()).append(":").append(lxhCountRes).append("> ");
                    }

                    System.out.println(msg);
                }
            } else {
                System.out.println("No matching!");
            }
            System.out.println();
        }
    }

    public static ArrayList<Combination> getRes (Account xpp, Account zxy, Account lxh, int tarVal) {
        ArrayList<Combination> res = new ArrayList<>();
        // 1 people
        Integer oneXpp = onePeople(xpp.getCount(), tarVal);
        if (Objects.nonNull(oneXpp)) {
            Combination combination = new Combination();
            combination.setXppCount(oneXpp);
            res.add(combination);
        }

        Integer oneZxy = onePeople(zxy.getCount(), tarVal);
        if (Objects.nonNull(oneZxy)) {
            Combination combination = new Combination();
            combination.setZxyCount(oneZxy);
            res.add(combination);
        }

        Integer oneLxh = onePeople(lxh.getCount(), tarVal);
        if (Objects.nonNull(oneLxh)) {
            Combination combination = new Combination();
            combination.setLxhCount(oneLxh);
            res.add(combination);
        }

        // 2 people
        int[] xppZxy = twoPeople(xpp.getCount(), zxy.getCount(), tarVal);
        if (Objects.nonNull(xppZxy)) {
            Combination combination = new Combination();
            combination.setXppCount(xppZxy[0]);
            combination.setZxyCount(xppZxy[1]);
            res.add(combination);
        }

        int[] xppLxh = twoPeople(xpp.getCount(), lxh.getCount(), tarVal);
        if (Objects.nonNull(xppLxh)) {
            Combination combination = new Combination();
            combination.setXppCount(xppLxh[0]);
            combination.setLxhCount(xppLxh[1]);
            res.add(combination);
        }

        int[] zxyLxh = twoPeople(zxy.getCount(), lxh.getCount(), tarVal);
        if (Objects.nonNull(zxyLxh)) {
            Combination combination = new Combination();
            combination.setZxyCount(zxyLxh[0]);
            combination.setLxhCount(zxyLxh[1]);
            res.add(combination);
        }

        // 3 people
        int[] xppZxyLxh = threePeople(xpp.getCount(), zxy.getCount(), lxh.getCount(), tarVal);
        if (Objects.nonNull(xppZxyLxh)) {
            Combination combination = new Combination();
            combination.setXppCount(xppZxyLxh[0]);
            combination.setZxyCount(xppZxyLxh[1]);
            combination.setLxhCount(xppZxyLxh[2]);
            res.add(combination);
        }

        return res;
    }

    public static Integer onePeople (int[] arr, int tarVal) {
        for (int num: arr) {
            if (num == tarVal) {
                return num;
            }
        }
        return null;
    }

    public static int[] twoPeople (int[] arr1, int[] arr2, int tarVal) {
        for (int num1 : arr1) {
            for (int num2 : arr2) {
                if (num1 + num2 == tarVal) {
                    return new int[]{num1, num2};
                }
            }
        }
        return null;
    }

    public static int[] threePeople (int[] arr1, int[] arr2, int[] arr3, int tarVal) {
        for (int num1: arr1) {
            int[] subRes = twoPeople(arr2, arr3, tarVal - num1);
            if (Objects.nonNull(subRes)) {
                return new int[] {num1, subRes[0], subRes[1]};
            }
        }
        return null;
    }
}
